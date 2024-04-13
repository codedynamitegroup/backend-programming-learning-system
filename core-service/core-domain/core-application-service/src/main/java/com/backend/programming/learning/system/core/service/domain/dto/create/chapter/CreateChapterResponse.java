package com.backend.programming.learning.system.core.service.domain.dto.create.chapter;

import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateChapterResponse {
    @NotNull
    private final Chapter chapter;
    @NotNull
    private final String message;
}
