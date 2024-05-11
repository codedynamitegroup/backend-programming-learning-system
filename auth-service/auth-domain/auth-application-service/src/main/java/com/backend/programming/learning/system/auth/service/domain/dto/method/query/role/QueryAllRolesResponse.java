package com.backend.programming.learning.system.auth.service.domain.dto.method.query.role;

import jakarta.validation.constraints.*;

import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.role.RoleEntityResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllRolesResponse {
    @NotNull
    private final List<RoleEntityResponse> roles;
    @NotNull
    private final int currentPage;
    @NotNull
    private final long totalItems;
    @NotNull
    private final int totalPages;
}
