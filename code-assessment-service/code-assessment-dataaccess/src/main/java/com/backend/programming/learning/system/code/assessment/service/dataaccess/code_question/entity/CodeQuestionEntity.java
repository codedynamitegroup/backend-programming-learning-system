package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.TestCase;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="main_qtype_code_questions")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CodeQuestionEntity {
    @Id
    private UUID id;
    private UUID questionId;
    private String dslTemplate;
    private String problemStatement;
    private String inputFormat;
    private String outputFormat;
    private Boolean isDeleted;
    private String constraints;

    @OneToMany(mappedBy = "codeQuestion", cascade = CascadeType.ALL)
    private List<TestCaseEntity> testCases;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CodeQuestionEntity that = (CodeQuestionEntity) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
