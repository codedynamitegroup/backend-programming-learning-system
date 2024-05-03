package com.backend.programming.learning.system.auth.service.domain.implement.saga.user;

import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class UserUpdateSagaHelper {
    private final UserRepository userRepository;

    public UserUpdateSagaHelper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(UUID userId) {
        Optional<User> userResult =
                userRepository.findById(new UserId(userId));
        if (userResult.isEmpty()) {
            log.warn("Could not find user with id: {}", userId);
            throw new AuthNotFoundException("Could not find user with user id: " +
                    userId);
        }
        return userResult.get();
    }

    public User findUserByIdAndIsDeletedTrue(UUID userId) {
        Optional<User> userResult =
                userRepository.findByIdAndIsDeletedTrue(new UserId(userId));
        if (userResult.isEmpty()) {
            log.warn("Could not find user with id: {}", userId);
            throw new AuthNotFoundException("Could not find user with user id: " +
                    userId);
        }
        return userResult.get();
    }

    public SagaStatus copyStatusToSagaStatus(CopyState copyState){
        return switch (copyState){
            case CREATING,UPDATING,DELETING -> SagaStatus.STARTED;
            case CREATE_FAILED, UPDATE_FAILED, DELETE_FAILED-> SagaStatus.COMPENSATING;
            case CREATED,UPDATED,DELETED -> SagaStatus.SUCCEEDED;
            default -> SagaStatus.STARTED;
        };
    }
}
