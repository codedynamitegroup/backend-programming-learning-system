package com.backend.programming.learning.system.dto.method.update.organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateOrganizationResponse {
    private final UUID organizationId;
    private final String message;
}
