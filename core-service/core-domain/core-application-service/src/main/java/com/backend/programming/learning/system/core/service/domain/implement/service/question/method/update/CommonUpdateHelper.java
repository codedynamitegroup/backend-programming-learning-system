package com.backend.programming.learning.system.core.service.domain.implement.service.question.method.update;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.exception.question.AnswerOfQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.AnswerOfQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class CommonUpdateHelper {
    private final AnswerOfQuestionRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final CoreDomainService coreDomainService;

    public CommonUpdateHelper(AnswerOfQuestionRepository answerRepository, QuestionRepository questionRepository,
                              CoreDomainService coreDomainService) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.coreDomainService = coreDomainService;
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
    @Transactional
    public void updateQuestion(Question question) {
        // Create new answer if null
        question.getAnswers().forEach(answer -> {
            if (answer.getId().getValue() == null) {
              coreDomainService.createAnswerOfQuestion(answer);
            }
        });

        List<AnswerOfQuestion> answerOfQuestions = answerRepository.getAllAnswerOfQuestionByQuestionId(question.getId().getValue());

        // Check if question has answer
        List<AnswerOfQuestion> deletingAnswerList = answerOfQuestions.stream().filter(answerOfQuestion -> !question.getAnswers().contains(answerOfQuestion)).toList();

        answerRepository.deleteAllById(deletingAnswerList
                .stream()
                .map(answerOfQuestion -> answerOfQuestion.getId().getValue())
                .toList());

        questionRepository.updateQuestion(question);
    }
}
