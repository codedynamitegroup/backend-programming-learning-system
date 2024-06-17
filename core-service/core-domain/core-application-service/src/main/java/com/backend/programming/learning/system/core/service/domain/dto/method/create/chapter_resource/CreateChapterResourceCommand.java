package com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_resource;

import com.backend.programming.learning.system.core.service.domain.valueobject.ResourceType;
import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateChapterResourceCommand {
    @NotNull(message = "ChapterId is required")
    private final UUID chapterId;
    @NotNull(message = "Title is required")
    private final String title;
    @NotNull(message = "resourceType is required")
    @EnumValidator(enumClass = ResourceType.class, message = "ResourceType is invalid")
    private final String resourceType;
    private final UUID questionId;
    private final String lessonHtml;
    private final String lessonVideo;
    private final String email;
}
