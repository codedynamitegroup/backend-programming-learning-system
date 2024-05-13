package com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllCertificateCoursesResponse {
    @NotNull
    private final List<CertificateCourseResponseEntity> mostEnrolledCertificateCourses;
    @NotNull
    private final List<CertificateCourseResponseEntity> certificateCourses;
}
