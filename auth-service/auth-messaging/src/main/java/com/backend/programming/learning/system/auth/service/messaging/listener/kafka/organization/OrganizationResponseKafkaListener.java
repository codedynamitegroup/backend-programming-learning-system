package com.backend.programming.learning.system.auth.service.messaging.listener.kafka.organization;

import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener.organization.OrganizationResponseMessageListener;
import com.backend.programming.learning.system.auth.service.messaging.mapper.OrganizationMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationResponseAvroModel;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import jakarta.persistence.OptimisticLockException;
import java.util.List;

@Slf4j
@Component
public class OrganizationResponseKafkaListener implements KafkaConsumer<OrganizationResponseAvroModel> {
    private final OrganizationResponseMessageListener organizationResponseMessageListener;
    private final OrganizationMessagingDataMapper organizationMessagingDataMapper;

    public OrganizationResponseKafkaListener(OrganizationResponseMessageListener organizationResponseMessageListener, OrganizationMessagingDataMapper organizationMessagingDataMapper) {
        this.organizationResponseMessageListener = organizationResponseMessageListener;
        this.organizationMessagingDataMapper = organizationMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.service-organization-response-group-id}",
            topics = "${auth-service.organization-response-topic-name}")
    public void receive(@Payload List<OrganizationResponseAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of organization responses received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(organizationResponseAvroModel -> {
            try {
                switch (organizationResponseAvroModel.getCopyState()) {
                    case CREATED, DELETED, UPDATED -> {
                        organizationResponseMessageListener
                                .organizationCreatedUpdatedOrDeletedSuccess(organizationMessagingDataMapper
                                        .organizationResponseAvroModelToOrganizationResponse(organizationResponseAvroModel));
                    }
                    case CREATE_FAILED, DELETE_FAILED, UPDATE_FAILED -> {
                        organizationResponseMessageListener
                                .organizationCreatedUpdatedOrDeletedFail(organizationMessagingDataMapper
                                        .organizationResponseAvroModelToOrganizationResponse(organizationResponseAvroModel));
                    }
                }
            } catch (OptimisticLockException e) {
                //NO-OP for optimistic lock. This means another thread finished the work, do not throw error to prevent reading the data from kafka again!
                log.error("Caught optimistic locking exception in OrganizationResponseAvroModel for organization id: {}",
                        organizationResponseAvroModel.getOrganizationId());
            } catch (AuthNotFoundException e) {
                //NO-OP for OrderNotFoundException
                log.error("No user found for organization id: {}", organizationResponseAvroModel.getOrganizationId());
            }
        });
    }
}
