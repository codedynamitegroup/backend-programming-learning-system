package com.backend.programming.learning.system.core.service.dataaccess.outbox.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.outbox.question.exception.QuestionOutboxNotFoundException;
import com.backend.programming.learning.system.core.service.dataaccess.outbox.question.mapper.QuestionOutboxDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.outbox.question.repository.QuestionOutboxJpaRepository;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionOutboxRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;
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
    public Optional<List<QuestionOutboxMessage>> findByTypeAndOutboxStatusAndSagaStatus(
            String type,
            OutboxStatus outboxStatus,
            SagaStatus... sagaStatus) {
        return Optional.of(questionOutboxJpaRepository.findByTypeAndOutboxStatusAndSagaStatusIn(type,
                        outboxStatus,
                        Arrays.asList(sagaStatus))
                .orElseThrow(() -> new QuestionOutboxNotFoundException("Question outbox object " +
                        "could not be found for saga type " + type))
                .stream()
                .map(questionOutboxDataAccessMapper::questionOutboxEntityToQuestionOutboxMessage)
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<QuestionOutboxMessage> findByTypeAndSagaIdAndCopyStateAndSagaStatus(
            String type,
            UUID sagaId,
            CopyState copyState,
            SagaStatus... sagaStatus) {
        return questionOutboxJpaRepository
                .findByTypeAndSagaIdAndCopyStateAndSagaStatusIn(type, sagaId, copyState, Arrays.asList(sagaStatus))
                .map(questionOutboxDataAccessMapper::questionOutboxEntityToQuestionOutboxMessage);    }

    @Override
    public void deleteByTypeAndOutboxStatusAndSagaStatus(
            String type,
            OutboxStatus outboxStatus,
            SagaStatus... sagaStatus) {
        questionOutboxJpaRepository.deleteByTypeAndOutboxStatusAndSagaStatusIn(type,
                outboxStatus,
                Arrays.asList(sagaStatus));
    }
}
