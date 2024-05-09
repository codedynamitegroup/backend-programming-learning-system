package com.backend.programming.learning.system.core.service.domain.dto.method.delete.plagiarismdetectionreport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeletePlagiarismDetectionReportResponse {
    @NotNull
    private final UUID plagiarismDetectionReportId;
    @NotNull
    private final String message;
}
