package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicProgrammingLanguageId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;

public class TopicProgrammingLanguage extends AggregateRoot<TopicProgrammingLanguageId> {
    private Topic topic;
    private ProgrammingLanguage programmingLanguage;

    private TopicProgrammingLanguage(Builder builder) {
        super.setId(builder.topicProgrammingLanguageId);
        topic = builder.topic;
        programmingLanguage = builder.programmingLanguage;
    }

    public static Builder builder() {
        return new Builder();
    }


    public Topic getTopic() {
        return topic;
    }

    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }

    public static final class Builder {
        private TopicProgrammingLanguageId topicProgrammingLanguageId;
        private Topic topic;
        private ProgrammingLanguage programmingLanguage;

        private Builder() {
        }

        public Builder id(TopicProgrammingLanguageId val) {
            topicProgrammingLanguageId = val;
            return this;
        }

        public Builder topic(Topic val) {
            topic = val;
            return this;
        }

        public Builder programmingLanguage(ProgrammingLanguage val) {
            programmingLanguage = val;
            return this;
        }

        public TopicProgrammingLanguage build() {
            return new TopicProgrammingLanguage(this);
        }
    }
}
