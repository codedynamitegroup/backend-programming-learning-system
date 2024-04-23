package com.backend.programming.learning.system.core.service.domain.implement.message.listener.user;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.user.UserCreateRequest;
import com.backend.programming.learning.system.core.service.domain.dto.method.message.user.UserDeleteRequest;
import com.backend.programming.learning.system.core.service.domain.dto.method.message.user.UserUpdateRequest;
import com.backend.programming.learning.system.core.service.domain.event.user.UserEvent;
import com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.auth.UserRequestMessageListener;
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
    public void userCreated(UserCreateRequest userRequest) {
        UserEvent userEvent = userRequestHelper.persistUser(userRequest);
        fireEvent(userEvent);
    }

    @Override
    public void userUpdated(UserUpdateRequest userUpdateRequest) {

    }

    @Override
    public void userDeleted(UserDeleteRequest userDeleteRequest) {

    }


    private void fireEvent(UserEvent userEvent) {
        log.info("Publishing user event with user id: {}",
                userEvent.getUser().getId().getValue());
        userEvent.fire();
    }
}
