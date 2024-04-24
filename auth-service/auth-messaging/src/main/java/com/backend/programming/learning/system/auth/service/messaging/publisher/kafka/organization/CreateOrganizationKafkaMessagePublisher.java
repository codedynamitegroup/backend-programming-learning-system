package com.backend.programming.learning.system.auth.service.messaging.publisher.kafka.organization;

import com.backend.programming.learning.system.auth.service.domain.config.AuthServiceConfigData;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.organization.OrganizationCreatedMessagePublisher;
import com.backend.programming.learning.system.auth.service.messaging.mapper.OrganizationMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationCreateRequestAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserCreateRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CreateOrganizationKafkaMessagePublisher implements OrganizationCreatedMessagePublisher {
    private final OrganizationMessagingDataMapper organizationMessagingDataMapper;
    private final AuthServiceConfigData authServiceConfigData;
    private final KafkaProducer<String, OrganizationCreateRequestAvroModel> kafkaProducer;
    private final KafkaMessageHelper kafkaMessageHelper;

    public CreateOrganizationKafkaMessagePublisher(OrganizationMessagingDataMapper organizationMessagingDataMapper, AuthServiceConfigData authServiceConfigData, KafkaProducer<String, OrganizationCreateRequestAvroModel> kafkaProducer, KafkaMessageHelper kafkaMessageHelper) {
        this.organizationMessagingDataMapper = organizationMessagingDataMapper;
        this.authServiceConfigData = authServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }


    @Override
    public void publish(OrganizationCreatedEvent domainEvent) {
        String organizationId = domainEvent.getOrganization().getId().getValue().toString();
        log.info("Received OrganizationCreatedEvent for organization id: {}", organizationId);

        try {
            OrganizationCreateRequestAvroModel organizationCreateRequestAvroModel = organizationMessagingDataMapper
                    .organizationCreatedToOrganizationCreateRequestAvroModel(domainEvent);
            kafkaProducer.send(authServiceConfigData.getOrganizationCreateRequestTopicName(),
                    organizationId,
                    organizationCreateRequestAvroModel,
                    kafkaMessageHelper.getKafkaCallback(authServiceConfigData.getOrganizationResponseTopicName(),
                            organizationCreateRequestAvroModel, organizationId, "OrganizationCreateRequestAvroModel"));
            log.info("OrganizationCreateRequestAvroModel sent to Kafka for organization id: {}", organizationCreateRequestAvroModel.getOrganizationId());
        } catch (Exception e) {
            log.error("Error while sending OrganizationCreateRequestAvroModel message" +
                    " to kafka with organization id: {}, error: {}", organizationId, e.getMessage());
        }

    }
}
