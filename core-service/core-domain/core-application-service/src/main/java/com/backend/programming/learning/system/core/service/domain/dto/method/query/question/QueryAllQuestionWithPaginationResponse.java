package com.backend.programming.learning.system.core.service.domain.dto.method.query.question;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.GetAllQuestionPaginationResponseEntity;
import lombok.Builder;

import java.util.List;

@Builder
public record QueryAllQuestionWithPaginationResponse(
        List<GetAllQuestionPaginationResponseEntity> questions,
        int currentPage,
        long totalItems,
        int totalPages) { }
