package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQtypeEssayQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeEssayQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import org.springframework.stereotype.Component;

@Component
public class QtypeEssayQuestionDataMapper {
    public QtypeEssayQuestion createQtypeEssayQuestionCommandToQtypeEssayQuestion(CreateQtypeEssayQuestionCommand createQtypeEssayQuestionCommand,
                                                                                  Question question) {
        return QtypeEssayQuestion.builder()
                .question(question)
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

    public QueryQtypeEssayQuestionResponse qtypeEssayQuestionToQueryQtypeEssayQuestionByIdResponse(QtypeEssayQuestion qtypeEssayQuestion) {
        return QueryQtypeEssayQuestionResponse.builder()
                .qtypeEssayQuestion(qtypeEssayQuestion)
                .build();
    }
}
