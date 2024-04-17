package com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllCertificateCourseUsersCommand {
    @NotNull
    private final UUID certificateCourseId;
    @NotNull
    private final int pageNo;
    @NotNull
    private final int pageSize;
    @NotNull
    private final Boolean fetchAll;
}
