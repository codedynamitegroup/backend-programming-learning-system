package com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.user;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.user.UserResponse;

public interface UserResponseAuthServiceToCourseServiceMessageListener {
    void userCreatedUpdatedFail(UserResponse userResponse);
    void userCreatedUpdatedSuccess(UserResponse userResponse);
}
