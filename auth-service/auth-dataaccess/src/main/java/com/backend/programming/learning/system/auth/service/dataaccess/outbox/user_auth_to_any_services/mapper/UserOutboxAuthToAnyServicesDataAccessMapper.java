package com.backend.programming.learning.system.auth.service.dataaccess.outbox.user_auth_to_any_services.mapper;

import com.backend.programming.learning.system.auth.service.dataaccess.outbox.user_auth_to_any_services.entity.UserOutboxAuthToAnyServicesEntity;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user_auth_to_any_services.UserOutboxAuthToAnyServicesMessage;
import org.springframework.stereotype.Component;

@Component
public class UserOutboxAuthToAnyServicesDataAccessMapper {

    public UserOutboxAuthToAnyServicesEntity userOutboxMessageToUserOutboxEntity(UserOutboxAuthToAnyServicesMessage
                                                                               userOutboxMessage) {
        return UserOutboxAuthToAnyServicesEntity.builder()
                .id(userOutboxMessage.getId())
                .sagaId(userOutboxMessage.getSagaId())
                .createdAt(userOutboxMessage.getCreatedAt())
                .type(userOutboxMessage.getType())
                .payload(userOutboxMessage.getPayload())
                .copyState(userOutboxMessage.getCopyState())
                .sagaStatus(userOutboxMessage.getSagaStatus())
                .outboxStatus(userOutboxMessage.getOutboxStatus())
                .serviceName(userOutboxMessage.getServiceName())
                .version(userOutboxMessage.getVersion())
                .build();
    }

    public UserOutboxAuthToAnyServicesMessage userOutboxEntityToUserOutboxMessage(UserOutboxAuthToAnyServicesEntity
                                                                               userOutboxEntity) {
        return UserOutboxAuthToAnyServicesMessage.builder()
                .id(userOutboxEntity.getId())
                .sagaId(userOutboxEntity.getSagaId())
                .createdAt(userOutboxEntity.getCreatedAt())
                .type(userOutboxEntity.getType())
                .payload(userOutboxEntity.getPayload())
                .copyState(userOutboxEntity.getCopyState())
                .sagaStatus(userOutboxEntity.getSagaStatus())
                .outboxStatus(userOutboxEntity.getOutboxStatus())
                .serviceName(userOutboxEntity.getServiceName())
                .version(userOutboxEntity.getVersion())
                .build();
    }

}
