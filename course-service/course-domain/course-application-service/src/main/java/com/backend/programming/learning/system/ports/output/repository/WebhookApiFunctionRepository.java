package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.WebhookApiFunction;

public interface WebhookApiFunctionRepository {
    WebhookApiFunction saveWebhookApiFunction(WebhookApiFunction webhookApiFunction);
}
