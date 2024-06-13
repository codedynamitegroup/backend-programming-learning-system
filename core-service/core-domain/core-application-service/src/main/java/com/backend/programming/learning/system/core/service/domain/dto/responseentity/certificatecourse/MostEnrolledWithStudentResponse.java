package com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse;

import java.util.UUID;

public class MostEnrolledWithStudentResponse {
    private UUID certificateCourseId;
    private String certificateCourseName;
    private Long numOfStudents;

    private MostEnrolledWithStudentResponse(Builder builder) {
        certificateCourseId = builder.certificateCourseId;
        certificateCourseName = builder.certificateCourseName;
        numOfStudents = builder.numOfStudents;
    }

    public UUID getCertificateCourseId() {
        return certificateCourseId;
    }

    public String getCertificateCourseName() {
        return certificateCourseName;
    }

    public Long getNumOfStudents() {
        return numOfStudents;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UUID certificateCourseId;
        private String certificateCourseName;
        private Long numOfStudents;

        private Builder() {
        }

        public Builder certificateCourseId(UUID val) {
            certificateCourseId = val;
            return this;
        }

        public Builder certificateCourseName(String val) {
            certificateCourseName = val;
            return this;
        }

        public Builder numOfStudents(Long val) {
            numOfStudents = val;
            return this;
        }

        public MostEnrolledWithStudentResponse build() {
            return new MostEnrolledWithStudentResponse(this);
        }
    }
}
