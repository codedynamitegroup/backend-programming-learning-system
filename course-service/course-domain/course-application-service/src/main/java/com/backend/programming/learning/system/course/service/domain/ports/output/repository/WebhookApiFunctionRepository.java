package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.WebhookApiFunction;

public interface WebhookApiFunctionRepository {
    WebhookApiFunction saveWebhookApiFunction(WebhookApiFunction webhookApiFunction);
}
