package com.backend.programming.learning.system.dto.method.create.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.post.create
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 1:14 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class CreatePostCommand {
    private UUID courseId;
    @NotNull(message = "Post title is required")
    private String title;
    private String content;
    private String summary;
    @NotNull(message = "Post type is required")
    private Boolean isPublished;
    @NotNull(message = "Created by is required")
    private UUID createdBy;
}
