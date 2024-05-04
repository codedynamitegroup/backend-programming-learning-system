package com.backend.programming.learning.system.core.service.domain.implement.service.question.method.update;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeShortAnswerQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeShortanswerQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeShortanswerQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeShortanswerQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class QtypeShortanswerQuestionUpdateHelper {
    // Repositories
    private final QtypeShortanswerQuestionRepository qtypeShortanswerQuestionRepository;
    private final QuestionRepository questionRepository;

    // Mappers
    private final QtypeShortanswerQuestionDataMapper qtypeShortanswerQuestionDataMapper;

    private final CoreDomainService coreDomainService;
    private final CommonUpdateHelper commonUpdateHelper;

    public QtypeShortanswerQuestionUpdateHelper(
            QtypeShortanswerQuestionRepository qtypeShortanswerQuestionRepository,
            QuestionRepository questionRepository,
            QtypeShortanswerQuestionDataMapper qtypeShortanswerQuestionDataMapper,
            CoreDomainService coreDomainService,
            CommonUpdateHelper commonUpdateHelper) {
        this.qtypeShortanswerQuestionRepository = qtypeShortanswerQuestionRepository;
        this.questionRepository = questionRepository;
        this.qtypeShortanswerQuestionDataMapper = qtypeShortanswerQuestionDataMapper;
        this.coreDomainService = coreDomainService;
        this.commonUpdateHelper = commonUpdateHelper;
    }

    // Persist updated Qtype Shortanswer Question entity in database
    public QuestionUpdatedEvent updateQtypeShortanswerQuestionInDb(UpdateQtypeShortanswerQuestionCommand updateQtypeShortanswerQuestionCommand) {
        // check answers if exist when updating answers
        if (updateQtypeShortanswerQuestionCommand.getQuestion().getAnswers() != null)
            updateQtypeShortanswerQuestionCommand
                    .getQuestion()
                    .getAnswers()
                    .forEach(answer -> commonUpdateHelper.checkAnswerExist(answer.getAnswerId()));

        QtypeShortAnswerQuestion qtypeShortAnswerQuestion = getQtypeShortanswerQuestion(updateQtypeShortanswerQuestionCommand.getQtShortanswerQuestionId());
        Question prevQuestion = questionRepository.findQuestion(qtypeShortAnswerQuestion.getQuestion().getId().getValue()).get();
        QtypeShortAnswerQuestion mappedQtypeShortAnswerQuestion = qtypeShortanswerQuestionDataMapper
                .updateQtypeShortanswerQuestionCommandToQtypeShortAnswerQuestion(updateQtypeShortanswerQuestionCommand,
                        qtypeShortAnswerQuestion,
                        prevQuestion);

        updateQtypeShortanswerQuestionInDb(mappedQtypeShortAnswerQuestion);
        log.info("Qtype Shortanswer Question updated with id: {}", mappedQtypeShortAnswerQuestion.getId().getValue());

        commonUpdateHelper.updateQuestion(mappedQtypeShortAnswerQuestion.getQuestion());
        log.info("Question updated with id: {}", mappedQtypeShortAnswerQuestion.getQuestion().getId().getValue());

        return coreDomainService.updateQtypeShortAnswerQuestion(mappedQtypeShortAnswerQuestion.getQuestion(), mappedQtypeShortAnswerQuestion, prevQuestion, qtypeShortAnswerQuestion);
    }

    // Check if Qtype Shortanswer Question exists in database
    private QtypeShortAnswerQuestion getQtypeShortanswerQuestion(UUID qtShortanswerQuestionId) {
        Optional<QtypeShortAnswerQuestion> qtypeShortAnswerQuestion = qtypeShortanswerQuestionRepository.findQtypeShortAnswerQuestion(qtShortanswerQuestionId);

        if (qtypeShortAnswerQuestion.isEmpty()) {
            log.error("Qtype Shortanswer Question not found with id: {}", qtShortanswerQuestionId);
            throw new QtypeShortanswerQuestionNotFoundException("Qtype Shortanswer Question not found with id: " + qtShortanswerQuestionId);
        }
        log.info("Qtype Shortanswer Question found with id: {}", qtShortanswerQuestionId);

        return qtypeShortAnswerQuestion.get();
    }

    // Update Qtype Shortanswer Question entity in database
    private void updateQtypeShortanswerQuestionInDb(QtypeShortAnswerQuestion qtypeShortAnswerQuestion) {
        qtypeShortanswerQuestionRepository.updateQtypeShortAnswerQuestion(qtypeShortAnswerQuestion);
    }
}
