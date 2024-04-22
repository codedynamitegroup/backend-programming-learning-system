package com.backend.programming.learning.system.auth.service.domain.implement.message.listener;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.UserResponse;
import com.backend.programming.learning.system.auth.service.domain.implement.saga.CreateUserCoreSaga;
import com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener.CoreServiceUserResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class CoreServiceUserResponseMessageListenerImpl implements CoreServiceUserResponseMessageListener {
    private final CreateUserCoreSaga createUserCoreSaga;

    public CoreServiceUserResponseMessageListenerImpl(CreateUserCoreSaga createUserCoreSaga) {
        this.createUserCoreSaga = createUserCoreSaga;
    }

    @Override
    public void userUpdatedFail(UserResponse userRequest) {

    }

    @Override
    public void userUpdatedSuccess(UserResponse userRequest) {

    }

    @Override
    public void userCreateFail(UserResponse userRequest) {
        log.info("User creation failed with id: {}", userRequest.getUserId());
        createUserCoreSaga.rollback(userRequest);
    }

    @Override
    public void userCreateSuccess(UserResponse userRequest) {
        log.info("User created with id: {}", userRequest.getUserId());
        createUserCoreSaga.process(userRequest);
    }

    @Override
    public void userDeleteFail(UserResponse userRequest) {

    }

    @Override
    public void userDeleteSuccess(UserResponse userRequest) {

    }
}
