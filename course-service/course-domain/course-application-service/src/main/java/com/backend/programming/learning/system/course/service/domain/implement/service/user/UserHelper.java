package com.backend.programming.learning.system.course.service.domain.implement.service.user;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user.UserModel;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.entity.WebhookMessage;
import com.backend.programming.learning.system.course.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.course.service.domain.implement.service.moodle.MoodleCommandHandler;
import com.backend.programming.learning.system.course.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.course.service.domain.outbox.scheduler.user.UserOutboxHelper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class UserHelper {
    private final UserDataMapper userDataMapper;
    private final UserRepository userRepository;
    private final CourseDomainService courseDomainService;
    private final MoodleCommandHandler moodleCommandHandler;
    private final UserOutboxHelper userOutboxHelper;

    public UserHelper(
            UserDataMapper userDataMapper,
            UserRepository userRepository,
            CourseDomainService courseDomainService, MoodleCommandHandler moodleCommandHandler,
            UserOutboxHelper userOutboxHelper) {
        this.userDataMapper = userDataMapper;
        this.userRepository = userRepository;
        this.courseDomainService = courseDomainService;
        this.moodleCommandHandler = moodleCommandHandler;
        this.userOutboxHelper = userOutboxHelper;
    }

    @Transactional
    public User createUser(WebhookMessage webhookMessage, Organization organization) {
        UserModel userModel = moodleCommandHandler.getUser(webhookMessage.getRelatedUserId());
        User user = userDataMapper.userModelToUser(userModel, organization);

        courseDomainService.createUser(user);

        User result = userRepository.save(user);
        log.info("User created with id: {} and moodle id: {}", result.getUserIdMoodle(), result.getId());

        userOutboxHelper.saveUserOutboxMessage(userDataMapper.userToUserEventPayload(result, CopyState.CREATING),
                CopyState.CREATING,
                OutboxStatus.STARTED,
                UUID.randomUUID());
        return result;
    }


    @Transactional
    public User updateUser(WebhookMessage webhookMessage) {
        UserModel userModel = moodleCommandHandler.getUser(webhookMessage.getRelatedUserId());
        User prevUser = getUser(Integer.valueOf(webhookMessage.getRelatedUserId()));
        User user = userDataMapper.setUserWithOtherPayload(userModel, prevUser);

        courseDomainService.updateUser(user);

        User result = userRepository.save(user);
        log.info("User updated with id: {} and moodle id: {}", result.getUserIdMoodle(), result.getId());

        userOutboxHelper.saveUserOutboxMessage(userDataMapper.userToUserEventPayload(result, CopyState.UPDATING),
                CopyState.UPDATING,
                OutboxStatus.STARTED,
                UUID.randomUUID());

        return result;
    }

    @Transactional
    public void deleteUser(WebhookMessage webhookMessage) {
        User user = getUser(Integer.valueOf(webhookMessage.getRelatedUserId()));

        userRepository.deleteByUserMoodleId(user.getUserIdMoodle());

        userOutboxHelper.saveUserOutboxMessage(userDataMapper.userToUserEventPayload(user, CopyState.DELETING),
                CopyState.DELETING,
                OutboxStatus.STARTED,
                UUID.randomUUID());

        log.info("User deleted with moodle id: {}", webhookMessage.getRelatedUserId());
    }

    private User getUser(Integer moodleId) {
        Optional<User> user = userRepository.findByUserIdMoodle(moodleId);

        if (user.isEmpty()) {
            log.info("User not found with moodle id: {}", moodleId);
            throw new UserNotFoundException("User not found with moodle id: " + moodleId);
        }
        return user.get();
    }
    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);

        if (user.isEmpty()) {
            log.info("User not found with id: {}", userId);
            throw new UserNotFoundException("User not found with id: " + userId);
        }
        return user.get();
    }
}
