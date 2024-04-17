package com.backend.programming.learning.system.core.service.domain.implement.question.method.delete;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionDeletedEvent;
import com.backend.programming.learning.system.core.service.domain.exception.question.QuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class QuestionDeleteHelper {
    private final QuestionRepository questionRepository;
    private final QtypeCodeQuestionRepository qtypeCodeQuestionRepository;
    private final QtypeShortanswerQuestionRepository qtypeShortanswerQuestionRepository;
    private final QtypeEssayQuestionRepository qtypeEssayQuestionRepository;
    private final QtypeMultichoiceQuestionRepository qtypeMultipleChoiceQuestionRepository;
    private final AnswerOfQuestionRepository answerOfQuestionRepository;
    private final CoreDomainService coreDomainService;

    public QuestionDeleteHelper(QuestionRepository questionRepository,
                                QtypeCodeQuestionRepository qtypeCodeQuestionRepository,
                                QtypeShortanswerQuestionRepository qtypeShortanswerQuestionRepository,
                                QtypeEssayQuestionRepository qtypeEssayQuestionRepository,
                                QtypeMultichoiceQuestionRepository qtypeMultipleChoiceQuestionRepository,
                                AnswerOfQuestionRepository answerOfQuestionRepository, CoreDomainService coreDomainService) {
        this.questionRepository = questionRepository;
        this.qtypeCodeQuestionRepository = qtypeCodeQuestionRepository;
        this.qtypeShortanswerQuestionRepository = qtypeShortanswerQuestionRepository;
        this.qtypeEssayQuestionRepository = qtypeEssayQuestionRepository;
        this.qtypeMultipleChoiceQuestionRepository = qtypeMultipleChoiceQuestionRepository;
        this.answerOfQuestionRepository = answerOfQuestionRepository;
        this.coreDomainService = coreDomainService;
    }

    public QuestionDeletedEvent deleteQuestionById(UUID questionId) {
        Question deletingQuestion = getQuestion(questionId);
        UUID qtypeQuestionId = getQtypeQuestionId(deletingQuestion);

        // delete answer of question
        log.info("Deleting answers of question with id: {}", questionId);
        answerOfQuestionRepository.deleteAllAnswerOfQuestionByQuestionId(questionId);
        log.info("Answers of question deleted with id: {}", questionId);

        deleteQuestion(questionId);

        return coreDomainService.deleteQuestion(deletingQuestion, qtypeQuestionId);
    }

    @Transactional
    private void deleteQuestion(UUID questionId) {
        log.info("Deleting question with id: {}", questionId);
        questionRepository.deleteQuestion(questionId);
        log.info("Question deleted with id: {}", questionId);
    }

    private Question getQuestion(UUID questionId) {
        Optional<Question> question = questionRepository.findQuestion(questionId);

        if(question.isEmpty()) {
            log.warn("Question not found with id: {}", questionId);
            throw new QuestionNotFoundException("Question with id " + questionId + " not found");
        }
        return question.get();
    }

    public UUID getQtypeQuestionId(Question question) {
        UUID qtypeQuestionId = null;

        if (question.getqtype() == QuestionType.CODE) {
            qtypeQuestionId = qtypeCodeQuestionRepository.getId(question.getId().getValue());
        }
        else if (question.getqtype() == QuestionType.SHORT_ANSWER) {
            qtypeQuestionId = qtypeShortanswerQuestionRepository.getId(question.getId().getValue());
        }
        else if (question.getqtype() == QuestionType.ESSAY) {
            qtypeQuestionId = qtypeEssayQuestionRepository.getId(question.getId().getValue());
        }
        else if (question.getqtype() == QuestionType.MULTIPLE_CHOICE) {
            qtypeQuestionId = qtypeMultipleChoiceQuestionRepository.getId(question.getId().getValue());
        }
        else {
            throw new IllegalArgumentException("Invalid question type");
        }
        return qtypeQuestionId;
    }
}
