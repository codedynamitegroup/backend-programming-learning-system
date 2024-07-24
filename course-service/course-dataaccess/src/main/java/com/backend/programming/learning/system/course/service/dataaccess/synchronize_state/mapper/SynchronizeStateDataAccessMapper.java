package com.backend.programming.learning.system.course.service.dataaccess.synchronize_state.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.synchronize_state.entity.SynchronizeStateEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeState;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.SynchronizeStateId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SynchronizeStateDataAccessMapper {

    private final OrganizationDataAccessMapper organizationDataAccessMapper;
    private final UserDataAccessMapper userDataAccessMapper;

    public SynchronizeStateEntity synchronizeStateToSynchronizeStateEntity(SynchronizeState synchronizeState) {
        OrganizationEntity organizationEntity = organizationDataAccessMapper.organizationToOrganizationEntity(synchronizeState.getOrganization());
        UserEntity userEntity = userDataAccessMapper.userToUserEntity(synchronizeState.getUser());
        return SynchronizeStateEntity.builder()
                .id(synchronizeState.getId().getValue())
                .organization(organizationEntity)
                .user(userEntity)
                .step(synchronizeState.getStep())
                .status(synchronizeState.getStatus())
                .syncCount(synchronizeState.getSyncCount())
                .timeCreated(synchronizeState.getTimeCreated())
                .build();
    }

    public SynchronizeState synchronizeStateEntityToSynchronizeState(SynchronizeStateEntity synchronizeStateEntity) {
        Organization organization = organizationDataAccessMapper.organizationEntityToOrganization(synchronizeStateEntity.getOrganization());
        User user = userDataAccessMapper.userEntityToUser(synchronizeStateEntity.getUser());
        return SynchronizeState.builder()
                .id(new SynchronizeStateId(synchronizeStateEntity.getId()))
                .organization(organization)
                .user(user)
                .step(synchronizeStateEntity.getStep())
                .status(synchronizeStateEntity.getStatus())
                .syncCount(synchronizeStateEntity.getSyncCount())
                .timeCreated(synchronizeStateEntity.getTimeCreated())
                .build();
    }
}
