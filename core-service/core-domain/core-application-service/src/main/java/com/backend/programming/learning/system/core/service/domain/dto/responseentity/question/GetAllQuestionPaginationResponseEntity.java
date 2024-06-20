package com.backend.programming.learning.system.core.service.domain.dto.responseentity.question;

import lombok.Builder;

@Builder
public record GetAllQuestionPaginationResponseEntity(
        String questionId,
        String name,
        String difficulty,
        String questionText) { }
