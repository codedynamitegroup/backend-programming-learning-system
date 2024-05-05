package com.backend.programming.learning.system.auth.service.domain.implement.message.listener;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.UserResponse;
import com.backend.programming.learning.system.auth.service.domain.implement.saga.user.UserUpdateSaga;
import com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener.CoreServiceUserResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class CoreServiceUserResponseMessageListenerImpl implements CoreServiceUserResponseMessageListener {
    private final UserUpdateSaga userUpdateSaga;

    public CoreServiceUserResponseMessageListenerImpl(UserUpdateSaga userUpdateSaga) {
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
