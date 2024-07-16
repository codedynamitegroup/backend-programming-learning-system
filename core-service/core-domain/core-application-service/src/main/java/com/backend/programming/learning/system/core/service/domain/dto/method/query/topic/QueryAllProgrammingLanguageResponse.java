package com.backend.programming.learning.system.core.service.domain.dto.method.query.topic;

import com.backend.programming.learning.system.core.service.domain.entity.ProgrammingLanguage;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
public record QueryAllProgrammingLanguageResponse(
        List<ProgrammingLanguage> programmingLanguages,
        int currentPage,
        long totalItems,
        int totalPages
) { }
