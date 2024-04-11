package com.backend.programming.learning.system.auth.service.dataaccess.user.adapter;

import com.backend.programming.learning.system.auth.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.auth.service.dataaccess.user.mapper.UserDataAccessMapper;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private final UserDataAccessMapper userDataAccessMapper;
    private final UserJpaRepository userJpaRepository;

    public UserRepositoryImpl(UserDataAccessMapper userDataAccessMapper, UserJpaRepository userJpaRepository) {
        this.userDataAccessMapper = userDataAccessMapper;
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public User save(User user) {
        return userDataAccessMapper
                .userEntityToUser(userJpaRepository
                        .save(userDataAccessMapper.userToUserEntity(user)));
    }

    @Override
    public Optional<User> findById(UserId userId) {
        return userJpaRepository.findById(userId.getValue())
                .map(userDataAccessMapper::userEntityToUser);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userJpaRepository.findByEmail(email)
                .map(userDataAccessMapper::userEntityToUser);
    }
}
