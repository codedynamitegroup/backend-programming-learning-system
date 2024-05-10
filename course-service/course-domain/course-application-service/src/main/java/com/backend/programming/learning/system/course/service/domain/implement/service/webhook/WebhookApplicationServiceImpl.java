package com.backend.programming.learning.system.course.service.domain.implement.service.webhook;

import com.backend.programming.learning.system.course.service.domain.dto.method.webhook.WebhookCommand;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.webhook.WebhookApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
public class WebhookApplicationServiceImpl implements WebhookApplicationService {
    private final WebhookCommandHandler webhookCommandHandler;

    public WebhookApplicationServiceImpl(WebhookCommandHandler webhookCommandHandler) {
        this.webhookCommandHandler = webhookCommandHandler;
    }

    @Override
    public void receiveWebhook(WebhookCommand webhookCommand) {
        webhookCommandHandler.receiveWebhook(webhookCommand);
    }
}
