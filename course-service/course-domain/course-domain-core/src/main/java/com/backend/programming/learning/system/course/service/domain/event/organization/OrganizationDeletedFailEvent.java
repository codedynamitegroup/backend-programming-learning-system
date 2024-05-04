package com.backend.programming.learning.system.course.service.domain.event.organization;

import com.backend.programming.learning.system.course.service.domain.entity.Organization;

import java.time.ZonedDateTime;
import java.util.List;

public class OrganizationDeletedFailEvent extends OrganizationEvent {
    public OrganizationDeletedFailEvent(Organization organization, ZonedDateTime createdAt, List<String> failureMessages) {
        super(organization, createdAt, failureMessages);
    }

    @Override
    public void fire() {

    }
}
