package com.backend.programming.learning.system.event;


import com.backend.programming.learning.system.entity.Organization;
import com.backend.programming.learning.system.entity.User;

import java.time.ZonedDateTime;

public class OrganizationCreatedEvent extends OrganizationEvent {
    public OrganizationCreatedEvent(Organization organization, ZonedDateTime createdAt) {
        super(organization, createdAt);
    }
}
