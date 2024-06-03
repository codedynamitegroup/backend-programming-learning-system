package com.backend.programming.learning.system.auth.service.application.utils;

import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class JwtUtils {
    public JsonObject getPayloadFromJwtString(String jwtString) {
        if (jwtString == null || jwtString.isEmpty()) {
            return null;
        }
        String[] splitString = jwtString.split("\\.");
        Base64.Decoder decoder = Base64.getDecoder();
        String payload = new String(decoder.decode(splitString[1]));
        JsonObject convertedObject = null;

        try {
            convertedObject = new Gson().fromJson(payload, JsonObject.class);
        } catch (Exception e) {
           throw new AuthDomainException("Error while converting jwt payload to json object");
        }
        return convertedObject;
    }

    public String getEmailFromJwtString(String jwtString) {
        if (jwtString == null || jwtString.isEmpty()) {
            return null;
        }
        String email = null;
        JsonObject jwtPayloadMap = getPayloadFromJwtString(jwtString);
        if (jwtPayloadMap != null && jwtPayloadMap.has("exp")) {
            String exp = jwtPayloadMap.get("exp").toString();
            if (Long.parseLong(exp) < System.currentTimeMillis() / 1000) {
                return null;
            } else {
                if (jwtPayloadMap.has("preferred_username")) {
                    email = jwtPayloadMap.get("preferred_username").toString().replace("\"", "");
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
        JsonObject jwtPayloadMap = getPayloadFromJwtString(jwtString);
        if (jwtPayloadMap != null && jwtPayloadMap.has("preferred_username")) {
            email = jwtPayloadMap.get("preferred_username").toString().replace("\"", "");
        }
        return email;
    }
}
