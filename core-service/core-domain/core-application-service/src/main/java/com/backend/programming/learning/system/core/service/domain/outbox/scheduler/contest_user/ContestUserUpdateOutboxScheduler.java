package com.backend.programming.learning.system.core.service.domain.outbox.scheduler.contest_user;

import com.backend.programming.learning.system.core.service.domain.outbox.model.contest_user.ContestUserUpdateOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.contest_user.ContestUserUpdateMessagePublisher;
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
public class ContestUserUpdateOutboxScheduler implements OutboxScheduler {

    private final ContestUserUpdateOutboxHelper contestUserUpdateOutboxHelper;
    private final ContestUserUpdateMessagePublisher contestUserUpdateMessagePublisher;

    public ContestUserUpdateOutboxScheduler(ContestUserUpdateOutboxHelper contestUserUpdateOutboxHelper,
                                            ContestUserUpdateMessagePublisher contestUserUpdateMessagePublisher) {
        this.contestUserUpdateOutboxHelper = contestUserUpdateOutboxHelper;
        this.contestUserUpdateMessagePublisher = contestUserUpdateMessagePublisher;
    }

    @Override
    @Transactional
    @Scheduled(fixedRateString = "${core-service.outbox-scheduler-fixed-rate}",
            initialDelayString = "${core-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {

        Optional<List<ContestUserUpdateOutboxMessage>> outboxMessagesResponse =
                contestUserUpdateOutboxHelper.getContestUserUpdateOutboxMessageByOutboxStatusAndSagaStatus(
                        OutboxStatus.STARTED,
                        SagaStatus.STARTED);

        if (outboxMessagesResponse.isPresent() && !outboxMessagesResponse.get().isEmpty()) {
            List<ContestUserUpdateOutboxMessage> outboxMessages = outboxMessagesResponse.get();
            log.info("Received {} ContestUserUpdateOutboxMessage with ids: {}, sending to message bus!",
                    outboxMessages.size(),
                    outboxMessages.stream().map(outboxMessage ->
                            outboxMessage.getId().toString()).collect(Collectors.joining(",")));
            outboxMessages.forEach(outboxMessage ->
                    contestUserUpdateMessagePublisher.publish(outboxMessage, this::updateOutboxStatus));
            log.info("{} ContestUserUpdateOutboxMessage sent to message bus!", outboxMessages.size());
        }
    }

    private void updateOutboxStatus(ContestUserUpdateOutboxMessage contestUserUpdateOutboxMessage,
                                    OutboxStatus outboxStatus) {
        contestUserUpdateOutboxMessage.setOutboxStatus(outboxStatus);
        contestUserUpdateOutboxHelper.save(contestUserUpdateOutboxMessage);
        log.info("ContestUserUpdateOutboxMessage is updated with outbox status: {}", outboxStatus.name());
    }

}
