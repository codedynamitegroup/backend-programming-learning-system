package com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.QuestionResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateChapterResponse {
    @NotNull
    private final UUID chapterId;
    @NotNull
    private final UUID certificateCourseId;
    @NotNull
    private final Integer no;
    @NotNull
    private final String title;
    @NotNull
    private final String description;
    @NotNull
    private final List<QuestionResponseEntity> questions;
    @NotNull
    private final String message;
}
