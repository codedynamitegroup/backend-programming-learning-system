package com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseResponseEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllMyCompletedCertificateCoursesCommand {
    @NotNull(message = "Email is required")
    private String email;
    @NotNull(message = "pageNo is required")
    private final int pageNo;
    @NotNull(message = "pageSize is required")
    private final int pageSize;
}
