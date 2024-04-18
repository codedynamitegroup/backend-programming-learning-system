package com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateChapterCommand {
    @NotNull
    private final UUID chapterId;
    private final Integer no;
    private final String title;
    private final String description;
    @NotNull
    private final UUID updatedBy;
}
