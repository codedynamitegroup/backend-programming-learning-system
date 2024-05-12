package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.tag.CodeQuestionTagEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.entity.TagEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.code_question_tag.CodeQuestionTagId;
import org.springframework.stereotype.Component;

@Component
public class CodeQuestionTagDataAccessMapper {

    public CodeQuestionTagEntity idToEntity(CodeQuestionTagId codeQuestionTagId) {
        return CodeQuestionTagEntity.builder()
                .codeQuestion(CodeQuestionEntity.builder().id(codeQuestionTagId.getValue().getCodeQuestionId().getValue()).build())
                .tag(TagEntity.builder().id(codeQuestionTagId.getValue().getTagId().getValue()).build())
                .build();
    }
}
