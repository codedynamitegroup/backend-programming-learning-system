package com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateChapterQuestionCommand {
    @NotNull(message = "QuestionId is required")
    private final UUID questionId;
    @NotNull(message = "ChapterId is required")
    private final UUID chapterId;
}
