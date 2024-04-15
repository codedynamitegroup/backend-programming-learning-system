package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.event.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.UserDeletedEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface AuthDomainService {
    UserCreatedEvent createUser(User user, DomainEventPublisher<UserCreatedEvent>
            userCreatedEventDomainEventPublisher);
    UserDeletedEvent deleteUser(User user, DomainEventPublisher<UserDeletedEvent>
            userDeletedEventDomainEventPublisher);
    void createOrganization(Organization organization);
    void deleteOrganization(Organization organization);
    void createUserRole(UserRole userRole);
    void createRole(Role role);
}
