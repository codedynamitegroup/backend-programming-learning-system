package com.backend.programming.learning.system.course.service.domain.ports.input.service.webhook;

import com.backend.programming.learning.system.course.service.domain.dto.method.webhook.WebhookCommand;
import jakarta.validation.Valid;

public interface WebhookApplicationService {
    void receiveWebhook(@Valid WebhookCommand webhookCommand);
}
