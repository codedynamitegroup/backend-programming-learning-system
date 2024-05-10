package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

public interface RoleKeycloakApplicationService {
    void assignRole(String userId,String roleName);
}
