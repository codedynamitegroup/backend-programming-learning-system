package com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.OrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.message.UserResponse;

public interface CoreServiceOrganizationResponseMessageListener {
    void organizationUpdatedFail(OrganizationResponse organizationResponse);
    void organizationUpdatedSuccess(OrganizationResponse organizationResponse);
    void organizationCreateFail(OrganizationResponse organizationResponse);
    void organizationCreateSuccess(OrganizationResponse organizationResponse);
    void organizationDeleteFail(OrganizationResponse organizationResponse);
    void organizationDeleteSuccess(OrganizationResponse organizationResponse);
}
