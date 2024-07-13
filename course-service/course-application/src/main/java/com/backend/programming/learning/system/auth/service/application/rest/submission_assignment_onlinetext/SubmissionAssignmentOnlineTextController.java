//package com.backend.programming.learning.system.auth.service.application.rest.submission_assignment_onlinetext;
//
//import com.backend.programming.learning.system.course.service.domain.dto.method.create.post.CreatePostResponse;
//import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_onlinetext.CreateSubmissionAssignmentOnlineTextCommand;
//import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_onlinetext.CreateSubmissionAssignmentOnlineTextResponse;
//import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_onlinetext.DeleteSubmissionAssignmentOnlineTextCommand;
//import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_onlinetext.DeleteSubmissionAssignmentOnlineTextResponse;
//import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment_onlinetext.QuerySubmissionAssignmentOnlineTextCommand;
//import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_onlinetext.SubmissionAssignmentOnlineTextResponseEntity;
//import com.backend.programming.learning.system.course.service.domain.ports.input.service.submission_assignment_onlinetext.SubmissionAssignmentOnlineTextApplicationService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.UUID;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping(value = "/assignment/submission_assignment_onlinetext", produces = "application/vnd.api.v1+json")
//public class SubmissionAssignmentOnlineTextController {
//private final SubmissionAssignmentOnlineTextApplicationService submissionAssignmentOnlineTextApplicationService;
//
//    @PostMapping
//    @Operation(summary = "Create submission assignment online text.")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Success.", content = {
//                    @Content(mediaType = "application/vnd.api.v1+json",
//                            schema = @Schema(implementation = CreateSubmissionAssignmentOnlineTextResponse.class))
//            }),
//            @ApiResponse(responseCode = "400", description = "Not found."),
//            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
//    public ResponseEntity<CreateSubmissionAssignmentOnlineTextResponse> createSubmissionAssignmentOnlineText(
//            @RequestBody CreateSubmissionAssignmentOnlineTextCommand createSubmissionAssignmentOnlineTextCommand
//    ) {
//        log.info("Creating submission assignment online text");
//        CreateSubmissionAssignmentOnlineTextResponse response = submissionAssignmentOnlineTextApplicationService.createSubmissionAssignmentOnlineText(createSubmissionAssignmentOnlineTextCommand);
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//    }
//
//    @GetMapping("/{submissionAssignmentOnlineTextId}")
//    @Operation(summary = "Query submission assignment online text by id.")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Success.", content = {
//                    @Content(mediaType = "application/vnd.api.v1+json",
//                            schema = @Schema(implementation = SubmissionAssignmentOnlineTextResponseEntity.class))
//            }),
//            @ApiResponse(responseCode = "400", description = "Not found."),
//            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
//    public ResponseEntity<SubmissionAssignmentOnlineTextResponseEntity> querySubmissionAssignmentOnlineTextById(
//            @PathVariable UUID submissionAssignmentOnlineTextId
//    ) {
//        log.info("Querying submission assignment online text by id");
//        SubmissionAssignmentOnlineTextResponseEntity response = submissionAssignmentOnlineTextApplicationService
//                .querySubmissionAssignmentOnlineTextById(new QuerySubmissionAssignmentOnlineTextCommand(submissionAssignmentOnlineTextId));
//
//        return ResponseEntity.ok(response);
//    }
//
//    @DeleteMapping("/{submissionAssignmentOnlineTextId}")
//    @Operation(summary = "Delete submission assignment online text by id.")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Success.", content = {
//                    @Content(mediaType = "application/vnd.api.v1+json",
//                            schema = @Schema(implementation = DeleteSubmissionAssignmentOnlineTextResponse.class))
//            }),
//            @ApiResponse(responseCode = "400", description = "Not found."),
//            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
//    public ResponseEntity<DeleteSubmissionAssignmentOnlineTextResponse> deleteSubmissionAssignmentOnlineTextById(
//            @PathVariable UUID submissionAssignmentOnlineTextId
//    ) {
//        log.info("Deleting submission assignment online text by id");
//        DeleteSubmissionAssignmentOnlineTextResponse response = submissionAssignmentOnlineTextApplicationService.deleteSubmissionAssignmentOnlineTextById(new DeleteSubmissionAssignmentOnlineTextCommand(submissionAssignmentOnlineTextId));
//        return ResponseEntity.ok(response);
//    }
//
//
//}
