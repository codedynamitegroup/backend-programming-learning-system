package com.backend.programming.learning.system.core.service.domain.implement.service.question.method.query;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeShortanswerQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeShortAnswerQuestion;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeShortanswerQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeShortanswerQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeShortanswerQuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class QtypeShortanswerQuestionQueryHelper {
    private final QtypeShortanswerQuestionRepository qtypeShortanswerQuestionRepository;
    private final QtypeShortanswerQuestionDataMapper qtypeShortanswerQuestionDataMapper;


    public QtypeShortanswerQuestionQueryHelper(QtypeShortanswerQuestionRepository qtypeShortanswerQuestionRepository,
                                               QtypeShortanswerQuestionDataMapper qtypeShortanswerQuestionDataMapper) {
        this.qtypeShortanswerQuestionRepository = qtypeShortanswerQuestionRepository;
        this.qtypeShortanswerQuestionDataMapper = qtypeShortanswerQuestionDataMapper;
    }

    public QueryQtypeShortanswerQuestionResponse queryQtypeShortanswerQuestionById(UUID qtShortanswerQuestionId) {
        Optional<QtypeShortAnswerQuestion> qtypeShortanswerQuestion = qtypeShortanswerQuestionRepository.findQtypeShortAnswerQuestion(qtShortanswerQuestionId);

        if (qtypeShortanswerQuestion.isEmpty()) {
            log.error("Qtype Shortanswer Question not found with id: {}", qtShortanswerQuestionId);

            throw new QtypeShortanswerQuestionNotFoundException("Qtype Shortanswer Question with id " + qtShortanswerQuestionId + " not found");
        }

        QueryQtypeShortanswerQuestionResponse queryQtypeShortanswerQuestionResponse = qtypeShortanswerQuestionDataMapper
                .qtypeShortanswerQuestionToQueryQtypeShortanswerQuestionResponse(qtypeShortanswerQuestion.get());

        log.info("Query Qtype Shortanswer Question with id: {}", qtypeShortanswerQuestion.get().getId().getValue());

        return queryQtypeShortanswerQuestionResponse;
    }

    public List<QueryQtypeShortanswerQuestionResponse> queryAllQtypeShortanswerQuestions() {
        List<QtypeShortAnswerQuestion> qtypeShortanswerQuestions = qtypeShortanswerQuestionRepository.findAllQtypeShortAnswerQuestions();

        log.info("Query all Qtype Shortanswer Questions");

        return qtypeShortanswerQuestionDataMapper
                .qtypeShortanswerQuestionsListToQueryQtypeShortanswerQuestionResponseList(qtypeShortanswerQuestions);
    }

    public QueryQtypeShortanswerQuestionResponse queryQtypeShortanswerQuestionByQuestionId(UUID questionId) {
        Optional<QtypeShortAnswerQuestion> qtypeShortanswerQuestion = qtypeShortanswerQuestionRepository.findQtypeShortAnswerQuestionByQuestionId(questionId);

        if (qtypeShortanswerQuestion.isEmpty()) {
            log.error("Qtype Shortanswer Question not found with question id: {}", questionId);

            throw new QtypeShortanswerQuestionNotFoundException("Qtype Shortanswer Question with question id " + questionId + " not found");
        }

        QueryQtypeShortanswerQuestionResponse queryQtypeShortanswerQuestionResponse = qtypeShortanswerQuestionDataMapper
                .qtypeShortanswerQuestionToQueryQtypeShortanswerQuestionResponse(qtypeShortanswerQuestion.get());

        log.info("Query Qtype Shortanswer Question with question id: {}", qtypeShortanswerQuestion.get().getId().getValue());

        return queryQtypeShortanswerQuestionResponse;
    }
}
