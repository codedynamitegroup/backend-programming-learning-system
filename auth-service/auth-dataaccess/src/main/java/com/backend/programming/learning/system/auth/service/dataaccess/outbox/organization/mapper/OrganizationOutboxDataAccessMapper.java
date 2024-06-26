package com.backend.programming.learning.system.auth.service.dataaccess.outbox.organization.mapper;

import com.backend.programming.learning.system.auth.service.dataaccess.outbox.organization.entity.OrganizationOutboxEntity;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import org.springframework.stereotype.Component;

@Component
public class OrganizationOutboxDataAccessMapper {

    public OrganizationOutboxEntity organizationOutboxMessageToOrganizationOutboxEntity(OrganizationOutboxMessage
                                                                               organizationOutboxMessage) {
        return OrganizationOutboxEntity.builder()
                .id(organizationOutboxMessage.getId())
                .sagaId(organizationOutboxMessage.getSagaId())
                .createdAt(organizationOutboxMessage.getCreatedAt())
                .type(organizationOutboxMessage.getType())
                .payload(organizationOutboxMessage.getPayload())
                .copyState(organizationOutboxMessage.getCopyState())
                .sagaStatus(organizationOutboxMessage.getSagaStatus())
                .outboxStatus(organizationOutboxMessage.getOutboxStatus())
                .serviceName(organizationOutboxMessage.getServiceName())
                .version(organizationOutboxMessage.getVersion())
                .build();
    }

    public OrganizationOutboxMessage organizationOutboxEntityToOrganizationOutboxMessage(OrganizationOutboxEntity
                                                                               organizationOutboxEntity) {
        return OrganizationOutboxMessage.builder()
                .id(organizationOutboxEntity.getId())
                .sagaId(organizationOutboxEntity.getSagaId())
                .createdAt(organizationOutboxEntity.getCreatedAt())
                .type(organizationOutboxEntity.getType())
                .payload(organizationOutboxEntity.getPayload())
                .copyState(organizationOutboxEntity.getCopyState())
                .sagaStatus(organizationOutboxEntity.getSagaStatus())
                .outboxStatus(organizationOutboxEntity.getOutboxStatus())
                .serviceName(organizationOutboxEntity.getServiceName())
                .version(organizationOutboxEntity.getVersion())
                .build();
    }

}
