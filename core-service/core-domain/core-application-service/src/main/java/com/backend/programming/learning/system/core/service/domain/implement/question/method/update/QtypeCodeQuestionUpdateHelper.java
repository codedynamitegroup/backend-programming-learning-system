package com.backend.programming.learning.system.core.service.domain.implement.question.method.update;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeCodeQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeCodeQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeCodeQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class QtypeCodeQuestionUpdateHelper {
    private final QtypeCodeQuestionRepository qtypeCodeQuestionRepository;
    private final QtypeCodeQuestionDataMapper qtypeCodeQuestionDataMapper;
    private final QuestionDataMapper questionDataMapper;
    private final QuestionRepository questionRepository;
    private final CoreDomainService coreDomainService;

    public QtypeCodeQuestionUpdateHelper(QtypeCodeQuestionRepository qtypeCodeQuestionRepository,
                                         QtypeCodeQuestionDataMapper qtypeCodeQuestionDataMapper,
                                         QuestionDataMapper questionDataMapper,
                                         QuestionRepository questionRepository,
                                         CoreDomainService coreDomainService) {
        this.qtypeCodeQuestionRepository = qtypeCodeQuestionRepository;
        this.qtypeCodeQuestionDataMapper = qtypeCodeQuestionDataMapper;
        this.questionDataMapper = questionDataMapper;
        this.questionRepository = questionRepository;
        this.coreDomainService = coreDomainService;
    }

    public QuestionUpdatedEvent updateQtypeCodeQuestion(UpdateQtypeCodeQuestionCommand updateQtypeCodeQuestionCommand) {
       QtypeCodeQuestion qtypeCodeQuestion = getQtypeCodeQuestion(updateQtypeCodeQuestionCommand.getQtCodeQuestionId());

        QtypeCodeQuestion mappedQtypeCodeQuestion = qtypeCodeQuestionDataMapper
                .updateQtypeCodeQuestionCommandToQtypeCodeQuestion(updateQtypeCodeQuestionCommand);
        Question mappedQuestion = questionDataMapper
                .updateQuestionEntityToQuestion(updateQtypeCodeQuestionCommand.getQuestion(),
                qtypeCodeQuestion.getQuestion().getOrganization(),
                qtypeCodeQuestion.getQuestion().getqtype(),
                qtypeCodeQuestion.getQuestion().getCreatedBy(),
                qtypeCodeQuestion.getQuestion().getAnswers());

        //
        updateQtypeCodeQuestion(mappedQtypeCodeQuestion);
        log.info("Qtype Code Question updated with id: {}", mappedQtypeCodeQuestion.getId().getValue());

        updateQuestion(mappedQuestion);
        log.info("Question updated with id: {}", mappedQuestion.getId().getValue());

        QuestionUpdatedEvent questionUpdatedEvent = coreDomainService.updateQtypeCodeQuestion(mappedQuestion, mappedQtypeCodeQuestion);

        return questionUpdatedEvent;
    }

    private void updateQuestion(Question question) {
        questionRepository.updateQuestion(question);
    }

    private QtypeCodeQuestion getQtypeCodeQuestion(UUID qtCodeQuestionId) {
        Optional<QtypeCodeQuestion> qtypeCodeQuestion = qtypeCodeQuestionRepository.findQtypeCodeQuestion(qtCodeQuestionId);

        if (qtypeCodeQuestion.isEmpty()) {
            log.error("Qtype Code Question not found with id: {}", qtCodeQuestionId);

            throw new QtypeCodeQuestionNotFoundException("Qtype Code Question with id " + qtCodeQuestionId + " not found");
        }
        log.info("Qtype Code Question found with id: {}", qtCodeQuestionId);
        return qtypeCodeQuestion.get();
    }

    private void updateQtypeCodeQuestion(QtypeCodeQuestion qtypeCodeQuestion) {
        qtypeCodeQuestionRepository.updateQtypeCodeQuestion(qtypeCodeQuestion);
    }
}
