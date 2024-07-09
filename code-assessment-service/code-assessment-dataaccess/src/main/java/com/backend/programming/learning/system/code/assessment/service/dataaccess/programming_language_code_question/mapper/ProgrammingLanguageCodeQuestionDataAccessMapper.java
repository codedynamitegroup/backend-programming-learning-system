package com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language.mapper.ProgrammingLanguageDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.entity.ProgrammingLanguageCodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.entity.ProgrammingLanguageCodeQuestionEntityId;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.ProgrammingLanguageCodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.programming_language_code_question.ProgrammingLanguageCodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import org.springframework.stereotype.Component;

@Component
public class ProgrammingLanguageCodeQuestionDataAccessMapper {
    final ProgrammingLanguageDataAccessMapper programmingLanguageDataAccessMapper;

    public ProgrammingLanguageCodeQuestionDataAccessMapper(ProgrammingLanguageDataAccessMapper programmingLanguageDataAccessMapper) {
        this.programmingLanguageDataAccessMapper = programmingLanguageDataAccessMapper;
    }

    public ProgrammingLanguageCodeQuestionEntityId idToEntityId(ProgrammingLanguageCodeQuestionId id) {
        return ProgrammingLanguageCodeQuestionEntityId.builder()
                .programmingLanguage(id.getValue().getProgrammingLanguageId().getValue())
                .codeQuestion(id.getValue().getCodeQuestionId().getValue())
                .build();
    }
    public ProgrammingLanguageCodeQuestionEntityId programmingLanguageIdAndCodeQuesitonIdToEntityId(ProgrammingLanguageId programmingLanguageId, CodeQuestionId codeQuestionId) {
        return ProgrammingLanguageCodeQuestionEntityId.builder()
                .programmingLanguage(programmingLanguageId.getValue())
                .codeQuestion(codeQuestionId.getValue())
                .build();
    }


    public ProgrammingLanguageCodeQuestion entityToDomainObject(ProgrammingLanguageCodeQuestionEntity entity) {
        return ProgrammingLanguageCodeQuestion.builder()
                .id(this.entityIdToDomainId(entity.getProgrammingLanguage(), entity.getCodeQuestion()))
                .timeLimit(entity.getTimeLimit())
                .memoryLimit(entity.getMemoryLimit())
                .language(programmingLanguageDataAccessMapper.entityToProgramingLanguage(entity.getProgrammingLanguage()))
                .active(entity.getActive())
                .headCode(entity.getHeadCode())
                .bodyCode(entity.getBodyCode())
                .tailCode(entity.getTailCode())
                .build();
    }

    public ProgrammingLanguageCodeQuestionEntity domainObjectToEntity(ProgrammingLanguageCodeQuestion obj){
        return ProgrammingLanguageCodeQuestionEntity.builder()
                .codeQuestion(CodeQuestionEntity.builder().id(obj.getId().getValue().getCodeQuestionId().getValue()).build())
                .programmingLanguage(ProgrammingLanguageEntity.builder().id(obj.getId().getValue().getProgrammingLanguageId().getValue()).build())
                .active(obj.getActive())
                .timeLimit(obj.getTimeLimit())
                .memoryLimit(obj.getMemoryLimit())
                .bodyCode(obj.getBodyCode())
                .headCode(obj.getHeadCode())
                .tailCode(obj.getTailCode())
                .build();
    }

    private ProgrammingLanguageCodeQuestionId entityIdToDomainId(ProgrammingLanguageEntity programmingLanguage, CodeQuestionEntity codeQuestion) {
        return new ProgrammingLanguageCodeQuestionId(
                new ProgrammingLanguageId(programmingLanguage.getId()),
                new CodeQuestionId(codeQuestion.getId())
        );
    }
}
