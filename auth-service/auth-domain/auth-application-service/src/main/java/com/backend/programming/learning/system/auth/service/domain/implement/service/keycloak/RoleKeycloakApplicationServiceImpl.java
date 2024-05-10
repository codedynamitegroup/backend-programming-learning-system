package com.backend.programming.learning.system.auth.service.domain.implement.service.keycloak;

import com.backend.programming.learning.system.auth.service.domain.ports.input.service.RoleKeycloakApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class RoleKeycloakApplicationServiceImpl implements RoleKeycloakApplicationService {
    @Override
    public void assignRole(String userId, String roleName) {

    }
}
