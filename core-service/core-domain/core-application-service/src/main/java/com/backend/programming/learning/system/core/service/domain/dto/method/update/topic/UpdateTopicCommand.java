package com.backend.programming.learning.system.core.service.domain.dto.method.update.topic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateTopicCommand {
    @NotNull
    private final UUID topicId;
    private final String name;
    private final String description;
    private final List<UUID> programmingLanguageIds;
    @NotNull
    private final UUID updatedBy;
}
