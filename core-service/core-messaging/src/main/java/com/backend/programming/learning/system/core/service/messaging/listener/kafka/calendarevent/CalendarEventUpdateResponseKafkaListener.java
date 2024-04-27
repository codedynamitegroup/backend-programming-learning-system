package com.backend.programming.learning.system.core.service.messaging.listener.kafka.calendarevent;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.calendarevent.CalendarEventUpdateResponse;
import com.backend.programming.learning.system.core.service.domain.exception.ContestUserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.calendarevent.CalendarEventDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.calendarevent.CalendarEventUpdateResponseMessageListener;
import com.backend.programming.learning.system.core.service.messaging.mapper.CalendarEventMessagingDataMapper;
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
public class CalendarEventUpdateResponseKafkaListener implements KafkaConsumer<CalendarEventUpdateResponseAvroModel> {

    private final CalendarEventUpdateResponseMessageListener calendarEventUpdateResponseMessageListener;
    private final CalendarEventMessagingDataMapper calendarEventMessagingDataMapper;

    public CalendarEventUpdateResponseKafkaListener(
            CalendarEventUpdateResponseMessageListener calendarEventUpdateResponseMessageListener,
            CalendarEventMessagingDataMapper calendarEventMessagingDataMapper) {
        this.calendarEventUpdateResponseMessageListener = calendarEventUpdateResponseMessageListener;
        this.calendarEventMessagingDataMapper = calendarEventMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.core-service-calendar-event-consumer-group-id}",
                    topics = "${core-service.calendar-event-update-response-topic-name}")
    public void receive(@Payload List<CalendarEventUpdateResponseAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of calendar event update responses received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(calendarEventUpdateResponseAvroModel -> {
            try {
                CalendarEventUpdateResponse calendarEventUpdateResponse =
                        calendarEventMessagingDataMapper
                                .calendarEventUpdateResponseAvroModelToCalendarEventUpdateResponse
                                        (calendarEventUpdateResponseAvroModel);

                switch (calendarEventUpdateResponseAvroModel.getUpdateCalendarEventState()){
                    case CREATED, UPDATED, DELETED-> {
                        log.info("Processing successful calendar event update for calendar event id: {}",
                                calendarEventUpdateResponse.getCalendarEventId());
                        calendarEventUpdateResponseMessageListener
                                .calendarEventCreatedUpdatedOrDeletedSuccess(calendarEventUpdateResponse);
                    }
                    case CREATE_FAILED, UPDATE_FAILED, DELETE_FAILED -> {
                        log.info("Processing unsuccessful calendar event update for calendar event id: {}",
                                calendarEventUpdateResponse.getCalendarEventId());
                        calendarEventUpdateResponseMessageListener
                                .calendarEventCreatedUpdatedOrDeletedFail(calendarEventUpdateResponse);
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
