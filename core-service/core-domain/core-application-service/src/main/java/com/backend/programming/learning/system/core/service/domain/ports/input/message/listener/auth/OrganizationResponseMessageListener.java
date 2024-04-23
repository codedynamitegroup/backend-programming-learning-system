package com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.auth;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.OrganizationModel;

import java.util.UUID;

public interface OrganizationResponseMessageListener {
    void organizationCreated(OrganizationModel organizationModel);
    void organizationDeleted(UUID organizationId);
    void organizationUpdated(OrganizationModel organizationModel);
}
