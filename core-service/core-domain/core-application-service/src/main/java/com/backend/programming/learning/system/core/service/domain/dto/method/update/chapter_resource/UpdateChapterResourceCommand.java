package com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter_resource;

import com.backend.programming.learning.system.core.service.domain.valueobject.ResourceType;
import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateChapterResourceCommand {
    private final Integer no;
    private final String title;
    @EnumValidator(enumClass = ResourceType.class, message = "ResourceType is invalid")
    private final String resourceType;
    private final UUID questionId;
    private final String lessonHtml;
    private final String lessonVideo;
}
