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
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.util.List;

public interface AuthDomainService {
    UserCreatedEvent createUser(User user);
    UserDeletedEvent deleteUser(User user);
    UserUpdatedEvent updateUser(User user);
    OrganizationCreatedEvent createOrganization(Organization organization);
    OrganizationDeletedEvent deleteOrganization(Organization organization);
    OrganizationUpdatedEvent updateOrganization(Organization organization);
    void createUserRole(UserRole userRole);
    void createRole(Role role);

    UserCreatedFailEvent createdUserFail(User user, List<String> failureMessages);

    UserCreatedSuccessEvent createdUserSuccess(User user);

    UserUpdatedFailEvent updatedUserFail(User user, List<String> failureMessages);

    UserUpdatedSuccessEvent updatedUserSuccess(User user);
}
