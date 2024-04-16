package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.WebhookApiFunctionId;

public class WebhookApiFunction extends AggregateRoot<WebhookApiFunctionId> {
        private String area;
        private String name;
        private String description;

        private WebhookApiFunction(Builder builder) {
            super.setId(builder.webhookApiFunctionId);
            area = builder.area;
            name = builder.name;
            description = builder.description;
        }

        public static Builder builder() {
            return new Builder();
        }

    public String getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static final class Builder {
            private WebhookApiFunctionId webhookApiFunctionId;
            private String area;
            private String name;
            private String description;

            private Builder() {
            }

            public static Builder newBuilder() {
                return new Builder();
            }

            public Builder id(WebhookApiFunctionId val) {
                webhookApiFunctionId = val;
                return this;
            }

            public Builder area(String val) {
                area = val;
                return this;
            }

            public Builder name(String val) {
                name = val;
                return this;
            }

            public Builder description(String val) {
                description = val;
                return this;
            }

            public WebhookApiFunction build() {
                return new WebhookApiFunction(this);
            }
        }
}
