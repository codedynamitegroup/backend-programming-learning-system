package com.backend.programming.learning.system.course.service.domain.implement.service.user;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.course.service.domain.event.user.UserCreatedEvent;
import com.backend.programming.learning.system.course.service.domain.event.user.UserUpdatedEvent;
import com.backend.programming.learning.system.course.service.domain.implement.saga.user.UserUpdateSagaHelper;
import com.backend.programming.learning.system.course.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.course.service.domain.outbox.scheduler.user.UserOutboxHelper;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserCommandHandler {
    private final UserCreateHelper userCreateHelper;
    private final UserDataMapper userDataMapper;
    private final UserUpdateHelper userUpdateHelper;
    private final UserOutboxHelper userOutboxHelper;
    private final UserUpdateSagaHelper userSagaHelper;


    @Transactional
    public CreateUserResponse createUser(CreateUserCommand createOrderCommand) {
        UserCreatedEvent userCreatedEvent = userCreateHelper.persistUser(createOrderCommand);
        log.info("User is created with id: {}", userCreatedEvent.getUser().getId().getValue());
        CreateUserResponse createUserResponse = userDataMapper.userToCreateUserResponse(userCreatedEvent.getUser(),
                "User created successfully");

        userOutboxHelper.saveUserOutboxMessage(
                        userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
//                        ServiceName.CORE_SERVICE,
                        CopyState.CREATING,
                        OutboxStatus.STARTED,
//                        userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
                                UUID.randomUUID());

//        userOutboxHelper.saveUserOutboxMessage(
//                userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
////                ServiceName.COURSE_SERVICE,
//                CopyState.CREATING,
//                OutboxStatus.STARTED,
////                userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
//                UUID.randomUUID());
//
//        userOutboxHelper.saveUserOutboxMessage(
//                userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
////                ServiceName.CODE_ASSESSMENT_SERVICE,
//                CopyState.CREATING,
//                OutboxStatus.STARTED,
////                userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
//                UUID.randomUUID());

        return createUserResponse;
    }

    @Transactional
    public UpdateUserResponse updateUser(UpdateUserCommand updateUserCommand) {
        UserUpdatedEvent userUpdatedEvent = userUpdateHelper.persistUser(updateUserCommand);

        userOutboxHelper.saveUserOutboxMessage(
                userDataMapper.userUpdatedEventToUserEventPayload(userUpdatedEvent),
//                ServiceName.CORE_SERVICE,
                CopyState.UPDATING,
                OutboxStatus.STARTED,
//                userSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
                UUID.randomUUID());

//        userOutboxHelper.saveUserOutboxMessage(
//                userDataMapper.userUpdatedEventToUserEventPayload(userUpdatedEvent),
//                ServiceName.COURSE_SERVICE,
//                CopyState.UPDATING,
//                OutboxStatus.STARTED,
//                userSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
//                UUID.randomUUID());
//
//        userOutboxHelper.saveUserOutboxMessage(
//                userDataMapper.userUpdatedEventToUserEventPayload(userUpdatedEvent),
//                ServiceName.CODE_ASSESSMENT_SERVICE,
//                CopyState.UPDATING,
//                OutboxStatus.STARTED,
//                userSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
//                UUID.randomUUID());

        log.info("User is updated with id: {}", userUpdatedEvent.getUser().getId().getValue());
        return userDataMapper.userToUpdateUserResponse(userUpdatedEvent.getUser(), "User updated successfully");
    }
}
