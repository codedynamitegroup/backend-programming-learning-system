package com.backend.programming.learning.system.auth.service.domain.dto.method.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SSOGoogleUserProfileResponse {
    private final String email;

    private final String sub;

    @JsonProperty("given_name")
    private final String givenName;

    @JsonProperty("family_name")
    private final String familyName;

    private final String picture;
}
