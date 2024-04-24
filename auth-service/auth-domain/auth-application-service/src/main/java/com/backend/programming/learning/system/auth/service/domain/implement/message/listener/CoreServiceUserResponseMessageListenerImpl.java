package com.backend.programming.learning.system.auth.service.domain.implement.message.listener;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.UserResponse;
import com.backend.programming.learning.system.auth.service.domain.implement.saga.CreatedUserCoreSaga;
import com.backend.programming.learning.system.auth.service.domain.implement.saga.DeletedUserCoreSaga;
import com.backend.programming.learning.system.auth.service.domain.implement.saga.UpdatedUserCoreSaga;
import com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener.CoreServiceUserResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class CoreServiceUserResponseMessageListenerImpl implements CoreServiceUserResponseMessageListener {
    private final CreatedUserCoreSaga createdUserCoreSaga;
    private final UpdatedUserCoreSaga updatedUserCoreSaga;
    private final DeletedUserCoreSaga deletedUserCoreSaga;

    public CoreServiceUserResponseMessageListenerImpl(CreatedUserCoreSaga createdUserCoreSaga, UpdatedUserCoreSaga updatedUserCoreSaga, DeletedUserCoreSaga deletedUserCoreSaga) {
        this.createdUserCoreSaga = createdUserCoreSaga;
        this.updatedUserCoreSaga = updatedUserCoreSaga;
        this.deletedUserCoreSaga = deletedUserCoreSaga;
    }

    @Override
    public void userUpdatedFail(UserResponse userResponse) {
        log.info("User update failed with id: {}", userResponse.getUserId());
        updatedUserCoreSaga.rollback(userResponse);
    }

    @Override
    public void userUpdatedSuccess(UserResponse userResponse) {
        log.info("User updated with id: {}", userResponse.getUserId());
        updatedUserCoreSaga.process(userResponse);
    }

    @Override
    public void userCreateFail(UserResponse userResponse) {
        log.info("User creation failed with id: {}", userResponse.getUserId());
        createdUserCoreSaga.rollback(userResponse);
    }

    @Override
    public void userCreateSuccess(UserResponse userResponse) {
        log.info("User created with id: {}", userResponse.getUserId());
        createdUserCoreSaga.process(userResponse);
    }

    @Override
    public void userDeleteFail(UserResponse userResponse) {
        log.info("User deletion failed with id: {}", userResponse.getUserId());
        createdUserCoreSaga.rollback(userResponse);
    }

    @Override
    public void userDeleteSuccess(UserResponse userResponse) {
        log.info("User deleted with id: {}", userResponse.getUserId());
        deletedUserCoreSaga.process(userResponse);
    }
}
