package com.backend.programming.learning.system.auth.service.dataaccess.outbox.user.mapper;

import com.backend.programming.learning.system.auth.service.dataaccess.outbox.user.entity.UserOutboxEntity;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserOutboxMessage;
import org.springframework.stereotype.Component;

@Component
public class UserOutboxDataAccessMapper {

    public UserOutboxEntity userOutboxMessageToUserOutboxEntity(UserOutboxMessage
                                                                               userOutboxMessage) {
        return UserOutboxEntity.builder()
                .id(userOutboxMessage.getId())
                .sagaId(userOutboxMessage.getSagaId())
                .createdAt(userOutboxMessage.getCreatedAt())
                .type(userOutboxMessage.getType())
                .payload(userOutboxMessage.getPayload())
                .copyState(userOutboxMessage.getCopyState())
                .sagaStatus(userOutboxMessage.getSagaStatus())
                .outboxStatus(userOutboxMessage.getOutboxStatus())
                .version(userOutboxMessage.getVersion())
                .build();
    }

    public UserOutboxMessage userOutboxEntityToUserOutboxMessage(UserOutboxEntity
                                                                               userOutboxEntity) {
        return UserOutboxMessage.builder()
                .id(userOutboxEntity.getId())
                .sagaId(userOutboxEntity.getSagaId())
                .createdAt(userOutboxEntity.getCreatedAt())
                .type(userOutboxEntity.getType())
                .payload(userOutboxEntity.getPayload())
                .copyState(userOutboxEntity.getCopyState())
                .sagaStatus(userOutboxEntity.getSagaStatus())
                .outboxStatus(userOutboxEntity.getOutboxStatus())
                .version(userOutboxEntity.getVersion())
                .build();
    }

}
