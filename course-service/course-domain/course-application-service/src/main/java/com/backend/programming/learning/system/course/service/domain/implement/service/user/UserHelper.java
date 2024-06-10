package com.backend.programming.learning.system.course.service.domain.implement.service.user;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user.UserModel;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.entity.WebhookMessage;
import com.backend.programming.learning.system.course.service.domain.event.user.UserCreatedEvent;
import com.backend.programming.learning.system.course.service.domain.event.user.UserDeletedSuccessEvent;
import com.backend.programming.learning.system.course.service.domain.event.user.UserUpdatedEvent;
import com.backend.programming.learning.system.course.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.course.service.domain.implement.saga.user.UserUpdateSagaHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.moodle.MoodleCommandHandler;
import com.backend.programming.learning.system.course.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.course.service.domain.outbox.scheduler.user.UserOutboxHelper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserHelper {
    private final UserDataMapper userDataMapper;
    private final UserRepository userRepository;
    private final CourseDomainService courseDomainService;
    private final MoodleCommandHandler moodleCommandHandler;
    private final UserOutboxHelper userOutboxHelper;
    private final UserUpdateSagaHelper userSagaHelper;

    @Transactional
    public void createUser(WebhookMessage webhookMessage, Organization organization) {
        UserModel userModel = moodleCommandHandler.getUser(webhookMessage.getRelatedUserId());
        User user = userDataMapper.userModelToUser(userModel, organization);

        UserCreatedEvent userCreatedEvent =  courseDomainService.createUser(user);

        userOutboxHelper.saveUserOutboxMessage(userDataMapper
                        .userEventToUserEventPayloadWithTime(userCreatedEvent,
                                CopyState.CREATING,
                                false),
                CopyState.CREATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
                UUID.randomUUID());
    }

    @Transactional
    public void updateUser(WebhookMessage webhookMessage) {
        UserModel userModel = moodleCommandHandler.getUser(webhookMessage.getRelatedUserId());
        User prevUser = getUser(Integer.valueOf(webhookMessage.getRelatedUserId()));
        User user = userDataMapper.setUserWithOtherPayload(userModel, prevUser);

        UserUpdatedEvent userUpdatedEvent =courseDomainService.updateUser(user);

        userOutboxHelper.saveUserOutboxMessage(userDataMapper
                        .userEventToUserEventPayloadWithTime(userUpdatedEvent,
                                CopyState.UPDATING,
                                false),
                CopyState.UPDATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
                UUID.randomUUID());
    }

    @Transactional
    public void deleteUser(WebhookMessage webhookMessage) {
        User user = getUser(Integer.valueOf(webhookMessage.getRelatedUserId()));

        userRepository.deleteByUserMoodleId(user.getUserIdMoodle());
        log.info("User deleted with moodle id: {}", webhookMessage.getRelatedUserId());

        UserDeletedSuccessEvent userDeletedSuccessEvent = courseDomainService.deletedUserSuccess(user);

        userOutboxHelper.saveUserOutboxMessage(userDataMapper
                        .userEventToUserEventPayloadWithTime(userDeletedSuccessEvent,
                                CopyState.DELETING,
                                true),
                CopyState.DELETING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.DELETING),
                UUID.randomUUID());
    }

    private User getUser(Integer moodleId) {
        Optional<User> user = userRepository.findByUserIdMoodle(moodleId);

        if (user.isEmpty()) {
            log.info("User not found with moodle id: {}", moodleId);
            throw new UserNotFoundException("User not found with moodle id: " + moodleId);
        }
        return user.get();
    }
}
