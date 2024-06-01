package com.backend.programming.learning.system.application.handler.utils;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    public static Map<String, String> getPayloadFromJwtString(String jwtString) {
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

    public static String getEmailFromJwtString(String jwtString) {
        if (jwtString == null || jwtString.isEmpty()) {
            return null;
        }
        String email = null;
        Map<String, String> jwtPayloadMap = JwtUtils.getPayloadFromJwtString(jwtString);
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
}
