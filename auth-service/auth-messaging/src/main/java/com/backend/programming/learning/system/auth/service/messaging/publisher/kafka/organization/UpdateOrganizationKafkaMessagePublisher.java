package com.backend.programming.learning.system.auth.service.messaging.publisher.kafka.organization;

import com.backend.programming.learning.system.auth.service.domain.config.AuthServiceConfigData;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationUpdatedEvent;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.organization.OrganizationCreatedMessagePublisher;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.organization.OrganizationUpdatedMessagePublisher;
import com.backend.programming.learning.system.auth.service.messaging.mapper.OrganizationMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationCreateRequestAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UpdateOrganizationKafkaMessagePublisher implements OrganizationUpdatedMessagePublisher {
    private final OrganizationMessagingDataMapper organizationMessagingDataMapper;
    private final AuthServiceConfigData authServiceConfigData;
    private final KafkaProducer<String, OrganizationUpdateRequestAvroModel> kafkaProducer;
    private final KafkaMessageHelper kafkaMessageHelper;

    public UpdateOrganizationKafkaMessagePublisher(OrganizationMessagingDataMapper organizationMessagingDataMapper, AuthServiceConfigData authServiceConfigData, KafkaProducer<String, OrganizationUpdateRequestAvroModel> kafkaProducer, KafkaMessageHelper kafkaMessageHelper) {
        this.organizationMessagingDataMapper = organizationMessagingDataMapper;
        this.authServiceConfigData = authServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }


    @Override
    public void publish(OrganizationUpdatedEvent domainEvent) {
        String organizationId = domainEvent.getOrganization().getId().getValue().toString();
        log.info("Received OrganizationCreatedEvent for organization id: {}", organizationId);

        try {
            OrganizationUpdateRequestAvroModel organizationUpdateRequestAvroModel = organizationMessagingDataMapper
                    .organizationUpdatedToOrganizationUpdateRequestAvroModel(domainEvent);
            kafkaProducer.send(authServiceConfigData.getOrganizationUpdateRequestTopicName(),
                    organizationId,
                    organizationUpdateRequestAvroModel,
                    kafkaMessageHelper.getKafkaCallback(authServiceConfigData.getOrganizationResponseTopicName(),
                            organizationUpdateRequestAvroModel, organizationId, "OrganizationUpdateRequestAvroModel"));
            log.info("OrganizationUpdateRequestAvroModel sent to Kafka for user id: {}", organizationUpdateRequestAvroModel.getOrganizationId());
        } catch (Exception e) {
            log.error("Error while sending OrganizationUpdateRequestAvroModel message" +
                    " to kafka with organization id: {}, error: {}", organizationId, e.getMessage());
        }

    }
}
