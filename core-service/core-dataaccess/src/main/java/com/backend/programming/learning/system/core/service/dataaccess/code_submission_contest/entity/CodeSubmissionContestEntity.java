package com.backend.programming.learning.system.core.service.dataaccess.code_submission_contest.entity;

import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
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
@Table(name = "code_submission_contest")
@Entity
public class CodeSubmissionContestEntity {
    @Id
    @Column(name = "id")
    private UUID codeSubmissionId;
    private UUID contestId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeSubmissionContestEntity that = (CodeSubmissionContestEntity) o;
        return Objects.equals(codeSubmissionId, that.codeSubmissionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeSubmissionId);
    }
}
