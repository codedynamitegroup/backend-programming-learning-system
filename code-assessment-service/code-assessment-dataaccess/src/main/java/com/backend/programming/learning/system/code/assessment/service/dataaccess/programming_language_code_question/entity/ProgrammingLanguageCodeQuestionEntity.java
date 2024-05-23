package com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.entity;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language.entity.ProgrammingLanguageEntity;
import lombok.*;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="programming_language_code_question")
@IdClass(ProgrammingLanguageCodeQuestionEntityId.class)
public class ProgrammingLanguageCodeQuestionEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "programming_language_id", referencedColumnName = "id")
    ProgrammingLanguageEntity programmingLanguage;

    @Id
    @ManyToOne
    @JoinColumn(name = "code_question_id", referencedColumnName = "id")
    CodeQuestionEntity codeQuestion;

    Float timeLimit;
    Float memoryLimit;
    Boolean active;

    String headCode;
    String tailCode;
    String bodyCode;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ProgrammingLanguageCodeQuestionEntity that = (ProgrammingLanguageCodeQuestionEntity) object;
        return Objects.equals(programmingLanguage, that.programmingLanguage) && Objects.equals(codeQuestion, that.codeQuestion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programmingLanguage, codeQuestion);
    }
}
