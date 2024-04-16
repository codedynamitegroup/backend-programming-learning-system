package com.backend.programming.learning.system.dto.create;

import com.backend.programming.learning.system.valueobject.CourseId;
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
    private CourseId courseId;
    private String title;
    private String content;
    private String summary;
    private Boolean isPublished;
}
