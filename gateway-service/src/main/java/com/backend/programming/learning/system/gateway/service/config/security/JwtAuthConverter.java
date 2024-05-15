package com.backend.programming.learning.system.gateway.service.config.security;

import com.backend.programming.learning.system.gateway.service.config.KeycloakGatewayConfigData;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class JwtAuthConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    private final KeycloakGatewayConfigData keycloakGatewayConfigData;

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Map<String, Object> resourceAccess;
        Map<String, Object> resource;
        Collection<String> resourceRoles;

        if (jwt.getClaim("resource_access") == null) {
            return Set.of();
        }
        resourceAccess = jwt.getClaim("resource_access");

        if (resourceAccess.get(keycloakGatewayConfigData.getClient()) == null) {
            return Set.of();
        }

        resource = (Map<String, Object>) resourceAccess.get(keycloakGatewayConfigData.getClient());

        resourceRoles = (Collection<String>) resource.get("roles");
        return resourceRoles
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toSet());
    }
}