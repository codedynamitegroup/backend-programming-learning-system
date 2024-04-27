package com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.auth;


import com.backend.programming.learning.system.course.service.domain.dto.method.OrganizationModel;

import java.util.UUID;

public interface OrganizationResponseMessageListener {
    void organizationCreated(OrganizationModel organizationModel);
    void organizationDeleted(UUID organizationId);
    void organizationUpdated(OrganizationModel organizationModel);
}
