package com.backend.programming.learning.system.core.service.messaging.publisher.kafka.contest_user;

import com.backend.programming.learning.system.core.service.domain.config.CoreServiceConfigData;
import com.backend.programming.learning.system.core.service.domain.outbox.model.contest_user.ContestUserUpdateEventPayload;
import com.backend.programming.learning.system.core.service.domain.outbox.model.contest_user.ContestUserUpdateOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.contest_user.ContestUserUpdateMessagePublisher;
import com.backend.programming.learning.system.core.service.messaging.mapper.ContestUserEventMessagingDataMapper;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.CalendarEventUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
public class ContestUserCalendarEventUpdateRequestKafkaPublisher implements ContestUserUpdateMessagePublisher {

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
    public void publish(
            ContestUserUpdateOutboxMessage contestUserUpdateOutboxMessage,
            BiConsumer<ContestUserUpdateOutboxMessage, OutboxStatus> outboxCallback) {
        ContestUserUpdateEventPayload contestUserUpdateEventPayload =
                kafkaMessageHelper.getObjectEventPayload(contestUserUpdateOutboxMessage.getPayload(),
                        ContestUserUpdateEventPayload.class);

        String sagaId = contestUserUpdateOutboxMessage.getSagaId().toString();

        log.info("Received ContestUserUpdateOutboxMessage for contest_user_id: {} and saga id: {}",
                contestUserUpdateEventPayload.getContestUserId(),
                sagaId);

        try {
            CalendarEventUpdateRequestAvroModel calendarEventUpdateRequestAvroModel =
                    contestUserEventMessagingDataMapper
                            .contestUserUpdatedEventPayloadToCalendarEventUpdateRequestAvroModel(
                                    sagaId, contestUserUpdateEventPayload);

            kafkaProducer.send(coreServiceConfigData.getCalendarEventUpdateRequestTopicName(),
                    sagaId,
                    calendarEventUpdateRequestAvroModel,
                    kafkaMessageHelper.getKafkaCallbackApplyOutbox(
                            coreServiceConfigData.getCalendarEventUpdateRequestTopicName(),
                            calendarEventUpdateRequestAvroModel,
                            contestUserUpdateOutboxMessage,
                            outboxCallback,
                            contestUserUpdateEventPayload.getContestUserId(),
                            "CalendarEventUpdateRequestAvroModel"));

            log.info("ContestUserUpdateEventPayload sent to Kafka for contest_user_id: {} and saga id: {}",
                    contestUserUpdateEventPayload.getContestUserId(), sagaId);
        } catch (Exception e) {
            log.error("Error while sending ContestUserUpdateEventPayload" +
                            " to kafka with contest_user_id: {} and saga id: {}, error: {}",
                    contestUserUpdateEventPayload.getContestUserId(),
                    sagaId, e.getMessage());
        }
    }
}
