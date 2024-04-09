package com.backend.programming.learning.system.course.service.domain.dto.exam.get;

import com.backend.programming.learning.system.course.service.domain.entity.exam.Exam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.get
 * Create by Dang Ngoc Tien
 * Date 3/24/2024 - 10:13 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class ExamsResponse {
    private final List<Exam> exams;
    private final String message;
}
