package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_questions_update_outbox.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_questions_update_outbox.entity.CodeQuestionsUpdateOutboxEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_questions_update_outbox.exception.CodeQuestionsUpdateOutboxNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_questions_update_outbox.mapper.CodeQuestionsUpdateOutboxMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_questions_update_outbox.repository.CodeQuestionsUpdateOutboxJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_question.CodeQuestionsUpdateOutboxRepository;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CodeQuestionsUpdateOutboxRepositoryImpl implements CodeQuestionsUpdateOutboxRepository {

    private final CodeQuestionsUpdateOutboxJpaRepository codeQuestionsUpdateOutboxJpaRepository;
    private final CodeQuestionsUpdateOutboxMapper codeQuestionsUpdateOutboxMapper;

    public CodeQuestionsUpdateOutboxRepositoryImpl
            (CodeQuestionsUpdateOutboxJpaRepository codeQuestionsUpdateOutboxJpaRepository,
             CodeQuestionsUpdateOutboxMapper codeQuestionsUpdateOutboxMapper) {
        this.codeQuestionsUpdateOutboxJpaRepository = codeQuestionsUpdateOutboxJpaRepository;
        this.codeQuestionsUpdateOutboxMapper = codeQuestionsUpdateOutboxMapper;
    }

    @Override
    public CodeQuestionsUpdateOutboxMessage save(CodeQuestionsUpdateOutboxMessage outboxMessage) {
        CodeQuestionsUpdateOutboxEntity entity
                = codeQuestionsUpdateOutboxJpaRepository.save(
                        codeQuestionsUpdateOutboxMapper
                                .codeQuestionsUpdateOutboxMessageToOutboxEntity(outboxMessage));
        return codeQuestionsUpdateOutboxMapper.outboxMessageEntityToCodeQuestionsUpdateOutboxMessage(entity);
    }

    @Override
    public Optional<List<CodeQuestionsUpdateOutboxMessage>> findByTypeAndOutboxStatusAndSagaStatus(String sagaType, OutboxStatus outboxStatus, SagaStatus... sagaStatus) {
        return Optional.of(codeQuestionsUpdateOutboxJpaRepository.findByTypeAndOutboxStatusAndSagaStatusIn(sagaType,
                        outboxStatus,
                        Arrays.asList(sagaStatus))
                .orElseThrow(() -> new CodeQuestionsUpdateOutboxNotFoundException("CodeQuestionsUpdate outbox object " +
                        "could not be found for saga type " + sagaType))
                .stream()
                .map(codeQuestionsUpdateOutboxMapper::outboxMessageEntityToCodeQuestionsUpdateOutboxMessage)
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<CodeQuestionsUpdateOutboxMessage> findByTypeAndSagaIdAndSagaStatus(String type, UUID sagaId, SagaStatus... sagaStatus) {
        return codeQuestionsUpdateOutboxJpaRepository
                .findByTypeAndSagaIdAndSagaStatusIn(type, sagaId, Arrays.asList(sagaStatus))
                .map(codeQuestionsUpdateOutboxMapper::outboxMessageEntityToCodeQuestionsUpdateOutboxMessage);
    }

    @Override
    public void deleteByTypeAndOutboxStatusAndSagaStatus(String type, OutboxStatus outboxStatus, SagaStatus... sagaStatus) {
        codeQuestionsUpdateOutboxJpaRepository.deleteByTypeAndOutboxStatusAndSagaStatusIn(type, outboxStatus,
                Arrays.asList(sagaStatus));
    }
}
