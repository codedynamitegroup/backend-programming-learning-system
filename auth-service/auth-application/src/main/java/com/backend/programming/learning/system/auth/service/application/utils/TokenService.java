package com.backend.programming.learning.system.auth.service.application.utils;

import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final JwtDecoderConfig jwtDecoderConfig;

    public Jwt decodeAccessToken(String token, String provider) {
        try {
            JwtDecoder decoder = jwtDecoderConfig.getDecoder(provider);
            return decoder.decode(token);
        } catch (JwtException e) {
            throw new AuthDomainException("Invalid token: " +  e.getMessage());
        }
    }
}