package com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_submission_sender_outbox.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_submission_sender_outbox.entity.CodeSubmissionSenderOutboxEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_submission_sender_outbox.exception.CodeSubmissionSenderOutboxNotFound;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_submission_sender_outbox.mapper.CodeSubmissionSenderOutboxMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_submission_sender_outbox.repository.CodeSubmissionSenderOutboxJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion.CodeSubmissionSenderOutboxRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class CodeSubmissionSenderOutboxRepositoryImpl implements CodeSubmissionSenderOutboxRepository {
    private final CodeSubmissionSenderOutboxMapper codeSubmissionSenderOutboxMapper;
    private final CodeSubmissionSenderOutboxJpaRepository codeSubmissionSenderOutboxJpaRepository;

    @Override
    public void save(UUID id, UUID sagaId) {
        codeSubmissionSenderOutboxJpaRepository
                .save(CodeSubmissionSenderOutboxEntity.builder()
                        .id(id)
                        .sagaId(sagaId)
                        .build());
    }

    @Override
    public Optional<UUID> findBySagaId(UUID sagaId) {
        Optional<CodeSubmissionSenderOutboxEntity> entity = codeSubmissionSenderOutboxJpaRepository
                .findBySagaId(sagaId);
        return entity.map(CodeSubmissionSenderOutboxEntity::getId);
    }
}
