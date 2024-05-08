package com.backend.programming.learning.system.code.assessment.service.application.rest;


import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.DeleteSharedSolutionVoteCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionByCodeQuestionIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionDetailCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.SharedSolutionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //vote
    @PostMapping("/{shared-solution-id}/vote")
    public ResponseEntity<VoteSharedSolutionResponse> voteSharedSolution
    (@PathVariable("shared-solution-id") UUID sharedSolutionId,
     @RequestBody VoteSharedSolutionCommand command){
        command.setSharedSolutionId(sharedSolutionId);
        VoteSharedSolutionResponse response =
                service.voteSharedSolution(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{shared-solution-id}/vote")
    public ResponseEntity deleteVote
            (@PathVariable("shared-solution-id") UUID sharedSolutionId,
             @RequestBody DeleteSharedSolutionVoteCommand command){
        command.setSharedSolutionId(sharedSolutionId);
        service.deleteVote(command);
        return ResponseEntity.noContent().build();

    }

    //view
    //need to deliver if user is vote this
    //num of comment
    @GetMapping
    public ResponseEntity<List<GetSharedSolutionResponseItem>>
    getSharedSolutions(@RequestBody UUID codeQuestionId){
        GetSharedSolutionByCodeQuestionIdCommand command =
                GetSharedSolutionByCodeQuestionIdCommand.builder().codeQuestionId(codeQuestionId).build();
        List<GetSharedSolutionResponseItem> items =
                service.getSharedSolutions(command);
        return ResponseEntity.ok(items);
    }

    //view detail
    @GetMapping("/{shared-solution-id}")
    public ResponseEntity<GetSharedSolutionResponseItem> getDetailSharedSolution
    (@PathVariable("shared-solution-id") UUID sharedSolutionId,
     @RequestBody GetSharedSolutionDetailCommand command){
        command.setSharedSolutionId(sharedSolutionId);
        GetSharedSolutionResponseItem item =
                service.getDetailSharedSolution(command);
        return ResponseEntity.ok(item);
    }


    //edit

    //delete
}
