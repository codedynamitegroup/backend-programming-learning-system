package com.backend.programming.learning.system.core.service.dataaccess.code_questions_update_outbox.addapter;

import com.backend.programming.learning.system.core.service.dataaccess.code_questions_update_outbox.exception.CodeQuestionsUpdateOutboxNotFoundException;
import com.backend.programming.learning.system.core.service.dataaccess.code_questions_update_outbox.mapper.CodeQuestionsUpdateOutboxDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.code_questions_update_outbox.repository.CodeQuestionsUpdateOutboxJpaRepository;
import com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CodeQuestionsUpdateOutboxRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CodeQuestionsUpdateOutboxRepositoryImpl implements CodeQuestionsUpdateOutboxRepository {

    private final CodeQuestionsUpdateOutboxJpaRepository jpaRepository;
    private final CodeQuestionsUpdateOutboxDataAccessMapper dataMapper;

    public CodeQuestionsUpdateOutboxRepositoryImpl(CodeQuestionsUpdateOutboxJpaRepository jpaRepository, CodeQuestionsUpdateOutboxDataAccessMapper dataMapper) {
        this.jpaRepository = jpaRepository;
        this.dataMapper = dataMapper;
    }

    @Override
    public Optional<CodeQuestionsUpdateOutboxMessage> findByTypeAndSagaIdAndCopyStateAndOutboxStatus(String type, UUID sagaId, CopyState copyState, OutboxStatus outboxStatus) {
        return jpaRepository.findByTypeAndSagaIdAndCopyStateAndOutboxStatus(type, sagaId,
                        copyState, outboxStatus)
                .map(dataMapper::outboxEntityToOutboxMessage);
    }

    @Override
    public CodeQuestionsUpdateOutboxMessage save(CodeQuestionsUpdateOutboxMessage outboxMessage) {
        return dataMapper
                .outboxEntityToOutboxMessage(jpaRepository
                        .save(dataMapper.outboxMessageToOutboxEntity(outboxMessage)));
    }

    @Override
    public Optional<List<CodeQuestionsUpdateOutboxMessage>> findByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus) {
        return Optional.of(jpaRepository.findByTypeAndOutboxStatus(type, outboxStatus)
                .orElseThrow(() -> new CodeQuestionsUpdateOutboxNotFoundException(" CodeQuestionsUpdate outbox object " +
                        "cannot be found for saga type " + type))
                .stream()
                .map(dataMapper::outboxEntityToOutboxMessage)
                .collect(Collectors.toList()));
    }

    @Override
    public void deleteByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus) {
        jpaRepository.deleteByTypeAndOutboxStatus(type, outboxStatus);
    }
}
