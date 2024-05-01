package com.backend.programming.learning.system.auth.service.messaging.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.OrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationUpdatedEvent;
import com.backend.programming.learning.system.domain.valueobject.OrganizationResponseStatus;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationCreateRequestAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationDeleteRequestAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationResponseAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationUpdateRequestAvroModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrganizationMessagingDataMapper {
    public OrganizationCreateRequestAvroModel organizationCreatedToOrganizationCreateRequestAvroModel(
            OrganizationCreatedEvent organizationCreatedEvent) {
        Organization organization = organizationCreatedEvent.getOrganization();
        return OrganizationCreateRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setOrganizationId(organization.getId().getValue().toString())
                .setEmail(organization.getEmail())
                .setDescription(organization.getDescription())
                .setName(organization.getName())
                .setPhone(organization.getPhone())
                .setAddress(organization.getPhone())
                .setApiKey(organization.getApiKey())
                .setMoodleUrl(organization.getMoodleUrl())
                .setCreatedAt(organization.getCreatedAt().toInstant())
                .setCreatedBy(organization.getCreatedBy().getId().toString())
                .setUpdatedAt(organization.getUpdatedAt().toInstant())
                .setIsDeleted(organization.getDeleted())
                .build();
    }

    public OrganizationUpdateRequestAvroModel organizationUpdatedToOrganizationUpdateRequestAvroModel(
            OrganizationUpdatedEvent organizationUpdatedEvent) {
        Organization organization = organizationUpdatedEvent.getOrganization();
        return OrganizationUpdateRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setOrganizationId(organization.getId().getValue().toString())
                .setDescription(organization.getDescription())
                .setName(organization.getName())
                .setEmail(organization.getEmail())
                .setPhone(organization.getPhone())
                .setAddress(organization.getAddress())
                .setApiKey(organization.getApiKey())
                .setMoodleUrl(organization.getMoodleUrl())
                .setUpdatedAt(organization.getUpdatedAt().toInstant())
                .setUpdatedBy(organization.getUpdatedBy().getId().toString())
                .build();
    }

    public OrganizationDeleteRequestAvroModel organizationDeletedToOrganizationDeleteRequestAvroModel(
            OrganizationDeletedEvent organizationDeletedEvent) {
        Organization organization = organizationDeletedEvent.getOrganization();
        return OrganizationDeleteRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setOrganizationId(organization.getId().getValue().toString())
                .setIsDeleted(organization.getDeleted())
                .build();
    }

    public OrganizationResponse organizationResponseAvroModelToOrganizationResponse(OrganizationResponseAvroModel organizationResponseAvroModel) {
        return OrganizationResponse.builder()
                .id(organizationResponseAvroModel.getId())
                .sagaId(organizationResponseAvroModel.getSagaId())
                .organizationId(organizationResponseAvroModel.getOrganizationId())
                .organizationResponseStatus(OrganizationResponseStatus.valueOf(organizationResponseAvroModel.getOrganizationResponseStatus().name()))
                .failureMessages(organizationResponseAvroModel.getFailureMessages())
                .build();

    }
}
