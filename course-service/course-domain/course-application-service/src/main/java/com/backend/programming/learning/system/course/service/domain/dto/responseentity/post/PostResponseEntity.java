package com.backend.programming.learning.system.course.service.domain.dto.responseentity.post;

import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.course.service.domain.valueobject.PostId;
import lombok.Builder;

/**
 * com.backend.programming.learning.system.dto.responseentity.post
 * Create by Dang Ngoc Tien
 * Date 4/19/2024 - 1:29 AM
 * Description: ...
 */
@Builder
public record PostResponseEntity(
        PostId postId,
        String title,
        String content,
        String summary,
        Boolean isPublished,
        UserId createdBy
) {
}
