package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseTopicId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

import java.util.UUID;

public class CertificateCourseTopic extends AggregateRoot<CertificateCourseTopicId> {
    private CertificateCourseId certificateCourseId;
    private TopicId topicId;

    public void initializeCertificateCourse() {
        setId(new CertificateCourseTopicId(UUID.randomUUID()));
    }

    private CertificateCourseTopic(Builder builder) {
        super.setId(builder.certificateCourseTopicId);
        certificateCourseId = builder.certificateCourseId;
        topicId = builder.topicId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public CertificateCourseId getCertificateCourseId() {
        return certificateCourseId;
    }

    public TopicId getTopicId() {
        return topicId;
    }

    public static final class Builder {
        private CertificateCourseTopicId certificateCourseTopicId;
        private CertificateCourseId certificateCourseId;
        private TopicId topicId;

        private Builder() {
        }

        public Builder id(CertificateCourseTopicId val) {
            certificateCourseTopicId = val;
            return this;
        }

        public Builder certificateCourseId(CertificateCourseId val) {
            certificateCourseId = val;
            return this;
        }

        public Builder topicId(TopicId val) {
            topicId = val;
            return this;
        }

        public CertificateCourseTopic build() {
            return new CertificateCourseTopic(this);
        }
    }
}
