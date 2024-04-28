package com.backend.programming.learning.system.core.service.domain.implement.service.question.method.update;

import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.exception.question.AnswerOfQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.AnswerOfQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class CommonUpdateHelper {
    private final AnswerOfQuestionRepository answerRepository;
    private final QuestionRepository questionRepository;

    public CommonUpdateHelper(AnswerOfQuestionRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    // Check if answer exist in database
    public void checkAnswerExist(UUID answerId) {
        Optional<AnswerOfQuestion> answer = answerRepository.getAnswerOfQuestionById(answerId);

        if (answer.isEmpty()) {
            log.error("Answer not found with id: {}", answerId);
            throw new AnswerOfQuestionNotFoundException("Answer with id " + answerId + " not found");
        }
    }

    // Update Question entity in database
    public void updateQuestion(Question question) {
        questionRepository.updateQuestion(question);
    }
}
