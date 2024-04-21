package com.backend.programming.learning.system.auth.service.application.rest.submission_assignment_onlinetext;

import com.backend.programming.learning.system.dto.method.create.submission_assignment_onlinetext.CreateSubmissionAssignmentOnlineTextCommand;
import com.backend.programming.learning.system.dto.method.create.submission_assignment_onlinetext.CreateSubmissionAssignmentOnlineTextResponse;
import com.backend.programming.learning.system.dto.method.delete.submission_assignment_onlinetext.DeleteSubmissionAssignmentOnlineTextCommand;
import com.backend.programming.learning.system.dto.method.delete.submission_assignment_onlinetext.DeleteSubmissionAssignmentOnlineTextResponse;
import com.backend.programming.learning.system.dto.method.query.submission_assignment_onlinetext.QuerySubmissionAssignmentOnlineTextCommand;
import com.backend.programming.learning.system.dto.responseentity.submission_assignment_onlinetext.SubmissionAssignmentOnlineTextResponseEntity;
import com.backend.programming.learning.system.ports.input.service.submission_assignment_onlinetext.SubmissionAssignmentOnlineTextApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/assignment/submission_assignment_onlinetext", produces = "application/vnd.api.v1+json")
public class SubmissionAssignmentOnlineTextController {
private final SubmissionAssignmentOnlineTextApplicationService submissionAssignmentOnlineTextApplicationService;

    @PostMapping
    public ResponseEntity<CreateSubmissionAssignmentOnlineTextResponse> createSubmissionAssignmentOnlineText(
            @RequestBody CreateSubmissionAssignmentOnlineTextCommand createSubmissionAssignmentOnlineTextCommand
    ) {
        log.info("Creating submission assignment online text");
        CreateSubmissionAssignmentOnlineTextResponse response = submissionAssignmentOnlineTextApplicationService.createSubmissionAssignmentOnlineText(createSubmissionAssignmentOnlineTextCommand);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{submissionAssignmentOnlineTextId}")
    public ResponseEntity<SubmissionAssignmentOnlineTextResponseEntity> querySubmissionAssignmentOnlineTextById(
            @PathVariable UUID submissionAssignmentOnlineTextId
    ) {
        log.info("Querying submission assignment online text by id");
        SubmissionAssignmentOnlineTextResponseEntity response = submissionAssignmentOnlineTextApplicationService
                .querySubmissionAssignmentOnlineTextById(new QuerySubmissionAssignmentOnlineTextCommand(submissionAssignmentOnlineTextId));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{submissionAssignmentOnlineTextId}")
    public ResponseEntity<DeleteSubmissionAssignmentOnlineTextResponse> deleteSubmissionAssignmentOnlineTextById(
            @PathVariable UUID submissionAssignmentOnlineTextId
    ) {
        log.info("Deleting submission assignment online text by id");
        DeleteSubmissionAssignmentOnlineTextResponse response = submissionAssignmentOnlineTextApplicationService.deleteSubmissionAssignmentOnlineTextById(new DeleteSubmissionAssignmentOnlineTextCommand(submissionAssignmentOnlineTextId));
        return ResponseEntity.ok(response);
    }


}
