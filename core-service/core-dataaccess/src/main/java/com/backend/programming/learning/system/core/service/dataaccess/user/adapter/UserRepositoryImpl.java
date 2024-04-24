package com.backend.programming.learning.system.core.service.dataaccess.user.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final UserDataAccessMapper userMapper;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository,
                              UserDataAccessMapper userMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> findUser(UUID userId) {
        return userJpaRepository.findById(userId)
                .map(userMapper::userEntityToUser);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userJpaRepository.findByEmail(email)
                .map(userMapper::userEntityToUser);
    }

    @Override
    public User save(User user) {
        return userMapper
                .userEntityToUser(userJpaRepository
                        .save(userMapper.userToUserEntity(user)));
    }
}
