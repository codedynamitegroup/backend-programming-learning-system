package com.backend.programming.learning.system.dto.method.query.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.query.post
 * Create by Dang Ngoc Tien
 * Date 4/19/2024 - 1:31 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QueryPostCommand {
    private final UUID postId;
}
