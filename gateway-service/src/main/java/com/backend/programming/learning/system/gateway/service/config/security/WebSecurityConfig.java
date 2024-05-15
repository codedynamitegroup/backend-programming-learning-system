package com.backend.programming.learning.system.gateway.service.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;
import org.springframework.core.convert.converter.Converter;

@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    public static final String ADMIN = "admin_client_role";
    public static final String USER = "user_client_role";
    private final JwtAuthConverter jwtAuthConverter;

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity serverHttpSecurity) {
        serverHttpSecurity
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers(HttpMethod.GET, "/auth/users").hasAnyRole(ADMIN)
                        .pathMatchers(HttpMethod.GET, "/auth/users/**").hasAnyRole(ADMIN)
                        .pathMatchers(HttpMethod.DELETE, "/auth/users/:id").hasRole(ADMIN)
                        .pathMatchers(HttpMethod.PUT, "/auth/users/:id").hasRole(ADMIN)
                        .pathMatchers(HttpMethod.POST, "/auth/users").hasRole(ADMIN)
                        .pathMatchers(HttpMethod.POST, "/auth/users/refresh_token").hasAnyRole(ADMIN, USER)
                        .pathMatchers(HttpMethod.POST, "/auth/user-roles").hasRole(ADMIN)
                        .anyExchange().permitAll()
                )
                .oauth2ResourceServer(oAuth2ResourceServerSpec ->  oAuth2ResourceServerSpec
                        .jwt(jwtSpec -> jwtSpec.jwtAuthenticationConverter(grantedAuthoritiesExtractor())));
        serverHttpSecurity.csrf((csrfSpec) -> csrfSpec.disable());
        return serverHttpSecurity.build();
    }

    Converter<Jwt, Mono<AbstractAuthenticationToken>> grantedAuthoritiesExtractor() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtAuthConverter);
        return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
    }

}
