package com.backend.programming.learning.system.core.service.domain.implement.question.method.query;

import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQtypeEssayQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeEssayQuestion;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeEssayQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeEssayQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeEssayQuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class QtypeEssayQuestionQueryHelper {
    private final QtypeEssayQuestionDataMapper qtypeEssayQuestionDataMapper;
    private final QtypeEssayQuestionRepository qtypeEssayQuestionRepository;

    public QtypeEssayQuestionQueryHelper(QtypeEssayQuestionDataMapper qtypeEssayQuestionDataMapper,
                                         QtypeEssayQuestionRepository qtypeEssayQuestionRepository) {
        this.qtypeEssayQuestionDataMapper = qtypeEssayQuestionDataMapper;
        this.qtypeEssayQuestionRepository = qtypeEssayQuestionRepository;
    }

    public QueryQtypeEssayQuestionResponse queryQtypeEssayQuestionById(UUID qtEssayQuestionId) {
        Optional<QtypeEssayQuestion> qtypeEssayQuestion = qtypeEssayQuestionRepository.findQtypeEssayQuestion(qtEssayQuestionId);

        if (qtypeEssayQuestion.isEmpty()) {
            log.error("Qtype Essay Question not found with id: {}", qtEssayQuestionId);

            throw new QtypeEssayQuestionNotFoundException("Qtype Essay Question with id " + qtEssayQuestionId + " not found");
        }

        QueryQtypeEssayQuestionResponse queryQtypeEssayQuestionByIdResponse = qtypeEssayQuestionDataMapper
                .qtypeEssayQuestionToQueryQtypeEssayQuestionResponse(qtypeEssayQuestion.get());

        log.info("Query Qtype Essay Question with id: {}", qtypeEssayQuestion.get().getId().getValue());

        return queryQtypeEssayQuestionByIdResponse;
    }

    public List<QueryQtypeEssayQuestionResponse> queryAllQtypeEssayQuestion() {
        List<QtypeEssayQuestion> qtypeEssayQuestions = qtypeEssayQuestionRepository.findAllQtypeEssayQuestion();

        log.info("Query all Qtype Essay Questions");

        return qtypeEssayQuestionDataMapper.qtypeEssayQuestionsToQueryQtypeEssayQuestionResponses(qtypeEssayQuestions);
    }
}
