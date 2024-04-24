package com.backend.programming.learning.system.dto.responseentity.post;

import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.valueobject.PostId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * com.backend.programming.learning.system.dto.responseentity.post
 * Create by Dang Ngoc Tien
 * Date 4/19/2024 - 1:29 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class PostResponseEntity {
    private PostId postId;
    private String title;
    private String content;
    private String summary;
    private Boolean isPublished;
    private UserId createdBy;
}
