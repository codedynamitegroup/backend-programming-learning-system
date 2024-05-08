package com.backend.programming.learning.system.core.service.domain.ports.input.service.plagiarismdetectionreport;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.plagiarismdetectionreport.DeletePlagiarismDetectionReportCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.plagiarismdetectionreport.DeletePlagiarismDetectionReportResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryAllPlagiarismDetectionReportsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryAllPlagiarismDetectionReportsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryPlagiarismDetectionReportCommand;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.plagiarismdetectionreport.PlagiarismDetectionReportResponseEntity;

import jakarta.validation.Valid;

public interface PlagiarismDetectionReportApplicationService {
    PlagiarismDetectionReportResponseEntity queryPlagiarismDetectionReport
            (@Valid QueryPlagiarismDetectionReportCommand queryPlagiarismDetectionReportCommand);

    QueryAllPlagiarismDetectionReportsResponse queryAllPlagiarismDetectionReports
            (@Valid QueryAllPlagiarismDetectionReportsCommand queryAllPlagiarismDetectionReportsCommand);

    DeletePlagiarismDetectionReportResponse deletePlagiarismDetectionReport
            (@Valid DeletePlagiarismDetectionReportCommand deletePlagiarismDetectionReportCommand);
}
