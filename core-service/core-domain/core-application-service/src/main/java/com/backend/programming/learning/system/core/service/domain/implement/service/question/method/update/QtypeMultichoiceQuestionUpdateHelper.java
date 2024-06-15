package com.backend.programming.learning.system.core.service.domain.implement.service.question.method.update;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeMultichoiceQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeMultiChoiceQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeMultichoiceQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeMultichoiceQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeMultichoiceQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class QtypeMultichoiceQuestionUpdateHelper {
    // Repositories
    private final QtypeMultichoiceQuestionRepository qtypeMultichoiceQuestionRepository;
    private final QuestionRepository questionRepository;

    // Mappers
    private final QtypeMultichoiceQuestionDataMapper qtypeMultichoiceQuestionDataMapper;

    private final CoreDomainService coreDomainService;
    private final CommonUpdateHelper commonUpdateHelper;

    public QtypeMultichoiceQuestionUpdateHelper(
            QtypeMultichoiceQuestionRepository qtypeMultichoiceQuestionRepository,
            QuestionRepository questionRepository,
            QtypeMultichoiceQuestionDataMapper qtypeMultichoiceQuestionDataMapper,
            CoreDomainService coreDomainService,
            CommonUpdateHelper commonUpdateHelper) {
        this.qtypeMultichoiceQuestionRepository = qtypeMultichoiceQuestionRepository;
        this.questionRepository = questionRepository;
        this.qtypeMultichoiceQuestionDataMapper = qtypeMultichoiceQuestionDataMapper;
        this.coreDomainService = coreDomainService;
        this.commonUpdateHelper = commonUpdateHelper;
    }

    // Persist updated Qtype Multichoice Question entity in database
    public QuestionUpdatedEvent updateQtypeMultichoiceQuestionInDb(UpdateQtypeMultichoiceQuestionCommand updateQtypeMultichoiceQuestionCommand) {
        QtypeMultiChoiceQuestion qtypeMultichoiceQuestion = getQtypeMultichoiceQuestion(updateQtypeMultichoiceQuestionCommand.getQtMultichoiceQuestionId());
        Question prevQuestion = questionRepository.findQuestion(qtypeMultichoiceQuestion.getQuestion().getId().getValue()).get();
        QtypeMultiChoiceQuestion mappedQtypeMultichoiceQuestion = qtypeMultichoiceQuestionDataMapper
                .updateQtypeMultichoiceQuestionCommandToQtypeMultiChoiceQuestion(updateQtypeMultichoiceQuestionCommand, prevQuestion, qtypeMultichoiceQuestion);

        updateQtypeMultichoiceQuestionInDb(mappedQtypeMultichoiceQuestion);
        log.info("Qtype Multichoice Question updated with id: {}", mappedQtypeMultichoiceQuestion.getId().getValue());

        commonUpdateHelper.updateQuestion(mappedQtypeMultichoiceQuestion.getQuestion());
        log.info("Question updated with id: {}", mappedQtypeMultichoiceQuestion.getQuestion().getId().getValue());

        return coreDomainService.updateQtypeMultipleChoiceQuestion(mappedQtypeMultichoiceQuestion.getQuestion(), mappedQtypeMultichoiceQuestion, prevQuestion, qtypeMultichoiceQuestion);
    }

    // Get Qtype Multichoice Question entity by id
    private QtypeMultiChoiceQuestion getQtypeMultichoiceQuestion(UUID qtypeMultichoiceQuestionId) {
        Optional<QtypeMultiChoiceQuestion> qtypeMultichoiceQuestion = qtypeMultichoiceQuestionRepository.findQtypeMultipleChoiceQuestion(qtypeMultichoiceQuestionId);
        if (qtypeMultichoiceQuestion.isEmpty())
            throw new QtypeMultichoiceQuestionNotFoundException("Qtype Multichoice Question not found with id: " + qtypeMultichoiceQuestionId);
        return qtypeMultichoiceQuestion.get();
    }

    // Update Qtype Multichoice Question entity in database
    private void updateQtypeMultichoiceQuestionInDb(QtypeMultiChoiceQuestion qtypeMultichoiceQuestion) {
        qtypeMultichoiceQuestionRepository.updateQtypeMultichoiceQuestion(qtypeMultichoiceQuestion);
    }
}
