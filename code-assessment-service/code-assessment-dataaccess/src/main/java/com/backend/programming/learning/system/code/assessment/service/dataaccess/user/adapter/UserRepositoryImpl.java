package com.backend.programming.learning.system.code.assessment.service.dataaccess.user.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final UserDataAccessMapper dataAccessMapper;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository, UserDataAccessMapper dataAccessMapper) {
        this.userJpaRepository = userJpaRepository;
        this.dataAccessMapper = dataAccessMapper;
    }

    @Override
    public Optional<User> findById(UserId userId) {
        Optional<UserEntity> user = userJpaRepository.findById(userId.getValue());
        return user.map(dataAccessMapper::userEntityToUser);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userJpaRepository.findByEmail(email)
                .map(dataAccessMapper::userEntityToUser);
    }

    @Override
    public User save(User user) {
        return dataAccessMapper
                .userEntityToUser(userJpaRepository
                        .save(dataAccessMapper.userToUserEntity(user)));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> user = userJpaRepository.findByEmail(email);
        return user.map(dataAccessMapper::userEntityToUser);
    }
}
