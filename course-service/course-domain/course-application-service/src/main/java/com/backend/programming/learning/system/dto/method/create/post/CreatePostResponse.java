package com.backend.programming.learning.system.dto.method.create.post;

import com.backend.programming.learning.system.valueobject.CourseId;
import com.backend.programming.learning.system.valueobject.PostId;
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
public class CreatePostResponse {
    private PostId id;
    private CourseId courseId;
    private String title;
    private String content;
    private String summary;
    private Boolean isPublished;
    private String message;
}
