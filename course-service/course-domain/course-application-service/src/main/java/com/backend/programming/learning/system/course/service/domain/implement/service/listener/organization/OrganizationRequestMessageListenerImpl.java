package com.backend.programming.learning.system.course.service.domain.implement.service.listener.organization;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.organization.OrganizationRequest;
import com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.organization.OrganizationRequestMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class OrganizationRequestMessageListenerImpl implements OrganizationRequestMessageListener {
    private final OrganizationRequestHelper organizationRequestHelper;

    public OrganizationRequestMessageListenerImpl(OrganizationRequestHelper organizationRequestHelper) {
        this.organizationRequestHelper = organizationRequestHelper;
    }

    @Override
    public void organizationCreated(OrganizationRequest organizationCreateRequest) {
        organizationRequestHelper.createdOrganization(organizationCreateRequest);
    }

    @Override
    public void organizationUpdated(OrganizationRequest organizationUpdateRequest) {
        organizationRequestHelper.updatedOrganization(organizationUpdateRequest);
    }

    @Override
    public void organizationDeleted(OrganizationRequest organizationDeleteRequest) {
        organizationRequestHelper.deletedOrganization(organizationDeleteRequest);
    }
}