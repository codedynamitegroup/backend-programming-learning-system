package com.backend.programming.learning.system.course.service.dataaccess.outbox.user_outbox.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.outbox.user_outbox.entity.UserOutboxEntity;
import com.backend.programming.learning.system.course.service.domain.outbox.model.user.UserOutboxMessage;
import org.springframework.stereotype.Component;

@Component
public class UserOutboxDataAccessMapper {

    public UserOutboxEntity userOutboxMessageToUserOutboxEntity(UserOutboxMessage userOutboxMessage) {
        return UserOutboxEntity.builder()
                .id(userOutboxMessage.getId())
                .sagaId(userOutboxMessage.getSagaId())
                .createdAt(userOutboxMessage.getCreatedAt())
                .type(userOutboxMessage.getType())
                .payload(userOutboxMessage.getPayload())
                .copyState(userOutboxMessage.getCopyState())
                .outboxStatus(userOutboxMessage.getOutboxStatus())
                .sagaStatus(userOutboxMessage.getSagaStatus())
                .version(userOutboxMessage.getVersion())
                .build();
    }

    public UserOutboxMessage userOutboxEntityToUserOutboxMessage(UserOutboxEntity userOutboxEntity) {
        return UserOutboxMessage.builder()
                .id(userOutboxEntity.getId())
                .sagaId(userOutboxEntity.getSagaId())
                .createdAt(userOutboxEntity.getCreatedAt())
                .type(userOutboxEntity.getType())
                .payload(userOutboxEntity.getPayload())
                .copyState(userOutboxEntity.getCopyState())
                .outboxStatus(userOutboxEntity.getOutboxStatus())
                .sagaStatus(userOutboxEntity.getSagaStatus())
                .version(userOutboxEntity.getVersion())
                .build();
    }

}
