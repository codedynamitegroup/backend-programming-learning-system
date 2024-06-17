package com.backend.programming.learning.system.core.service.domain.dto.method.query.question;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QtypeCodeQuestionResponseEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllAdminQtypeCodeQuestionsResponse {
    private final List<QtypeCodeQuestionResponseEntity> qtypeCodeQuestions;
    @NotNull
    private final int currentPage;
    @NotNull
    private final long totalItems;
    @NotNull
    private final int totalPages;
}
