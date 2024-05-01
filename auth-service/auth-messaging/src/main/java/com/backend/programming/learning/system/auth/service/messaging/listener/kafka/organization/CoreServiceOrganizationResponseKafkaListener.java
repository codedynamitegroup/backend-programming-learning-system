package com.backend.programming.learning.system.auth.service.messaging.listener.kafka.organization;

import com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener.CoreServiceOrganizationResponseMessageListener;
import com.backend.programming.learning.system.auth.service.messaging.mapper.OrganizationMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationResponseAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserResponseAvroModel;
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
public class CoreServiceOrganizationResponseKafkaListener implements KafkaConsumer<OrganizationResponseAvroModel> {
    private final CoreServiceOrganizationResponseMessageListener organizationResponseMessageListener;
    private final OrganizationMessagingDataMapper organizationMessagingDataMapper;

    public CoreServiceOrganizationResponseKafkaListener(CoreServiceOrganizationResponseMessageListener organizationResponseMessageListener, OrganizationMessagingDataMapper organizationMessagingDataMapper) {
        this.organizationResponseMessageListener = organizationResponseMessageListener;
        this.organizationMessagingDataMapper = organizationMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.core-service-organization-response-group-id}",
            topics = "${auth-service.organization-response-topic-name}")
    public void receive(@Payload List<OrganizationResponseAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of organization responses received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(organizationResponseAvroModel -> {
            switch (organizationResponseAvroModel.getOrganizationResponseStatus()){
                case CREATED:{
                    log.info("Success to create organization for id: {}",
                            organizationResponseAvroModel.getOrganizationId());
                    organizationResponseMessageListener
                            .organizationCreateSuccess(organizationMessagingDataMapper
                                    .organizationResponseAvroModelToOrganizationResponse(organizationResponseAvroModel));
                    break;
                }
                case CREATE_FAILED:{
                    log.info("Fail to create organization for id: {}",
                            organizationResponseAvroModel.getOrganizationId());
                    organizationResponseMessageListener
                            .organizationCreateFail(organizationMessagingDataMapper
                                    .organizationResponseAvroModelToOrganizationResponse(organizationResponseAvroModel));
                    break;
                }
                case DELETED: {
                    log.info("Success to delete organization for id: {}",
                            organizationResponseAvroModel.getOrganizationId());
                    organizationResponseMessageListener
                            .organizationDeleteSuccess(organizationMessagingDataMapper
                                    .organizationResponseAvroModelToOrganizationResponse(organizationResponseAvroModel));
                    break;
                }
                case DELETE_FAILED:{
                    log.info("Fail to delete organization for id: {}",
                            organizationResponseAvroModel.getOrganizationId());
                    organizationResponseMessageListener
                            .organizationDeleteFail(organizationMessagingDataMapper
                                    .organizationResponseAvroModelToOrganizationResponse(organizationResponseAvroModel));
                    break;
                }
                case UPDATED:{
                    log.info("Success to update organization for id: {}",
                            organizationResponseAvroModel.getOrganizationId());
                    organizationResponseMessageListener
                            .organizationCreateSuccess(organizationMessagingDataMapper
                                    .organizationResponseAvroModelToOrganizationResponse(organizationResponseAvroModel));
                    break;
                }
                case UPDATE_FAILED:{
                    log.info("Fail to update organization for id: {}",
                            organizationResponseAvroModel.getOrganizationId());
                    organizationResponseMessageListener
                            .organizationUpdatedFail(organizationMessagingDataMapper
                                    .organizationResponseAvroModelToOrganizationResponse(organizationResponseAvroModel));
                    break;
                }
            }

        });
    }
}
