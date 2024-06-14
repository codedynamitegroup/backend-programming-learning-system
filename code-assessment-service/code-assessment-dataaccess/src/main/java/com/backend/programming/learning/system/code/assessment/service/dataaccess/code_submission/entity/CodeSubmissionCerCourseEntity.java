package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="code_submission_cer_course")
public class CodeSubmissionCerCourseEntity {
    @Id
    private UUID codeSubmissionId;

    private UUID cerCourseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeSubmissionCerCourseEntity that = (CodeSubmissionCerCourseEntity) o;
        return Objects.equals(codeSubmissionId, that.codeSubmissionId) && Objects.equals(cerCourseId, that.cerCourseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeSubmissionId, cerCourseId);
    }
}
