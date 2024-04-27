package com.backend.programming.learning.system.core.service.domain.implement.service.plagiarismdetectionreport;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.plagiarismdetectionreport.DeletePlagiarismDetectionReportCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.plagiarismdetectionreport.DeletePlagiarismDetectionReportResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryAllPlagiarismDetectionReportsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryAllPlagiarismDetectionReportsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryPlagiarismDetectionReportCommand;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.plagiarismdetectionreport.PlagiarismDetectionReportResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.PlagiarismDetectionReport;
import com.backend.programming.learning.system.core.service.domain.mapper.plagiarismdetectionreport.PlagiarismDetectionReportDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class PlagiarismDetectionReportCommandHandler {
    private final PlagiarismDetectionReportQueryHelper plagiarismDetectionReportQueryHelper;
    private final PlagiarismDetectionReportDeleteHelper plagiarismDetectionReportDeleteHelper;
    private final PlagiarismDetectionReportDataMapper plagiarismDetectionReportDataMapper;

    public PlagiarismDetectionReportCommandHandler(
            PlagiarismDetectionReportQueryHelper plagiarismDetectionReportQueryHelper,
            PlagiarismDetectionReportDeleteHelper plagiarismDetectionReportDeleteHelper,
            PlagiarismDetectionReportDataMapper plagiarismDetectionReportDataMapper) {
        this.plagiarismDetectionReportQueryHelper = plagiarismDetectionReportQueryHelper;
        this.plagiarismDetectionReportDeleteHelper = plagiarismDetectionReportDeleteHelper;
        this.plagiarismDetectionReportDataMapper = plagiarismDetectionReportDataMapper;
    }

    @Transactional(readOnly = true)
    public PlagiarismDetectionReportResponseEntity queryPlagiarismDetectionReportResponse(
            QueryPlagiarismDetectionReportCommand queryPlagiarismDetectionReportCommand) {
        PlagiarismDetectionReport plagiarismDetectionReport = plagiarismDetectionReportQueryHelper
                .queryPlagiarismDetectionReportById(
                        queryPlagiarismDetectionReportCommand.getPlagiarismDetectionReportId());

        log.info("Returning plagiarism detection report: {}", plagiarismDetectionReport);

        return plagiarismDetectionReportDataMapper
                .plagiarismDetectionReportToPlagiarismDetectionReportResponse(plagiarismDetectionReport);
    }

    @Transactional(readOnly = true)
    public QueryAllPlagiarismDetectionReportsResponse queryAllPlagiarismDetectionReportsResponse(
            QueryAllPlagiarismDetectionReportsCommand queryAllPlagiarismDetectionReportsCommand) {
        Page<PlagiarismDetectionReport> plagiarismDetectionReport = plagiarismDetectionReportQueryHelper
                .queryAllPlagiarismDetectionReportsByExamId(
                        queryAllPlagiarismDetectionReportsCommand.getExamId(),
                        queryAllPlagiarismDetectionReportsCommand.getPageNo(),
                        queryAllPlagiarismDetectionReportsCommand.getPageSize(),
                        queryAllPlagiarismDetectionReportsCommand.getFetchAll());

        return plagiarismDetectionReportDataMapper
                .plagiarismDetectionReportsToQueryAllPlagiarismDetectionReportsResponse(plagiarismDetectionReport);
    }

    @Transactional
    public DeletePlagiarismDetectionReportResponse deletePlagiarismDetectionReportResponse(
            DeletePlagiarismDetectionReportCommand deletePlagiarismDetectionReportCommand) {
        plagiarismDetectionReportDeleteHelper
                .deletePlagiarismDetectionReportById(deletePlagiarismDetectionReportCommand);

        log.info("Plagiarism Detection Report deleted with id: {}",
                deletePlagiarismDetectionReportCommand.getPlagiarismDetectionReportId());

        return DeletePlagiarismDetectionReportResponse.builder()
                .plagiarismDetectionReportId(deletePlagiarismDetectionReportCommand.getPlagiarismDetectionReportId())
                .message("Plagiarism Detection Report deleted successfully")
                .build();
    }

}
