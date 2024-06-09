package com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateChapterCommand {
    @NotNull
    private final UUID chapterId;
    @Min(1)
    private final Integer no;
    private final String title;
    private final String description;
    private final String email;
}
