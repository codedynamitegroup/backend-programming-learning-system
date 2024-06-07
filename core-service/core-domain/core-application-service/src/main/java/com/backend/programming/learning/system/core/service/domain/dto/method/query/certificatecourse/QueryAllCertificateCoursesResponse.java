package com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.GeneralCertificateCourseResponseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import jakarta.validation.constraints.NotNull;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class QueryAllCertificateCoursesResponse {
    @NotNull
    @JsonProperty("certificateCourses")
    private final List<GeneralCertificateCourseResponseEntity> certificateCourses;

}
