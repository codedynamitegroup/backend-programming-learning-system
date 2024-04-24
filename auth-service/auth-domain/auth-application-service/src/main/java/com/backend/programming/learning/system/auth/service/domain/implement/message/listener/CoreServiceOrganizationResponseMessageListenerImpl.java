package com.backend.programming.learning.system.auth.service.domain.implement.message.listener;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.OrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.message.UserResponse;
import com.backend.programming.learning.system.auth.service.domain.implement.saga.CreatedUserCoreSaga;
import com.backend.programming.learning.system.auth.service.domain.implement.saga.DeletedUserCoreSaga;
import com.backend.programming.learning.system.auth.service.domain.implement.saga.UpdatedUserCoreSaga;
import com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener.CoreServiceOrganizationResponseMessageListener;
import com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener.CoreServiceUserResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class CoreServiceOrganizationResponseMessageListenerImpl implements CoreServiceOrganizationResponseMessageListener {

    @Override
    public void organizationUpdatedFail(OrganizationResponse organizationResponse) {

    }

    @Override
    public void organizationUpdatedSuccess(OrganizationResponse organizationResponse) {

    }

    @Override
    public void organizationCreateFail(OrganizationResponse organizationResponse) {

    }

    @Override
    public void organizationCreateSuccess(OrganizationResponse organizationResponse) {

    }

    @Override
    public void organizationDeleteFail(OrganizationResponse organizationResponse) {

    }

    @Override
    public void organizationDeleteSuccess(OrganizationResponse organizationResponse) {

    }
}
