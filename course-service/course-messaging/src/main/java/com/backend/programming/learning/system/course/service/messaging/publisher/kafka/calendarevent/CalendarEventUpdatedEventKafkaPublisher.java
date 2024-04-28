package com.backend.programming.learning.system.course.service.messaging.publisher.kafka.calendarevent;

import com.backend.programming.learning.system.course.service.domain.config.CourseServiceConfigData;
import com.backend.programming.learning.system.course.service.domain.event.calendarevent.CalendarEventUpdatedEvent;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.calendarevent.CalendarEventUpdatedMessagePublisher;
import com.backend.programming.learning.system.course.service.messaging.mapper.CalendarEventMessagingDataMapper;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.CalendarEventUpdateResponseAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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
    public void publish(CalendarEventUpdatedEvent domainEvent) {

        String calendarEventId = domainEvent.getCalendarEvent().getId().toString();
        String contestId = domainEvent.getCalendarEvent().getContestId().toString();
        String userId = domainEvent.getCalendarEvent().getUser().getId().toString();
        log.info("Received CalendarEventUpdatedEvent for calendar event id: {} and contest id: {} and user id: {}",
                calendarEventId, contestId, userId);
        String key = contestId.concat(userId);

        try {
            CalendarEventUpdateResponseAvroModel calendarEventUpdateResponseAvroModel = calendarEventMessagingDataMapper
                    .calendarEventUpdateEventToCalendarEventUpdateResponseAvroModel(domainEvent);

            kafkaProducer.send(courseServiceConfigData.getCalendarEventUpdateResponseTopicName(),
                    key,
                    calendarEventUpdateResponseAvroModel,
                    kafkaMessageHelper.getKafkaCallback(
                            courseServiceConfigData.getCalendarEventUpdateResponseTopicName(),
                            calendarEventUpdateResponseAvroModel,
                            calendarEventId,
                            "CalendarEventUpdateResponseAvroModel")
            );
            log.info("CalendarEventUpdateResponseAvroModel sent to Kafka for calendar event id: {} and contest id: {} and user id: {}",
                    calendarEventId, contestId, userId);
        } catch (Exception e) {
            log.error("Error while sending CalendarEventUpdateResponseAvroModel message" +
                            " to kafka with calendar event id: {} and contest id: {} and user id: {}, error: {}",
                    calendarEventId, contestId, userId, e.getMessage());
        }

    }
}
