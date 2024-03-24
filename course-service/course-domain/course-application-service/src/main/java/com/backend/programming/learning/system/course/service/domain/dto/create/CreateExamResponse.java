package com.backend.programming.learning.system.course.service.domain.dto.create;

import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * com.backend.programming.learning.system.course.service.domain.create
 * Create by Dang Ngoc Tien
 * Date 3/24/2024 - 2:52 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class CreateExamResponse {
    private final Exam exam;
    private final String message;
}
