package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

public interface RoleKeycloakApplicationService {
    void assignRole(String email, String roleName);
    void removeRole(String email, String roleName);
}
