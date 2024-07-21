package com.backend.programming.learning.system.code.assessment.service.domain.implement.message.listener.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.code_submission.CodeSubmissionReceiver;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.ValidateHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_submission.CodeSubmissionCommandHandler;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_submission.CodeSubmissionDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion.CodeSubmissionSenderOutboxRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class CodeSubmissionReceiverMessageHelper {
    private final CodeSubmissionCommandHandler codeSubmissionCommandHandler;
    private final CodeSubmissionDataMapper codeSubmissionDataMapper;
    private final CodeSubmissionSenderOutboxRepository codeSubmissionSenderOutboxRepository;
    private final ValidateHelper validateHelper;

    @Transactional
    public void createCodeSubmission(CodeSubmissionReceiver receiver) {
        Optional<UUID> outboxId = codeSubmissionSenderOutboxRepository.findBySagaId(receiver.getSagaId());
        if(outboxId.isPresent()){
            log.info("receiver with sagaId {} was already processed", receiver.getSagaId());
            return;
        }
        codeSubmissionSenderOutboxRepository.save(UUID.randomUUID(), receiver.getSagaId());
        try {
            User user = validateHelper.validateUser(receiver.getUserId());
            CreateCodeSubmissionCommand command = codeSubmissionDataMapper.codeSubmissionReceiverToCreateCodeSubmissionCommand(receiver, user);
            codeSubmissionCommandHandler.createCodeSubmission(command);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
