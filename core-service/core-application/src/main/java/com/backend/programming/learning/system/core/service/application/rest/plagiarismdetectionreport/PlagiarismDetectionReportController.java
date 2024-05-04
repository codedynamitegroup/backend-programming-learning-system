package com.backend.programming.learning.system.core.service.application.rest.plagiarismdetectionreport;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.plagiarismdetectionreport.DeletePlagiarismDetectionReportCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.plagiarismdetectionreport.DeletePlagiarismDetectionReportResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestUsersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryAllPlagiarismDetectionReportsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryAllPlagiarismDetectionReportsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryPlagiarismDetectionReportCommand;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.plagiarismdetectionreport.PlagiarismDetectionReportResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.plagiarismdetectionreport.PlagiarismDetectionReportApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Get plagiarism detection report by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = PlagiarismDetectionReportResponseEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
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
    @Operation(summary = "Get all plagiarism detection reports for exam.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllPlagiarismDetectionReportsResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
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
    @Operation(summary = "Delete plagiarism detection report by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeletePlagiarismDetectionReportResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
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
