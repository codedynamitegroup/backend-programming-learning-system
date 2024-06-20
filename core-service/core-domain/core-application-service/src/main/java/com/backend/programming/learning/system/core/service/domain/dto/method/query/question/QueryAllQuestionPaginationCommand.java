package com.backend.programming.learning.system.core.service.domain.dto.method.query.question;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record QueryAllQuestionPaginationCommand(
        String qtype,
        @NotNull int pageNo,
        @NotNull int pageSize,
        @NotNull String searchName
) {
}
