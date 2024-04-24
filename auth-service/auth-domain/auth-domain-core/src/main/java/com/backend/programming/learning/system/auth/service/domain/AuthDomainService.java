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
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface AuthDomainService {
    UserCreatedEvent createUser(User user, DomainEventPublisher<UserCreatedEvent>
            userCreatedEventDomainEventPublisher);
    UserDeletedEvent deleteUser(User user, DomainEventPublisher<UserDeletedEvent>
            userDeletedEventDomainEventPublisher);
    UserUpdatedEvent updateUser(User user, DomainEventPublisher<UserUpdatedEvent>
            userUpdatedEventDomainEventPublisher);
    OrganizationCreatedEvent createOrganization(Organization organization, DomainEventPublisher<OrganizationCreatedEvent>
            organizationCreatedEventDomainEventPublisher);
    OrganizationDeletedEvent deleteOrganization(Organization organization, DomainEventPublisher<OrganizationDeletedEvent>
            organizationDeletedEventDomainEventPublisher);
    OrganizationUpdatedEvent updateOrganization(Organization organization, DomainEventPublisher<OrganizationUpdatedEvent>
            organizationUpdatedEventDomainEventPublisher);
    void createUserRole(UserRole userRole);
    void createRole(Role role);
}
