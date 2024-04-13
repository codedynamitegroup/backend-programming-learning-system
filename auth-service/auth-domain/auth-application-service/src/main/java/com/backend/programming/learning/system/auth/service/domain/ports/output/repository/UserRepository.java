package com.backend.programming.learning.system.auth.service.domain.ports.output.repository;

import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.auth.service.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UserId userId);
    Optional<User> findByEmail(String email);
    List<User> findAll();
}
