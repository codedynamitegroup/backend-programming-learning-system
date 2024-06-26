package com.backend.programming.learning.system.auth.service.domain.implement.message.listener.user.course_to_auth;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.user.UserRequest;
import com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener.user.UserRequestCourseToAuthMessageListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class UserRequestCourseToAuthServiceMessageListenerImpl implements UserRequestCourseToAuthMessageListener {
    private final UserRequestCourseToAuthServiceHelper userRequestHelper;

    @Override
    public void userCreated(UserRequest userRequest) {
        userRequestHelper.createdUser(userRequest);
    }

    @Override
    public void userUpdated(UserRequest userUpdateRequest) {
        userRequestHelper.updatedUser(userUpdateRequest);
    }

    @Override
    public void userDeleted(UserRequest userDeleteRequest) {

    }
}
