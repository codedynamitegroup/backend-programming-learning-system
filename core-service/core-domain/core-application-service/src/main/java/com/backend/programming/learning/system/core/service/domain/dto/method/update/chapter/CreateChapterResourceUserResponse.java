package com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateChapterResourceUserResponse {
    @NotNull
    private final UUID chapterResourceId;
    @NotNull
    private final UUID userId;
    @NotNull
    private final Boolean isViewed;
}
