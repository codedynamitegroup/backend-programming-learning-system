package com.backend.programming.learning.system.auth.service.domain.implement.saga;

import com.backend.programming.learning.system.auth.service.domain.AuthDomainService;
import com.backend.programming.learning.system.auth.service.domain.dto.method.message.UserResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.event.EmptyEvent;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.saga.SagaStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class DeletedUserCoreSaga implements SagaStep<UserResponse, EmptyEvent, EmptyEvent> {
    private final AuthDomainService authDomainService;
    private final UserRepository userRepository;

    public DeletedUserCoreSaga(AuthDomainService authDomainService, UserRepository userRepository) {
        this.authDomainService = authDomainService;
        this.userRepository = userRepository;
    }


    @Override
    @Transactional
    public EmptyEvent process(UserResponse userResponse) {
        log.info("Deleting user with id: {}", userResponse.getUserId());
        return EmptyEvent.INSTANCE;
    }

    @Override
    @Transactional
    public EmptyEvent rollback(UserResponse userResponse) {
        log.info("Deleting user fail with id: {}", userResponse.getUserId());
        return EmptyEvent.INSTANCE;
    }
}
