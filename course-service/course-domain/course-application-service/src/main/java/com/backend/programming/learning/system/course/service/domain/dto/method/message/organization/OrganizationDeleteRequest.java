package com.backend.programming.learning.system.course.service.domain.dto.method.message.organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class OrganizationDeleteRequest {
    private String id;
    private String sagaId;
    private String organizationId;
    private Boolean isDeleted;
}
