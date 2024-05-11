package com.backend.programming.learning.system.auth.service.domain.dto.response_entity.role;

import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.organization.OrganizationEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class RoleEntityResponse {
    @NotNull
    private UUID roleId;

    private UserEntityResponse createdBy;

    private UserEntityResponse updatedBy;

    private String description;

    private String name;

    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;
}
