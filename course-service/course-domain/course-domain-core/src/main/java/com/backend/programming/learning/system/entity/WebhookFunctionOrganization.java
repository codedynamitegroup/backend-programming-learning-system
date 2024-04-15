package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.valueobject.WebhookApiFunctionId;
import com.backend.programming.learning.system.valueobject.WebhookFunctionOrganizationId;

public class WebhookFunctionOrganization extends AggregateRoot<WebhookFunctionOrganizationId> {
    private OrganizationId organizationId;
    private WebhookApiFunctionId webhookApiFunctionId;

    private WebhookFunctionOrganization(Builder builder) {
        super.setId(builder.webhookFunctionOrganizationId);
        organizationId = builder.organizationId;
        webhookApiFunctionId = builder.webhookApiFunctionId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public OrganizationId getOrganizationId() {
        return organizationId;
    }

    public WebhookApiFunctionId getWebhookApiFunctionId() {
        return webhookApiFunctionId;
    }

    public static final class Builder {
        private WebhookFunctionOrganizationId webhookFunctionOrganizationId;
        private OrganizationId organizationId;
        private WebhookApiFunctionId webhookApiFunctionId;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(WebhookFunctionOrganizationId val) {
            webhookFunctionOrganizationId = val;
            return this;
        }

        public Builder organizationId(OrganizationId val) {
            organizationId = val;
            return this;
        }

        public Builder webhookApiFunctionId(WebhookApiFunctionId val) {
            webhookApiFunctionId = val;
            return this;
        }

        public WebhookFunctionOrganization build() {
            return new WebhookFunctionOrganization(this);
        }
    }
}
