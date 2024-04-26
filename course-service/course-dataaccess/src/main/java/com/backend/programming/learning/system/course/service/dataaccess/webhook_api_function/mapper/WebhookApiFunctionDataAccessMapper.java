package com.backend.programming.learning.system.course.service.dataaccess.webhook_api_function.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.webhook_api_function.entity.WebhookApiFunctionEntity;
import com.backend.programming.learning.system.course.service.domain.entity.WebhookApiFunction;
import com.backend.programming.learning.system.course.service.domain.valueobject.WebhookApiFunctionId;
import org.springframework.stereotype.Component;

@Component
public class WebhookApiFunctionDataAccessMapper {
    public WebhookApiFunctionEntity webhookApiFunctionToWebhookApiFunctionEntity(WebhookApiFunction webhookApiFunction) {
        return WebhookApiFunctionEntity.builder()
                .id(webhookApiFunction.getId().getValue())
                .area(webhookApiFunction.getArea())
                .name(webhookApiFunction.getName())
                .description(webhookApiFunction.getDescription())
                .build();
    }

    public WebhookApiFunction webhookApiFunctionEntityToWebhookApiFunction(WebhookApiFunctionEntity webhookApiFunctionEntity) {
        return WebhookApiFunction.builder()
                .id(new WebhookApiFunctionId(webhookApiFunctionEntity.getId()))
                .area(webhookApiFunctionEntity.getArea())
                .name(webhookApiFunctionEntity.getName())
                .description(webhookApiFunctionEntity.getDescription())
                .build();
    }
}
