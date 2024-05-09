package com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.QuestionResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class ChapterResponseEntity {
    @NotNull
    private final UUID chapterId;
    @NotNull
    private final UUID certificateCourseId;
    @NotNull
    private final int no;
    @NotNull
    private final String title;
    @NotNull
    private final String description;
    @NotNull
    private final List<QuestionResponseEntity> questions;
    @NotNull
    private final UserResponseEntity createdBy;
    @NotNull
    private final UserResponseEntity updatedBy;
    @NotNull
    private final ZonedDateTime createdAt;
    @NotNull
    private final ZonedDateTime updatedAt;

}
