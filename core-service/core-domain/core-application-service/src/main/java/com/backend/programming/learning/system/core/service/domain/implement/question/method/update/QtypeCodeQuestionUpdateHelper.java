package com.backend.programming.learning.system.core.service.domain.implement.question.method.update;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.exception.question.AnswerOfQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeCodeQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeCodeQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.AnswerOfQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeCodeQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class QtypeCodeQuestionUpdateHelper {
    // Repositories
    private final AnswerOfQuestionRepository answerRepository;
    private final QtypeCodeQuestionRepository qtypeCodeQuestionRepository;
    private final QuestionRepository questionRepository;

    // Mappers
    private final QtypeCodeQuestionDataMapper qtypeCodeQuestionDataMapper;

    private final CoreDomainService coreDomainService;

    public QtypeCodeQuestionUpdateHelper(
            AnswerOfQuestionRepository answerRepository,
            QtypeCodeQuestionRepository qtypeCodeQuestionRepository,
            QuestionRepository questionRepository,
            QtypeCodeQuestionDataMapper qtypeCodeQuestionDataMapper,
            CoreDomainService coreDomainService) {
        this.answerRepository = answerRepository;
        this.qtypeCodeQuestionRepository = qtypeCodeQuestionRepository;
        this.questionRepository = questionRepository;
        this.qtypeCodeQuestionDataMapper = qtypeCodeQuestionDataMapper;
        this.coreDomainService = coreDomainService;
    }


    // Persist updated Qtype Code Question entity in database
    public QuestionUpdatedEvent updateQtypeCodeQuestion(UpdateQtypeCodeQuestionCommand updateQtypeCodeQuestionCommand) {
        // check answers if exist when updating answers
        if (updateQtypeCodeQuestionCommand.getQuestion().getAnswers() != null)
            updateQtypeCodeQuestionCommand
                    .getQuestion()
                    .getAnswers()
                    .forEach(answer -> checkAnswerExist(answer.getAnswerId()));

        QtypeCodeQuestion qtypeCodeQuestion = getQtypeCodeQuestion(updateQtypeCodeQuestionCommand.getQtCodeQuestionId());
        QtypeCodeQuestion mappedQtypeCodeQuestion = qtypeCodeQuestionDataMapper
                .updateQtypeCodeQuestionCommandToQtypeCodeQuestion(updateQtypeCodeQuestionCommand, qtypeCodeQuestion);

        updateQtypeCodeQuestion(mappedQtypeCodeQuestion);
        log.info("Qtype Code Question updated with id: {}", mappedQtypeCodeQuestion.getId().getValue());

        updateQuestion(mappedQtypeCodeQuestion.getQuestion());
        log.info("Question updated with id: {}", mappedQtypeCodeQuestion.getQuestion().getId().getValue());

        return coreDomainService.updateQtypeCodeQuestion(mappedQtypeCodeQuestion.getQuestion(), mappedQtypeCodeQuestion);
    }

    // Update Question entity in database
    private void updateQuestion(Question question) {
        questionRepository.updateQuestion(question);
    }

    // Check and get Qtype Code Question entity from database
    private QtypeCodeQuestion getQtypeCodeQuestion(UUID qtCodeQuestionId) {
        Optional<QtypeCodeQuestion> qtypeCodeQuestion = qtypeCodeQuestionRepository.findQtypeCodeQuestion(qtCodeQuestionId);

        if (qtypeCodeQuestion.isEmpty()) {
            log.error("Qtype Code Question not found with id: {}", qtCodeQuestionId);

            throw new QtypeCodeQuestionNotFoundException("Qtype Code Question with id " + qtCodeQuestionId + " not found");
        }
        log.info("Qtype Code Question found with id: {}", qtCodeQuestionId);
        return qtypeCodeQuestion.get();
    }

    // Update Qtype Code Question entity in database
    private void updateQtypeCodeQuestion(QtypeCodeQuestion qtypeCodeQuestion) {
        qtypeCodeQuestionRepository.updateQtypeCodeQuestion(qtypeCodeQuestion);
    }

    // Check if answer exist in database
    private void checkAnswerExist(UUID answerId) {
        Optional<AnswerOfQuestion> answer = answerRepository.getAnswerOfQuestionById(answerId);

        if (answer.isEmpty()) {
            log.error("Answer not found with id: {}", answerId);
            throw new AnswerOfQuestionNotFoundException("Answer with id " + answerId + " not found");
        }
    }
}
