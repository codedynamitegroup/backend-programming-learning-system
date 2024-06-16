package com.backend.programming.learning.system.core.service.dataaccess.code_submission_certificatecourse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "code_submission_certificate_course")
@Entity
public class CodeSubmissionCertificateCourseEntity {
    @Id
    private UUID codeSubmissionId;
    private UUID certificateCourseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeSubmissionCertificateCourseEntity that = (CodeSubmissionCertificateCourseEntity) o;
        return Objects.equals(codeSubmissionId, that.codeSubmissionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeSubmissionId);
    }
}
