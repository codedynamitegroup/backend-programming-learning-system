package com.backend.programming.learning.system.core.service.domain.dto.create.topic;

import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateTopicCommand {
    @NotNull(message = "name is required")
    private final String name;
    @NotNull(message = "skillLevel is required")
    private final String description;
    @NotNull(message = "programmingLanguageIds is required")
    private final List<UUID> programmingLanguageIds;
    @NotNull(message = "createdBy is required")
    private final UUID createdBy;
    @NotNull(message = "updatedBy is required")
    private final UUID updatedBy;
}
