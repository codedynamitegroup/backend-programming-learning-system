package com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryPlagiarismDetectionReportCommand {
    @NotNull(message = "plagiarismDetectionReport Id is required")
    private final UUID plagiarismDetectionReportId;
}
