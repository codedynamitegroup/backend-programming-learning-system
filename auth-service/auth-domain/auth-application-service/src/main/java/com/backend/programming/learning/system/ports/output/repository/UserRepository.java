package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.entity.User;

import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findById(UserId userId);
}
