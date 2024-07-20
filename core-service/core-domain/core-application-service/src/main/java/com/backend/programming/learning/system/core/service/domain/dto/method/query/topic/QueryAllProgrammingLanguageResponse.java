package com.backend.programming.learning.system.core.service.domain.dto.method.query.topic;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.programminglanguage.ProgrammingLanguageIdResponseEntity;
import lombok.Builder;

import java.util.List;

@Builder
public record QueryAllProgrammingLanguageResponse(
        List<ProgrammingLanguageIdResponseEntity> programmingLanguages,
        int currentPage,
        long totalItems,
        int totalPages
) { }
