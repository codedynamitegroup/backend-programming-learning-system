package com.backend.programming.learning.system.core.service.domain.implement.service.question.method.query;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeMultichoiceQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeMultiChoiceQuestion;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeMultichoiceQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeMultichoiceQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeMultichoiceQuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class QtypeMultichoiceQuestionQueryHelper {
    private final QtypeMultichoiceQuestionRepository qtypeMultichoiceQuestionRepository;
    private final QtypeMultichoiceQuestionDataMapper qtypeMultichoiceQuestionDataMapper;

    public QtypeMultichoiceQuestionQueryHelper(QtypeMultichoiceQuestionRepository qtypeMultichoiceQuestionRepository,
                                               QtypeMultichoiceQuestionDataMapper qtypeMultichoiceQuestionDataMapper) {
        this.qtypeMultichoiceQuestionRepository = qtypeMultichoiceQuestionRepository;
        this.qtypeMultichoiceQuestionDataMapper = qtypeMultichoiceQuestionDataMapper;
    }

    public QueryQtypeMultichoiceQuestionResponse queryQtypeMultichoiceQuestionById(UUID qtMultichoiceQuestionId) {
        Optional<QtypeMultiChoiceQuestion> qtypeMultichoiceQuestion = qtypeMultichoiceQuestionRepository.findQtypeMultipleChoiceQuestion(qtMultichoiceQuestionId);

        if (qtypeMultichoiceQuestion.isEmpty()) {
            log.error("Qtype Multichoice Question not found with id: {}", qtMultichoiceQuestionId);

            throw new QtypeMultichoiceQuestionNotFoundException("Qtype Multichoice Question with id " + qtMultichoiceQuestionId + " not found");
        }

        QueryQtypeMultichoiceQuestionResponse queryQtypeMultichoiceQuestionResponse = qtypeMultichoiceQuestionDataMapper
                .qtypeMultichoiceQuestionToQueryQtypeMultichoiceQuestionResponse(qtypeMultichoiceQuestion.get());

        log.info("Query Qtype Multichoice Question with id: {}", qtypeMultichoiceQuestion.get().getId().getValue());

        return queryQtypeMultichoiceQuestionResponse;
    }

    public List<QueryQtypeMultichoiceQuestionResponse> queryAllQtypeMultichoiceQuestion() {
        List<QtypeMultiChoiceQuestion> qtypeMultichoiceQuestions = qtypeMultichoiceQuestionRepository.findAllQtypeMultipleChoiceQuestion();

        log.info("Query all Qtype Multichoice Questions");

        return qtypeMultichoiceQuestionDataMapper.qtypeMultichoiceQuestionsToQueryQtypeMultichoiceQuestionResponse(qtypeMultichoiceQuestions);
    }

    public QueryQtypeMultichoiceQuestionResponse queryQtypeMultichoiceQuestionByQuestionId(UUID questionId) {
        Optional<QtypeMultiChoiceQuestion> qtypeMultichoiceQuestion = qtypeMultichoiceQuestionRepository.findQtypeMultipleChoiceQuestionByQuestionId(questionId);

        if (qtypeMultichoiceQuestion.isEmpty()) {
            log.error("Qtype Multichoice Question not found with id: {}", questionId);

            throw new QtypeMultichoiceQuestionNotFoundException("Qtype Multichoice Question with id " + questionId + " not found");
        }

        QueryQtypeMultichoiceQuestionResponse queryQtypeMultichoiceQuestionResponse = qtypeMultichoiceQuestionDataMapper
                .qtypeMultichoiceQuestionToQueryQtypeMultichoiceQuestionResponse(qtypeMultichoiceQuestion.get());

        log.info("Query Qtype Multichoice Question with id: {}", qtypeMultichoiceQuestion.get().getId().getValue());

        return queryQtypeMultichoiceQuestionResponse;
    }
}
