package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.calendarevent;

import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.calendarevent.CalendarEventUpdatedMessagePublisher;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CalendarEventUpdateOutboxScheduler implements OutboxScheduler {

    private final CalendarEventUpdateOutboxHelper calendarEventUpdateOutboxHelper;
    private final CalendarEventUpdatedMessagePublisher calendarEventUpdatedMessagePublisher;

    public CalendarEventUpdateOutboxScheduler(CalendarEventUpdateOutboxHelper calendarEventUpdateOutboxHelper,
                                              CalendarEventUpdatedMessagePublisher calendarEventUpdatedMessagePublisher) {
        this.calendarEventUpdateOutboxHelper = calendarEventUpdateOutboxHelper;
        this.calendarEventUpdatedMessagePublisher = calendarEventUpdatedMessagePublisher;
    }

    @Override
    @Transactional
    @Scheduled(fixedRateString = "${course-service.outbox-scheduler-fixed-rate}",
            initialDelayString = "${course-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {
        Optional<List<CalendarEventUpdateOutboxMessage>> outboxMessagesResponse =
                calendarEventUpdateOutboxHelper.getCalendarEventUpdateOutboxMessageByOutboxStatus(OutboxStatus.STARTED);
        if (outboxMessagesResponse.isPresent() && !outboxMessagesResponse.get().isEmpty()) {
            List<CalendarEventUpdateOutboxMessage> outboxMessages = outboxMessagesResponse.get();
            log.info("Received {} CalendarEventUpdateOutboxMessage with ids {}, sending to message bus!",
                    outboxMessages.size(),
                    outboxMessages.stream().map(outboxMessage ->
                            outboxMessage.getId().toString()).collect(Collectors.joining(",")));
            outboxMessages.forEach(calendarEventUpdateOutboxMessage ->
                    calendarEventUpdatedMessagePublisher.publish(
                            calendarEventUpdateOutboxMessage, this::updateOutboxStatus));
            log.info("{} CalendarEventUpdateOutboxMessage sent to message bus!", outboxMessages.size());
        }
    }

    private void updateOutboxStatus(CalendarEventUpdateOutboxMessage calendarEventUpdateOutboxMessage,
                                    OutboxStatus outboxStatus) {
        calendarEventUpdateOutboxMessage.setOutboxStatus(outboxStatus);
        calendarEventUpdateOutboxHelper.save(calendarEventUpdateOutboxMessage);
        log.info("CalendarEventUpdateOutboxMessage is updated with outbox status: {}", outboxStatus.name());
    }

}
