package com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.auth;


import com.backend.programming.learning.system.course.service.domain.dto.method.message.organization.OrganizationCreateRequest;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.organization.OrganizationDeleteRequest;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.organization.OrganizationUpdateRequest;

public interface OrganizationRequestMessageListener {
    void organizationCreated(OrganizationCreateRequest organizationCreateRequest);
    void organizationDeleted(OrganizationDeleteRequest organizationDeleteRequest);
    void organizationUpdated(OrganizationUpdateRequest organizationUpdateRequest);
}
