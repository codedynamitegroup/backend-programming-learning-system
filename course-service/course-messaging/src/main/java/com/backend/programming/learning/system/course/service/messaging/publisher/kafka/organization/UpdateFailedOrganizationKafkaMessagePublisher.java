package com.backend.programming.learning.system.course.service.messaging.publisher.kafka.organization;

import com.backend.programming.learning.system.course.service.domain.config.CourseServiceConfigData;
import com.backend.programming.learning.system.course.service.domain.event.organization.OrganizationUpdatedFailEvent;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.organization.OrganizationUpdateFailedMessagePublisher;
import com.backend.programming.learning.system.course.service.messaging.mapper.OrganizationMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationResponseAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UpdateFailedOrganizationKafkaMessagePublisher implements OrganizationUpdateFailedMessagePublisher {
    private final OrganizationMessagingDataMapper organizationMessagingDataMapper;
    private final CourseServiceConfigData courseServiceConfigData;
    private final KafkaProducer<String, OrganizationResponseAvroModel> kafkaProducer;
    private final KafkaMessageHelper organizationKafkaMessageHelper;

    public UpdateFailedOrganizationKafkaMessagePublisher(OrganizationMessagingDataMapper organizationMessagingDataMapper,
                                                         CourseServiceConfigData courseServiceConfigData,
                                                         KafkaProducer<String, OrganizationResponseAvroModel> kafkaProducer,
                                                         KafkaMessageHelper organizationKafkaMessageHelper) {
        this.organizationMessagingDataMapper = organizationMessagingDataMapper;
        this.courseServiceConfigData = courseServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.organizationKafkaMessageHelper = organizationKafkaMessageHelper;
    }


    @Override
    public void publish(OrganizationUpdatedFailEvent domainEvent) {
        String organizationId = domainEvent.getOrganization().getId().getValue().toString();
        log.info("Received OrganizationCreatedSuccessEvent for organization id: {}", organizationId);

        try {
            OrganizationResponseAvroModel organizationResponseAvroModel =organizationMessagingDataMapper
                    .organizationUpdatedFailEventToOrganizationResponseAvroModel(domainEvent);
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
