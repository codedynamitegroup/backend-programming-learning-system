package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission_test_case.entity;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity.CodeSubmissionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.test_case.entity.TestCaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="code_submission_test_case")
public class CodeSubmissionTestCaseEntity {
    @Id
    UUID id;

    @ManyToOne
    @JoinColumn(name="test_case_id", referencedColumnName = "id")
    TestCaseEntity testCase;

    @ManyToOne
    @JoinColumn(name="code_submission_id", referencedColumnName = "id")
    CodeSubmissionEntity codeSubmission;

    String actualOutput;
    String compileOutput;
    Float runtime;
    Float memory;
    Boolean passed;
    String judgeToken;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CodeSubmissionTestCaseEntity that = (CodeSubmissionTestCaseEntity) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
