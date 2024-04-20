package com.backend.programming.learning.system.auth.service.dataaccess.user_role.adapter;

import com.backend.programming.learning.system.auth.service.dataaccess.user_role.mapper.UserRoleDataAccessMapper;
import com.backend.programming.learning.system.auth.service.dataaccess.user_role.repository.UserRoleJpaRepository;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRoleRepository;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.auth.service.domain.valueobject.UserRoleId;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRoleRepositoryImpl implements UserRoleRepository {
    private final UserRoleDataAccessMapper userRoleDataAccessMapper;
    private final UserRoleJpaRepository userRoleJpaRepository;

    public UserRoleRepositoryImpl(UserRoleDataAccessMapper userRoleDataAccessMapper, UserRoleJpaRepository userRoleJpaRepository) {
        this.userRoleDataAccessMapper = userRoleDataAccessMapper;
        this.userRoleJpaRepository = userRoleJpaRepository;
    }

    @Override
    public UserRole save(UserRole userRole) {
        return userRoleDataAccessMapper
                .userRoleEntityToUserRole(userRoleJpaRepository
                        .save(userRoleDataAccessMapper.userRoleToUserRoleEntity(userRole)));
    }

    @Override
    public Optional<UserRole> findByRoleIdAndUserId(RoleId roleId, UserId userId) {
        return userRoleJpaRepository.findByRoleIdAndUserId(roleId.getValue(), userId.getValue())
                .map(userRoleDataAccessMapper::userRoleEntityToUserRole);
    }

    @Override
    public void deleteByRoleIdAndUserId(RoleId roleId, UserId userId) {
        userRoleJpaRepository.deleteByRoleIdAndUserId(roleId.getValue(), userId.getValue());
    }

    @Override
    public void deleteByRoleId(RoleId roleId) {
        userRoleJpaRepository.deleteByRoleId(roleId.getValue());
    }

    @Override
    public Optional<UserRole> findById(UserRoleId userRoleId) {
        return userRoleJpaRepository.findById(userRoleId.getValue())
                .map(userRoleDataAccessMapper::userRoleEntityToUserRole);
    }
}
