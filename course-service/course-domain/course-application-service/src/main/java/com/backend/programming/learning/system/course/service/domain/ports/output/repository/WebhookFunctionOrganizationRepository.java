package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.WebhookFunctionOrganization;

public interface WebhookFunctionOrganizationRepository {
    WebhookFunctionOrganization saveWebhookFunctionOrganization(WebhookFunctionOrganization webhookFunctionOrganization);
}
