package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class UserQueryHelper {
    private final UserRepository userRepository;

    public UserQueryHelper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional(readOnly = true)
    public User queryUser(UUID userId) {
        Optional<User> userResult =
                userRepository.findById(new UserId(userId));
        if (userResult.isEmpty()) {
            log.warn("Could not find user with id: {}", userId);
            throw new AuthNotFoundException("Could not find user with user id: " +
                    userId);
        }
        return userResult.get();
    }

    @Transactional(readOnly = true)
    public Page<User> queryAllUsers(Integer pageNo, Integer pageSize) {
        return userRepository.findAll(pageNo, pageSize);
    }

    @Transactional(readOnly = true)
    public Page<User> queryAllUsersByOrganization(UUID organizationId, Integer pageNo, Integer pageSize) {
        return userRepository.findAllUsersByOrganization(organizationId, pageNo, pageSize);
    }
}





















