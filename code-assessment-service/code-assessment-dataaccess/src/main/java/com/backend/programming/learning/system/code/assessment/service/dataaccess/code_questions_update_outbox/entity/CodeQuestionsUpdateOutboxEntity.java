package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_questions_update_outbox.entity;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.*;

import jakarta.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;
import java.util.Objects;

@Entity
@Table(name="code_questions_update_outbox")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CodeQuestionsUpdateOutboxEntity {
    @Id
    private UUID id;
    private UUID sagaId;
    private ZonedDateTime createdAt;
    private ZonedDateTime processedAt;
    private String type;
    private String payload;
    @Enumerated(EnumType.STRING)
    private SagaStatus sagaStatus;
    @Enumerated(EnumType.STRING)
    private CopyState copyState;
    @Enumerated(EnumType.STRING)
    private OutboxStatus outboxStatus;
    @Version
    private int version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeQuestionsUpdateOutboxEntity that = (CodeQuestionsUpdateOutboxEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
