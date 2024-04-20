package com.backend.programming.learning.system.dto.method.delete.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.delete.post
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 11:27 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class DeleteQuestionCommand {
    private final UUID questionId;
}
