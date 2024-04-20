package com.backend.programming.learning.system.auth.service.application.rest.submission_assignment;

import com.backend.programming.learning.system.dto.method.create.submission_assignment.CreateSubmissionAssignmentCommand;
import com.backend.programming.learning.system.dto.method.create.submission_assignment.CreateSubmissionAssignmentResponse;
import com.backend.programming.learning.system.dto.method.delete.submission_assignment.DeleteSubmissionAssignmentCommand;
import com.backend.programming.learning.system.dto.method.delete.submission_assignment.DeleteSubmissionAssignmentResponse;
import com.backend.programming.learning.system.dto.method.query.submission_assignment.QueryAllSubmissionAssignmentResponse;
import com.backend.programming.learning.system.dto.method.query.submission_assignment.QueryAllSubmissionnAssignmentCommand;
import com.backend.programming.learning.system.dto.method.query.submission_assignment.QuerySubmissionAssignmentCommand;
import com.backend.programming.learning.system.dto.responseentity.submission_assignment.SubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.dto.update.submission_assignment.UpdateSubmissionAssignmentCommand;
import com.backend.programming.learning.system.dto.update.submission_assignment.UpdateSubmissionAssignmentResponse;
import com.backend.programming.learning.system.ports.input.service.submission_assignment.SubmissionAssignmentApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/assignment/submission_assignment", produces = "application/vnd.api.v1+json")
public class SubmissionAssignmentController {
    private final SubmissionAssignmentApplicationService submissionAssignmentApplicationService;

    @PostMapping
    public ResponseEntity<CreateSubmissionAssignmentResponse> createSubmissionAssignment(
            @RequestBody CreateSubmissionAssignmentCommand createSubmissionAssignmentCommand
    ) {
        log.info("Creating submission assignment");
        CreateSubmissionAssignmentResponse response = submissionAssignmentApplicationService.createSubmissionAssignment(createSubmissionAssignmentCommand);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{submissionId}")
    public ResponseEntity<SubmissionAssignmentResponseEntity> querySubmissionAssignmentById(
            @PathVariable UUID submissionId
    ) {
        log.info("Querying submission assignment by id");
        SubmissionAssignmentResponseEntity response = submissionAssignmentApplicationService
                .querySubmissionAssignmentById(new QuerySubmissionAssignmentCommand(submissionId));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<QueryAllSubmissionAssignmentResponse> queryAllByAssignmentId(
            @RequestParam UUID assignmentId
    ) {
        log.info("Querying all submission assignment by assignment id");
        QueryAllSubmissionAssignmentResponse response = submissionAssignmentApplicationService
                .queryAllByAssignmentId(new QueryAllSubmissionnAssignmentCommand(assignmentId));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{submissionAssignmentId}")
    public ResponseEntity<DeleteSubmissionAssignmentResponse> deleteSubmissionAssignmentById(
            @PathVariable UUID submissionAssignmentId
    ) {
        log.info("Deleting submission assignment by id");
       DeleteSubmissionAssignmentResponse response = submissionAssignmentApplicationService
               .deleteSubmissionAssignmentById(DeleteSubmissionAssignmentCommand.builder()
               .submissionAssignmentId(submissionAssignmentId)
               .build());

        return ResponseEntity.ok(response);

    }

    @PutMapping("/{submissionAssignmentId}")
    public ResponseEntity<UpdateSubmissionAssignmentResponse> updateSubmissionAssignmentById(
            @PathVariable UUID submissionAssignmentId,
            @RequestBody UpdateSubmissionAssignmentCommand updateSubmissionAssignmentCommand
    ) {
        log.info("Updating submission assignment by id");
        UpdateSubmissionAssignmentResponse response = submissionAssignmentApplicationService
                .updateSubmissionAssignmentById(updateSubmissionAssignmentCommand.builder()
                        .pass_status(updateSubmissionAssignmentCommand.getPass_status())
                        .submissionAssignmentId(submissionAssignmentId)
                        .grade(updateSubmissionAssignmentCommand.getGrade())
                        .content(updateSubmissionAssignmentCommand.getContent())
                        .timeSubmit(updateSubmissionAssignmentCommand.getTimeSubmit())
                        .build());
        return ResponseEntity.ok(response);
    }
}
