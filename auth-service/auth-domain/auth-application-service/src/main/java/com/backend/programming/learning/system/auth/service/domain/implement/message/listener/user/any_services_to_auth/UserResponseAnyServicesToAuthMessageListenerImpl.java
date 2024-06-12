package com.backend.programming.learning.system.auth.service.domain.implement.message.listener.user.any_services_to_auth;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.user.UserResponse;
import com.backend.programming.learning.system.auth.service.domain.implement.saga.user.UserUpdateSaga;
import com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener.user.UserResponseAnyServicesToAuthMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class UserResponseAnyServicesToAuthMessageListenerImpl implements UserResponseAnyServicesToAuthMessageListener {
    private final UserUpdateSaga userUpdateSaga;

    public UserResponseAnyServicesToAuthMessageListenerImpl(UserUpdateSaga userUpdateSaga) {
        this.userUpdateSaga = userUpdateSaga;
    }

    @Override
    public void userCreatedUpdatedOrDeletedFail(UserResponse userResponse) {
        userUpdateSaga.rollback(userResponse);
    }

    @Override
    public void userCreatedUpdatedOrDeletedSuccess(UserResponse userResponse) {
        userUpdateSaga.process(userResponse);
    }
}
