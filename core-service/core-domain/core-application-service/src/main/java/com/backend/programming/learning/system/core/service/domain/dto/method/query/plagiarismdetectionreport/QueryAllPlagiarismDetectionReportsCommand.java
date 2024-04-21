package com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllPlagiarismDetectionReportsCommand {
    @NotNull
    private final UUID examId;
    @NotNull
    private final int pageNo;
    @NotNull
    private final int pageSize;
    private final Boolean fetchAll;

}
