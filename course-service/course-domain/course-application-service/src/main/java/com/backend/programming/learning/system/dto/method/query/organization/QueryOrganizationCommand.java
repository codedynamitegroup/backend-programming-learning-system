package com.backend.programming.learning.system.dto.method.query.organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryOrganizationCommand {
    private final UUID organizationId;
}
