package com.backend.programming.learning.system.auth.service.domain.dto.method.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SSOMicrosoftUserProfileResponse {
    private final String mail;

    private final String userPrincipalName;

    private final String id;

    private final String displayName;

    private final String surname;

    private final String givenName;

    private final String preferredLanguage;

    private final String mobilePhone;

    private final String jobTitle;
}
