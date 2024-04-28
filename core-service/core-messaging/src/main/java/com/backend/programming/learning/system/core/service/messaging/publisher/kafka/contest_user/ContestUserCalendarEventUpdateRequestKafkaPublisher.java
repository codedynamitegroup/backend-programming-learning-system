package com.backend.programming.learning.system.core.service.messaging.publisher.kafka.contest_user;

import com.backend.programming.learning.system.core.service.domain.config.CoreServiceConfigData;
import com.backend.programming.learning.system.core.service.domain.event.contest_user.ContestUserUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.contest_user.ContestUserUpdatedMessagePublisher;
import com.backend.programming.learning.system.core.service.messaging.mapper.ContestUserEventMessagingDataMapper;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.CalendarEventUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class ContestUserCalendarEventUpdateRequestKafkaPublisher implements ContestUserUpdatedMessagePublisher {

    private final ContestUserEventMessagingDataMapper contestUserEventMessagingDataMapper;
    private final KafkaProducer<String, CalendarEventUpdateRequestAvroModel> kafkaProducer;
    private final CoreServiceConfigData coreServiceConfigData;
    private final KafkaMessageHelper kafkaMessageHelper;

    public ContestUserCalendarEventUpdateRequestKafkaPublisher(ContestUserEventMessagingDataMapper contestUserEventMessagingDataMapper,
                                                               KafkaProducer<String, CalendarEventUpdateRequestAvroModel> kafkaProducer,
                                                               CoreServiceConfigData coreServiceConfigData,
                                                               KafkaMessageHelper kafkaMessageHelper) {
        this.contestUserEventMessagingDataMapper = contestUserEventMessagingDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.coreServiceConfigData = coreServiceConfigData;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void publish(ContestUserUpdatedEvent domainEvent) {
        UUID userId = domainEvent.getContestUser().getUser().getId().getValue();
        UUID contestId = domainEvent.getContestUser().getContest().getId().getValue();
        log.info("Received ContestUserUpdatedEvent for user id: {} and contest id: {}", userId, contestId);
        String key = userId.toString().concat("_").concat(contestId.toString()); // 'userId_contestId

        try {
            CalendarEventUpdateRequestAvroModel calendarEventUpdateRequestAvroModel = contestUserEventMessagingDataMapper
                    .contestUserUpdatedEventPayloadToCalendarEventUpdateRequestAvroModel(domainEvent);

            kafkaProducer.send(coreServiceConfigData.getCalendarEventUpdateRequestTopicName(),
                    key,
                    calendarEventUpdateRequestAvroModel,
                    kafkaMessageHelper.getKafkaCallback(
                            coreServiceConfigData.getCalendarEventUpdateRequestTopicName(),
                            calendarEventUpdateRequestAvroModel,
                            key,
                            "CalendarEventUpdateRequestAvroModel")
            );
            log.info("CalendarEventUpdateRequestAvroModel sent to Kafka for contest id: {} and user id: {}",
                    contestId, userId);
        } catch (Exception e) {
            log.error("Error while sending CalendarEventUpdateRequestAvroModel message" +
                    " to kafka with contest id: {} and user id: {}, error: {}",
                    contestId, userId, e.getMessage());
        }

    }
}
