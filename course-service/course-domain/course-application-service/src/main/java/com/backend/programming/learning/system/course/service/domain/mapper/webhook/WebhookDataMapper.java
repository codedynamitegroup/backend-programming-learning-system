package com.backend.programming.learning.system.course.service.domain.mapper.webhook;

import com.backend.programming.learning.system.course.service.domain.dto.method.webhook.WebhookCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.WebhookMessage;
import com.backend.programming.learning.system.domain.valueobject.WebhookEventName;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WebhookDataMapper {
    public WebhookMessage webhookCommandToWebhookMessage(WebhookCommand webhookCommand) {
        return WebhookMessage.builder()
                .eventName(lookupWebhookEventNameByLabel(webhookCommand.getEventname()))
                .component(webhookCommand.getComponent())
                .action(webhookCommand.getAction())
                .target(webhookCommand.getTarget())
                .objectId(webhookCommand.getObjectid())
                .objectTable(webhookCommand.getObjecttable())
                .crud(webhookCommand.getCrud())
                .eduLevel(webhookCommand.getEdulevel())
                .contextId(webhookCommand.getContextid())
                .contextLevel(webhookCommand.getContextlevel())
                .contextInstanceId(webhookCommand.getContextinstanceid())
                .userId(webhookCommand.getUserid())
                .courseId(webhookCommand.getCourseid())
                .relatedUserId(webhookCommand.getRelateduserid())
                .anonymous(webhookCommand.getAnonymous())
                .other(webhookCommand.getOther())
                .timeCreated(webhookCommand.getTimecreated())
                .host(webhookCommand.getHost())
                .token(webhookCommand.getToken())
                .extra(webhookCommand.getExtra())
                .build();
    }

    private WebhookEventName lookupWebhookEventNameByLabel(String eventName) {
        for (WebhookEventName e : WebhookEventName.values()) {
            if (e.getLabel().equals(eventName)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Invalid event name: " + eventName);
    }

    public Course webhookCommandToCourse(WebhookCommand webhookCommand) {
        Map<String, Object> courseData = webhookCommand.getOther();

        return null;
    }
}
