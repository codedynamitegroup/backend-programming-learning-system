package com.backend.programming.learning.system.core.service.messaging.listener.kafka.contest_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.contest_user.ContestUserCalendarEventUpdatedResponse;
import com.backend.programming.learning.system.core.service.domain.exception.ContestUserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.contest_user.ContestUserCalendarEventUpdateResponseMessageListener;
import com.backend.programming.learning.system.core.service.messaging.mapper.ContestUserEventMessagingDataMapper;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.CalendarEventUpdateResponseAvroModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ContestUserCalendarEventUpdatedResponseKafkaListener implements KafkaConsumer<CalendarEventUpdateResponseAvroModel> {

    private final ContestUserCalendarEventUpdateResponseMessageListener contestUserCalendarEventUpdateResponseMessageListener;
    private final ContestUserEventMessagingDataMapper contestUserEventMessagingDataMapper;

    public ContestUserCalendarEventUpdatedResponseKafkaListener(
            ContestUserCalendarEventUpdateResponseMessageListener contestUserCalendarEventUpdateResponseMessageListener,
            ContestUserEventMessagingDataMapper contestUserEventMessagingDataMapper) {
        this.contestUserCalendarEventUpdateResponseMessageListener = contestUserCalendarEventUpdateResponseMessageListener;
        this.contestUserEventMessagingDataMapper = contestUserEventMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.core-service-calendar-event-consumer-group-id}",
                    topics = "${core-service.calendar-event-update-response-topic-name}")
    public void receive(@Payload List<CalendarEventUpdateResponseAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of calendar event update responses received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(calendarEventUpdateResponseAvroModel -> {
            try {
                log.info("Processing calendar event update response for calendar event id: {}",
                        calendarEventUpdateResponseAvroModel.getCalendarEventId());
                ContestUserCalendarEventUpdatedResponse contestUserCalendarEventUpdatedResponse =
                        contestUserEventMessagingDataMapper
                                .calendarEventUpdateResponseAvroModelToCalendarEventUpdateResponse
                                        (calendarEventUpdateResponseAvroModel);

                switch (calendarEventUpdateResponseAvroModel.getUpdateCalendarEventState()){
                    case CREATED, UPDATED, DELETED-> {
                        log.info("Processing successful calendar event update for calendar event id: {}",
                                contestUserCalendarEventUpdatedResponse.getCalendarEventId());
                        contestUserCalendarEventUpdateResponseMessageListener
                                .calendarEventCreatedUpdatedOrDeletedSuccess(contestUserCalendarEventUpdatedResponse);
                    }
                    case CREATE_FAILED, UPDATE_FAILED, DELETE_FAILED -> {
                        log.info("Processing unsuccessful calendar event update for calendar event id: {}",
                                contestUserCalendarEventUpdatedResponse.getCalendarEventId());
                        contestUserCalendarEventUpdateResponseMessageListener
                                .calendarEventCreatedUpdatedOrDeletedFail(contestUserCalendarEventUpdatedResponse);
                    }
                }
            } catch (OptimisticLockingFailureException e) {
                //NO-OP for optimistic lock. This means another thread finished the work, do not throw error to prevent reading the data from kafka again!
                log.error("Caught optimistic locking exception in CalendarEventUpdateResponseKafkaListener for calendar event id: {}",
                        calendarEventUpdateResponseAvroModel.getCalendarEventId());
            } catch (ContestUserNotFoundException e){
                log.error("No contest_user founded for contest id: {} and user id: {}",
                        calendarEventUpdateResponseAvroModel.getContestId(),
                        calendarEventUpdateResponseAvroModel.getUserId());
            }
        });

    }
}
