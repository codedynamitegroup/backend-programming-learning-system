package com.backend.programming.learning.system.course.service.domain.dto.method.query.module;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryModuleCommand {
    @NotNull
    private final UUID sectionId;
}
