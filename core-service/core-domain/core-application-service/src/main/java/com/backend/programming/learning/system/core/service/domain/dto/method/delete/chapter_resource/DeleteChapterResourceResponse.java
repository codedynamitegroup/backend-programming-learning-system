package com.backend.programming.learning.system.core.service.domain.dto.method.delete.chapter_resource;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteChapterResourceResponse {
    @NotNull
    private final UUID chapterResourceId;
    @NotNull
    private final String message;
}
