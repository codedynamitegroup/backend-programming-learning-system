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

public interface AuthDomainService {
    UserCreatedEvent createUser(User user);
    UserDeletedEvent deleteUser(User user);
    UserUpdatedEvent updateUser(User user);
    OrganizationCreatedEvent createOrganization(Organization organization);
    OrganizationDeletedEvent deleteOrganization(Organization organization);
    OrganizationUpdatedEvent updateOrganization(Organization organization);
    void createUserRole(UserRole userRole);
    void createRole(Role role);
}
