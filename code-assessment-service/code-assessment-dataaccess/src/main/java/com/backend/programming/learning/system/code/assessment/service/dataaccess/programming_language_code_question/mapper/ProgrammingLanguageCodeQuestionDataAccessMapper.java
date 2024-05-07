package com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.language.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.entity.ProgrammingLanguageCodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.entity.ProgrammingLanguageCodeQuestionEntityId;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.ProgrammingLanguageCodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.programming_language_code_question.ProgrammingLanguageCodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import org.springframework.stereotype.Component;

@Component
public class ProgrammingLanguageCodeQuestionDataAccessMapper {
    public ProgrammingLanguageCodeQuestionEntityId idToEntityId(ProgrammingLanguageCodeQuestionId id) {
        return ProgrammingLanguageCodeQuestionEntityId.builder()
                .programmingLanguage(id.getValue().getProgrammingLanguageId().getValue())
                .codeQuestion(id.getValue().getCodeQuestionId().getValue())
                .build();
    }


    public ProgrammingLanguageCodeQuestion entityToDomainObject(ProgrammingLanguageCodeQuestionEntity entity) {
        return ProgrammingLanguageCodeQuestion.builder()
                .id(this.entityIdToDomainId(entity.getProgrammingLanguage(), entity.getCodeQuestion()))
                .timeLimit(entity.getTimeLimit())
                .memoryLimit(entity.getMemoryLimit())
                .active(entity.getActive())
                .build();
    }

    private ProgrammingLanguageCodeQuestionId entityIdToDomainId(ProgrammingLanguageEntity programmingLanguage, CodeQuestionEntity codeQuestion) {
        return new ProgrammingLanguageCodeQuestionId(
                new ProgrammingLanguageId(programmingLanguage.getId()),
                new CodeQuestionId(codeQuestion.getId())
        );
    }
}
