package com.backend.programming.learning.system.auth.service.domain.implement.message.listener;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.OrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.implement.saga.organization.OrganizationUpdateSaga;
import com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener.CoreServiceOrganizationResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class CoreServiceOrganizationResponseMessageListenerImpl implements CoreServiceOrganizationResponseMessageListener {
    private final OrganizationUpdateSaga organizationUpdateSaga;

    public CoreServiceOrganizationResponseMessageListenerImpl(OrganizationUpdateSaga organizationUpdateSaga) {
        this.organizationUpdateSaga = organizationUpdateSaga;
    }

    @Override
    public void organizationCreatedUpdatedOrDeletedFail(OrganizationResponse organizationResponse) {
        organizationUpdateSaga.rollback(organizationResponse);
    }

    @Override
    public void organizationCreatedUpdatedOrDeletedSuccess(OrganizationResponse organizationResponse) {
        organizationUpdateSaga.process(organizationResponse);
    }
}
