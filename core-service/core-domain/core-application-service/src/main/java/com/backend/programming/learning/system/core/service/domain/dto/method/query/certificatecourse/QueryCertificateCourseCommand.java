package com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryCertificateCourseCommand {
    @NotNull
    private final UUID certificateCourseId;
    private final String username;
}
