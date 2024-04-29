package com.backend.programming.learning.system.core.service.domain.outbox.scheduler.contest_user;

import com.backend.programming.learning.system.core.service.domain.outbox.model.contest_user.ContestUserUpdateOutboxMessage;
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
public class ContestUserUpdateOutboxCleanerScheduler implements OutboxScheduler {

    private final ContestUserUpdateOutboxHelper contestUserUpdateOutboxHelper;

    public ContestUserUpdateOutboxCleanerScheduler(ContestUserUpdateOutboxHelper contestUserUpdateOutboxHelper) {
        this.contestUserUpdateOutboxHelper = contestUserUpdateOutboxHelper;
    }

    @Override
    @Transactional
    @Scheduled(cron = "@midnight")
    public void processOutboxMessage() {
        Optional<List<ContestUserUpdateOutboxMessage>> outboxMessagesResponse =
                contestUserUpdateOutboxHelper.getContestUserUpdateOutboxMessageByOutboxStatusAndSagaStatus(
                        OutboxStatus.COMPLETED,
                        SagaStatus.SUCCEEDED,
                        SagaStatus.FAILED,
                        SagaStatus.COMPENSATED);

        if (outboxMessagesResponse.isPresent()) {
            List<ContestUserUpdateOutboxMessage> outboxMessages = outboxMessagesResponse.get();
            log.info("Received {} ContestUserUpdateOutboxMessage for clean-up. The payloads: {}",
                    outboxMessages.size(),
                    outboxMessages.stream().map(ContestUserUpdateOutboxMessage::getPayload)
                            .collect(Collectors.joining("\n")));
            contestUserUpdateOutboxHelper.deleteContestUserUpdateOutboxMessageByOutboxStatusAndSagaStatus(
                    OutboxStatus.COMPLETED,
                    SagaStatus.SUCCEEDED,
                    SagaStatus.FAILED,
                    SagaStatus.COMPENSATED);
            log.info("{} ContestUserUpdateOutboxMessage deleted!", outboxMessages.size());
        }
    }
}
