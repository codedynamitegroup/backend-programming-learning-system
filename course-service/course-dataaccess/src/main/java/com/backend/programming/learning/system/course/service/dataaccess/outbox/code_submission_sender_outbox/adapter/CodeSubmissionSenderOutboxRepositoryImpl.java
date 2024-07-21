package com.backend.programming.learning.system.course.service.dataaccess.outbox.code_submission_sender_outbox.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.outbox.code_submission_sender_outbox.entity.CodeSubmissionSenderOutboxEntity;
import com.backend.programming.learning.system.course.service.dataaccess.outbox.code_submission_sender_outbox.exception.CodeSubmissionSenderOutboxNotFoundException;
import com.backend.programming.learning.system.course.service.dataaccess.outbox.code_submission_sender_outbox.mapper.CodeSubmissionSenderOutboxDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.outbox.code_submission_sender_outbox.repository.CodeSubmissionSenderOutboxJpaRepository;
import com.backend.programming.learning.system.course.service.dataaccess.outbox.organization_outbox.exception.OrganizationOutboxNotFoundException;
import com.backend.programming.learning.system.course.service.domain.outbox.model.code_submission_sender.CodeSubmissionSenderOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.outbox.CodeSubmissionSenderOutboxRepository;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CodeSubmissionSenderOutboxRepositoryImpl implements CodeSubmissionSenderOutboxRepository {
    private final CodeSubmissionSenderOutboxJpaRepository jpaRepository;
    private final CodeSubmissionSenderOutboxDataAccessMapper dataAccessMapper;
    @Override
    public void save(CodeSubmissionSenderOutboxMessage message) {
        CodeSubmissionSenderOutboxEntity entity = dataAccessMapper.messageToEntity(message);
        jpaRepository.save(entity);
    }

    @Override
    public Optional<List<CodeSubmissionSenderOutboxMessage>> findByOutboxStatus(OutboxStatus outboxStatus) {

        return Optional.of(jpaRepository.findByOutboxStatus(outboxStatus)
                .orElseThrow(() -> new CodeSubmissionSenderOutboxNotFoundException("submission outbox object " +
                        "could not be found"))
                .stream()
                .map(dataAccessMapper::entityToMessage)
                .collect(Collectors.toList()));
    }

    @Override
    public void deleteByOutboxStatus(OutboxStatus outboxStatus) {
        jpaRepository.deleteByOutboxStatus(outboxStatus);
    }
}
