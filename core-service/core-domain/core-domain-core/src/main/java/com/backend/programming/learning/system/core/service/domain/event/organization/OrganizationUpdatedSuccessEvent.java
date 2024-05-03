package com.backend.programming.learning.system.core.service.domain.event.organization;

import com.backend.programming.learning.system.core.service.domain.entity.Organization;
import com.backend.programming.learning.system.core.service.domain.entity.User;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

public class OrganizationUpdatedSuccessEvent extends OrganizationEvent {
    public OrganizationUpdatedSuccessEvent(Organization organization, ZonedDateTime createdAt) {
        super(organization, createdAt, Collections.emptyList());
    }

    @Override
    public void fire() {

    }
}
