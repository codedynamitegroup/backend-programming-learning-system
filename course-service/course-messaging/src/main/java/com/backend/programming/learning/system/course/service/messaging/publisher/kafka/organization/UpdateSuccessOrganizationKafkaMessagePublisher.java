package com.backend.programming.learning.system.course.service.messaging.publisher.kafka.organization;

import com.backend.programming.learning.system.course.service.config.CourseServiceConfigData;
import com.backend.programming.learning.system.course.service.domain.event.organization.OrganizationUpdatedSuccessEvent;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.organization.OrganizationUpdatedSuccessMessagePublisher;
import com.backend.programming.learning.system.course.service.messaging.mapper.OrganizationMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationResponseAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UpdateSuccessOrganizationKafkaMessagePublisher implements OrganizationUpdatedSuccessMessagePublisher {
    private final OrganizationMessagingDataMapper organizationMessagingDataMapper;
    private final CourseServiceConfigData courseServiceConfigData;
    private final KafkaProducer<String, OrganizationResponseAvroModel> kafkaProducer;
    private final KafkaMessageHelper organizationKafkaMessageHelper;

    public UpdateSuccessOrganizationKafkaMessagePublisher(OrganizationMessagingDataMapper organizationMessagingDataMapper,
                                                         CourseServiceConfigData courseServiceConfigData,
                                                         KafkaProducer<String, OrganizationResponseAvroModel> kafkaProducer,
                                                         KafkaMessageHelper organizationKafkaMessageHelper) {
        this.organizationMessagingDataMapper = organizationMessagingDataMapper;
        this.courseServiceConfigData = courseServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.organizationKafkaMessageHelper = organizationKafkaMessageHelper;
    }


    @Override
    public void publish(OrganizationUpdatedSuccessEvent domainEvent) {
        String organizationId = domainEvent.getOrganization().getId().getValue().toString();
        log.info("Received OrganizationCreatedSuccessEvent for organization id: {}", organizationId);

        try {
            OrganizationResponseAvroModel organizationResponseAvroModel =organizationMessagingDataMapper
                    .organizationUpdatedSuccessEventToOrganizationResponseAvroModel(domainEvent);
            kafkaProducer.send(courseServiceConfigData.getOrganizationResponseTopicName(),
                    organizationId,
                    organizationResponseAvroModel,
                    organizationKafkaMessageHelper.getKafkaCallback(courseServiceConfigData.getOrganizationResponseTopicName(),
                            organizationResponseAvroModel, organizationId, "OrganizationResponseAvroModel"));

            log.info("OrganizationResponseAvroModel sent to Kafka for organization id: {}", organizationResponseAvroModel.getOrganizationId());
        } catch (Exception e) {
            log.error("Error while sending OrganizationResponseAvroModel message" +
                    " to kafka with organization id: {}, error: {}", organizationId, e.getMessage());
        }

    }
}
