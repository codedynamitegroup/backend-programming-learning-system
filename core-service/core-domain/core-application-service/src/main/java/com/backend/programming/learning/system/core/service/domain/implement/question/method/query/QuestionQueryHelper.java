package com.backend.programming.learning.system.core.service.domain.implement.question.method.query;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.domain.exception.question.QuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class QuestionQueryHelper {
    private final QuestionDataMapper questionDataMapper;
    private final QuestionRepository questionRepository;

    public QuestionQueryHelper(QuestionDataMapper questionDataMapper, QuestionRepository questionRepository) {
        this.questionDataMapper = questionDataMapper;
        this.questionRepository = questionRepository;
    }

    public QuestionResponseEntity queryQuestionById(UUID questionId) {
        Optional<Question> question = questionRepository.findQuestion(questionId);

        if (question.isEmpty()) {
            log.error("Question not found with id: {}", questionId);

            throw new QuestionNotFoundException("Question with id " + questionId + " not found");
        }

        QuestionResponseEntity questionResponseEntity = questionDataMapper
                .questionToQuestionResponseEntity(question.get());

        log.info("Query question with id: {}", question.get().getId().getValue());

        return questionResponseEntity;
    }

    public List<QuestionResponseEntity> queryAllQuestion() {
        List<QuestionResponseEntity> questions = questionRepository.findAllQuestion();

        log.info("Query all questions");

        return questions;
    }
}
