package com.backend.programming.learning.system.course.service.domain.implement.service.webhook;

import com.backend.programming.learning.system.course.service.domain.dto.method.webhook.WebhookCommand;
import org.springframework.stereotype.Component;

@Component
public class WebhookCommandHandler {
    private final WebhookHelper webhookHelper;

    public WebhookCommandHandler(WebhookHelper webhookHelper) {
        this.webhookHelper = webhookHelper;
    }

    public void receiveWebhook(WebhookCommand webhookCommand) {
        webhookHelper.processWebhook(webhookCommand);
    }
}
