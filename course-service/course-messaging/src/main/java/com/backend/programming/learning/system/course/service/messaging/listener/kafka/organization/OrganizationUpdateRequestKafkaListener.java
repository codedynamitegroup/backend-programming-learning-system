package com.backend.programming.learning.system.course.service.messaging.listener.kafka.organization;

import com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.auth.OrganizationRequestMessageListener;
import com.backend.programming.learning.system.course.service.messaging.mapper.OrganizationMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class OrganizationUpdateRequestKafkaListener implements KafkaConsumer<OrganizationUpdateRequestAvroModel> {
    private final OrganizationRequestMessageListener organizationRequestMessageListener;
    private final OrganizationMessagingDataMapper organizationMessagingDataMapper;

    public OrganizationUpdateRequestKafkaListener(OrganizationRequestMessageListener organizationRequestMessageListener, OrganizationMessagingDataMapper organizationMessagingDataMapper) {
        this.organizationRequestMessageListener = organizationRequestMessageListener;
        this.organizationMessagingDataMapper = organizationMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.course-service-organization-update-request-group-id}",
            topics = "${course-service.organization-update-request-topic-name}")
    public void receive(@Payload List<OrganizationUpdateRequestAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of user requests received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(organizationRequestAvroModel -> {
            log.info("Updating user: {}",
                    organizationRequestAvroModel);
            organizationRequestMessageListener
                    .organizationUpdated(organizationMessagingDataMapper
                            .organizationUpdateRequestAvroModelToOrganizationUpdateRequest(organizationRequestAvroModel));
        });
    }
}
