package com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener.organization;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.OrganizationResponse;

public interface OrganizationResponseMessageListener {
    void organizationCreatedUpdatedOrDeletedFail(OrganizationResponse organizationResponse);
    void organizationCreatedUpdatedOrDeletedSuccess(OrganizationResponse organizationResponse);
}
