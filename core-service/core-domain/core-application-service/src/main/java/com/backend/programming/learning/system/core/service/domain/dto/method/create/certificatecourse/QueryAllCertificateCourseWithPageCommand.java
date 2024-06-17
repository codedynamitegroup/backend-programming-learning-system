package com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record QueryAllCertificateCourseWithPageCommand(
        @NotNull int pageNo,
        @NotNull int pageSize,
        @NotNull String searchName) { }
