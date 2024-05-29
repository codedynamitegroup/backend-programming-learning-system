package com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_submission_update_outbox.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_questions_update_outbox.entity.CodeQuestionsUpdateOutboxEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_submission_update_outbox.entity.CodeSubmissionUpdateOutboxEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_submission_update_outbox.exception.CodeSubmissionUpdateOutboxNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_submission_update_outbox.mapper.CodeSubmissionUpdateOutboxMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_submission_update_outbox.repository.CodeSubmissionUpdateOutboxJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_submission_update_outbox.CodeSubmissionUpdateOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion.CodeSubmissionUpdateOutboxRepository;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Slf4j
public class CodeSubmissionUpdateOutboxRepositoryImpl implements CodeSubmissionUpdateOutboxRepository {
    final CodeSubmissionUpdateOutboxJpaRepository jpaRepository;
    final CodeSubmissionUpdateOutboxMapper mapper;

    public CodeSubmissionUpdateOutboxRepositoryImpl(CodeSubmissionUpdateOutboxJpaRepository jpaRepository, CodeSubmissionUpdateOutboxMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<CodeSubmissionUpdateOutboxMessage>> findByTypeAndOutboxStatusAndSagaStatus(String sagaType, OutboxStatus outboxStatus, SagaStatus ...sagaStatus) {
        return Optional.of(jpaRepository.findByTypeAndOutboxStatusAndSagaStatusIn(sagaType,
                        outboxStatus,
                        Arrays.asList(sagaStatus))
                .orElseThrow(() -> new CodeSubmissionUpdateOutboxNotFoundException("CodeSubmissionUpdateOutboxMessage object " +
                        "could not be found for saga type " + sagaType))
                .stream()
                .map(mapper::outboxMessageEntityToCodeSubmissionUpdateOutboxMessage)
                .collect(Collectors.toList()));
    }

    @Override
    public CodeSubmissionUpdateOutboxMessage save(CodeSubmissionUpdateOutboxMessage outboxMessage) {
        CodeSubmissionUpdateOutboxEntity entity
                = jpaRepository.save(
                mapper.codeSubmisisonUpdateOutboxMessageToOutboxEntity(outboxMessage));
        return mapper.outboxMessageEntityToCodeSubmissionUpdateOutboxMessage(entity);
    }

    @Override
    public void deleteByTypeAndOutboxStatusAndSagaStatus(String type, OutboxStatus outboxStatus, SagaStatus ...sagaStatus) {
        jpaRepository.deleteByTypeAndOutboxStatusAndSagaStatusIn(type, outboxStatus,
                Arrays.asList(sagaStatus));
    }
}
