package com.backend.programming.learning.system.core.service.messaging.publisher.kafka.organization;

import com.backend.programming.learning.system.core.service.config.CoreServiceConfigData;
import com.backend.programming.learning.system.core.service.domain.outbox.model.organization.OrganizationEventPayload;
import com.backend.programming.learning.system.core.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.organization.OrganizationResponseMessagePublisher;
import com.backend.programming.learning.system.core.service.messaging.mapper.OrganizationMessagingDataMapper;
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
    private final CoreServiceConfigData coreServiceConfigData;
    private final KafkaOutboxMessageHelper kafkaOutboxMessageHelper;

    public OrganizationEventKafkaPublisher(OrganizationMessagingDataMapper organizationMessagingDataMapper, KafkaProducer<String, OrganizationResponseAvroModel> kafkaProducer, CoreServiceConfigData coreServiceConfigData, KafkaOutboxMessageHelper kafkaOutboxMessageHelper) {
        this.organizationMessagingDataMapper = organizationMessagingDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.coreServiceConfigData = coreServiceConfigData;
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
            kafkaProducer.send(coreServiceConfigData.getOrganizationResponseTopicName(),
                    sagaId,
                    organizationResponseAvroModel,
                    kafkaOutboxMessageHelper.getKafkaCallback(coreServiceConfigData.getOrganizationResponseTopicName(),
                            organizationResponseAvroModel,
                            organizationOutboxMessage,
                            outboxCallback,
                            organizationEventPayload.getOrganizationId(),
                            "OrganizationResponseAvroModel"));
            log.info("OrganizationResponseAvroModel sent to Kafka for organization id: {} and saga id: {}",
                    organizationEventPayload.getOrganizationId(), sagaId);
        } catch (Exception e) {
            log.error("Error while sending OrganizationResponseAvroModel message" +
                    " to kafka with organization id: {} and saga id: {}, error: {}", organizationEventPayload.getOrganizationId(), sagaId, e.getMessage());
        }

    }
}
