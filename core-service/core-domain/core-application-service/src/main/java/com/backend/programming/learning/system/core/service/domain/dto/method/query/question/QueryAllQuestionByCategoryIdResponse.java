package com.backend.programming.learning.system.core.service.domain.dto.method.query.question;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * com.backend.programming.learning.system.core.service.domain.dto.method.query.question
 * Create by Dang Ngoc Tien
 * Date 5/29/2024 - 2:57 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QueryAllQuestionByCategoryIdResponse {
    private final List<QuestionResponseEntity> questionResponses;
    private final int currentPage;
    private final long totalItems;
    private final int totalPages;
}
