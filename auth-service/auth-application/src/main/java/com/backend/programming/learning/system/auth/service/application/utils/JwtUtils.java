package com.backend.programming.learning.system.auth.service.application.utils;

import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {
    public Map<String, String> getPayloadFromJwtString(String jwtString) {
        if (jwtString == null || jwtString.isEmpty()) {
            return null;
        }
        String[] splitString = jwtString.split("\\.");
        Base64.Decoder decoder = Base64.getDecoder();
        String payload = new String(decoder.decode(splitString[1]));
        String[] payloadSplit = payload.split(",");
        Map<String, String> payloadMap = new HashMap<>();
        for (String s : payloadSplit) {
            String[] keyValue = s.split(":");
            payloadMap.put(
                    keyValue[0]
                            .replace("\"", "")
                            .replace("{", ""),
                    keyValue[1].replace("\"", "")
                            .replace("}", ""));
        }
        return payloadMap;
    }

    public String getEmailFromJwtString(String jwtString) {
        if (jwtString == null || jwtString.isEmpty()) {
            return null;
        }
        String email = null;
        Map<String, String> jwtPayloadMap = getPayloadFromJwtString(jwtString);
        if (jwtPayloadMap != null && jwtPayloadMap.containsKey("exp")) {
            String exp = jwtPayloadMap.get("exp");
            if (Long.parseLong(exp) < System.currentTimeMillis() / 1000) {
                return null;
            } else {
                if (jwtPayloadMap.containsKey("preferred_username")) {
                    email = jwtPayloadMap.get("preferred_username");
                }
            }
        }
        return email;
    }

    public String getEmailFromJwtStringWithoutCheckExp(String jwtString) {
        if (jwtString == null || jwtString.isEmpty()) {
            return null;
        }
        String email = null;
        Map<String, String> jwtPayloadMap = getPayloadFromJwtString(jwtString);
        if (jwtPayloadMap.containsKey("preferred_username")) {
            email = jwtPayloadMap.get("preferred_username");
        }
        return email;
    }
}
