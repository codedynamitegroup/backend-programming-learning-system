package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeEssayQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QtypeEssayQuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeEssayQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.domain.valueobject.QtypeEssayQuestionId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QtypeEssayQuestionDataMapper {
    private final QuestionDataMapper questionDataMapper;

    public QtypeEssayQuestionDataMapper(QuestionDataMapper questionDataMapper) {
        this.questionDataMapper = questionDataMapper;
    }

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

    public QueryQtypeEssayQuestionResponse qtypeEssayQuestionToQueryQtypeEssayQuestionResponse(QtypeEssayQuestion qtypeEssayQuestion) {
        return QueryQtypeEssayQuestionResponse.builder()
                .qtypeEssayQuestion(qtypeEssayQuestionToQtypeEssayQuestionResponseEntity(qtypeEssayQuestion))
                .build();
    }

    public List<QueryQtypeEssayQuestionResponse> qtypeEssayQuestionsToQueryQtypeEssayQuestionResponses(List<QtypeEssayQuestion> qtypeEssayQuestions) {
        return List.of(qtypeEssayQuestions.stream()
                .map(this::qtypeEssayQuestionToQueryQtypeEssayQuestionResponse)
                .toArray(QueryQtypeEssayQuestionResponse[]::new));
    }

    public QtypeEssayQuestion updateQtypeEssayQuestionCommandToQtypeEssayQuestion(UpdateQtypeEssayQuestionCommand updateQtypeEssayQuestionCommand,
            Question prevQuestion,
            QtypeEssayQuestion qtypeEssayQuestion) {

            return QtypeEssayQuestion.builder()
                    .id(new QtypeEssayQuestionId(updateQtypeEssayQuestionCommand.getQtEssayQuestionId()))
                    .responseFormat(updateQtypeEssayQuestionCommand.getResponseFormat())
                    .responseRequired(updateQtypeEssayQuestionCommand.getResponseRequired())
                    .responseFieldLines(updateQtypeEssayQuestionCommand.getResponseFieldLines())
                    .minWordLimit(updateQtypeEssayQuestionCommand.getMinWordLimit())
                    .maxWordLimit(updateQtypeEssayQuestionCommand.getMaxWordLimit())
                    .attachments(updateQtypeEssayQuestionCommand.getAttachments())
                    .attachmentsRequired(updateQtypeEssayQuestionCommand.getAttachmentsRequired())
                    .graderInfo(updateQtypeEssayQuestionCommand.getGraderInfo())
                    .graderInfoFormat(updateQtypeEssayQuestionCommand.getGraderInfoFormat())
                    .responseTemplate(updateQtypeEssayQuestionCommand.getResponseTemplate())
                    .maxBytes(updateQtypeEssayQuestionCommand.getMaxBytes())
                    .fileTypesList(updateQtypeEssayQuestionCommand.getFileTypesList())
                    .question(questionDataMapper.updateQuestionEntityToQuestion(updateQtypeEssayQuestionCommand.getQuestion(),
                            prevQuestion,
                            qtypeEssayQuestion.getQuestion().getId(),
                            qtypeEssayQuestion.getQuestion().getOrganization(),
                            qtypeEssayQuestion.getQuestion().getCreatedBy(),
                            qtypeEssayQuestion.getQuestion().getqtype(),
                            qtypeEssayQuestion.getQuestion().getAnswers()))
                    .build();
    }

    private QtypeEssayQuestionResponseEntity qtypeEssayQuestionToQtypeEssayQuestionResponseEntity(QtypeEssayQuestion qtypeEssayQuestion) {
        return QtypeEssayQuestionResponseEntity.builder()
                .question(questionDataMapper.questionToQuestionResponseEntity(qtypeEssayQuestion.getQuestion()))
                .id(qtypeEssayQuestion.getId().getValue().toString())
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

}
