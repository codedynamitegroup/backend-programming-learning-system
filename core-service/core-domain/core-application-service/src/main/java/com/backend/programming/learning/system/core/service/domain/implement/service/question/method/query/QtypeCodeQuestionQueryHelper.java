package com.backend.programming.learning.system.core.service.domain.implement.service.question.method.query;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeCodeQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeCodeQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeCodeQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeCodeQuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class QtypeCodeQuestionQueryHelper {
    private final QtypeCodeQuestionRepository qtypeCodeQuestionRepository;
    private final QtypeCodeQuestionDataMapper qtypeCodeQuestionDataMapper;

    public QtypeCodeQuestionQueryHelper(QtypeCodeQuestionRepository qtypeCodeQuestionRepository,
                                        QtypeCodeQuestionDataMapper qtypeCodeQuestionDataMapper) {
        this.qtypeCodeQuestionRepository = qtypeCodeQuestionRepository;
        this.qtypeCodeQuestionDataMapper = qtypeCodeQuestionDataMapper;
    }

    public QueryQtypeCodeQuestionResponse queryQtypeCodeQuestionById(UUID qtCodeQuestionId) {
        Optional<QtypeCodeQuestion> qtypeCodeQuestion = qtypeCodeQuestionRepository.findQtypeCodeQuestion(qtCodeQuestionId);

        if (qtypeCodeQuestion.isEmpty()) {
            log.error("Qtype Code Question not found with id: {}", qtCodeQuestionId);

            throw new QtypeCodeQuestionNotFoundException("Qtype Code Question with id " + qtCodeQuestionId + " not found");
        }

        QueryQtypeCodeQuestionResponse queryQtypeCodeQuestionResponse = qtypeCodeQuestionDataMapper
                .qtypeCodeQuestionToQueryQtypeCodeQuestionResponse(qtypeCodeQuestion.get());

        log.info("Query Qtype Code Question with id: {}", qtypeCodeQuestion.get().getId().getValue());

        return queryQtypeCodeQuestionResponse;
    }

    public QueryQtypeCodeQuestionResponse queryQuestionById(UUID questionId) {
        Optional<QtypeCodeQuestion> qtypeCodeQuestion = qtypeCodeQuestionRepository.findQuestionId(questionId);

        if (qtypeCodeQuestion.isEmpty()) {
            log.error("Qtype Code Question not found with id: {}", questionId);

            throw new QtypeCodeQuestionNotFoundException("Qtype Code Question with id " + questionId + " not found");
        }

        QueryQtypeCodeQuestionResponse queryQtypeCodeQuestionResponse = qtypeCodeQuestionDataMapper
                .qtypeCodeQuestionToQueryQtypeCodeQuestionResponse(qtypeCodeQuestion.get());

        log.info("Query Qtype Code Question with id: {}", qtypeCodeQuestion.get().getId().getValue());

        return queryQtypeCodeQuestionResponse;
    }

    public List<QueryQtypeCodeQuestionResponse> queryAllQtypeCodeQuestions() {
        List<QtypeCodeQuestion> qtypeCodeQuestions = qtypeCodeQuestionRepository.findAllQtypeCodeQuestions();

        return qtypeCodeQuestionDataMapper.qtypeCodeQuestionsToQueryQtypeCodeQuestionResponses(qtypeCodeQuestions);
    }
}
