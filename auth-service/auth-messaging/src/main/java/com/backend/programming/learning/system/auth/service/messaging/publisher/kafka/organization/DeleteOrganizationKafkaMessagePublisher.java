package com.backend.programming.learning.system.auth.service.messaging.publisher.kafka.organization;

import com.backend.programming.learning.system.auth.service.config.AuthServiceConfigData;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationDeletedEvent;
import com.backend.programming.learning.system.auth.service.messaging.mapper.OrganizationMessagingDataMapper;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationDeleteRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DeleteOrganizationKafkaMessagePublisher implements DomainEventPublisher<OrganizationDeletedEvent> {
    private final OrganizationMessagingDataMapper organizationMessagingDataMapper;
    private final AuthServiceConfigData authServiceConfigData;
    private final KafkaProducer<String, OrganizationDeleteRequestAvroModel> kafkaProducer;
    private final KafkaMessageHelper kafkaMessageHelper;

    public DeleteOrganizationKafkaMessagePublisher(OrganizationMessagingDataMapper organizationMessagingDataMapper, AuthServiceConfigData authServiceConfigData, KafkaProducer<String, OrganizationDeleteRequestAvroModel> kafkaProducer, KafkaMessageHelper kafkaMessageHelper) {
        this.organizationMessagingDataMapper = organizationMessagingDataMapper;
        this.authServiceConfigData = authServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }


    @Override
    public void publish(OrganizationDeletedEvent domainEvent) {
        String organizationId = domainEvent.getOrganization().getId().getValue().toString();
        log.info("Received OrganizationDeletedEvent for organization id: {}", organizationId);

        try {
            OrganizationDeleteRequestAvroModel organizationDeleteRequestAvroModel = organizationMessagingDataMapper
                    .organizationDeletedToOrganizationDeleteRequestAvroModel(domainEvent);
            kafkaProducer.send(authServiceConfigData.getOrganizationDeleteRequestTopicName(),
                    organizationId,
                    organizationDeleteRequestAvroModel,
                    kafkaMessageHelper.getKafkaCallback(authServiceConfigData.getOrganizationResponseTopicName(),
                            organizationDeleteRequestAvroModel, organizationId, "OrganizationDeleteRequestAvroModel"));
            log.info("OrganizationDeleteRequestAvroModel sent to Kafka for organization id: {}", organizationDeleteRequestAvroModel.getOrganizationId());
        } catch (Exception e) {
            log.error("Error while sending OrganizationDeleteRequestAvroModel message" +
                    " to kafka with organization id: {}, error: {}", organizationId, e.getMessage());
        }

    }
}
