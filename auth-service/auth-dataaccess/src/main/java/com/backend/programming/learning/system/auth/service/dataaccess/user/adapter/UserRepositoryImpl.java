package com.backend.programming.learning.system.auth.service.dataaccess.user.adapter;

import com.backend.programming.learning.system.auth.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.auth.service.dataaccess.user.mapper.UserDataAccessMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
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
        return userJpaRepository.findByIdAndIsDeletedFalse(userId.getValue())
                .map(userDataAccessMapper::userEntityToUser);
    }

    @Override
    public Optional<User> findByIdAndIsDeletedTrue(UserId userId) {
        return userJpaRepository.findByIdAndIsDeletedTrue(userId.getValue())
                .map(userDataAccessMapper::userEntityToUser);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userJpaRepository.findByEmailAndIsDeletedFalse(email)
                .map(userDataAccessMapper::userEntityToUser);
    }

    @Override
    public Page<User> findAll(Integer page, Integer size, String searchName) {
        Pageable paging = PageRequest.of(page, size);
        return userJpaRepository.findAll(paging, searchName)
                .map(userDataAccessMapper::userEntityToUser);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userJpaRepository.findByEmailAndIsDeletedFalse(email)
                .map(userDataAccessMapper::userEntityToUser);
    }

    @Override
    public Optional<User> findUser(UUID userId) {
        return userJpaRepository.findById(userId)
                .map(userDataAccessMapper::userEntityToUser);
    }

    @Override
    public Page<User> findAllUsersByOrganization(UUID organizationId, Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        return userJpaRepository.findAllByOrganizationIdAndIsDeletedFalse(organizationId, paging)
                .map(userDataAccessMapper::userEntityToUser);
    }
}
