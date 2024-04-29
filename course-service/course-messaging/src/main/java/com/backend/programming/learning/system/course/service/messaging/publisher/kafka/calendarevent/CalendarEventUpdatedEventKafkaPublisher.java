package com.backend.programming.learning.system.course.service.messaging.publisher.kafka.calendarevent;

import com.backend.programming.learning.system.course.service.domain.config.CourseServiceConfigData;
import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateEventPayload;
import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.calendarevent.CalendarEventUpdatedMessagePublisher;
import com.backend.programming.learning.system.course.service.messaging.mapper.CalendarEventMessagingDataMapper;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.CalendarEventUpdateResponseAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
public class CalendarEventUpdatedEventKafkaPublisher implements CalendarEventUpdatedMessagePublisher {

    private final CalendarEventMessagingDataMapper calendarEventMessagingDataMapper;
    private final KafkaProducer<String, CalendarEventUpdateResponseAvroModel> kafkaProducer;
    private final CourseServiceConfigData courseServiceConfigData;
    private final KafkaMessageHelper kafkaMessageHelper;

    public CalendarEventUpdatedEventKafkaPublisher(CalendarEventMessagingDataMapper calendarEventMessagingDataMapper,
                                                   KafkaProducer<String, CalendarEventUpdateResponseAvroModel> kafkaProducer,
                                                   CourseServiceConfigData courseServiceConfigData,
                                                   KafkaMessageHelper kafkaMessageHelper) {
        this.calendarEventMessagingDataMapper = calendarEventMessagingDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.courseServiceConfigData = courseServiceConfigData;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void publish(CalendarEventUpdateOutboxMessage calendarEventUpdateOutboxMessage,
                        BiConsumer<CalendarEventUpdateOutboxMessage, OutboxStatus> outboxCallback) {
        CalendarEventUpdateEventPayload calendarEventUpdateEventPayload =
                kafkaMessageHelper.getObjectEventPayload(
                        calendarEventUpdateOutboxMessage.getPayload(),
                        CalendarEventUpdateEventPayload.class);

        String sagaId = calendarEventUpdateOutboxMessage.getSagaId().toString();

        log.info("Received CalendarEventUpdateOutboxMessage for calendar event id: {} and saga id: {}",
                calendarEventUpdateEventPayload.getCalendarEvent().getId().getValue().toString(),
                sagaId);

        try {
            CalendarEventUpdateResponseAvroModel calendarEventUpdateResponseAvroModel =
                    calendarEventMessagingDataMapper
                            .calendarEventUpdateEventPayloadToCalendarEventUpdateResponseAvroModel(
                                    sagaId, calendarEventUpdateEventPayload);

            kafkaProducer.send(courseServiceConfigData.getCalendarEventUpdateResponseTopicName(),
                    sagaId,
                    calendarEventUpdateResponseAvroModel,
                    kafkaMessageHelper.getKafkaCallbackApplyOutbox(
                            courseServiceConfigData.getCalendarEventUpdateResponseTopicName(),
                            calendarEventUpdateResponseAvroModel,
                            calendarEventUpdateOutboxMessage,
                            outboxCallback,
                            calendarEventUpdateEventPayload.getCalendarEvent().getId().getValue().toString(),
                            "CalendarEventUpdateResponseAvroModel"));

            log.info("CalendarEventUpdateEventPayload sent to Kafka for calendar event id: {} and saga id: {}",
                    calendarEventUpdateEventPayload.getCalendarEvent().getId().getValue().toString(), sagaId);
        } catch (Exception e) {
            log.error("Error while sending CalendarEventUpdateEventPayload" +
                            " to kafka with calendar event id: {} and saga id: {}, error: {}",
                    calendarEventUpdateEventPayload.getCalendarEvent().getId().getValue().toString(),
                    sagaId, e.getMessage());
        }
    }
}
