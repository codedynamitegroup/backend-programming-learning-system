package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicProgrammingLanguageId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;

public class TopicProgrammingLanguage extends AggregateRoot<TopicProgrammingLanguageId> {
    private TopicId topicId;
    private ProgrammingLanguageId programmingLanguageId;

    private TopicProgrammingLanguage(Builder builder) {
        super.setId(builder.topicProgrammingLanguageId);
        topicId = builder.topicId;
        programmingLanguageId = builder.programmingLanguageId;
    }

    public static Builder builder() {
        return new Builder();
    }


    public TopicId getTopicId() {
        return topicId;
    }

    public ProgrammingLanguageId getProgrammingLanguageId() {
        return programmingLanguageId;
    }

    public static final class Builder {
        private TopicProgrammingLanguageId topicProgrammingLanguageId;
        private TopicId topicId;
        private ProgrammingLanguageId programmingLanguageId;

        private Builder() {
        }

        public Builder id(TopicProgrammingLanguageId val) {
            topicProgrammingLanguageId = val;
            return this;
        }

        public Builder topicId(TopicId val) {
            topicId = val;
            return this;
        }

        public Builder programmingLanguageId(ProgrammingLanguageId val) {
            programmingLanguageId = val;
            return this;
        }

        public TopicProgrammingLanguage build() {
            return new TopicProgrammingLanguage(this);
        }
    }
}
