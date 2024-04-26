package com.backend.programming.learning.system.course.service.domain.dto.method.query.organization;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.organization.OrganizationResponseEntity;
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
