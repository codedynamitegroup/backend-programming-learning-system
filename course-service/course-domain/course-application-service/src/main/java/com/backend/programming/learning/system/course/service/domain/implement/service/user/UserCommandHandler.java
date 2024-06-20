package com.backend.programming.learning.system.course.service.domain.implement.service.user;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserSubmissionAssignmentResponseEntity;
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

import java.util.List;
import java.util.UUID;

import static com.backend.programming.learning.system.saga.user.SagaConstants.COURSE_TO_AUTH_SERVICE_USER_SAGA_NAME;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserCommandHandler {
    private final UserCreateHelper userCreateHelper;
    private final UserDataMapper userDataMapper;
    private final UserUpdateHelper userUpdateHelper;
    private final UserQueryHelper userQueryHelper;
    private final UserOutboxHelper userOutboxHelper;
    private final UserUpdateSagaHelper userSagaHelper;


    @Transactional
    public CreateUserResponse createUser(CreateUserCommand createOrderCommand) {
        UserCreatedEvent userCreatedEvent = userCreateHelper.persistUser(createOrderCommand);
        log.info("User is created with id: {}", userCreatedEvent.getUser().getId().getValue());
        CreateUserResponse createUserResponse = userDataMapper.userToCreateUserResponse(userCreatedEvent.getUser(),
                "User created successfully");

        userOutboxHelper.saveUserOutboxMessage(COURSE_TO_AUTH_SERVICE_USER_SAGA_NAME,
                        userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
                        CopyState.CREATING,
                        OutboxStatus.STARTED,
                        userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
                                UUID.randomUUID());

        return createUserResponse;
    }

    @Transactional
    public UpdateUserResponse updateUser(UpdateUserCommand updateUserCommand) {
        UserUpdatedEvent userUpdatedEvent = userUpdateHelper.persistUser(updateUserCommand);

        userOutboxHelper.saveUserOutboxMessage(COURSE_TO_AUTH_SERVICE_USER_SAGA_NAME,
                userDataMapper.userUpdatedEventToUserEventPayload(userUpdatedEvent),
                CopyState.UPDATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
                UUID.randomUUID());

        log.info("User is updated with id: {}", userUpdatedEvent.getUser().getId().getValue());
        return userDataMapper.userToUpdateUserResponse(userUpdatedEvent.getUser(), "User updated successfully");
    }

    @Transactional
    public List<UserSubmissionAssignmentResponseEntity> queryAllUserByAssignmentId(UUID assignmentId) {
        return userDataMapper.userToUserSubmissionAssignmentResponseEntityList(userQueryHelper.queryAllUserByAssignmentId(assignmentId),assignmentId);
    }
}
