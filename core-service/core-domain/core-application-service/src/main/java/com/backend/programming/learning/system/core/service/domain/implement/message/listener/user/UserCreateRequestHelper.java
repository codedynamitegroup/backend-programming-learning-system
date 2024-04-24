package com.backend.programming.learning.system.core.service.domain.implement.message.listener.user;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.message.user.UserCreateRequest;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.event.user.UserEvent;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.user.UserCreateFailedMessagePublisher;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.user.UserCreatedSuccessMessagePublisher;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserCreateRequestHelper {
    private final UserDataMapper userDataMapper;
    private final UserRepository userRepository;
    private final CoreDomainService coreDomainService;
    private final UserCreatedSuccessMessagePublisher userCreatedSuccessMessagePublisher;
    private final UserCreateFailedMessagePublisher userCreateFailedMessagePublisher;


    public UserCreateRequestHelper(UserDataMapper userDataMapper, UserRepository userRepository, CoreDomainService coreDomainService, UserCreatedSuccessMessagePublisher userCreatedSuccessMessagePublisher, UserCreateFailedMessagePublisher userCreateFailedMessagePublisher) {
        this.userDataMapper = userDataMapper;
        this.userRepository = userRepository;
        this.coreDomainService = coreDomainService;
        this.userCreatedSuccessMessagePublisher = userCreatedSuccessMessagePublisher;
        this.userCreateFailedMessagePublisher = userCreateFailedMessagePublisher;
    }

    @Transactional
    public UserEvent persistUser(UserCreateRequest userRequest) {
        User user = userDataMapper.userCreateRequestToUser(userRequest);
        Optional<User> userResult = userRepository.findUserByEmail(user.getEmail());
        List<String> failureMessages = new ArrayList<>();
        //Find user with email
        if (userResult.isPresent()) {
            log.error("Found user with email: {}", user.getEmail());
            failureMessages.add("Found user with email: " + user.getEmail());
            return coreDomainService.createUserFail(user,
                    userCreateFailedMessagePublisher,
                    failureMessages);
        }

        //Save user
        User userSaved = userRepository.save(user);
        if (userSaved == null) {
            log.error("Could not create user with id: {}", user.getId().getValue());
            failureMessages.add("Could not create user with id: " + user.getId().getValue());
            return coreDomainService.createUserFail(user,
                    userCreateFailedMessagePublisher,
                    failureMessages);
        }
        log.info("User is created with id: {}", userSaved.getId().getValue());

        return coreDomainService.createUserSuccess(user, userCreatedSuccessMessagePublisher);
    }
}
