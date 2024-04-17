package com.backend.programming.learning.system.core.service.domain.implement.question.method.delete;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.AnswerOfQuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.core.service.domain.exception.question.AnswerOfQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.AnswerOfQuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class AnswerOfQuestionDeleteHelper {
    private final AnswerOfQuestionRepository answerOfQuestionRepository;
    private final QuestionDataMapper questionDataMapper;

    public AnswerOfQuestionDeleteHelper(AnswerOfQuestionRepository answerOfQuestionRepository,
                                        QuestionDataMapper questionDataMapper) {
        this.answerOfQuestionRepository = answerOfQuestionRepository;
        this.questionDataMapper = questionDataMapper;
    }

    public AnswerOfQuestionDeleteResponse deleteAnswerOfQuestionById(UUID answerId) {
        checkAnswerOfQuestionExist(answerId);

        log.info("Deleting answers of question with id: {}", answerId);
        answerOfQuestionRepository.deleteAnswerOfQuestion(answerId);
        log.info("Answers of question deleted with id: {}", answerId);

        return questionDataMapper.answerOfQuestionToAnswerOfQuestionDeleteResponse(answerId);
    }

    private void checkAnswerOfQuestionExist(UUID answerId) {
        Optional<AnswerOfQuestion> answerOfQuestion = answerOfQuestionRepository.getAnswerOfQuestionById(answerId);
        if (answerOfQuestion.isEmpty()) {
            log.error("Answer of question with id: {} not found", answerId);
            throw new AnswerOfQuestionNotFoundException("Answer of question with id: " + answerId + " not found");
        }
    }
}
