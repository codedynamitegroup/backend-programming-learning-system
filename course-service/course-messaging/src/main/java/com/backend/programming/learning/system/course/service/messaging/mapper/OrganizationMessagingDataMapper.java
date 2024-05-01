package com.backend.programming.learning.system.course.service.messaging.mapper;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.organization.OrganizationCreateRequest;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.organization.OrganizationDeleteRequest;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.organization.OrganizationUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.event.organization.*;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrganizationMessagingDataMapper {

    public OrganizationResponseAvroModel organizationCreatedSuccessEventToOrganizationResponseAvroModel(OrganizationCreatedSuccessEvent organizationCreatedSuccessEvent) {
        return OrganizationResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setOrganizationId(organizationCreatedSuccessEvent.getOrganization().getId().getValue().toString())
                .setOrganizationResponseStatus(OrganizationResponseStatus.CREATED)
                .setFailureMessages(organizationCreatedSuccessEvent.getFailureMessages())
                .build();
    }

    public OrganizationResponseAvroModel organizationCreatedFailEventToOrganizationResponseAvroModel(OrganizationCreatedFailEvent organizationCreatedFailEvent) {
        return OrganizationResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setOrganizationId(organizationCreatedFailEvent.getOrganization().getId().getValue().toString())
                .setOrganizationResponseStatus(OrganizationResponseStatus.CREATE_FAILED)
                .setFailureMessages(organizationCreatedFailEvent.getFailureMessages())
                .build();
    }

    public OrganizationResponseAvroModel organizationDeletedSuccessEventToOrganizationResponseAvroModel(OrganizationDeletedSuccessEvent organizationDeletedSuccessEvent) {
        return OrganizationResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setOrganizationId(organizationDeletedSuccessEvent.getOrganization().getId().getValue().toString())
                .setOrganizationResponseStatus(OrganizationResponseStatus.DELETED)
                .setFailureMessages(organizationDeletedSuccessEvent.getFailureMessages())
                .build();
    }

    public OrganizationResponseAvroModel organizationDeletedFailEventToOrganizationResponseAvroModel(OrganizationDeletedFailEvent organizationDeletedFailEvent) {
        return OrganizationResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setOrganizationId(organizationDeletedFailEvent.getOrganization().getId().getValue().toString())
                .setOrganizationResponseStatus(OrganizationResponseStatus.DELETE_FAILED)
                .setFailureMessages(organizationDeletedFailEvent.getFailureMessages())
                .build();
    }


    public OrganizationResponseAvroModel organizationUpdatedSuccessEventToOrganizationResponseAvroModel(OrganizationUpdatedSuccessEvent organizationUpdatedSuccessEvent) {
        return OrganizationResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setOrganizationId(organizationUpdatedSuccessEvent.getOrganization().getId().getValue().toString())
                .setOrganizationResponseStatus(OrganizationResponseStatus.UPDATED)
                .setFailureMessages(organizationUpdatedSuccessEvent.getFailureMessages())
                .build();
    }

    public OrganizationResponseAvroModel organizationUpdatedFailEventToOrganizationResponseAvroModel(OrganizationUpdatedFailEvent organizationUpdatedFailEvent) {
        return OrganizationResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setOrganizationId(organizationUpdatedFailEvent.getOrganization().getId().getValue().toString())
                .setOrganizationResponseStatus(OrganizationResponseStatus.UPDATE_FAILED)
                .setFailureMessages(organizationUpdatedFailEvent.getFailureMessages())
                .build();
    }

    public OrganizationCreateRequest organizationCreateRequestAvroModelToOrganizationCreateRequest(OrganizationCreateRequestAvroModel organizationCreateRequestAvroModel) {
        return OrganizationCreateRequest.builder()
                .id(organizationCreateRequestAvroModel.getId())
                .sagaId(organizationCreateRequestAvroModel.getSagaId())
                .organizationId(organizationCreateRequestAvroModel.getOrganizationId())
                .name(organizationCreateRequestAvroModel.getName())
                .description(organizationCreateRequestAvroModel.getDescription())
                .apiKey(organizationCreateRequestAvroModel.getApiKey())
                .moodle_url(organizationCreateRequestAvroModel.getMoodleUrl())
                .createdAt(organizationCreateRequestAvroModel.getCreatedAt())
                .updatedAt(organizationCreateRequestAvroModel.getUpdatedAt())
                .build();
    }

    public OrganizationUpdateRequest organizationUpdateRequestAvroModelToOrganizationUpdateRequest(OrganizationUpdateRequestAvroModel organizationUpdateRequestAvroModel) {
        return OrganizationUpdateRequest.builder()
                .id(organizationUpdateRequestAvroModel.getId())
                .sagaId(organizationUpdateRequestAvroModel.getSagaId())
                .organizationId(organizationUpdateRequestAvroModel.getOrganizationId())
                .name(organizationUpdateRequestAvroModel.getName())
                .description(organizationUpdateRequestAvroModel.getDescription())
                .moodle_url(organizationUpdateRequestAvroModel.getMoodleUrl())
                .apiKey(organizationUpdateRequestAvroModel.getApiKey())
                .updatedAt(organizationUpdateRequestAvroModel.getUpdatedAt())
                .build();
    }

    public OrganizationDeleteRequest organizationDeleteRequestAvroModelToOrganizationDeleteRequest(OrganizationDeleteRequestAvroModel organizationDeleteRequestAvroModel) {
        return OrganizationDeleteRequest.builder()
                .id(organizationDeleteRequestAvroModel.getId())
                .sagaId(organizationDeleteRequestAvroModel.getSagaId())
                .organizationId(organizationDeleteRequestAvroModel.getOrganizationId())
                .isDeleted(organizationDeleteRequestAvroModel.getIsDeleted())
                .build();
    }
}
