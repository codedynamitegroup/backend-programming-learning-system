package com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllCertificateCoursesCommand {
    @NotNull
    private final int pageNo;
    @NotNull
    private final int pageSize;
}
