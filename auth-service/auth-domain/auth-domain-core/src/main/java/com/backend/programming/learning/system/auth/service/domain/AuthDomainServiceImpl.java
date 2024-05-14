package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationUpdatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserCreatedFailEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserCreatedSuccessEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserUpdatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserUpdatedFailEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserUpdatedSuccessEvent;
import com.backend.programming.learning.system.domain.DomainConstants;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
public class AuthDomainServiceImpl implements AuthDomainService {
    @Override
    public UserCreatedEvent createUser(User user) {
        user.initializeUser();
        log.info("User with id: {} is initiated", user.getId().getValue());
        return new UserCreatedEvent(user, ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
    }

    @Override
    public UserDeletedEvent deleteUser(User user) {
        user.deleteUser();
        log.info("User with id: {} is deleted", user.getId().getValue());
        return new UserDeletedEvent(user, ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
    }

    @Override
    public UserUpdatedEvent updateUser(User user) {
        return new UserUpdatedEvent(user, ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
    }

    @Override
    public OrganizationCreatedEvent createOrganization(Organization organization) {
        organization.initializeOrganization();
        log.info("Organization with id: {} is initiated", organization.getId().getValue());
        return new OrganizationCreatedEvent(organization,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
    }

    @Override
    public OrganizationDeletedEvent deleteOrganization(Organization organization) {
        organization.deleteOrganization();
        log.info("Organization with id: {} is deleted", organization.getId().getValue());
        return new OrganizationDeletedEvent(organization,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
    }

    @Override
    public OrganizationUpdatedEvent updateOrganization(Organization organization) {
        return new OrganizationUpdatedEvent(organization,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
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

    @Override
    public UserCreatedFailEvent createdUserFail(User user, List<String> failureMessages) {
        return new UserCreatedFailEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
    }

    @Override
    public UserCreatedSuccessEvent createdUserSuccess(User user) {
        return new UserCreatedSuccessEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
    }

    @Override
    public UserUpdatedFailEvent updatedUserFail(User user, List<String> failureMessages) {
        return new UserUpdatedFailEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)),
                failureMessages);
    }

    @Override
    public UserUpdatedSuccessEvent updatedUserSuccess(User user) {
        return new UserUpdatedSuccessEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
    }
}
