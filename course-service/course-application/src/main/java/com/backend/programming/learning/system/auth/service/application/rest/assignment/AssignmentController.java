package com.backend.programming.learning.system.auth.service.application.rest.assignment;

import com.backend.programming.learning.system.course.service.domain.dto.method.ai_grade_essay.AIGradeEssayCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.report_grade_essay_ai.ReportGradeEssayAICommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.assignment.DeleteAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.assignment.DeleteAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.ai_grade_essay_report.QueryAllAIGradeEssayReportsByAssignmentIdCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.ai_grade_essay_report.QueryAllAIGradeEssayReportsByAssignmentIdResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment.*;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.rubric_user.QueryAllRubricsByUserIdCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.rubric_user.QueryAllRubricsByUserIdResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.assignment.UpdateAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.assignment.UpdateAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.ai_grade_essay_report.AssignmentAIGradeReportEntityResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment.ListSubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment.StudentAssignmentListResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.ai_grade_essay.AIGradeEssayApplicationService;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.assignment.AssignmentApplicationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/assignment", produces = "application/vnd.api.v1+json")
public class AssignmentController {
    private final AssignmentApplicationService assignmentApplicationService;
    private final AIGradeEssayApplicationService aiGradeEssayApplicationService;

    @PostMapping
    @Operation(summary = "Create assignment.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateAssignmentResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateAssignmentResponse> createAssignment(
            @RequestBody CreateAssignmentCommand createAssignmentCommand
    ) {
        log.info("Creating assignment");
        CreateAssignmentResponse response = assignmentApplicationService.createAssignment(createAssignmentCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    @Operation(summary = "Get all assignments.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllAssignmentsResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllAssignmentsResponse> getAllAssignments(@RequestParam UUID courseId) {
        log.info("Getting list assignments");
        QueryAllAssignmentsResponse response = assignmentApplicationService.queryAllAssignments(new QueryAllAssignmentsCommand(courseId));
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get assignment by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAssignmentResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAssignmentResponse> findBy(@PathVariable UUID id) {
        log.info("Getting assignment with id: {}", id);
        QueryAssignmentResponse response = assignmentApplicationService.queryAssignment(new QueryAssignmentCommand(id));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update assignment.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateAssignmentResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateAssignmentResponse> updateAssignment(
            @PathVariable UUID id,
            @RequestBody UpdateAssignmentCommand updateAssignmentCommand
    )
    {
        log.info("Updating assignment with id: {}", id);
        UpdateAssignmentResponse response = assignmentApplicationService
                .updateAssignment(updateAssignmentCommand, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete assignment.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeleteAssignmentResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<DeleteAssignmentResponse> deleteAssignment(@PathVariable UUID id) {
        log.info("Deleting assignment with id: {}", id);
        DeleteAssignmentResponse response= assignmentApplicationService
                .deleteAssignment(DeleteAssignmentCommand
                        .builder()
                        .assignmentId(id)
                        .build());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list-submission/{id}")
    @Operation(summary = "Get list submission assignment.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = ListSubmissionAssignmentResponseEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<ListSubmissionAssignmentResponseEntity> listSubmissionAssignment(@PathVariable UUID id) {
        log.info("Getting list submission assignment with id: {}", id);
        ListSubmissionAssignmentResponseEntity response = assignmentApplicationService
                .queryAssignmentDetail(new QueryAssignmentCommand(id));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/grade")
    @Operation(summary = "Get assignment grade.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllAssignmentGradeResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllAssignmentGradeResponse> getAssignmentGrade(
            @RequestParam UUID courseId,
            @RequestParam UUID userId,
            @RequestParam(defaultValue = "") String searchName,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize)
    {
        log.info("Getting assignment grade with courseId: {} and userId: {}", courseId, userId);
        QueryAllAssignmentGradeResponse response = assignmentApplicationService.queryAssignmentGrade(
                QueryAllAssignmentGradeByStudentCommand.builder()
                        .courseId(courseId)
                        .userId(userId)
                        .searchName(searchName)
                        .pageNo(pageNo)
                        .pageSize(pageSize)
                        .build()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/student-assignment")
    @Operation(summary = "Get student assignment.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = StudentAssignmentListResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<StudentAssignmentListResponse> getStudentAssignment(
            @RequestParam UUID courseId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String searchName) {
        log.info("Getting student assignment with courseId: {}", courseId);
        StudentAssignmentListResponse response = assignmentApplicationService.retrieveStudentAssignmentGrades(
                QueryStudentAssignmentListCommand.builder()
                        .courseId(courseId)
                        .pageNo(pageNo)
                        .pageSize(pageSize)
                        .searchName(searchName)
                        .build()
        );
        return ResponseEntity.ok(response);
    }
    @PostMapping("/create-report-grade-essay-ai")
    @Operation(summary = "Create report AI grade essay.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = StudentAssignmentListResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<String> createReport(
            @RequestBody ReportGradeEssayAICommand reportGradeEssayAICommand
    ) throws JsonProcessingException {
        aiGradeEssayApplicationService.createReportEssay(reportGradeEssayAICommand);
        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
    }

    @GetMapping("/get-reports-by-assignment/{assignmentId}")
    @Operation(summary = "Get all reports ai by assignment.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllRubricsByUserIdResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllAIGradeEssayReportsByAssignmentIdResponse> queryAllRubricsByUserId(
            @PathVariable UUID assignmentId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String searchName

    ) {
        QueryAllAIGradeEssayReportsByAssignmentIdResponse queryAllAIGradeEssayReportsByAssignmentIdResponse =
                aiGradeEssayApplicationService.queryAllAIGradeEssayReportsByAssignmentId (
                QueryAllAIGradeEssayReportsByAssignmentIdCommand.builder()
                        .assignmentId(assignmentId)
                        .pageNo(pageNo)
                        .pageSize(pageSize)
                        .search(searchName)
                        .build());
        return ResponseEntity.ok(queryAllAIGradeEssayReportsByAssignmentIdResponse);
    }

    @GetMapping("/ai-reports/{reportId}")
    @Operation(summary = "Get detail report ai")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllRubricsByUserIdResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<AssignmentAIGradeReportEntityResponse> queryAIReportById(
            @PathVariable UUID reportId

    ) {
        AssignmentAIGradeReportEntityResponse assignmentAIGradeReportEntityResponse =
                aiGradeEssayApplicationService.queryAIGradeEssayReportById(reportId);
        return ResponseEntity.ok(assignmentAIGradeReportEntityResponse);
    }
}
