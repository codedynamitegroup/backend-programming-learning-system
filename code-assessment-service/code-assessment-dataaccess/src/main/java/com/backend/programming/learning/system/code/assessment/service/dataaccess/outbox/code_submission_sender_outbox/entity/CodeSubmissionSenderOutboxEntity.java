package com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_submission_sender_outbox.entity;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="code_submission_sender_outbox")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CodeSubmissionSenderOutboxEntity {
    @Id
    private UUID id;
    private UUID sagaId;
    @Version
    private int version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeSubmissionSenderOutboxEntity that = (CodeSubmissionSenderOutboxEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
