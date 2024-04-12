package com.backend.programming.learning.system.auth.service.domain.dto.query;

import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class QueryOrganizationResponse {
    @NotNull
    @Email
    private String email;

    private String description;

    @NotNull
    private String name;

    private String phone;
    private String address;
    private String apiKey;
    private String moodleUrl;

    private ZonedDateTime updatedAt;
    @NotNull
    private final ZonedDateTime createdAt;
}
