package com.backend.programming.learning.system.auth.service.domain.dto.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryRoleByOrganizationCommand {
    @NotNull
    private final UUID organizationId;
}
