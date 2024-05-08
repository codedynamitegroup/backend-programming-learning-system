package com.backend.programming.learning.system.auth.service.domain.dto.response_entity.organization;

import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class OrganizationEntityResponse {
    @NotNull
    private UUID organizationId;

    private UserEntityResponse createdBy;

    private UserEntityResponse updatedBy;

    private String description;

    @NotNull
    private String name;

    @NotNull
    private String email;

    private String phone;

    private String address;

    private String apiKey;

    private String moodleUrl;

    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;

    private Boolean isDeleted;
}
