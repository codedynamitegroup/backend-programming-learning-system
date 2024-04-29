package com.backend.programming.learning.system.auth.service.domain.implement.saga;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.UserResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.auth.service.domain.scheduler.user.UserOutboxHelper;
import com.backend.programming.learning.system.saga.SagaStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Component
public class DeletedUserCoreSaga implements SagaStep<UserResponse> {
    private final UserOutboxHelper userOutboxHelper;
    private final UserSagaHelper userSagaHelper;
    private final UserRepository userRepository;

    public DeletedUserCoreSaga(UserOutboxHelper userOutboxHelper, UserSagaHelper userSagaHelper, UserRepository userRepository) {
        this.userOutboxHelper = userOutboxHelper;
        this.userSagaHelper = userSagaHelper;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void process(UserResponse userResponse) {

    }

    @Override
    @Transactional
    public void rollback(UserResponse userResponse) {

    }
}
