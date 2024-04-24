package com.backend.programming.learning.system.dto.method.query.post;

import com.backend.programming.learning.system.dto.responseentity.post.PostResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * com.backend.programming.learning.system.dto.method.query.post
 * Create by Dang Ngoc Tien
 * Date 4/19/2024 - 1:31 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QueryAllPostResponse {
    private List<PostResponseEntity> posts;
    private final int currentPage;
    private final long totalItems;
    private final int totalPages;
}
