package com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.entity;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.language.entity.ProgrammingLanguageEntity;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgrammingLanguageCodeQuestionEntityId implements Serializable {

    ProgrammingLanguageEntity programmingLanguage;

    CodeQuestionEntity codeQuestion;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ProgrammingLanguageCodeQuestionEntityId that = (ProgrammingLanguageCodeQuestionEntityId) object;
        return Objects.equals(programmingLanguage, that.programmingLanguage) && Objects.equals(codeQuestion, that.codeQuestion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programmingLanguage, codeQuestion);
    }
}
