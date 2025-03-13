package com.example.webbe.Service;

import com.example.webbe.DTO.Request.AuthenticationRequest;
import com.example.webbe.DTO.Request.IntrospectRequest;
import com.example.webbe.DTO.Response.AuthenticationResponse;
import com.example.webbe.DTO.Response.IntrospectResponse;
import com.example.webbe.DTO.ResponseDto;
import com.example.webbe.Entity.User;
import com.example.webbe.Repository.AuthenticationRepo;
import com.example.webbe.exception.AppException;
import com.example.webbe.exception.EnumCode;
import com.example.webbe.exception.ResponseBuilder;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.StringJoiner;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private final AuthenticationRepo authenticationRepo;

    protected static final String SINGER_KEY = "LDzDIQeFNWXeWjG/yQ3yQz0cNJY2QAx08t5vyu7/E1ZaYZNsaSzaQBQ/nhWH591f";
    private final CartService cartService;

    public ResponseEntity<ResponseDto<Object>> Login(AuthenticationRequest authenticationRequest, HttpServletRequest request) {
        try {
            var user = authenticationRepo.findByName(authenticationRequest.getName())
                    .orElseThrow(() -> new AppException(EnumCode.USER_NOT_EXITED));

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
            boolean authenticated = passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword());

            if (!authenticated) {
                throw new AppException(EnumCode.AUTHENTICATED);
            }

            var token = generateToken(user);

            String sessionId = request.getSession().getId();

            cartService.mergeGuestCartToUserCart(sessionId, user.getId());

            return ResponseBuilder.okResponse(
                    EnumCode.LOGIN_SUCC,
                    AuthenticationResponse.builder()
                            .token(token)
                            .authenticated(true)
                            .role(user.getRoles().toString())
                            .build()
            );
        } catch (Exception e) {
            return ResponseBuilder.failedResponse(EnumCode.NOT_USER);
        }
    }


    private String generateToken(User user) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimSet = new JWTClaimsSet.Builder()
                .subject(user.getName())
                .issuer("quang.com")
                .expirationTime(new Date(Instant.now().plus(7, ChronoUnit.DAYS).toEpochMilli()))
                .issueTime(new Date())
                .claim("scope", buildScope(user))
                .build();

        Payload payload = new Payload(jwtClaimSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SINGER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }


    public IntrospectResponse introspect(IntrospectRequest introspectRequest) throws JOSEException, ParseException {
        var token = introspectRequest.getToken();
        JWSVerifier verifier = new MACVerifier(SINGER_KEY.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        var verified = signedJWT.verify(verifier);

        return IntrospectResponse.builder()
                .valid(verified && expiryTime.after(new Date()))
                .build();
    }

    private String buildScope(User user) {
        StringJoiner stringJoiner =  new StringJoiner(" ");

        if(!CollectionUtils.isEmpty(user.getRoles()))
            user.getRoles().forEach(role ->{stringJoiner.add("ROLE_" + role.getName());

                if(!CollectionUtils.isEmpty(role.getPermission()))
                    role.getPermission().forEach(permission -> stringJoiner.add(permission.getName()));
            });
        return stringJoiner.toString();
    }

}
