package com.backend.programming.learning.system.course.service.domain.dto.method.delete.module;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;
@Getter
@Builder
@AllArgsConstructor
public class DeleteModuleCommand {
    @NotNull(message = "Module id is required")
   private UUID moduleId;
}
