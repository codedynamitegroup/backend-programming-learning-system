package com.backend.programming.learning.system.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class WebhookFunctionOrganizationId extends BaseId<UUID> {
    public WebhookFunctionOrganizationId(UUID value) {
        super(value);
    }
}
