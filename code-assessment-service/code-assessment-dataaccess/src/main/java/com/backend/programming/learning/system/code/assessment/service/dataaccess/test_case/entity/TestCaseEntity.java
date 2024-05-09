package com.backend.programming.learning.system.code.assessment.service.dataaccess.test_case.entity;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import lombok.*;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="test_cases")
public class TestCaseEntity {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name="code_question_id", referencedColumnName = "id")
    private CodeQuestionEntity codeQuestion;

    private String inputData;
    private String outputData;
    private Boolean isSample;
    private Double score;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        TestCaseEntity that = (TestCaseEntity) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
