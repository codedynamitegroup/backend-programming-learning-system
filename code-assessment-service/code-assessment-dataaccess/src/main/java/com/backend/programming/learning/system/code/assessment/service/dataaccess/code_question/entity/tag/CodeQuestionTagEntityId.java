package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.tag;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeQuestionTagEntityId implements Serializable {
    UUID codeQuestion;
    UUID tag;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeQuestionTagEntityId that = (CodeQuestionTagEntityId) o;
        return Objects.equals(codeQuestion, that.codeQuestion) && Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeQuestion, tag);
    }
}