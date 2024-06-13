package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.projection;

import java.util.UUID;

public interface MostEnrolledCertificateCourseProjection {
    UUID getCertificateCourseId();
    String getCertificateCourseName();
    Long getNumOfStudents();
}
