package com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user;

import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.organization.OrganizationEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UserEntityResponse {
    @NotNull
    private UUID userId;
    @NotNull
    private String email;
    private ZonedDateTime dob;
    private Organization organization;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String avatarUrl;
    private String lastIp;
    private ZonedDateTime lastLogin;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private Boolean isDeleted;
}
