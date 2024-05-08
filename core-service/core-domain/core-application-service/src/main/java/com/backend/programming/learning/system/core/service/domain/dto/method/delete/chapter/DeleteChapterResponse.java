package com.backend.programming.learning.system.core.service.domain.dto.method.delete.chapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteChapterResponse {
    @NotNull
    private final UUID chapterId;
    @NotNull
    private final String message;
}
