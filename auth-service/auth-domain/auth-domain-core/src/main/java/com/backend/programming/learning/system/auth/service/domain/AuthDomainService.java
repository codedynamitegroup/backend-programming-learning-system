package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;

public interface AuthDomainService {
    void createUser(User user);
    void deleteUser(User user);
    void createOrganization(Organization organization);
    void deleteOrganization(Organization organization);
    void createUserRole(UserRole userRole);
    void createRole(Role role);
}
