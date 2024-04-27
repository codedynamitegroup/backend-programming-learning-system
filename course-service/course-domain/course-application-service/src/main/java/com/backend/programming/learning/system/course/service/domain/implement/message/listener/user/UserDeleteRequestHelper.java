package com.backend.programming.learning.system.course.service.domain.implement.message.listener.user;


import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.user.UserDeleteRequest;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.event.user.UserEvent;
import com.backend.programming.learning.system.course.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.user.UserDeleteFailedMessagePublisher;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.user.UserDeletedSuccessMessagePublisher;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserDeleteRequestHelper {
    private final UserDataMapper userDataMapper;
    private final UserRepository userRepository;
    private final CourseDomainService courseDomainService;
    private final UserDeletedSuccessMessagePublisher userDeletedSuccessMessagePublisher;
    private final UserDeleteFailedMessagePublisher userDeleteFailedMessagePublisher;

    public UserDeleteRequestHelper(UserDataMapper userDataMapper, UserRepository userRepository, CourseDomainService courseDomainService, UserDeletedSuccessMessagePublisher userDeletedSuccessMessagePublisher, UserDeleteFailedMessagePublisher userDeleteFailedMessagePublisher) {
        this.userDataMapper = userDataMapper;
        this.userRepository = userRepository;
        this.courseDomainService = courseDomainService;
        this.userDeletedSuccessMessagePublisher = userDeletedSuccessMessagePublisher;
        this.userDeleteFailedMessagePublisher = userDeleteFailedMessagePublisher;
    }


    @Transactional
    public UserEvent persistUser(UserDeleteRequest userRequest) {
        User user = userDataMapper.userDeleteRequestToUser(userRequest);
        Optional<User> userFound = userRepository.findUser(user.getId().getValue());
        List<String> failureMessages = new ArrayList<>();
        //Find user with id
        if (userFound.isEmpty()) {
            log.error("Not found user with id: {}", user.getId().getValue());
            failureMessages.add("Not found user with id: " + user.getId().getValue());
            return courseDomainService.deletedUserFail(user,
                    userDeleteFailedMessagePublisher,
                    failureMessages);
        }

        //Deleting user
        User userDeleted = userFound.get();

        userDeleted.setDeleted(user.getDeleted());

        //Save user
        User userSaved = userRepository.saveUser(userDeleted);
        if (userSaved == null) {
            log.error("Could not delete user with id: {}", user.getId().getValue());
            failureMessages.add("Could not delete user with id: " + user.getId().getValue());
            return courseDomainService.deletedUserFail(user,
                    userDeleteFailedMessagePublisher,
                    failureMessages);
        }
        log.info("User is deleted with id: {}", userSaved.getId().getValue());

        return courseDomainService.deletedUserSuccess(user, userDeletedSuccessMessagePublisher);
    }
}
