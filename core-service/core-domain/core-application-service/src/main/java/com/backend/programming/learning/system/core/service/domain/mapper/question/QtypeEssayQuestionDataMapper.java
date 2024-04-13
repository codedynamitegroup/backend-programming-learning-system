package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeEssayQuestion;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

@Component
public class QtypeEssayQuestionDataMapper {
    public QtypeEssayQuestion createQtypeEssayQuestionCommandToQtypeEssayQuestion(CreateQtypeEssayQuestionCommand createQtypeEssayQuestionCommand,
                                                                                  QuestionId questionId) {
        return QtypeEssayQuestion.builder()
                .questionId(questionId)
                .responseFormat(createQtypeEssayQuestionCommand.getResponseFormat())
                .responseRequired(createQtypeEssayQuestionCommand.getResponseRequired())
                .responseFieldLines(createQtypeEssayQuestionCommand.getResponseFieldLines())
                .minWordLimit(createQtypeEssayQuestionCommand.getMinWordLimit())
                .maxWordLimit(createQtypeEssayQuestionCommand.getMaxWordLimit())
                .attachments(createQtypeEssayQuestionCommand.getAttachments())
                .attachmentsRequired(createQtypeEssayQuestionCommand.getAttachmentsRequired())
                .graderInfo(createQtypeEssayQuestionCommand.getGraderInfo())
                .graderInfoFormat(createQtypeEssayQuestionCommand.getGraderInfoFormat())
                .responseTemplate(createQtypeEssayQuestionCommand.getResponseTemplate())
                .maxBytes(createQtypeEssayQuestionCommand.getMaxBytes())
                .fileTypesList(createQtypeEssayQuestionCommand.getFileTypesList())
                .build();
    }
}
