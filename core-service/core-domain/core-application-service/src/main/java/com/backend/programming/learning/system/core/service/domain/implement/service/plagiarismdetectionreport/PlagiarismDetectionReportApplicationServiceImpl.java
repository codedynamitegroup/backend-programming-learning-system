package com.backend.programming.learning.system.core.service.domain.implement.service.plagiarismdetectionreport;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.plagiarismdetectionreport.DeletePlagiarismDetectionReportCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.plagiarismdetectionreport.DeletePlagiarismDetectionReportResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryAllPlagiarismDetectionReportsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryAllPlagiarismDetectionReportsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryPlagiarismDetectionReportCommand;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.plagiarismdetectionreport.PlagiarismDetectionReportResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.plagiarismdetectionreport.PlagiarismDetectionReportApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
class PlagiarismDetectionReportApplicationServiceImpl implements PlagiarismDetectionReportApplicationService {
    private final PlagiarismDetectionReportCommandHandler plagiarismDetectionReportCommandHandler;

    public PlagiarismDetectionReportApplicationServiceImpl(PlagiarismDetectionReportCommandHandler plagiarismDetectionReportCommandHandler) {
        this.plagiarismDetectionReportCommandHandler = plagiarismDetectionReportCommandHandler;
    }

    @Override
    public PlagiarismDetectionReportResponseEntity queryPlagiarismDetectionReport(QueryPlagiarismDetectionReportCommand queryPlagiarismDetectionReportCommand) {
        return plagiarismDetectionReportCommandHandler
                .queryPlagiarismDetectionReportResponse(queryPlagiarismDetectionReportCommand);
    }

    @Override
    public QueryAllPlagiarismDetectionReportsResponse queryAllPlagiarismDetectionReports(
            QueryAllPlagiarismDetectionReportsCommand queryAllPlagiarismDetectionReportsCommand) {
        return plagiarismDetectionReportCommandHandler
                .queryAllPlagiarismDetectionReportsResponse(queryAllPlagiarismDetectionReportsCommand);
    }

    @Override
    public DeletePlagiarismDetectionReportResponse deletePlagiarismDetectionReport(DeletePlagiarismDetectionReportCommand deletePlagiarismDetectionReportCommand) {
        return plagiarismDetectionReportCommandHandler
                .deletePlagiarismDetectionReportResponse(deletePlagiarismDetectionReportCommand);
    }
}
