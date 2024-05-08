package com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.question_outbox.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_questions_update_outbox.exception.CodeQuestionsUpdateOutboxNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.question_outbox.repository.QuestionOutboxJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.question_outbox.mapper.QuestionOutboxDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.question.QuestionOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.QuestionOutboxRepository;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class QuestionOutboxRepositoryImpl implements QuestionOutboxRepository {
    private final QuestionOutboxJpaRepository questionOutboxJpaRepository;
    private final QuestionOutboxDataAccessMapper questionOutboxDataAccessMapper;

    public QuestionOutboxRepositoryImpl(
            QuestionOutboxJpaRepository questionOutboxJpaRepository,
            QuestionOutboxDataAccessMapper questionOutboxDataAccessMapper) {
        this.questionOutboxJpaRepository = questionOutboxJpaRepository;
        this.questionOutboxDataAccessMapper = questionOutboxDataAccessMapper;
    }

    @Override
    public QuestionOutboxMessage save(QuestionOutboxMessage questionOutboxMessage) {
        return questionOutboxDataAccessMapper
                .questionOutboxEntityToQuestionOutboxMessage(questionOutboxJpaRepository
                        .save(questionOutboxDataAccessMapper
                                .questionOutboxMessageToQuestionOutboxEntity(questionOutboxMessage)));
    }

    @Override
    public Optional<List<QuestionOutboxMessage>> findByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus) {
        return Optional.of(questionOutboxJpaRepository.findByTypeAndOutboxStatus(type,
                        outboxStatus)
                .orElseThrow(() -> new CodeQuestionsUpdateOutboxNotFoundException("Question outbox object " +
                        "could not be found for saga type " + type))
                .stream()
                .map(questionOutboxDataAccessMapper::questionOutboxEntityToQuestionOutboxMessage)
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<QuestionOutboxMessage> findByTypeAndSagaId(String type, UUID sagaId) {
        return questionOutboxJpaRepository
                .findByTypeAndSagaId(type, sagaId)
                .map(questionOutboxDataAccessMapper::questionOutboxEntityToQuestionOutboxMessage);
    }

    @Override
    public void deleteByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus) {
        questionOutboxJpaRepository.deleteByTypeAndOutboxStatus(type, outboxStatus);
    }
}
