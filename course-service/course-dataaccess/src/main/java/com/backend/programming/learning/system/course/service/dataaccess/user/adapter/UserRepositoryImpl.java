package com.backend.programming.learning.system.course.service.dataaccess.user.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final UserDataAccessMapper userDataAccessMapper;

    @Override
    public User save(User user) {
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
        return userJpaRepository.findByEmailAndIsDeletedFalse(email)
                .map(userDataAccessMapper::userEntityToUser);
    }

    @Override
    public Optional<User> findByUserIdMoodle(Integer userIdMoodle) {
        return userJpaRepository.findByUserIdMoodle(userIdMoodle)
                .map(userDataAccessMapper::userEntityToUser);
    }

    @Override
    public List<User> findAll() {
        return userDataAccessMapper
                .userEntityListToUserList(userJpaRepository.findAll());
    }

    @Override
    public List<User> findAllUserByAssignmentId(UUID assignmentId) {
        return userDataAccessMapper
                .userEntityListToUserList(userJpaRepository.findAllByAssignmentId(assignmentId));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userJpaRepository.findByEmailAndIsDeletedFalse(email)
                .map(userDataAccessMapper::userEntityToUser);
    }

    @Override
    public Optional<User> findById(UserId userId) {
        return userJpaRepository.findByIdAndIsDeletedFalse(userId.getValue())
                .map(userDataAccessMapper::userEntityToUser);
    }

    @Override
    public void deleteByUserMoodleId(Integer userIdMoodle) {
        userJpaRepository.deleteByUserIdMoodle(userIdMoodle);
    }

    @Override
    public List<User> findAllByCourseId(UUID courseId) {
        return userDataAccessMapper
                .userEntityListToUserList(userJpaRepository.findAllByCourseId(courseId));
    }
}
