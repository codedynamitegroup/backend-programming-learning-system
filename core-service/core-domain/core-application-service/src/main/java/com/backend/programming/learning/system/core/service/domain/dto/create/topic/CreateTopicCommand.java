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
    @NotNull
    private final String name;
    @NotNull
    private final String description;
    @NotNull
    private final List<UUID> programmingLanguageIds;
    @NotNull
    private final UUID createdBy;
    @NotNull
    private final UUID updatedBy;
}
