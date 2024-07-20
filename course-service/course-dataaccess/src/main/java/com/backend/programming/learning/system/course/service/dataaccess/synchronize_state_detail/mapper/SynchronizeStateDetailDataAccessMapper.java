package com.backend.programming.learning.system.course.service.dataaccess.synchronize_state_detail.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.synchronize_state_detail.entity.SynchronizeStateDetailEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeState;
import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeStateDetail;
import com.backend.programming.learning.system.course.service.domain.valueobject.SynchronizeStateDetailId;
import com.backend.programming.learning.system.course.service.domain.valueobject.SynchronizeStateId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SynchronizeStateDetailDataAccessMapper {

    private final OrganizationDataAccessMapper organizationDataAccessMapper;

    public SynchronizeStateDetailEntity synchronizeStateDetailToSynchronizeStateDetailEntity(SynchronizeStateDetail synchronizeStateDetail) {
        OrganizationEntity organizationEntity = organizationDataAccessMapper.organizationToOrganizationEntity(synchronizeStateDetail.getOrganization());
        return SynchronizeStateDetailEntity.builder()
                .id(synchronizeStateDetail.getId().getValue())
                .organization(organizationEntity)
                .status(synchronizeStateDetail.getStatus())
                .type(synchronizeStateDetail.getTypeSynchronize())
                .webhookMessage(synchronizeStateDetail.getWebhookMessage())
                .timeCreated(synchronizeStateDetail.getTimeCreated())
                .build();
    }

    public SynchronizeStateDetail synchronizeStateDetailEntityToSynchronizeStateDetail(SynchronizeStateDetailEntity synchronizeStateDetailEntity) {
        Organization organization = organizationDataAccessMapper.organizationEntityToOrganization(synchronizeStateDetailEntity.getOrganization());
        return SynchronizeStateDetail.builder()
                .id(new SynchronizeStateDetailId(synchronizeStateDetailEntity.getId()))
                .organization(organization)
                .status(synchronizeStateDetailEntity.getStatus())
                .typeSynchronize(synchronizeStateDetailEntity.getType())
                .webhookMessage(synchronizeStateDetailEntity.getWebhookMessage())
                .timeCreated(synchronizeStateDetailEntity.getTimeCreated())
                .build();
    }


    public List<SynchronizeStateDetail> synchronizeStateDetailEntityToSynchronizeStateDetail(List<SynchronizeStateDetailEntity> synchronizeStateDetailEntityList) {
        return synchronizeStateDetailEntityList.stream()
                .map(this::synchronizeStateDetailEntityToSynchronizeStateDetail)
                .toList();
    }
}
