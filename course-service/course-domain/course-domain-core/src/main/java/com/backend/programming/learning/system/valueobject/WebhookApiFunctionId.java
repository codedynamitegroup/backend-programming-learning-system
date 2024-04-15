package com.backend.programming.learning.system.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class WebhookApiFunctionId extends BaseId<UUID> {
    public WebhookApiFunctionId(UUID value) {
        super(value);
    }
}
