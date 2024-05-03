package com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.organization;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.organization.OrganizationRequest;

public interface OrganizationRequestMessageListener {
    void organizationCreated(OrganizationRequest organizationCreateRequest);
    void organizationUpdated(OrganizationRequest organizationUpdateRequest);
    void organizationDeleted(OrganizationRequest organizationDeleteRequest);
}
