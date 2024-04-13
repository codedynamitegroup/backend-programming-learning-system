package com.backend.programming.learning.system.core.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCertificateCourseUserCommand {
    @NotNull
    private final UUID certificateCourseId;
    @NotNull
    private final UUID userId;
}
