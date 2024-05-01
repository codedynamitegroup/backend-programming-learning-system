package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationUpdatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserUpdatedEvent;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class AuthDomainServiceImpl implements AuthDomainService {
    @Override
    public UserCreatedEvent createUser(User user) {
        user.initializeUser();
        user.setCopyState(CopyState.CREATING);
        log.info("User with id: {} is initiated", user.getId().getValue());
        return new UserCreatedEvent(user, ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public UserDeletedEvent deleteUser(User user) {
        user.deleteUser();
        user.setCopyState(CopyState.DELETING);
        log.info("User with id: {} is deleted", user.getId().getValue());
        return new UserDeletedEvent(user, ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public UserUpdatedEvent updateUser(User user) {
        user.setCopyState(CopyState.UPDATING);
        return new UserUpdatedEvent(user, ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public OrganizationCreatedEvent createOrganization(Organization organization) {
        organization.initializeOrganization();
        organization.setCopyState(CopyState.CREATING);
        log.info("Organization with id: {} is initiated", organization.getId().getValue());
        return new OrganizationCreatedEvent(organization,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public OrganizationDeletedEvent deleteOrganization(Organization organization) {
        organization.deleteOrganization();
        organization.setCopyState(CopyState.DELETING);
        log.info("Organization with id: {} is deleted", organization.getId().getValue());
        return new OrganizationDeletedEvent(organization,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public OrganizationUpdatedEvent updateOrganization(Organization organization) {
        organization.setCopyState(CopyState.UPDATING);
        return new OrganizationUpdatedEvent(organization,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public void createUserRole(UserRole userRole) {
        userRole.initializeUserRole();
        log.info("User role with id: {} is initiated", userRole.getId().getValue());
    }

    @Override
    public void createRole(Role role) {
        role.initializeRole();
        log.info("Role with id: {} is initiated", role.getId().getValue());
    }
}
