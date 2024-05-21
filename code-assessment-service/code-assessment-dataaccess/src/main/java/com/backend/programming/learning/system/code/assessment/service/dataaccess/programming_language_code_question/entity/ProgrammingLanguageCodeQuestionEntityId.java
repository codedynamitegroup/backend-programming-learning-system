package com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgrammingLanguageCodeQuestionEntityId implements Serializable {

    UUID programmingLanguage;

    UUID codeQuestion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgrammingLanguageCodeQuestionEntityId that = (ProgrammingLanguageCodeQuestionEntityId) o;
        return Objects.equals(programmingLanguage, that.programmingLanguage) && Objects.equals(codeQuestion, that.codeQuestion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programmingLanguage, codeQuestion);
    }
}
