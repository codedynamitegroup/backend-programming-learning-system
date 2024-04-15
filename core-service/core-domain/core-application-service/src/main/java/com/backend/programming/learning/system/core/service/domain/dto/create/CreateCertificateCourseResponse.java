package com.backend.programming.learning.system.core.service.domain.dto.create;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateCertificateCourseResponse {
    @NotNull
    private final CertificateCourse certificateCourse;
    @NotNull
    private final String message;
}
