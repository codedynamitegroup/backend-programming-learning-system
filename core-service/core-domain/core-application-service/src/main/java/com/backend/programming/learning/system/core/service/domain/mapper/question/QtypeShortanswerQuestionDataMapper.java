package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeShortanswerQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QtypeShortanswerQuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeShortAnswerQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.domain.valueobject.QtypeShortAnswerQuestionId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QtypeShortanswerQuestionDataMapper {
    private final QuestionDataMapper questionDataMapper;

    public QtypeShortanswerQuestionDataMapper(QuestionDataMapper questionDataMapper) {
        this.questionDataMapper = questionDataMapper;
    }

    public QtypeShortAnswerQuestion createQuestionCommandToQtypeShortAnswerQuestion(CreateQtypeShortanswerQuestionCommand createQtypeShortanswerQuestionCommand,
                                                                                    Question question) {
        return QtypeShortAnswerQuestion.builder()
                .question(question)
                .caseSensitive(createQtypeShortanswerQuestionCommand.getCaseSensitive())
                .build();
    }

    public QueryQtypeShortanswerQuestionResponse qtypeShortanswerQuestionToQueryQtypeShortanswerQuestionResponse(QtypeShortAnswerQuestion qtypeShortanswerQuestion) {
        return QueryQtypeShortanswerQuestionResponse.builder()
                .qtypeShortAnswerQuestion(qtypeShortAnswerQuestionToQtypeShortanswerQuestionResponseEntity(qtypeShortanswerQuestion))
                .build();
    }

    public List<QueryQtypeShortanswerQuestionResponse> qtypeShortanswerQuestionsListToQueryQtypeShortanswerQuestionResponseList(List<QtypeShortAnswerQuestion> qtypeShortanswerQuestions) {
        return List.of(qtypeShortanswerQuestions.stream()
                .map(this::qtypeShortanswerQuestionToQueryQtypeShortanswerQuestionResponse)
                .toArray(QueryQtypeShortanswerQuestionResponse[]::new));
    }

    public QtypeShortAnswerQuestion updateQtypeShortanswerQuestionCommandToQtypeShortAnswerQuestion(
            UpdateQtypeShortanswerQuestionCommand updateQtypeShortanswerQuestionCommand,
            QtypeShortAnswerQuestion qtypeShortAnswerQuestion,
            Question prevQuestion) {
        return QtypeShortAnswerQuestion.builder()
                .id(new QtypeShortAnswerQuestionId(updateQtypeShortanswerQuestionCommand.getQtShortanswerQuestionId()))
                .caseSensitive(updateQtypeShortanswerQuestionCommand.getCaseSensitive())
                .question(questionDataMapper
                        .updateQuestionEntityToQuestion(updateQtypeShortanswerQuestionCommand.getQuestion(),
                                prevQuestion,
                                qtypeShortAnswerQuestion.getQuestion().getId(),
                                qtypeShortAnswerQuestion.getQuestion().getOrganization(),
                                qtypeShortAnswerQuestion.getQuestion().getCreatedBy(),
                                qtypeShortAnswerQuestion.getQuestion().getqtype(),
                                qtypeShortAnswerQuestion.getQuestion().getAnswers()))
                .build();
    }

    private QtypeShortanswerQuestionResponseEntity qtypeShortAnswerQuestionToQtypeShortanswerQuestionResponseEntity(QtypeShortAnswerQuestion qtypeShortAnswerQuestion) {
        return QtypeShortanswerQuestionResponseEntity.builder()
                .question(questionDataMapper.questionToQuestionResponseEntity(qtypeShortAnswerQuestion.getQuestion()))
                .id(qtypeShortAnswerQuestion.getId().getValue().toString())
                .caseSensitive(qtypeShortAnswerQuestion.getCaseSensitive())
                .build();
    }
}
