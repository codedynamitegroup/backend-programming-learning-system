package com.backend.programming.learning.system.course.service.messaging.publisher.kafka.organization;

import com.backend.programming.learning.system.course.service.config.CourseServiceConfigData;
import com.backend.programming.learning.system.course.service.domain.outbox.model.organization.OrganizationEventPayload;
import com.backend.programming.learning.system.course.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.organization.OrganizationResponseMessagePublisher;
import com.backend.programming.learning.system.course.service.messaging.mapper.OrganizationMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationResponseAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaOutboxMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
public class OrganizationEventKafkaPublisher implements OrganizationResponseMessagePublisher {
    private final OrganizationMessagingDataMapper organizationMessagingDataMapper;
    private final KafkaProducer<String, OrganizationResponseAvroModel> kafkaProducer;
    private final CourseServiceConfigData courseServiceConfigData;
    private final KafkaOutboxMessageHelper kafkaOutboxMessageHelper;

    public OrganizationEventKafkaPublisher(OrganizationMessagingDataMapper organizationMessagingDataMapper, KafkaProducer<String, OrganizationResponseAvroModel> kafkaProducer, CourseServiceConfigData courseServiceConfigData, KafkaOutboxMessageHelper kafkaOutboxMessageHelper) {
        this.organizationMessagingDataMapper = organizationMessagingDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.courseServiceConfigData = courseServiceConfigData;
        this.kafkaOutboxMessageHelper = kafkaOutboxMessageHelper;
    }

    @Override
    public void publish(OrganizationOutboxMessage organizationOutboxMessage, BiConsumer<OrganizationOutboxMessage, OutboxStatus> outboxCallback) {
        OrganizationEventPayload organizationEventPayload = kafkaOutboxMessageHelper.getEventPayload(organizationOutboxMessage.getPayload(), OrganizationEventPayload.class);

        String sagaId = organizationOutboxMessage.getSagaId().toString();

        log.info("Received OrganizationOutboxMessage for organization id: {} and saga id: {}",
                organizationEventPayload.getOrganizationId(), sagaId);

        try {
            OrganizationResponseAvroModel organizationResponseAvroModel = organizationMessagingDataMapper
                    .organizationEventPayloadToOrganizationResponseAvroModel(sagaId, organizationEventPayload);
            kafkaProducer.send(courseServiceConfigData.getOrganizationResponseTopicName(),
                    sagaId,
                    organizationResponseAvroModel,
                    kafkaOutboxMessageHelper.getKafkaCallback(courseServiceConfigData.getOrganizationResponseTopicName(),
                            organizationResponseAvroModel,
                            organizationOutboxMessage,
                            outboxCallback,
                            organizationEventPayload.getOrganizationId(),
                            "UserResponseAvroModel"));
            log.info("OrganizationResponseAvroModel sent to Kafka for organization id: {} and saga id: {}",
                    organizationEventPayload.getOrganizationId(), sagaId);
        } catch (Exception e) {
            log.error("Error while sending OrganizationResponseAvroModel message" +
                    " to kafka with user id: {} and saga id: {}, error: {}", organizationEventPayload.getOrganizationId(), sagaId, e.getMessage());
        }

    }
}
