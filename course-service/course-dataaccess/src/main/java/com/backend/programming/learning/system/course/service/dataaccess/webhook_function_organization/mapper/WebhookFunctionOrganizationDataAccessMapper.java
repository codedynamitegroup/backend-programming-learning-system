package com.backend.programming.learning.system.course.service.dataaccess.webhook_function_organization.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.webhook_function_organization.entity.WebhookFunctionOrganizationEntity;
import com.backend.programming.learning.system.course.service.domain.entity.WebhookFunctionOrganization;
import com.backend.programming.learning.system.course.service.domain.valueobject.WebhookFunctionOrganizationId;
import org.springframework.stereotype.Component;

@Component
public class WebhookFunctionOrganizationDataAccessMapper {
    public WebhookFunctionOrganizationEntity webhookFunctionOrganizationToWebhookFunctionOrganizationEntity(WebhookFunctionOrganization webhookFunctionOrganization) {
        return WebhookFunctionOrganizationEntity.builder()
                .id(webhookFunctionOrganization.getId().getValue())
                .build();
    }

    public WebhookFunctionOrganization webhookFunctionOrganizationEntityToWebhookFunctionOrganization(WebhookFunctionOrganizationEntity webhookFunctionOrganizationEntity) {
        return WebhookFunctionOrganization.builder()
                .id(new WebhookFunctionOrganizationId(webhookFunctionOrganizationEntity.getId()))
                .build();
    }
}
