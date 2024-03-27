package com.backend.programming.learning.system.course.service.domain.dto.question.get;

import com.backend.programming.learning.system.course.service.domain.entity.question.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.question.get
 * Create by Dang Ngoc Tien
 * Date 3/27/2024 - 10:48 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QuestionResponse {
    private final List<Question> questions;
    private final String message;
}
