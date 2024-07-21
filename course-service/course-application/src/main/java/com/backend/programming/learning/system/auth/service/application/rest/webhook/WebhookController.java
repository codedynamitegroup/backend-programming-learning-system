package com.backend.programming.learning.system.auth.service.application.rest.webhook;


import com.backend.programming.learning.system.course.service.domain.dto.method.webhook.WebhookCommand;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.webhook.WebhookApplicationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "course/webhook", produces = "application/vnd.api.v1+json")
public class WebhookController {
    private final WebhookApplicationService webhookApplicationService;

    @PostMapping("/receive")
    public void receiveWebhook(@RequestBody WebhookCommand webhookCommand) throws JsonProcessingException {
        log.info("Received webhook");
        webhookApplicationService.receiveWebhook(webhookCommand);
    }

}
