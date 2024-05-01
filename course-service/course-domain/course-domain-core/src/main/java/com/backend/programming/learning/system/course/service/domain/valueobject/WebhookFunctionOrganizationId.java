package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class WebhookFunctionOrganizationId extends BaseId<UUID> {
    public WebhookFunctionOrganizationId(UUID value) {
        super(value);
    }
}
