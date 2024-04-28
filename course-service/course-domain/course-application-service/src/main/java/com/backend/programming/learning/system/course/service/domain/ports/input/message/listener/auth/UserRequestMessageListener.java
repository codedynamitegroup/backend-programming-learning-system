package com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.auth;


import com.backend.programming.learning.system.course.service.domain.dto.method.message.user.UserCreateRequest;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.user.UserDeleteRequest;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.user.UserUpdateRequest;

public interface UserRequestMessageListener {
    void userCreated(UserCreateRequest userCreateRequest);
    void userUpdated(UserUpdateRequest userUpdateRequest);
    void userDeleted(UserDeleteRequest userDeleteRequest);
}
