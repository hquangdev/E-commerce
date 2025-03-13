package com.example.webbe.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    protected static final String SINGER_KEY = "LDzDIQeFNWXeWjG/yQ3yQz0cNJY2QAx08t5vyu7/E1ZaYZNsaSzaQBQ/nhWH591f";

    private final String[] PUBLIC_ENDPOINTS = {"/user","/home/**", "/auth/**", "/auth/introspect","/uploads/**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                    .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf((AbstractHttpConfigurer::disable))
                .authorizeHttpRequests(request ->
                        request
//                                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                .requestMatchers( PUBLIC_ENDPOINTS).permitAll()
                                .requestMatchers(HttpMethod.GET, "/slide/**").permitAll()
                                .anyRequest().authenticated()
                );
        httpSecurity.oauth2ResourceServer(auth2 -> auth2.jwt(jwtConfigurer -> jwtConfigurer.decoder(jwtDecoder())
                .jwtAuthenticationConverter(jwtAuthenticationConverter()))

                .authenticationEntryPoint(new JwtAuthenticationEntryPoint()));

        return httpSecurity.build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter(){
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        jwtGrantedAuthoritiesConverter.setAuthorityPrefix("");

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);

        return jwtAuthenticationConverter;
    }

    @Bean
    JwtDecoder jwtDecoder(){
        SecretKeySpec secretKey = new SecretKeySpec(SINGER_KEY.getBytes(), "HS512");

        return NimbusJwtDecoder
                .withSecretKey(secretKey)
                .macAlgorithm(MacAlgorithm.HS512)
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:5173"); // Thêm frontend của bạn
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }

}

//authorizeHttpRequests: chỉ định các quy tắc ủy quyền
//requestMatchers: chỉ định URL or Http để áp dụng vào quy tắc
//permitAll(): cho phép tất cả
//anyRequest(): Áp dụng quy tắc cho tất cả các yêu cầu HTTP.

//bean 2:
//+ AuthenticationManager là ktra thông tin xác thực và trả về 1 Authentication chứa token

//bean 3:
//+ PasswordEncoder: interface đẻ SD mã hóa pass
//+ BCryptPasswordEncoder(): là 1 thuật toán max hóa.