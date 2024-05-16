package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.tag.CodeQuestionTagEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.tag.CodeQuestionTagEntityId;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.entity.TagEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestionTag;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.code_question_tag.CodeQuestionTagId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import org.springframework.stereotype.Component;

@Component
public class CodeQuestionTagDataAccessMapper {

    public CodeQuestionTagEntity idToEntity(CodeQuestionTagId codeQuestionTagId) {
        return CodeQuestionTagEntity.builder()
                .codeQuestion(CodeQuestionEntity.builder().id(codeQuestionTagId.getValue().getCodeQuestionId().getValue()).build())
                .tag(TagEntity.builder().id(codeQuestionTagId.getValue().getTagId().getValue()).build())
                .build();
    }

    public CodeQuestionTagEntityId idToEntityId(CodeQuestionTagId codeQuestionTagId) {
        return CodeQuestionTagEntityId.builder()
                .codeQuestion(codeQuestionTagId.getValue().getCodeQuestionId().getValue())
                .tag(codeQuestionTagId.getValue().getTagId().getValue())
                .build();
    }

    public CodeQuestionTagEntity codeQuestionIdAndTagIdToEntity(CodeQuestionId codeQuestionId, TagId tagId) {
        return CodeQuestionTagEntity.builder()
                .tag(TagEntity.builder().id(tagId.getValue()).build())
                .codeQuestion(CodeQuestionEntity.builder().id(codeQuestionId.getValue()).build())
                .build();
    }

    public CodeQuestionTag entityToCodeQuestionTag(CodeQuestionTagEntity codeQuestionTagEntity) {
        return CodeQuestionTag.builder()
                .id(new CodeQuestionTagId(new CodeQuestionId(codeQuestionTagEntity.getCodeQuestion().getId()),
                        new TagId(codeQuestionTagEntity.getTag().getId())))
                .build();
    }
}
