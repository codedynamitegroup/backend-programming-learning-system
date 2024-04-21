package com.backend.programming.learning.system.core.service.domain.implement.plagiarismdetectionreport;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.chapter.DeleteChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.chapter.DeleteChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.plagiarismdetectionreport.DeletePlagiarismDetectionReportCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.plagiarismdetectionreport.DeletePlagiarismDetectionReportResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryAllChaptersCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryAllChaptersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryAllPlagiarismDetectionReportsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryAllPlagiarismDetectionReportsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryPlagiarismDetectionReportCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.UpdateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.UpdateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.plagiarismdetectionreport.PlagiarismDetectionReportResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.PlagiarismDetectionReport;
import com.backend.programming.learning.system.core.service.domain.implement.chapter.ChapterCreateHelper;
import com.backend.programming.learning.system.core.service.domain.implement.chapter.ChapterDeleteHelper;
import com.backend.programming.learning.system.core.service.domain.implement.chapter.ChapterQueryHelper;
import com.backend.programming.learning.system.core.service.domain.implement.chapter.ChapterUpdateHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.chapter.ChapterDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.plagiarismdetectionreport.PlagiarismDetectionReportDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
