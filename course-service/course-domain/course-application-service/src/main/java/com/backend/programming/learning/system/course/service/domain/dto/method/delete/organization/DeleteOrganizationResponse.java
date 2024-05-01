package com.backend.programming.learning.system.course.service.domain.dto.method.delete.organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteOrganizationResponse {
    private final UUID organizationId;
    private final String message;
}
