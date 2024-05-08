package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity;


import com.backend.programming.learning.system.domain.valueobject.CopyState;
import lombok.*;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="qtype_code_questions")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CodeQuestionEntity {
    @Id
    private UUID id;
    private UUID questionId;

    private String name;
    private String dslTemplate;
    private String problemStatement;
    private String inputFormat;
    private String outputFormat;

    @Enumerated(EnumType.STRING)
    private CopyState copyState;

    private String constraints;
    private String failureMessages;

    private Float maxGrade;

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
