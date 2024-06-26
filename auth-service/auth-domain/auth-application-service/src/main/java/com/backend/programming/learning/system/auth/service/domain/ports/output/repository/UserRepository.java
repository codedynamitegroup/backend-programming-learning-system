package com.backend.programming.learning.system.auth.service.domain.ports.output.repository;

import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UserId userId);
    Optional<User> findByIdAndIsDeletedTrueOrFalse(UserId userId);
    Optional<User> findByEmailAndIsDeletedTrueOrFalse(String email);
    Optional<User> findByEmail(String email);
    Page<User> findAll(Integer page, Integer size, String searchName, String belongToOrg);

    Optional<User> findUser(UUID value);
    Page<User> findAllUsersByOrganization(UUID organizationId, Integer page, Integer size, String searchName);
}
