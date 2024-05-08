package com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.plagiarismdetectionreport.PlagiarismDetectionReportResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllPlagiarismDetectionReportsResponse {
    @NotNull
    private final List<PlagiarismDetectionReportResponseEntity> plagiarismDetectionReports;
    @NotNull
    private final int currentPage;
    @NotNull
    private final long totalItems;
    @NotNull
    private final int totalPages;

}
