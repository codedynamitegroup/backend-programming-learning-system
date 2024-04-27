package com.backend.programming.learning.system.core.service.messaging.publisher.kafka.calendarevent;

import com.backend.programming.learning.system.core.service.domain.config.CoreServiceConfigData;
import com.backend.programming.learning.system.core.service.domain.event.calendarevent.CalendarEventCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.calendarevent.CalendarEventCreatedMessagePublisher;
import com.backend.programming.learning.system.core.service.messaging.mapper.CalendarEventMessagingDataMapper;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.CalendarEventUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiConsumer;

@Slf4j
@Component
public class CalendarEventUpdatedEventKafkaPublisher implements CalendarEventCreatedMessagePublisher {

    private final CalendarEventMessagingDataMapper calendarEventMessagingDataMapper;
    private final KafkaProducer<String, CalendarEventUpdateRequestAvroModel> kafkaProducer;
    private final CoreServiceConfigData coreServiceConfigData;
    private final CalendarEventKafkaMessageHelper kafkaMessageHelper;

    public CalendarEventUpdatedEventKafkaPublisher(CalendarEventMessagingDataMapper calendarEventMessagingDataMapper,
                                                   KafkaProducer<String, CalendarEventUpdateRequestAvroModel> kafkaProducer,
                                                   CoreServiceConfigData coreServiceConfigData,
                                                   CalendarEventKafkaMessageHelper kafkaMessageHelper) {
        this.calendarEventMessagingDataMapper = calendarEventMessagingDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.coreServiceConfigData = coreServiceConfigData;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void publish(CalendarEventCreatedEvent domainEvent) {
        UUID userId = domainEvent.getContestUser().getUser().getId().getValue();
        UUID contestId = domainEvent.getContestUser().getContest().getId().getValue();
        log.info("Received CalendarEventUpdatedEvent for user id: {} and contest id: {}", userId, contestId);
        String key = userId.toString().concat(contestId.toString());

        try {
            CalendarEventUpdateRequestAvroModel calendarEventUpdateRequestAvroModel = calendarEventMessagingDataMapper
                    .contestUserCreateEventPayloadToCalendarEventCreateRequestAvroModel(domainEvent);

            kafkaProducer.send(coreServiceConfigData.getCalendarEventUpdateRequestTopicName(),
                    key,
                    calendarEventUpdateRequestAvroModel,
                    kafkaMessageHelper.getKafkaCallback(
                            coreServiceConfigData.getCalendarEventUpdateResponseTopicName(),
                            calendarEventUpdateRequestAvroModel,
                            contestId.toString(),
                            userId.toString(),
                            "CalendarEventUpdateRequestAvroModel")
            );
            log.info("CalendarEventUpdateResponseAvroModel sent to Kafka for contest id: {} and user id: {}",
                    contestId, userId);
        } catch (Exception e) {
            log.error("Error while sending CalendarEventUpdateResponseAvroModel message" +
                    " to kafka with contest id: {} and user id: {}, error: {}",
                    contestId, userId, e.getMessage());
        }

    }
}
