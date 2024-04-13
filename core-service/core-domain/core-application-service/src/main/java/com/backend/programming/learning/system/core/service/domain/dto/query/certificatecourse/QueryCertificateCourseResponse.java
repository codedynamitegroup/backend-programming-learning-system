package com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class QueryCertificateCourseResponse {
    @NotNull
    private final CertificateCourse certificateCourse;
    @NotNull
    private final String message;
}
