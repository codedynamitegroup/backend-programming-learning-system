package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;

public class CodeSubmissionCertificateCourse extends BaseEntity<CodeSubmissionId> {
    private CertificateCourseId certificateCourseId;

    private CodeSubmissionCertificateCourse(Builder builder) {
        super.setId(builder.codeSubmissionId);
        setCertificateCourseId(builder.certificateCourseId);
    }

    public static Builder builder() {
        return new Builder();
    }


    public CertificateCourseId getCertificateCourseId() {
        return certificateCourseId;
    }

    public void setCertificateCourseId(CertificateCourseId certificateCourseId) {
        this.certificateCourseId = certificateCourseId;
    }

    public static final class Builder {
        private CodeSubmissionId codeSubmissionId;
        private CertificateCourseId certificateCourseId;

        private Builder() {
        }

        public Builder id(CodeSubmissionId val) {
            codeSubmissionId = val;
            return this;
        }

        public Builder certificateCourseId(CertificateCourseId val) {
            certificateCourseId = val;
            return this;
        }

        public CodeSubmissionCertificateCourse build() {
            return new CodeSubmissionCertificateCourse(this);
        }
    }
}
