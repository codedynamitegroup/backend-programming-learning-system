package com.backend.programming.learning.system.course.service.domain.implement.service.listener.user.response_auth_to_course;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.user.UserResponse;
import com.backend.programming.learning.system.course.service.domain.implement.saga.user.UserUpdateSaga;
import com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.user.UserResponseAuthServiceToCourseServiceMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class UserResponseAnyServicesToAuthMessageListenerImpl implements UserResponseAuthServiceToCourseServiceMessageListener {
    private final UserUpdateSaga userUpdateSaga;

    public UserResponseAnyServicesToAuthMessageListenerImpl(UserUpdateSaga userUpdateSaga) {
        this.userUpdateSaga = userUpdateSaga;
    }

    @Override
    public void userCreatedUpdatedFail(UserResponse userResponse) {
        userUpdateSaga.rollback(userResponse);
    }

    @Override
    public void userCreatedUpdatedSuccess(UserResponse userResponse) {
        userUpdateSaga.process(userResponse);
    }
}
