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
    private final UserCreateRequestHelper userCreateRequestHelper;
    private final UserUpdateRequestHelper userUpdateRequestHelper;
    private final UserDeleteRequestHelper userDeleteRequestHelper;

    public UserRequestMessageListenerImpl(UserCreateRequestHelper userCreateRequestHelper, UserUpdateRequestHelper userUpdateRequestHelper, UserDeleteRequestHelper userDeleteRequestHelper) {
        this.userCreateRequestHelper = userCreateRequestHelper;
        this.userUpdateRequestHelper = userUpdateRequestHelper;
        this.userDeleteRequestHelper = userDeleteRequestHelper;
    }

    @Override
    public void userCreated(UserCreateRequest userRequest) {
        UserEvent userEvent = userCreateRequestHelper.persistUser(userRequest);
        fireEvent(userEvent);
    }

    @Override
    public void userUpdated(UserUpdateRequest userUpdateRequest) {
        UserEvent userEvent = userUpdateRequestHelper.persistUser(userUpdateRequest);
        fireEvent(userEvent);
    }

    @Override
    public void userDeleted(UserDeleteRequest userDeleteRequest) {
        UserEvent userEvent = userDeleteRequestHelper.persistUser(userDeleteRequest);
        fireEvent(userEvent);
    }


    private void fireEvent(UserEvent userEvent) {
        log.info("Publishing user event with user id: {}",
                userEvent.getUser().getId().getValue());
        userEvent.fire();
    }
}
