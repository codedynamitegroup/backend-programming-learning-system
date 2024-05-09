package com.backend.programming.learning.system.course.service.messaging.listener.kafka.calendarevent;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.calendarevent.CalendarEventUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.calendarevent.CalendarEventUpdateRequestMessageListener;
import com.backend.programming.learning.system.course.service.messaging.mapper.CalendarEventMessagingDataMapper;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.*;
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
public class CalendarEventUpdateRequestKafkaListener implements KafkaConsumer<CalendarEventUpdateRequestAvroModel> {

    private final CalendarEventUpdateRequestMessageListener calendarEventUpdateRequestMessageListener;
    private final CalendarEventMessagingDataMapper calendarEventMessagingDataMapper;

    public CalendarEventUpdateRequestKafkaListener(
            CalendarEventUpdateRequestMessageListener calendarEventUpdateRequestMessageListener,
            CalendarEventMessagingDataMapper calendarEventMessagingDataMapper) {
        this.calendarEventUpdateRequestMessageListener = calendarEventUpdateRequestMessageListener;
        this.calendarEventMessagingDataMapper = calendarEventMessagingDataMapper;
    }

    @Override
    @KafkaListener(id="${kafka-consumer-config.course-service-calendar-event-consumer-group-id}",
            topics = "${course-service.calendar-event-update-request-topic-name}")
    public void receive(
            @Payload List<CalendarEventUpdateRequestAvroModel> messages,
            @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
            @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
            @Header(KafkaHeaders.OFFSET) List<Long> offsets) {

        log.info("{} number of calendar event update request received with keys: {}, partitions: {} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(calendarEventUpdateRequestAvroModel -> {
            try {
                CalendarEventUpdateRequest calendarEventUpdateRequest =
                        calendarEventMessagingDataMapper
                                .calendarEventUpdateRequestAvroModelToCalendarEventUpdateRequest
                                        (calendarEventUpdateRequestAvroModel);

                switch (calendarEventUpdateRequestAvroModel.getUpdateCalendarEventState()){
                    case CREATING, UPDATING, DELETING-> {
                        log.info("Processing successful calendar event update for contest id {} and user id {}",
                                calendarEventUpdateRequest.getContestId(), calendarEventUpdateRequest.getUserId());
                        calendarEventUpdateRequestMessageListener
                                .updateCalendarEvent(calendarEventUpdateRequest);
                    }
                }
            } catch (OptimisticLockingFailureException e) {
                //NO-OP for optimistic lock. This means another thread finished the work, do not throw error to prevent reading the data from kafka again!
                log.error("Caught optimistic locking exception in CalendarEventUpdateRequestAvroModel for contest id {} and user id {}",
                        calendarEventUpdateRequestAvroModel.getContestId(),
                        calendarEventUpdateRequestAvroModel.getUserId());
            } catch (Exception e){
                log.error("Error while processing calendar event update request for contest id {} and user id {}",
                        calendarEventUpdateRequestAvroModel.getContestId(),
                        calendarEventUpdateRequestAvroModel.getUserId(),
                        e);
            }
        });
    }
}
