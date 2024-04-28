package com.backend.programming.learning.system.course.service.domain.implement.message.listener.organization;


import com.backend.programming.learning.system.course.service.domain.dto.method.message.organization.OrganizationCreateRequest;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.organization.OrganizationDeleteRequest;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.organization.OrganizationUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.event.organization.OrganizationEvent;
import com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.auth.OrganizationRequestMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class OrganizationRequestMessageListenerImpl implements OrganizationRequestMessageListener {
    private final OrganizationCreateRequestHelper organizationCreateRequestHelper;
    private final OrganizationUpdateRequestHelper organizationUpdateRequestHelper;
    private final OrganizationDeleteRequestHelper organizationDeleteRequestHelper;

    public OrganizationRequestMessageListenerImpl(OrganizationCreateRequestHelper organizationCreateRequestHelper, OrganizationUpdateRequestHelper organizationUpdateRequestHelper, OrganizationDeleteRequestHelper organizationDeleteRequestHelper) {
        this.organizationCreateRequestHelper = organizationCreateRequestHelper;
        this.organizationUpdateRequestHelper = organizationUpdateRequestHelper;
        this.organizationDeleteRequestHelper = organizationDeleteRequestHelper;
    }


    @Override
    public void organizationCreated(OrganizationCreateRequest organizationCreateRequest) {
        OrganizationEvent organizationEvent = organizationCreateRequestHelper.persistOrganization(organizationCreateRequest);
        fireEvent(organizationEvent);
    }

    @Override
    public void organizationDeleted(OrganizationDeleteRequest organizationDeleteRequest) {
        OrganizationEvent organizationEvent = organizationDeleteRequestHelper.persistOrganization(organizationDeleteRequest);
        fireEvent(organizationEvent);
    }

    @Override
    public void organizationUpdated(OrganizationUpdateRequest organizationUpdateRequest) {
        OrganizationEvent organizationEvent = organizationUpdateRequestHelper.persistOrganization(organizationUpdateRequest);
        fireEvent(organizationEvent);

    }

    private void fireEvent(OrganizationEvent organizationEvent) {
        log.info("Publishing organization event with organization id: {}",
                organizationEvent.getOrganization().getId().getValue());
        organizationEvent.fire();
    }
}
