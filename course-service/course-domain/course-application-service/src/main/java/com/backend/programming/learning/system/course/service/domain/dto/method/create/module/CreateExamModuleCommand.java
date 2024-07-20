package com.backend.programming.learning.system.course.service.domain.dto.method.create.module;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateExamModuleCommand {
    @NotNull(message = "Section id is required")
    private UUID sectionId;
    @NotNull(message = "Exam id is required")
    private UUID examId;
}
