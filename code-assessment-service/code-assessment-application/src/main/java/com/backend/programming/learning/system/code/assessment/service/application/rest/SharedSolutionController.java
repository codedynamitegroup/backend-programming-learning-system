package com.backend.programming.learning.system.code.assessment.service.application.rest;


import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.CreateCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.CreateCommentResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.DeleteSharedSolutionCommad;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.DeleteSharedSolutionVoteCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionByCodeQuestionIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionDetailCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.shared_solution.UpdateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.shared_solution.comment.UpdateCommentCommand;
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

    //create shared solution
    @PostMapping
    public ResponseEntity<CreateSharedSolutionResponse> createSharedSolution
            (@RequestBody CreateSharedSolutionCommand command){
        CreateSharedSolutionResponse response =
                service.createSharedSolution(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //view
    //num of comment
    @GetMapping
    public ResponseEntity<GetSharedSolutionsResponse>
    getSharedSolutions(
            @RequestBody GetSharedSolutionByCodeQuestionIdCommand command,
            @RequestParam(defaultValue = "${code-assessment-service.default-page-number}") Integer pageNo,
            @RequestParam(defaultValue = "${code-assessment-service.default-page-size}") Integer pageSize
    ){
        command.setPageNum(pageNo);
        command.setPageSize(pageSize);
        GetSharedSolutionsResponse response =
                service.getSharedSolutions(command);
        return ResponseEntity.ok(response);
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
    @PutMapping("/{shared-solution-id}")
    public ResponseEntity updateSharedSolution(
            @PathVariable("shared-solution-id") UUID sharedSolutionId,
            @RequestBody UpdateSharedSolutionCommand command){
        command.setSharedSolutionId(sharedSolutionId);
        service.updateSharedSolution(command);
        return ResponseEntity.noContent().build();
    }

    //delete
    @DeleteMapping("/{shared-solution-id}")
    public ResponseEntity deleteSharedSolution(
            @PathVariable("shared-solution-id") UUID sharedSolutionId,
            @RequestBody DeleteSharedSolutionCommad command){
        command.setSharedSolutionId(sharedSolutionId);
        service.deleteSharedSolution(command);
        return ResponseEntity.noContent().build();
    }


    //comment
    //comment reply
    @PostMapping("/{shared-solution-id}/comment")
    public ResponseEntity<CreateCommentResponse> createComment(
            @PathVariable("shared-solution-id") UUID sharedSolutionId,
            @RequestBody CreateCommentCommand command){
        command.setSharedSolutionId(sharedSolutionId);
        CreateCommentResponse response = service.createComment(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //edit
    @PutMapping("/{shared-solution-id}/comment/{comment-id}")
    public ResponseEntity updateComment(
            @PathVariable("shared-solution-id") UUID sharedSolutionId,
            @PathVariable("comment-id") UUID commentId,
            @RequestBody UpdateCommentCommand command){
        command.setCommentId(commentId);
        command.setSharedSolutionId(sharedSolutionId);
        service.updateComment(command);
        return ResponseEntity.noContent().build();

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

    //remove vote
    @DeleteMapping("/{shared-solution-id}/vote")
    public ResponseEntity deleteVote
    (@PathVariable("shared-solution-id") UUID sharedSolutionId,
     @RequestBody DeleteSharedSolutionVoteCommand command){
        command.setSharedSolutionId(sharedSolutionId);
        service.deleteVote(command);
        return ResponseEntity.noContent().build();
    }
}
