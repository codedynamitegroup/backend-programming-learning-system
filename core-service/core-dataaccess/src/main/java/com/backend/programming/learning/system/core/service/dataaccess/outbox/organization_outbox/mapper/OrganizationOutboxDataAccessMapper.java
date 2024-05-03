package com.backend.programming.learning.system.core.service.dataaccess.outbox.organization_outbox.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.outbox.organization_outbox.entity.OrganizationOutboxEntity;
import com.backend.programming.learning.system.core.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.outbox.model.user.UserOutboxMessage;
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
                .outboxStatus(organizationOutboxMessage.getOutboxStatus())
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
                .outboxStatus(organizationOutboxEntity.getOutboxStatus())
                .version(organizationOutboxEntity.getVersion())
                .build();
    }

}
