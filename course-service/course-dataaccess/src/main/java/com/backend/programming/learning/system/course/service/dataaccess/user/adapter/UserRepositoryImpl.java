package com.backend.programming.learning.system.course.service.dataaccess.user.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final UserDataAccessMapper userDataAccessMapper;

    @Override
    public User saveUser(User user) {
        return userDataAccessMapper
                .userEntityToUser(userJpaRepository
                        .save(userDataAccessMapper
                                .userToUserEntity(user)));
    }

    @Override
    public Optional<User> findUser(UUID userId) {
        return userJpaRepository.findById(userId)
                .map(userDataAccessMapper::userEntityToUser);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userJpaRepository.findByEmail(email)
                .map(userDataAccessMapper::userEntityToUser);
    }
}
