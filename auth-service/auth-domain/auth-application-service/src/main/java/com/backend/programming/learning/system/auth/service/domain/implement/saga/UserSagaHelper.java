package com.backend.programming.learning.system.auth.service.domain.implement.saga;

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
public class UserSagaHelper {
    private final UserRepository userRepository;

    public UserSagaHelper(UserRepository userRepository) {
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

    public SagaStatus copyStatusToSagaStatus(CopyState copyState){
        return switch (copyState){
            case CREATING,UPDATING,DELETING -> SagaStatus.STARTED;

            case UPDATE_PROPAGATING,
                    DELETE_PROPAGATING,
                    CREATE_PROPAGATING-> SagaStatus.PROCESSING;

            case CREATE_ROLLBACKING, DELETE_ROLLBACKING, UPDATE_ROLLBACKING-> SagaStatus.COMPENSATING;

            case CREATED,UPDATED,DELETED -> SagaStatus.SUCCEEDED;

            case CREATE_FAILED, UPDATE_FAILED, DELETE_FAILED -> SagaStatus.COMPENSATED;
        };
    }
}
