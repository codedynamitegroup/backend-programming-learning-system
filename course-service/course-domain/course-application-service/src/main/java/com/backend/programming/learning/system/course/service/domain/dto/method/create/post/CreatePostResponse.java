package com.backend.programming.learning.system.course.service.domain.dto.method.create.post;

import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.PostId;
import lombok.Builder;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.post.create
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 1:14 AM
 * Description: ...
 */
@Builder
public record CreatePostResponse(
        PostId id,
        CourseId courseId,
        String title,
        String content,
        String summary,
        Boolean isPublished,
        String message
) {
}
