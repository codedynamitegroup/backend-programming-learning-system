package com.backend.programming.learning.system.dto.method.query.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.query.question
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 2:24 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QueryQuestionCommand {
    private final UUID questionId;
}
