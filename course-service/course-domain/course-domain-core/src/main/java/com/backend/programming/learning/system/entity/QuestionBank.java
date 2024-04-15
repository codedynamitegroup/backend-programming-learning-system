package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.valueobject.QuestionBankId;

public class QuestionBank extends AggregateRoot<QuestionBankId> {

    private OrganizationId organizationId;
    private String name;

    private QuestionBank(Builder builder) {
        super.setId(builder.questionBankId);
        organizationId = builder.organizationId;
        name = builder.name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public OrganizationId getOrganizationId() {
        return organizationId;
    }

    public String getName() {
        return name;
    }

    public static final class Builder {
        private QuestionBankId questionBankId;
        private OrganizationId organizationId;
        private String name;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder questionBank(QuestionBankId val) {
            questionBankId = val;
            return this;
        }

        public Builder organizationId(OrganizationId val) {
            organizationId = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public QuestionBank build() {
            return new QuestionBank(this);
        }
    }
}
