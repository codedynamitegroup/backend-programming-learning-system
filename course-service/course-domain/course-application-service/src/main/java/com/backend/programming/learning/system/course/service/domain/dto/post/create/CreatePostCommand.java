package com.backend.programming.learning.system.course.service.domain.dto.post.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

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
    private final Long courseId;
    private final String title;
    private final String summary;
    private final String content;
    private final Boolean publishState;
}
