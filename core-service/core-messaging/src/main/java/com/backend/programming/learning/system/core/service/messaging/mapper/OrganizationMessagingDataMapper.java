package com.backend.programming.learning.system.core.service.messaging.mapper;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.organization.OrganizationRequest;
import com.backend.programming.learning.system.core.service.domain.outbox.model.organization.OrganizationEventPayload;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.CopyState;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationRequestAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationResponseAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.ServiceName;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrganizationMessagingDataMapper {
    public OrganizationRequest organizationCreatedRequestAvroModelToOrganizationRequest(OrganizationRequestAvroModel organizationRequestAvroModel) {
        return OrganizationRequest.builder()
                .id(organizationRequestAvroModel.getId())
                .sagaId(organizationRequestAvroModel.getSagaId())
                .organizationId(organizationRequestAvroModel.getOrganizationId())
                .name(organizationRequestAvroModel.getName())
                .description(organizationRequestAvroModel.getDescription())
                .createdAt(organizationRequestAvroModel.getCreatedAt())
                .updatedAt(organizationRequestAvroModel.getUpdatedAt())
                .isDeleted(organizationRequestAvroModel.getIsDeleted())
                .build();
    }

    public OrganizationRequest organizationUpdatedRequestAvroModelToOrganizationRequest(OrganizationRequestAvroModel organizationRequestAvroModel) {
        return OrganizationRequest.builder()
                .id(organizationRequestAvroModel.getId())
                .sagaId(organizationRequestAvroModel.getSagaId())
                .organizationId(organizationRequestAvroModel.getOrganizationId())
                .name(organizationRequestAvroModel.getName())
                .description(organizationRequestAvroModel.getDescription())
                .apiKey(organizationRequestAvroModel.getApiKey())
                .moodleUrl(organizationRequestAvroModel.getMoodleUrl())
                .updatedAt(organizationRequestAvroModel.getUpdatedAt())
                .isDeleted(organizationRequestAvroModel.getIsDeleted())
                .build();
    }

    public OrganizationRequest organizationDeletedRequestAvroModelToOrganizationRequest(OrganizationRequestAvroModel organizationRequestAvroModel) {
        return OrganizationRequest.builder()
                .id(organizationRequestAvroModel.getId())
                .sagaId(organizationRequestAvroModel.getSagaId())
                .organizationId(organizationRequestAvroModel.getOrganizationId())
                .isDeleted(organizationRequestAvroModel.getIsDeleted())
                .build();
    }

    public OrganizationResponseAvroModel organizationEventPayloadToOrganizationResponseAvroModel(String sagaId, OrganizationEventPayload organizationEventPayload) {
        return OrganizationResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId(sagaId)
                .setOrganizationId(organizationEventPayload.getOrganizationId())
                .setCopyState(CopyState.valueOf(organizationEventPayload.getCopyState()))
                .setServiceName(
                        ServiceName.valueOf(com.backend.programming.learning.system.domain.valueobject.ServiceName.CORE_SERVICE.name()))
                .setFailureMessages(organizationEventPayload.getFailureMessages())
                .build();
    }
}