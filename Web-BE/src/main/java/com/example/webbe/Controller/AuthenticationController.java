package com.example.webbe.Controller;

import com.example.webbe.DTO.Request.AuthenticationRequest;
import com.example.webbe.DTO.Request.IntrospectRequest;
import com.example.webbe.DTO.Response.IntrospectResponse;
import com.example.webbe.DTO.ResponseDto;
import com.example.webbe.Service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<ResponseDto<Object>> Login(@RequestBody AuthenticationRequest authenticationRequest, HttpServletRequest request){
         return authenticationService.Login(authenticationRequest, request);
    }

    @PostMapping("/introspect")
    public ResponseDto<IntrospectResponse> introspect(@RequestBody IntrospectRequest introspectRequest) throws ParseException, JOSEException {
        var result = authenticationService.introspect(introspectRequest);

        return ResponseDto.<IntrospectResponse>builder()
                .data(result)
                .build();
    }

}
