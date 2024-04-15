package com.backend.programming.learning.system.core.service.domain.implement.question.method.query;

import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQtypeShortanswerQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeShortAnswerQuestion;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeShortanswerQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeShortanswerQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeShortanswerQuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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
                .qtypeShortanswerQuestionToQueryQtypeShortanswerQuestionByIdResponse(qtypeShortanswerQuestion.get());

        log.info("Query Qtype Shortanswer Question with id: {}", qtypeShortanswerQuestion.get().getId().getValue());

        return queryQtypeShortanswerQuestionResponse;
    }
}
