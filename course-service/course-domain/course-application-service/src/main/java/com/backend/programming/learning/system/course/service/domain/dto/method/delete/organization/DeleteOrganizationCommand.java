package com.backend.programming.learning.system.course.service.domain.dto.method.delete.organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteOrganizationCommand {
    @NotNull
    private final UUID organizationId;
}
