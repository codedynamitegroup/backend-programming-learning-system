package com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user_role;

import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.role.RoleEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UserRoleEntityResponse {
    @NotNull
    private UUID userRoleId;

    private UserEntityResponse user;

    private RoleEntityResponse role;

    private UserEntityResponse createdBy;

    private UserEntityResponse updatedBy;

    private boolean isActive;
    private String name;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
