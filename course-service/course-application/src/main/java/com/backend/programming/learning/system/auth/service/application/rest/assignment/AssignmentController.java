package com.backend.programming.learning.system.auth.service.application.rest.assignment;

import com.backend.programming.learning.system.dto.create.assignment.CreateAssignmentCommand;
import com.backend.programming.learning.system.dto.create.assignment.CreateAssignmentResponse;
import com.backend.programming.learning.system.dto.query.assignment.QueryAllAssignmentsCommand;
import com.backend.programming.learning.system.dto.query.assignment.QueryAllAssignmentsResponse;
import com.backend.programming.learning.system.dto.query.assignment.QueryAssignmentCommand;
import com.backend.programming.learning.system.dto.query.assignment.QueryAssignmentResponse;
import com.backend.programming.learning.system.ports.input.service.AssignmentApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/assignment/assignment", produces = "application/vnd.api.v1+json")
public class AssignmentController {
    private final AssignmentApplicationService assignmentApplicationService;

   @PostMapping
    public ResponseEntity<CreateAssignmentResponse> createAssignment(
            @RequestBody CreateAssignmentCommand createAssignmentCommand
    ) {
        log.info("Creating assignment");
        CreateAssignmentResponse response = assignmentApplicationService.createAssignment(createAssignmentCommand);
        return ResponseEntity.ok(response);
    }

    @GetMapping
   public ResponseEntity<QueryAllAssignmentsResponse> getAllAssignments(@RequestParam UUID courseId) {
        log.info("Getting list assignments");
        QueryAllAssignmentsResponse response = assignmentApplicationService.queryAllAssignments(new QueryAllAssignmentsCommand(courseId));
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<QueryAssignmentResponse> findBy(@PathVariable UUID id) {
        log.info("Getting assignment with id: {}", id);
        QueryAssignmentResponse response = assignmentApplicationService.queryAssignment(new QueryAssignmentCommand(id));
        return ResponseEntity.ok(response);
    }

}
