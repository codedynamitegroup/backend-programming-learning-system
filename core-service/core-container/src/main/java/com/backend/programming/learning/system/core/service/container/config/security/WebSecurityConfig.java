package com.backend.programming.learning.system.core.service.container.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    public static final String ADMIN = "admin";
    public static final String GENERAL = "general";
    private final JwtAuthConverter jwtAuthConverter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .antMatchers(HttpMethod.GET, "/core/certificate-courses").hasAnyRole(ADMIN, GENERAL)
                        .antMatchers(HttpMethod.GET, "/core/topics").hasAnyRole(ADMIN, GENERAL)
                        .anyRequest().permitAll()
                )
                .csrf(csrf -> csrf.disable())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwtAuthenticationConverter(jwtAuthConverter)
                        )
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> {
            web.ignoring().antMatchers(
                    HttpMethod.POST,
                    "/auth/users/login",
                    "/auth/users/refresh_token"
            );
            web.ignoring().antMatchers(
                            HttpMethod.OPTIONS,
                            "/**"
                    )
                    .antMatchers("/v3/api-docs/**", "/configuration/**", "/swagger-ui/**",
                            "/swagger-resources/**", "/swagger-ui.html", "/webjars/**", "/api-docs/**");

        };
    }

}
