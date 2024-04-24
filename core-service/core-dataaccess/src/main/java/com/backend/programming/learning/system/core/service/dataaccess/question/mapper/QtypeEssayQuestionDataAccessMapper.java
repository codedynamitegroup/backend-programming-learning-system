package com.backend.programming.learning.system.core.service.dataaccess.question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeEssayQuestionEntity;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeEssayQuestion;
import com.backend.programming.learning.system.domain.valueobject.QtypeEssayQuestionId;
import org.springframework.stereotype.Component;

@Component
public class QtypeEssayQuestionDataAccessMapper {
    private final QuestionDataAccessMapper questionDataAccessMapper;

    public QtypeEssayQuestionDataAccessMapper(QuestionDataAccessMapper questionDataAccessMapper) {
        this.questionDataAccessMapper = questionDataAccessMapper;
    }

    public QtypeEssayQuestionEntity qtypeEssayQuestionToQtypeEssayQuestionEntity(QtypeEssayQuestion qtypeEssayQuestion) {
        return QtypeEssayQuestionEntity.builder()
                .id(qtypeEssayQuestion.getId().getValue())
                .question(questionDataAccessMapper.questionToQuestionEntity(qtypeEssayQuestion.getQuestion()))
                .responseFormat(qtypeEssayQuestion.getResponseFormat())
                .responseRequired(qtypeEssayQuestion.getResponseRequired())
                .responseFieldLines(qtypeEssayQuestion.getResponseFieldLines())
                .minWordLimit(qtypeEssayQuestion.getMinWordLimit())
                .maxWordLimit(qtypeEssayQuestion.getMaxWordLimit())
                .attachments(qtypeEssayQuestion.getAttachments())
                .attachmentsRequired(qtypeEssayQuestion.getAttachmentsRequired())
                .graderInfo(qtypeEssayQuestion.getGraderInfo())
                .graderInfoFormat(qtypeEssayQuestion.getGraderInfoFormat())
                .responseTemplate(qtypeEssayQuestion.getResponseTemplate())
                .maxBytes(qtypeEssayQuestion.getMaxBytes())
                .fileTypesList(qtypeEssayQuestion.getFileTypesList())
                .build();
    }

    public QtypeEssayQuestion qtypeEssayQuestionEntityToQtypeEssayQuestion(QtypeEssayQuestionEntity qtypeEssayQuestionEntity) {
        return QtypeEssayQuestion.builder()
                .id(new QtypeEssayQuestionId(qtypeEssayQuestionEntity.getId()))
                .question(questionDataAccessMapper.questionEntityToQuestion(qtypeEssayQuestionEntity.getQuestion()))
                .responseFormat(qtypeEssayQuestionEntity.getResponseFormat())
                .responseRequired(qtypeEssayQuestionEntity.getResponseRequired())
                .responseFieldLines(qtypeEssayQuestionEntity.getResponseFieldLines())
                .minWordLimit(qtypeEssayQuestionEntity.getMinWordLimit())
                .maxWordLimit(qtypeEssayQuestionEntity.getMaxWordLimit())
                .attachments(qtypeEssayQuestionEntity.getAttachments())
                .attachmentsRequired(qtypeEssayQuestionEntity.getAttachmentsRequired())
                .graderInfo(qtypeEssayQuestionEntity.getGraderInfo())
                .graderInfoFormat(qtypeEssayQuestionEntity.getGraderInfoFormat())
                .responseTemplate(qtypeEssayQuestionEntity.getResponseTemplate())
                .maxBytes(qtypeEssayQuestionEntity.getMaxBytes())
                .fileTypesList(qtypeEssayQuestionEntity.getFileTypesList())
                .build();
    }

    public QtypeEssayQuestionEntity setQtypeEssayQuestionEntity(QtypeEssayQuestionEntity qtypeEssayQuestionEntity,
                                                                QtypeEssayQuestion qtypeEssayQuestion) {
//        // TODO: Check if should i set Id
//        if(qtypeEssayQuestion.getId() != null)
//            qtypeEssayQuestionEntity.setId(qtypeEssayQuestion.getId().getValue());
        if(qtypeEssayQuestion.getQuestion() != null)
            qtypeEssayQuestionEntity.setQuestion(questionDataAccessMapper.setQuestionEntity(qtypeEssayQuestionEntity.getQuestion(), qtypeEssayQuestion.getQuestion()));
        if(qtypeEssayQuestion.getResponseFormat() != null)
            qtypeEssayQuestionEntity.setResponseFormat(qtypeEssayQuestion.getResponseFormat());
        if(qtypeEssayQuestion.getResponseRequired() != null)
            qtypeEssayQuestionEntity.setResponseRequired(qtypeEssayQuestion.getResponseRequired());
        if(qtypeEssayQuestion.getResponseFieldLines() != null)
            qtypeEssayQuestionEntity.setResponseFieldLines(qtypeEssayQuestion.getResponseFieldLines());
        if(qtypeEssayQuestion.getMinWordLimit() != null)
            qtypeEssayQuestionEntity.setMinWordLimit(qtypeEssayQuestion.getMinWordLimit());
        if(qtypeEssayQuestion.getMaxWordLimit() != null)
            qtypeEssayQuestionEntity.setMaxWordLimit(qtypeEssayQuestion.getMaxWordLimit());
        if(qtypeEssayQuestion.getAttachments() != null)
            qtypeEssayQuestionEntity.setAttachments(qtypeEssayQuestion.getAttachments());
        if(qtypeEssayQuestion.getAttachmentsRequired() != null)
            qtypeEssayQuestionEntity.setAttachmentsRequired(qtypeEssayQuestion.getAttachmentsRequired());
        if(qtypeEssayQuestion.getGraderInfo() != null)
            qtypeEssayQuestionEntity.setGraderInfo(qtypeEssayQuestion.getGraderInfo());
        if(qtypeEssayQuestion.getGraderInfoFormat() != null)
            qtypeEssayQuestionEntity.setGraderInfoFormat(qtypeEssayQuestion.getGraderInfoFormat());
        if(qtypeEssayQuestion.getResponseTemplate() != null)
            qtypeEssayQuestionEntity.setResponseTemplate(qtypeEssayQuestion.getResponseTemplate());
        if(qtypeEssayQuestion.getMaxBytes() != null)
            qtypeEssayQuestionEntity.setMaxBytes(qtypeEssayQuestion.getMaxBytes());
        if(qtypeEssayQuestion.getFileTypesList() != null)
            qtypeEssayQuestionEntity.setFileTypesList(qtypeEssayQuestion.getFileTypesList());

        return qtypeEssayQuestionEntity;
    }
}
