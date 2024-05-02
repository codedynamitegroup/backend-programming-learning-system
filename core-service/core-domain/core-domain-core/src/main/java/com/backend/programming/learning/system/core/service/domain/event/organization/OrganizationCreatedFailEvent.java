package com.backend.programming.learning.system.core.service.domain.event.organization;

import com.backend.programming.learning.system.core.service.domain.entity.Organization;
import com.backend.programming.learning.system.core.service.domain.entity.User;

import java.time.ZonedDateTime;
import java.util.List;

public class OrganizationCreatedFailEvent extends OrganizationEvent {
    public OrganizationCreatedFailEvent(Organization organization, ZonedDateTime createdAt, List<String> failureMessages) {
        super(organization, createdAt, failureMessages);
    }

    @Override
    public void fire() {

    }
}
