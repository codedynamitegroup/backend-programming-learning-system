package com.backend.programming.learning.system.code.assessment.service.domain.implement.message.listener.user;

import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.user.UserRequest;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import com.backend.programming.learning.system.code.assessment.service.domain.event.user.*;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.user.UserOutboxHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.message.publisher.user.UserResponseMessagePublisher;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class UserRequestHelper {
    private final UserDataMapper userDataMapper;
    private final UserRepository userRepository;
    private final CodeAssessmentDomainService codeAssessmentDomainService;
    private final UserOutboxHelper userOutboxHelper;
    private final UserResponseMessagePublisher userResponseMessagePublisher;

    public UserRequestHelper(UserDataMapper userDataMapper, UserRepository userRepository, CodeAssessmentDomainService codeAssessmentDomainService, UserOutboxHelper userOutboxHelper, UserResponseMessagePublisher userResponseMessagePublisher) {
        this.userDataMapper = userDataMapper;
        this.userRepository = userRepository;
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.userOutboxHelper = userOutboxHelper;
        this.userResponseMessagePublisher = userResponseMessagePublisher;
    }

    @Transactional
    public void createdUser(UserRequest userRequest) {
        if (publishOutboxMessageProcessedForUser(userRequest, CopyState.CREATED)) {
            log.info("An outbox message with saga id: {} is already saved to database", userRequest.getSagaId());
            return;
        }

        User user = userDataMapper.userCreateRequestToUser(userRequest);
        Optional<User> userResult = userRepository.findUserByEmail(user.getEmail());
        List<String> failureMessages = new ArrayList<>();
        //Find user with email
        if (userResult.isPresent()) {
            log.error("Found user with email: {}", user.getEmail());
            failureMessages.add("Found user with email: " + user.getEmail());
            UserCreatedFailEvent userCreatedFailEvent = codeAssessmentDomainService.createdUserFail(user, failureMessages);
            userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userCreatedFailEvent, CopyState.CREATE_FAILED),
                    CopyState.CREATE_FAILED,
                    OutboxStatus.STARTED,
                    UUID.fromString(userRequest.getSagaId()));
            return;
        }

        //Save user
        User userSaved = userRepository.save(user);
        if (userSaved == null) {
            log.error("Could not create user with id: {}", user.getId().getValue().toString());
            failureMessages.add("Could not create user with id: " + user.getId().getValue().toString());
            UserCreatedFailEvent userCreatedFailEvent = codeAssessmentDomainService.createdUserFail(user, failureMessages);
            userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userCreatedFailEvent, CopyState.CREATE_FAILED),
                    CopyState.CREATE_FAILED,
                    OutboxStatus.STARTED,
                    UUID.fromString(userRequest.getSagaId()));
            return;
        }

        log.info("User is created with id: {}", userSaved.getId().getValue());
        UserCreatedSuccessEvent userCreatedSuccessEvent = codeAssessmentDomainService.createdUserSuccess(user);

        userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userCreatedSuccessEvent, CopyState.CREATED),
                CopyState.CREATED,
                OutboxStatus.STARTED,
                UUID.fromString(userRequest.getSagaId()));
    }

    @Transactional
    public void deletedUser(UserRequest userRequest) {
        if (publishOutboxMessageProcessedForUser(userRequest, CopyState.DELETED)) {
            log.info("An outbox message with saga id: {} is already saved to database", userRequest.getSagaId());
            return;
        }

        User user = userDataMapper.userDeleteRequestToUser(userRequest);
        Optional<User> userFound = userRepository.findById(new UserId(user.getId().getValue()));
        List<String> failureMessages = new ArrayList<>();
        //Find user with id
        if (userFound.isEmpty()) {
            log.error("Not found user with id: {}", user.getId().getValue());
            failureMessages.add("Not found user with id: " + user.getId().getValue());
            UserDeletedFailEvent userDeletedFailEvent = codeAssessmentDomainService.deletedUserFail(user, failureMessages);
            userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userDeletedFailEvent, CopyState.DELETE_FAILED),
                    CopyState.DELETE_FAILED,
                    OutboxStatus.STARTED,
                    UUID.fromString(userRequest.getSagaId()));
            return;
        }

        //Deleting user
        User userDeleted = userFound.get();

        userDeleted.setDeleted(user.getDeleted());

        //Save user
        User userSaved = userRepository.save(userDeleted);
        if (userSaved == null) {
            log.error("Could not delete user with id: {}", user.getId().getValue());
            return;
        }
        log.info("User is deleted with id: {}", userSaved.getId().getValue());

        UserDeletedSuccessEvent userDeletedSuccessEvent = codeAssessmentDomainService.deletedUserSuccess(user);

        userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userDeletedSuccessEvent, CopyState.DELETED),
                CopyState.DELETED,
                OutboxStatus.STARTED,
                UUID.fromString(userRequest.getSagaId()));
    }

    @Transactional
    public void updatedUser(UserRequest userUpdateRequest) {
        if (publishOutboxMessageProcessedForUser(userUpdateRequest, CopyState.UPDATED)) {
            log.info("An outbox message with saga id: {} is already saved to database", userUpdateRequest.getSagaId());
            return;
        }

        User user = userDataMapper.userUpdateRequestToUser(userUpdateRequest);
        Optional<User> userFound = userRepository.findById(new UserId(user.getId().getValue()));
        List<String> failureMessages = new ArrayList<>();

        //Find user with id
        if (userFound.isEmpty()) {
            log.error("Not found user with id: {}", user.getId().getValue());
            failureMessages.add("Not found user with id: " + user.getId().getValue());
            UserUpdatedFailEvent userUpdatedFailEvent = codeAssessmentDomainService.updatedUserFail(user, failureMessages);
            userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userUpdatedFailEvent, CopyState.UPDATE_FAILED),
                    CopyState.UPDATE_FAILED,
                    OutboxStatus.STARTED,
                    UUID.fromString(userUpdateRequest.getSagaId()));
            return;
        }

        //Update user
        User userUpdated = userFound.get();

        userUpdated.setUpdatedAt(user.getUpdatedAt());

        if (userUpdateRequest.getDob().get(ChronoField.NANO_OF_SECOND) != 0) {
            userUpdated.setDob(user.getDob());
        }
        if (userUpdateRequest.getFirstName() != null) {
            userUpdated.setFirstName(user.getFirstName());
        }
        if (userUpdateRequest.getLastName() != null) {
            userUpdated.setLastName(user.getLastName());
        }
        if (userUpdateRequest.getPhone() != null) {
            userUpdated.setPhone(user.getPhone());
        }
        if (userUpdateRequest.getAddress() != null) {
            userUpdated.setAddress(user.getAddress());
        }
        if (userUpdateRequest.getAvatarUrl() != null) {
            userUpdated.setAvatarUrl(user.getAvatarUrl());
        }
        if (userUpdateRequest.getIsDeleted() != null) {
            userUpdated.setDeleted(user.getDeleted());
        }

        //Save user
        User userSaved = userRepository.save(userUpdated);
        if (userSaved == null) {
            log.error("Could not update user with id: {}", user.getId().getValue());
            failureMessages.add("Could not update user with id: " + user.getId().getValue());
            UserUpdatedFailEvent userUpdatedFailEvent = codeAssessmentDomainService.updatedUserFail(user, failureMessages);
            userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userUpdatedFailEvent, CopyState.UPDATE_FAILED),
                    CopyState.UPDATE_FAILED,
                    OutboxStatus.STARTED,
                    UUID.fromString(userUpdateRequest.getSagaId()));
            return;
        }

        log.info("User is updated with id: {}", userSaved.getId().getValue());
        UserUpdatedSuccessEvent userUpdatedSuccessEvent = codeAssessmentDomainService.updatedUserSuccess(user);

        userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userUpdatedSuccessEvent, CopyState.UPDATED),
                CopyState.UPDATED,
                OutboxStatus.STARTED,
                UUID.fromString(userUpdateRequest.getSagaId()));
    }

    private boolean publishOutboxMessageProcessedForUser(UserRequest userRequest, CopyState copyState) {
        Optional<UserOutboxMessage> userOutboxMessage =
                userOutboxHelper.getUserOutboxMessageBySagaIdAndCopyState(
                        UUID.fromString(userRequest.getSagaId()), copyState);
        if (userOutboxMessage.isPresent()) {
            userResponseMessagePublisher.publish(userOutboxMessage.get(), userOutboxHelper::updateOutboxMessage);
            return true;
        }
        return false;
    }
}
