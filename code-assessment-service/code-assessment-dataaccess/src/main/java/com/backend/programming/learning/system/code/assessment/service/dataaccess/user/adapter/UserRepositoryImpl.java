package com.backend.programming.learning.system.code.assessment.service.dataaccess.user.adapter;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class UserRepositoryImpl implements UserRepository {

    @Override
    public Optional<User> findById(UserId userId) {
        return Optional.empty();
    }
}
