package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.WebhookFunctionOrganization;

public interface WebhookFunctionOrganizationRepository {
    WebhookFunctionOrganization saveWebhookFunctionOrganization(WebhookFunctionOrganization webhookFunctionOrganization);
}
