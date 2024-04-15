package com.backend.programming.learning.system.core.service.domain.dto.create.chapter_question;

import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateChapterQuestionResponse {
    @NotNull
    private final ChapterQuestion chapterQuestion;
    @NotNull
    private final String message;
}
