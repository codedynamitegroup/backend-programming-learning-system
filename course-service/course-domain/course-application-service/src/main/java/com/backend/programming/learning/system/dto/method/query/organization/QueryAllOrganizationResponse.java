package com.backend.programming.learning.system.dto.method.query.organization;

import com.backend.programming.learning.system.dto.responseentity.organization.OrganizationResponseEntity;
import com.backend.programming.learning.system.entity.Organization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllOrganizationResponse {
    private final List<OrganizationResponseEntity> organizationResponseEntities;
}
