package com.backend.programming.learning.system.course.service.domain.dto.method.query.question;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.question.QuestionResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * com.backend.programming.learning.system.dto.method.query.question
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 2:24 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QueryAllQuestionResponse {
    private List<QuestionResponseEntity> questions;
    private int currentPage;
    private long totalItems;
    private int totalPages;
}
