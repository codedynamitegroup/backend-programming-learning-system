package com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_resource;

import com.backend.programming.learning.system.core.service.domain.valueobject.ResourceType;
import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateChapterResourceResponse {
    private final UUID chapterResourceId;
    private final UUID chapterId;
    private final String title;
    private final Integer no;
    private final String resourceType;
    private final UUID questionId;
    private final String lessonHtml;
    private final String lessonVideo;
    private final String message;
}
