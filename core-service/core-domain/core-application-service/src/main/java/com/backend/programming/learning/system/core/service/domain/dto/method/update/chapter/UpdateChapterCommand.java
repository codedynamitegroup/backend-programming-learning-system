package com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_resource.CreateChapterResourceCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter_resource.UpdateChapterResourceCommand;
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
public class UpdateChapterCommand {
    @NotNull(message = "Title is required")
    private final String title;
    @NotNull(message = "No is required")
    @Min(1)
    private final Integer no;
    @NotNull(message = "description is required")
    private final String description;
    private final List<UpdateChapterResourceCommand> resources;
}
