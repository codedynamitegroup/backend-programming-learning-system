package com.backend.programming.learning.system.core.service.domain.implement.message.listener.user;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.message.user.UserDeleteRequest;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.event.user.UserEvent;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.user.UserDeleteFailedMessagePublisher;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.user.UserDeletedSuccessMessagePublisher;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
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
    private final CoreDomainService coreDomainService;
    private final UserDeletedSuccessMessagePublisher userDeletedSuccessMessagePublisher;
    private final UserDeleteFailedMessagePublisher userDeleteFailedMessagePublisher;

    public UserDeleteRequestHelper(UserDataMapper userDataMapper, UserRepository userRepository, CoreDomainService coreDomainService, UserDeletedSuccessMessagePublisher userDeletedSuccessMessagePublisher, UserDeleteFailedMessagePublisher userDeleteFailedMessagePublisher) {
        this.userDataMapper = userDataMapper;
        this.userRepository = userRepository;
        this.coreDomainService = coreDomainService;
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
            return coreDomainService.deletedUserFail(user,
                    userDeleteFailedMessagePublisher,
                    failureMessages);
        }

        //Deleting user
        User userDeleted = userFound.get();

        userDeleted.setDeleted(user.getDeleted());

        //Save user
        User userSaved = userRepository.save(userDeleted);
        if (userSaved == null) {
            log.error("Could not delete user with id: {}", user.getId().getValue());
            failureMessages.add("Could not delete user with id: " + user.getId().getValue());
            return coreDomainService.deletedUserFail(user,
                    userDeleteFailedMessagePublisher,
                    failureMessages);
        }
        log.info("User is deleted with id: {}", userSaved.getId().getValue());

        return coreDomainService.deletedUserSuccess(user, userDeletedSuccessMessagePublisher);
    }
}
