package com.backend.programming.learning.system.auth.service.messaging.publisher.kafka.organization;

import com.backend.programming.learning.system.auth.service.config.AuthServiceConfigData;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.organization.OrganizationEventPayload;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.organization.OrganizationRequestMessagePublish;
import com.backend.programming.learning.system.auth.service.messaging.mapper.OrganizationMessagingDataMapper;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaOutboxMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
public class OrganizationEventKafkaPublisher implements OrganizationRequestMessagePublish {
    private final OrganizationMessagingDataMapper organizationMessagingDataMapper;
    private final KafkaProducer<String, OrganizationRequestAvroModel> kafkaProducer;
    private final AuthServiceConfigData authServiceConfigData;
    private final KafkaOutboxMessageHelper kafkaOutboxMessageHelper;

    public OrganizationEventKafkaPublisher(OrganizationMessagingDataMapper organizationMessagingDataMapper, KafkaProducer<String, OrganizationRequestAvroModel> kafkaProducer, AuthServiceConfigData authServiceConfigData, KafkaOutboxMessageHelper kafkaOutboxMessageHelper) {
        this.organizationMessagingDataMapper = organizationMessagingDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.authServiceConfigData = authServiceConfigData;
        this.kafkaOutboxMessageHelper = kafkaOutboxMessageHelper;
    }

    @Override
    public void publish(OrganizationOutboxMessage organizationOutboxMessage, BiConsumer<OrganizationOutboxMessage, OutboxStatus> outboxCallback) {
        OrganizationEventPayload organizationEventPayload = kafkaOutboxMessageHelper.getEventPayload(organizationOutboxMessage.getPayload(), OrganizationEventPayload.class);

        String sagaId = organizationOutboxMessage.getSagaId().toString();
        ServiceName serviceName = organizationOutboxMessage.getServiceName();

        log.info("Received OrganizationOutboxMessage for organization id: {} and saga id: {}",
                organizationEventPayload.getOrganizationId(), sagaId);

        try {
            switch (organizationOutboxMessage.getCopyState()) {
                case CREATING -> {
                    OrganizationRequestAvroModel organizationRequestAvroModel = organizationMessagingDataMapper
                            .organizationCreatedEventPayloadToOrganizationRequestAvroModel(sagaId, serviceName, organizationEventPayload);
                    kafkaProducer.send(authServiceConfigData.getOrganizationRequestTopicName(),
                            sagaId,
                            organizationRequestAvroModel,
                            kafkaOutboxMessageHelper.getKafkaCallback(authServiceConfigData.getOrganizationRequestTopicName(),
                                    organizationRequestAvroModel, organizationOutboxMessage, outboxCallback,
                                    sagaId, "OrganizationRequestAvroModel"));
                }
                case DELETING -> {
                    OrganizationRequestAvroModel organizationRequestAvroModel = organizationMessagingDataMapper
                            .organizationDeletedEventPayloadToOrganizationRequestAvroModel(sagaId, serviceName, organizationEventPayload);
                    kafkaProducer.send(authServiceConfigData.getOrganizationRequestTopicName(),
                            sagaId,
                            organizationRequestAvroModel,
                            kafkaOutboxMessageHelper.getKafkaCallback(authServiceConfigData.getOrganizationRequestTopicName(),
                                    organizationRequestAvroModel, organizationOutboxMessage, outboxCallback,
                                    sagaId, "OrganizationRequestAvroModel"));
                }
                case UPDATING -> {
                    OrganizationRequestAvroModel organizationRequestAvroModel = organizationMessagingDataMapper
                            .organizationUpdatedEventPayloadToOrganizationRequestAvroModel(sagaId, serviceName, organizationEventPayload);
                    kafkaProducer.send(authServiceConfigData.getOrganizationRequestTopicName(),
                            sagaId,
                            organizationRequestAvroModel,
                            kafkaOutboxMessageHelper.getKafkaCallback(authServiceConfigData.getOrganizationRequestTopicName(),
                                    organizationRequestAvroModel, organizationOutboxMessage, outboxCallback,
                                    sagaId, "OrganizationRequestAvroModel"));
                }
            }
            log.info("OrganizationRequestAvroModel sent to Kafka for organization id: {} and saga id: {}",
                    organizationEventPayload.getOrganizationId(), sagaId);
        } catch (Exception e) {
            log.error("Error while sending OrganizationRequestAvroModel message" +
                    " to kafka with organization id: {} and saga id: {}, error: {}", organizationEventPayload.getOrganizationId(), sagaId, e.getMessage());
        }
    }
}
