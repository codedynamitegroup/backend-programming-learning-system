package com.backend.programming.learning.system.course.service.dataaccess.synchronize_state.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.synchronize_state.entity.SynchronizeStateEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeState;
import com.backend.programming.learning.system.course.service.domain.valueobject.SynchronizeStateId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SynchronizeStateDataAccessMapper {

    private final OrganizationDataAccessMapper organizationDataAccessMapper;

    public SynchronizeStateEntity synchronizeStateToSynchronizeStateEntity(SynchronizeState synchronizeState) {
        OrganizationEntity organizationEntity = organizationDataAccessMapper.organizationToOrganizationEntity(synchronizeState.getOrganization());
        return SynchronizeStateEntity.builder()
                .id(synchronizeState.getId().getValue())
                .organization(organizationEntity)
                .step(synchronizeState.getStep())
                .status(synchronizeState.getStatus())
                .syncCount(synchronizeState.getSyncCount())
                .timeCreated(synchronizeState.getTimeCreated())
                .build();
    }

    public SynchronizeState synchronizeStateEntityToSynchronizeState(SynchronizeStateEntity synchronizeStateEntity) {
        Organization organization = organizationDataAccessMapper.organizationEntityToOrganization(synchronizeStateEntity.getOrganization());
        return SynchronizeState.builder()
                .id(new SynchronizeStateId(synchronizeStateEntity.getId()))
                .organization(organization)
                .step(synchronizeStateEntity.getStep())
                .status(synchronizeStateEntity.getStatus())
                .syncCount(synchronizeStateEntity.getSyncCount())
                .timeCreated(synchronizeStateEntity.getTimeCreated())
                .build();
    }
}
