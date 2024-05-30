package com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.code_submission_update_outbox;

import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_submission_update_outbox.CodeSubmissionUpdateOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.message.publisher.code_submission.CodeSubmissionUpdateMessagePublisher;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CodeSubmissionUpdateOutboxScheduler implements OutboxScheduler {
    final CodeSubmissionUpdateOutboxHelper codeSubmissionUpdateOutboxHelper;
    final CodeSubmissionUpdateMessagePublisher publisher;

    public CodeSubmissionUpdateOutboxScheduler(CodeSubmissionUpdateOutboxHelper codeSubmissionUpdateOutboxHelper, CodeSubmissionUpdateMessagePublisher publisher) {
        this.codeSubmissionUpdateOutboxHelper = codeSubmissionUpdateOutboxHelper;
        this.publisher = publisher;
    }

    @Override
    @Transactional
//    @Scheduled(fixedDelayString = "${code-assessment-service.outbox-scheduler-fixed-rate}",
//            initialDelayString = "${code-assessment-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {
        Optional<List<CodeSubmissionUpdateOutboxMessage>> outboxMessagesResponse =
                codeSubmissionUpdateOutboxHelper
                        .getCodeSubmissionUpdateOutboxMessageByOutboxStatusAndSagaStatus(
                                OutboxStatus.STARTED,
                                SagaStatus.STARTED,
                                SagaStatus.COMPENSATING
                        );
        if (outboxMessagesResponse.isPresent() && !outboxMessagesResponse.get().isEmpty()) {
            List<CodeSubmissionUpdateOutboxMessage> outboxMessages = outboxMessagesResponse.get();
            log.info("Received {} CodeSubmissionUpdateOutboxMessage with ids: {}, sending to message bus!",
                    outboxMessages.size(),
                    outboxMessages.stream().map(outboxMessage ->
                            outboxMessage.getId().toString()).collect(Collectors.joining(",")));
            outboxMessages.forEach(outboxMessage ->
                    publisher.publish(outboxMessage, this::updateOutboxStatus));
            log.info("{} CodeSubmissionUpdateOutboxMessage sent to message bus!", outboxMessages.size());
        }
    }

    private void updateOutboxStatus(CodeSubmissionUpdateOutboxMessage outboxMessage, OutboxStatus outboxStatus) {
        outboxMessage.setOutboxStatus(outboxStatus);
        if(outboxStatus == OutboxStatus.COMPLETED){
            outboxMessage.setSagaStatus(SagaStatus.SUCCEEDED);
            if(outboxMessage.getCopyState() == CopyState.CREATING)
                outboxMessage.setCopyState(CopyState.CREATED);
            if(outboxMessage.getCopyState() == CopyState.UPDATING)
                outboxMessage.setCopyState(CopyState.UPDATED);
        }
        if(outboxStatus == OutboxStatus.FAILED){
            outboxMessage.setSagaStatus(SagaStatus.FAILED);
            if(outboxMessage.getCopyState() == CopyState.CREATING)
                outboxMessage.setCopyState(CopyState.CREATE_FAILED);
            if(outboxMessage.getCopyState() == CopyState.UPDATING)
                outboxMessage.setCopyState(CopyState.UPDATE_FAILED);
        }
        codeSubmissionUpdateOutboxHelper.save(outboxMessage);
        log.info("CodeSubmissionUpdateOutboxMessage is updated with outbox status: {}", outboxStatus.name());
    }

}
