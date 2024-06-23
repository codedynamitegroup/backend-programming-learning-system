package com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseResponseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class QueryAllMyCompletedCertificateCoursesResponse {
    @NotNull
    @JsonProperty("certificateCourses")
    private final List<CertificateCourseResponseEntity> certificateCourses;
    @NotNull
    @JsonProperty("currentPage")
    private final int currentPage;
    @NotNull
    @JsonProperty("totalItems")
    private final long totalItems;
    @NotNull
    @JsonProperty("totalPages")
    private final int totalPages;

}
