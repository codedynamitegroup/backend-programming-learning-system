package com.backend.programming.learning.system.code.assessment.service.domain.implement.message.listener.user;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.user.UserRequest;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener.UserRequestMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class UserRequestMessageListenerImpl implements UserRequestMessageListener {
    private final UserRequestHelper userRequestHelper;

    public UserRequestMessageListenerImpl(UserRequestHelper userRequestHelper) {
        this.userRequestHelper = userRequestHelper;
    }

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
        userRequestHelper.deletedUser(userDeleteRequest);
    }
}
