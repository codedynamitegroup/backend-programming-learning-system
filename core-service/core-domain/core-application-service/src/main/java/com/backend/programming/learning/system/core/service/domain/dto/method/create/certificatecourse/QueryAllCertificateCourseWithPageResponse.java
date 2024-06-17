package com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse;


import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseResponseEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllCertificateCourseWithPageResponse {
    @NotNull
    private final List<CertificateCourseResponseEntity> certificateCourses;
    @NotNull
    private final int currentPage;
    @NotNull
    private final long totalItems;
    @NotNull
    private final int totalPages;
}
