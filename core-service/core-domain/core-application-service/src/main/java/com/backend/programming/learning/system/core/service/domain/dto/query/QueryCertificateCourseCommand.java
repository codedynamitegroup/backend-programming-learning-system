package com.backend.programming.learning.system.core.service.domain.dto.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryCertificateCourseCommand {
    @NotNull
    private final UUID certificateCourseId;
}
