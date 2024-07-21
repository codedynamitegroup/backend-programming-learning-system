package com.backend.programming.learning.system.course.service.dataaccess.outbox.code_submission_result_outbox.entity;

import com.backend.programming.learning.system.outbox.OutboxStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "code_submission_result_outbox")
@Entity
public class CodeSubmissionResultOutboxEntity {
    @Id
    private UUID id;
    private UUID sagaId;
    @Version
    private int version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeSubmissionResultOutboxEntity that = (CodeSubmissionResultOutboxEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
