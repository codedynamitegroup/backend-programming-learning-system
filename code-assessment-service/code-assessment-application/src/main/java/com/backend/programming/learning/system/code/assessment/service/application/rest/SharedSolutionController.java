package com.backend.programming.learning.system.code.assessment.service.application.rest;


import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.CreateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.CreateSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionByCodeQuestionIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionDetailCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.SharedSolutionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/code-assessment/shared-solution",
        produces = "application/vnd.api.v1+json")
@Slf4j
@Validated
public class SharedSolutionController {
    private final SharedSolutionApplicationService service;

    public SharedSolutionController(SharedSolutionApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateSharedSolutionResponse> createCodeSubmission
            (@RequestBody CreateSharedSolutionCommand command){
        CreateSharedSolutionResponse response =
                service.createSharedSolution(command);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<GetSharedSolutionResponseItem>>
    getSharedSolutions(@RequestBody UUID codeQuestionId){
        GetSharedSolutionByCodeQuestionIdCommand command =
                GetSharedSolutionByCodeQuestionIdCommand.builder().codeQuestionId(codeQuestionId).build();
        List<GetSharedSolutionResponseItem> items =
                service.getSharedSolutions(command);
        return ResponseEntity.ok(items);
    }

    //vote

    //view

    //view detail
    @GetMapping("/{shared-solution-id}")
    public ResponseEntity<GetSharedSolutionResponseItem> getDetailSharedSolution
    (@PathVariable("shared-solution-id") UUID sharedSolutionId){
        GetSharedSolutionDetailCommand command = GetSharedSolutionDetailCommand.builder()
                .sharedSolutionId(sharedSolutionId).build();
        GetSharedSolutionResponseItem item =
                service.getDetailSharedSolution(command);
        return ResponseEntity.ok(item);
    }


    //edit

    //delete
}
