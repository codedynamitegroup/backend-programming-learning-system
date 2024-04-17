package com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCertificateCourseResponse {
    @NotNull
    private final UUID certificateCourseId;
    @NotNull
    private final String name;
    @NotNull
    private final String message;
}
