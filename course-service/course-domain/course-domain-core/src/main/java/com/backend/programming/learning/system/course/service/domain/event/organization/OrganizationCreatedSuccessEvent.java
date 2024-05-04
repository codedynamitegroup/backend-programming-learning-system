package com.backend.programming.learning.system.course.service.domain.event.organization;

import com.backend.programming.learning.system.course.service.domain.entity.Organization;

import java.time.ZonedDateTime;
import java.util.Collections;

public class OrganizationCreatedSuccessEvent extends OrganizationEvent {
    public OrganizationCreatedSuccessEvent(Organization organization, ZonedDateTime createdAt) {
        super(organization, createdAt, Collections.emptyList());
    }

    @Override
    public void fire() {

    }
}
