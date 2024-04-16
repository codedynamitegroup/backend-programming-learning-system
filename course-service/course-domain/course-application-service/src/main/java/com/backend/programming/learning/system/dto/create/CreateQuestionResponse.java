package com.backend.programming.learning.system.dto.create;

import com.backend.programming.learning.system.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.question.create
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 11:06 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class CreateQuestionResponse {
    private final Question question;
    private final String message;
}
