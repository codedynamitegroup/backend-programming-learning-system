package com.backend.programming.learning.system.course.service.domain.implement.message.listener.user;


import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.user.UserUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.event.user.UserEvent;
import com.backend.programming.learning.system.course.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.user.UserUpdateFailedMessagePublisher;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.user.UserUpdatedSuccessMessagePublisher;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserUpdateRequestHelper {
    private final UserDataMapper userDataMapper;
    private final UserRepository userRepository;
    private final CourseDomainService courseDomainService;
    private final UserUpdatedSuccessMessagePublisher userUpdatedSuccessMessagePublisher;
    private final UserUpdateFailedMessagePublisher userUpdateFailedMessagePublisher;

    public UserUpdateRequestHelper(UserDataMapper userDataMapper, UserRepository userRepository, CourseDomainService courseDomainService, UserUpdatedSuccessMessagePublisher userUpdatedSuccessMessagePublisher, UserUpdateFailedMessagePublisher userUpdateFailedMessagePublisher) {
        this.userDataMapper = userDataMapper;
        this.userRepository = userRepository;
        this.courseDomainService = courseDomainService;
        this.userUpdatedSuccessMessagePublisher = userUpdatedSuccessMessagePublisher;
        this.userUpdateFailedMessagePublisher = userUpdateFailedMessagePublisher;
    }

    @Transactional
    public UserEvent persistUser(UserUpdateRequest userUpdateRequest) {
        User user = userDataMapper.userUpdateRequestToUser(userUpdateRequest);
        Optional<User> userFound = userRepository.findUser(user.getId().getValue());
        List<String> failureMessages = new ArrayList<>();
        //Find user with id
        if (userFound.isEmpty()) {
            log.error("Not found user with id: {}", user.getId().getValue());
            failureMessages.add("Not found user with id: " + user.getId().getValue());
            return courseDomainService.updateUserFail(user,
                    userUpdateFailedMessagePublisher,
                    failureMessages);
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

        //Save user
        User userSaved = userRepository.saveUser(userUpdated);
        if (userSaved == null) {
            log.error("Could not update user with id: {}", user.getId().getValue());
            failureMessages.add("Could not update user with id: " + user.getId().getValue());
            return courseDomainService.updateUserFail(user,
                    userUpdateFailedMessagePublisher,
                    failureMessages);
        }
        log.info("User is updated with id: {}", userSaved.getId().getValue());

        return courseDomainService.updateUserSuccess(user, userUpdatedSuccessMessagePublisher);
    }
}
