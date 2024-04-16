package com.backend.programming.learning.system.core.service.domain.dto.create.chapter;

import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
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
    private final String message;
}
