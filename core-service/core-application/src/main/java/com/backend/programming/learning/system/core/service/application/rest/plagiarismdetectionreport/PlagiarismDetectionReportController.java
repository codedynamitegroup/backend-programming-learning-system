package com.backend.programming.learning.system.core.service.application.rest.plagiarismdetectionreport;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.plagiarismdetectionreport.DeletePlagiarismDetectionReportCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.plagiarismdetectionreport.DeletePlagiarismDetectionReportResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryAllPlagiarismDetectionReportsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryAllPlagiarismDetectionReportsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryPlagiarismDetectionReportCommand;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.plagiarismdetectionreport.PlagiarismDetectionReportResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.plagiarismdetectionreport.PlagiarismDetectionReportApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/core/plagiarism-detection-reports", produces = "application/vnd.api.v1+json")
public class PlagiarismDetectionReportController {
    private final PlagiarismDetectionReportApplicationService plagiarismDetectionReportApplicationService;

    public PlagiarismDetectionReportController(PlagiarismDetectionReportApplicationService plagiarismDetectionReportApplicationService) {
        this.plagiarismDetectionReportApplicationService = plagiarismDetectionReportApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlagiarismDetectionReportResponseEntity> getPlagiarismDetectionReport(
            @PathVariable UUID id
    ) {
        PlagiarismDetectionReportResponseEntity plagiarismDetectionReportResponseEntity =
                plagiarismDetectionReportApplicationService.queryPlagiarismDetectionReport(
                        QueryPlagiarismDetectionReportCommand
                        .builder()
                        .plagiarismDetectionReportId(id)
                        .build());
        log.info("Returning plagiarism detection report: {}", plagiarismDetectionReportResponseEntity);
        return ResponseEntity.ok(plagiarismDetectionReportResponseEntity);
    }

    @GetMapping
    public ResponseEntity<QueryAllPlagiarismDetectionReportsResponse> getAllPlagiarismDetectionReportsForExam(
            @RequestParam UUID examId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "false") Boolean fetchAll
    ) {
        QueryAllPlagiarismDetectionReportsResponse queryAllPlagiarismDetectionReportsResponse =
                plagiarismDetectionReportApplicationService.queryAllPlagiarismDetectionReports(
                        QueryAllPlagiarismDetectionReportsCommand.builder()
                                .examId(examId)
                                .pageNo(pageNo)
                                .pageSize(pageSize)
                                .fetchAll(fetchAll)
                                .build());
        log.info("Returning all plagiarism detection reports for exam: {}",
                queryAllPlagiarismDetectionReportsResponse);
        return ResponseEntity.ok(queryAllPlagiarismDetectionReportsResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletePlagiarismDetectionReportResponse> deletePlagiarismDetectionReport(
            @PathVariable UUID id) {
        DeletePlagiarismDetectionReportResponse deletePlagiarismDetectionReportResponse =
                plagiarismDetectionReportApplicationService.deletePlagiarismDetectionReport(
                        DeletePlagiarismDetectionReportCommand.builder()
                        .plagiarismDetectionReportId(id)
                        .build());
        log.info("Plagiarism Detection Report deleted: {}", id);
        return ResponseEntity.ok(deletePlagiarismDetectionReportResponse);
    }
}
