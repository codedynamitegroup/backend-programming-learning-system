package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseProgrammingLanguageId;
import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class CertificateCourseProgrammingLanguage extends AggregateRoot<CertificateCourseProgrammingLanguageId> {
    private CertificateCourseId certificateCourseId;
    private ProgrammingLanguageId programmingLanguageId;

    private CertificateCourseProgrammingLanguage(Builder builder) {
        super.setId(builder.certificateCourseProgrammingLanguageId);
        certificateCourseId = builder.certificateCourseId;
        programmingLanguageId = builder.programmingLanguageId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public CertificateCourseId getCertificateCourseId() {
        return certificateCourseId;
    }

    public ProgrammingLanguageId getProgrammingLanguageId() {
        return programmingLanguageId;
    }

    public static final class Builder {
        private CertificateCourseProgrammingLanguageId certificateCourseProgrammingLanguageId;
        private CertificateCourseId certificateCourseId;
        private ProgrammingLanguageId programmingLanguageId;

        private Builder() {
        }

        public Builder id(CertificateCourseProgrammingLanguageId val) {
            certificateCourseProgrammingLanguageId = val;
            return this;
        }

        public Builder certificateCourseId(CertificateCourseId val) {
            certificateCourseId = val;
            return this;
        }

        public Builder programmingLanguageId(ProgrammingLanguageId val) {
            programmingLanguageId = val;
            return this;
        }

        public CertificateCourseProgrammingLanguage build() {
            return new CertificateCourseProgrammingLanguage(this);
        }
    }
}
