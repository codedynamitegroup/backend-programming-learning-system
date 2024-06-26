package com.backend.programming.learning.system.auth.service.messaging.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.organization.OrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.organization.OrganizationEventPayload;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.CopyState;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationRequestAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationResponseAvroModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrganizationMessagingDataMapper {
    public OrganizationRequestAvroModel organizationCreatedEventPayloadToOrganizationRequestAvroModel(
            String sagaId,
            ServiceName serviceName,
            OrganizationEventPayload organizationEventPayload) {
        return OrganizationRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId(sagaId)
                .setOrganizationId(organizationEventPayload.getOrganizationId())
                .setDescription(organizationEventPayload.getDescription())
                .setName(organizationEventPayload.getName())
                .setCreatedAt(organizationEventPayload.getCreatedAt().toInstant())
                .setUpdatedAt(organizationEventPayload.getUpdatedAt().toInstant())
                .setIsDeleted(organizationEventPayload.getIsDeleted())
                .setCopyState(CopyState.CREATING)
                .setServiceName(
                        com.backend.programming.learning.system.kafka.auth.avro.model.organization.ServiceName.valueOf(serviceName.name()))
                .build();
    }

    public OrganizationRequestAvroModel organizationUpdatedEventPayloadToOrganizationRequestAvroModel(
            String sagaId,
            ServiceName serviceName,
            OrganizationEventPayload organizationEventPayload) {
        return OrganizationRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId(sagaId)
                .setOrganizationId(organizationEventPayload.getOrganizationId())
                .setDescription(organizationEventPayload.getDescription())
                .setName(organizationEventPayload.getName())
                .setApiKey(organizationEventPayload.getApiKey())
                .setMoodleUrl(organizationEventPayload.getMoodleUrl())
                .setUpdatedAt(organizationEventPayload.getUpdatedAt().toInstant())
                .setCopyState(CopyState.UPDATING)
                .setIsDeleted(organizationEventPayload.getIsDeleted())
                .setServiceName(
                        com.backend.programming.learning.system.kafka.auth.avro.model.organization.ServiceName.valueOf(serviceName.name()))
                .build();
    }

    public OrganizationRequestAvroModel organizationDeletedEventPayloadToOrganizationRequestAvroModel(
            String sagaId,
            ServiceName serviceName,
            OrganizationEventPayload organizationEventPayload) {
        return OrganizationRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId(sagaId)
                .setOrganizationId(organizationEventPayload.getOrganizationId())
                .setIsDeleted(organizationEventPayload.getIsDeleted())
                .setCopyState(CopyState.DELETING)
                .setServiceName(
                        com.backend.programming.learning.system.kafka.auth.avro.model.organization.ServiceName.valueOf(serviceName.name()))
                .build();
    }

    public OrganizationResponse organizationResponseAvroModelToOrganizationResponse(OrganizationResponseAvroModel organizationResponseAvroModel) {
        return OrganizationResponse.builder()
                .id(organizationResponseAvroModel.getId())
                .sagaId(organizationResponseAvroModel.getSagaId())
                .organizationId(organizationResponseAvroModel.getOrganizationId())
                .state(com.backend.programming.learning.system.domain.valueobject
                        .CopyState.valueOf(organizationResponseAvroModel.getCopyState().name()))
                .serviceName(com.backend.programming.learning.system.domain.valueobject
                        .ServiceName.valueOf(organizationResponseAvroModel.getServiceName().name()))
                .failureMessages(organizationResponseAvroModel.getFailureMessages())
                .build();

    }
}
