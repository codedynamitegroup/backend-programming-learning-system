package com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.OrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.message.UserResponse;

public interface CoreServiceOrganizationResponseMessageListener {
    void organizationCreatedUpdatedOrDeletedFail(OrganizationResponse organizationResponse);
    void organizationCreatedUpdatedOrDeletedSuccess(OrganizationResponse organizationResponse);
}
