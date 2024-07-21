package com.backend.programming.learning.system.course.service.dataaccess.outbox.code_submission_result_outbox.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.outbox.code_submission_result_outbox.entity.CodeSubmissionResultOutboxEntity;
import com.backend.programming.learning.system.course.service.dataaccess.outbox.code_submission_result_outbox.repository.CodeSubmissionResultOutboxJpaRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.outbox.CodeSubmissionResultOutboxRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class CodeSubmissionResultOutboxRepositoryImpl implements CodeSubmissionResultOutboxRepository {
    private final CodeSubmissionResultOutboxJpaRepository jpaRepository;

    @Override
    public void save(UUID id, UUID sagaId) {
        jpaRepository.save(CodeSubmissionResultOutboxEntity.builder()
                        .id(id)
                        .sagaId(sagaId)
                .build());
    }

    @Override
    public Optional<UUID> findBySagaId(UUID sagaId) {
        return jpaRepository.findBySagaId(sagaId).map(CodeSubmissionResultOutboxEntity::getId);
    }

}
