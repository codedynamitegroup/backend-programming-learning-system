package com.backend.programming.learning.system.course.service.dataaccess.call_organization.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.call_organization.entity.CallOrganizationEntity;
import com.backend.programming.learning.system.entity.CallOrganization;
import com.backend.programming.learning.system.valueobject.CallOrganizationId;
import org.springframework.stereotype.Component;

@Component
public class CallOrganizationDataAccessMapper {
    public CallOrganizationEntity callOrganizationToCallOrganizationEntity(CallOrganization callOrganization) {
        return CallOrganizationEntity.builder()
                .id(callOrganization.getId().getValue())
                .build();
    }
    public CallOrganization callOrganizationEntityToCallOrganization(CallOrganizationEntity callOrganizationEntity) {
        return CallOrganization.builder()
                .id(new CallOrganizationId(callOrganizationEntity.getId()))
                .build();
    }
}
