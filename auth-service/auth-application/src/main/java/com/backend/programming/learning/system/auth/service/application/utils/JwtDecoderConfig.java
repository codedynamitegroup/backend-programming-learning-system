package com.backend.programming.learning.system.auth.service.application.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JwtDecoderConfig {
    private final Map<String, JwtDecoder> jwtDecoders = new HashMap<>();

    public JwtDecoderConfig() {
        jwtDecoders.put("microsoft", NimbusJwtDecoder.withJwkSetUri("https://login.microsoftonline.com/common/discovery/keys").build());
        jwtDecoders.put("google", NimbusJwtDecoder.withJwkSetUri("https://www.googleapis.com/oauth2/v3/certs").build());
    }

    public JwtDecoder getDecoder(String provider) {
        JwtDecoder decoder = jwtDecoders.get(provider.toLowerCase());
        if (decoder == null) {
            throw new IllegalArgumentException("Unsupported provider: " + provider);
        }
        return decoder;
    }
}