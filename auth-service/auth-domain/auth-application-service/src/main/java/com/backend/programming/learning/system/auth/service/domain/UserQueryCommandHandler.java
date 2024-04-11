package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.mapper.AuthDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class UserQueryCommandHandler {
    private final AuthDataMapper authDataMapper;
    private final UserRepository userRepository;

    public UserQueryCommandHandler(UserCreateHelper authCreateHelper, AuthDataMapper authDataMapper, UserRepository userRepository) {
        this.authDataMapper = authDataMapper;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public QueryUserResponse queryUser(QueryUserCommand queryUserCommand) {
        Optional<User> userResult =
                userRepository.findById(new UserId(queryUserCommand.getUserId()));
        if (userResult.isEmpty()) {
            log.warn("Could not find user with user id: {}", queryUserCommand.getUserId());
            throw new AuthNotFoundException("Could not find user with user id: " +
                    queryUserCommand.getUserId());
        }
        return authDataMapper.userToQueryUserResponse(userResult.get());
    }

}
