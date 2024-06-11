package com.backend.programming.learning.system.course.service.domain.implement.service.user;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.event.user.UserUpdatedEvent;
import com.backend.programming.learning.system.course.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserUpdateHelper {
    private final UserRepository userRepository;
    private final CourseDomainService courseDomainService;

    @Transactional
    public UserUpdatedEvent persistUser(UpdateUserCommand updateUserCommand) {
        User user = getUser(updateUserCommand.getUserId());
        user.setUpdatedAt(ZonedDateTime.now(ZoneId.of("UTC")));

        if (updateUserCommand.getUserIdMoodle() != null) {
            user.setUserIdMoodle(updateUserCommand.getUserIdMoodle());
        }
        if (updateUserCommand.getUsername() != null) {
            user.setUserName(updateUserCommand.getUsername());
        }
        if (updateUserCommand.getDob() != null) {
            user.setDob(updateUserCommand.getDob());
        }
        if (updateUserCommand.getFirstName() != null) {
            user.setFirstName(updateUserCommand.getFirstName());
        }
        if (updateUserCommand.getLastName() != null) {
            user.setLastName(updateUserCommand.getLastName());
        }
        if (updateUserCommand.getPhone() != null) {
            user.setPhone(updateUserCommand.getPhone());
        }
        if (updateUserCommand.getAddress() != null) {
            user.setAddress(updateUserCommand.getAddress());
        }
        if (updateUserCommand.getAvatarUrl() != null) {
            user.setAvatarUrl(updateUserCommand.getAvatarUrl());
        }

        return courseDomainService.updateUser(user);
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findById(new UserId(userId));
        if (user.isEmpty()) {
            log.error("User with id: {} could not be found!", userId);
            throw new AuthDomainException("User with id: " + userId + " could not be found!");
        }
        return user.get();
    }
}
