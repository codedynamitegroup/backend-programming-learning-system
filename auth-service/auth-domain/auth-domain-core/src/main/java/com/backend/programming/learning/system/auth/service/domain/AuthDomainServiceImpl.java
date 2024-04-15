package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthDomainServiceImpl implements AuthDomainService {
    @Override
    public void createUser(User user) {
        user.initializeUser();
        log.info("User with id: {} is initiated", user.getId().getValue());
    }

    @Override
    public void deleteUser(User user) {
        user.deleteUser();
        log.info("User with id: {} is deleted", user.getId().getValue());
    }

    @Override
    public void createOrganization(Organization organization) {
        organization.initializeOrganization();
        log.info("Organization with id: {} is initiated", organization.getId().getValue());
    }

    @Override
    public void deleteOrganization(Organization organization) {
        organization.deleteOrganization();
        log.info("Organization with id: {} is deleted", organization.getId().getValue());
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
