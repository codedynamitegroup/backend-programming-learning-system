package com.backend.programming.learning.system.course.service.domain.implement.service.webhook;

import com.backend.programming.learning.system.course.service.domain.dto.method.webhook.WebhookCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

@Component
public class WebhookCommandHandler {
    private final WebhookHelper webhookHelper;

    public WebhookCommandHandler(WebhookHelper webhookHelper) {
        this.webhookHelper = webhookHelper;
    }

    public void receiveWebhook(WebhookCommand webhookCommand) throws JsonProcessingException {
        webhookHelper.processWebhook(webhookCommand);
    }
}
