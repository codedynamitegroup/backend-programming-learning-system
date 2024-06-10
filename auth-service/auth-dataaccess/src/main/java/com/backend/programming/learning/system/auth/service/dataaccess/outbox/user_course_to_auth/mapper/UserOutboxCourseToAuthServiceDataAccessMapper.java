package com.backend.programming.learning.system.auth.service.dataaccess.outbox.user_course_to_auth.mapper;

import com.backend.programming.learning.system.auth.service.dataaccess.outbox.user_course_to_auth.entity.UserOutboxCourseToAuthServiceEntity;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user_course_to_auth_service.UserOutboxCourseToAuthServiceMessage;
import org.springframework.stereotype.Component;

@Component
public class UserOutboxCourseToAuthServiceDataAccessMapper {

    public UserOutboxCourseToAuthServiceEntity userOutboxMessageToUserOutboxEntity(UserOutboxCourseToAuthServiceMessage
                                                                               userOutboxMessage) {
        return UserOutboxCourseToAuthServiceEntity.builder()
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

    public UserOutboxCourseToAuthServiceMessage userOutboxEntityToUserOutboxMessage(UserOutboxCourseToAuthServiceEntity
                                                                               userOutboxEntity) {
        return UserOutboxCourseToAuthServiceMessage.builder()
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
