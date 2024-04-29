package com.backend.programming.learning.system.core.service.dataaccess.outbox.contest_user_update_outbox.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.outbox.contest_user_update_outbox.entity.ContestUserUpdateOutboxEntity;
import com.backend.programming.learning.system.core.service.domain.outbox.model.contest_user.ContestUserUpdateOutboxMessage;
import org.springframework.stereotype.Component;

@Component
public class ContestUserUpdateOutboxDataAccessMapper {
    public ContestUserUpdateOutboxEntity contestUserUpdateOutboxMessageToContestUserUpdateOutboxEntity(
            ContestUserUpdateOutboxMessage contestUserUpdateOutboxMessage) {
        return ContestUserUpdateOutboxEntity.builder()
                .id(contestUserUpdateOutboxMessage.getId())
                .sagaId(contestUserUpdateOutboxMessage.getSagaId())
                .createdAt(contestUserUpdateOutboxMessage.getCreatedAt())
                .type(contestUserUpdateOutboxMessage.getType())
                .payload(contestUserUpdateOutboxMessage.getPayload())
                .updateCalendarEventState(contestUserUpdateOutboxMessage.getUpdateCalendarEventState())
                .sagaStatus(contestUserUpdateOutboxMessage.getSagaStatus())
                .outboxStatus(contestUserUpdateOutboxMessage.getOutboxStatus())
                .version(contestUserUpdateOutboxMessage.getVersion())
                .build();
    }

    public ContestUserUpdateOutboxMessage contestUserUpdateOutboxEntityToContestUserUpdateOutboxMessage(
            ContestUserUpdateOutboxEntity contestUserUpdateOutboxEntity) {
        return ContestUserUpdateOutboxMessage.builder()
                .id(contestUserUpdateOutboxEntity.getId())
                .sagaId(contestUserUpdateOutboxEntity.getSagaId())
                .createdAt(contestUserUpdateOutboxEntity.getCreatedAt())
                .processedAt(contestUserUpdateOutboxEntity.getProcessedAt())
                .type(contestUserUpdateOutboxEntity.getType())
                .payload(contestUserUpdateOutboxEntity.getPayload())
                .updateCalendarEventState(contestUserUpdateOutboxEntity.getUpdateCalendarEventState())
                .sagaStatus(contestUserUpdateOutboxEntity.getSagaStatus())
                .outboxStatus(contestUserUpdateOutboxEntity.getOutboxStatus())
                .version(contestUserUpdateOutboxEntity.getVersion())
                .build();
    }
}
