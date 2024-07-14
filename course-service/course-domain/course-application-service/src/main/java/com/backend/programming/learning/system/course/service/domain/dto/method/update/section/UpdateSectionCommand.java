package com.backend.programming.learning.system.course.service.domain.dto.method.update.section;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateSectionCommand {
    @NotNull(message = "Section id is required")
    private UUID sectionId;
    @NotNull(message = "Section name is required")
    private String name;
//    @NotNull(message = "Visible is required")
    private Integer visible;
}
