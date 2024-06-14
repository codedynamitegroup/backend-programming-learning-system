package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity.contest;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity.CodeSubmissionEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="code_submission_contest")
public class CodeSubmissionContestEntity {
    @Id
    private UUID codeSubmissionId;

    private UUID contestId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeSubmissionContestEntity that = (CodeSubmissionContestEntity) o;
        return Objects.equals(codeSubmissionId, that.codeSubmissionId) && Objects.equals(contestId, that.contestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeSubmissionId, contestId);
    }
}
