package com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_resource.CreateChapterResourceCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateChapterCommand {
    @NotNull(message = "Title is required")
    private final String title;
    @NotNull(message = "No is required")
    private final Integer no;
    @NotNull(message = "Description is required")
    private final String description;
    private final List<CreateChapterResourceCommand> resources;
}
