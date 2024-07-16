package com.backend.programming.learning.system.code.assessment.service.application.rest;

import com.backend.programming.learning.system.application.handler.utils.JwtUtils;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.CommentDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.CreateCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.CreateCommentResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.vote.VoteCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.tag.AddTagsToSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.DeleteSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.tag.DeleteSharedSolutionTagCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.vote.DeleteSharedSolutionVoteCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.comment.DeleteCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.comment.vote.UnvoteCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionByCodeQuestionIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionDetailCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.comment.GetReplyCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.comment.GetSolutionCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.comment.GetSolutionCommentResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.shared_solution.UpdateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.shared_solution.comment.UpdateCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.SharedSolutionApplicationService;
import com.backend.programming.learning.system.domain.valueobject.QueryOrderBy;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
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
            (@RequestHeader(value = "Access-Token") String accessToken,
             @RequestBody CreateSharedSolutionCommand command){
        String email = JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);
        command.setEmail(email);

        CreateSharedSolutionResponse response =
                service.createSharedSolution(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //view
    @GetMapping
    public ResponseEntity<GetSharedSolutionsResponse>
    getSharedSolutions(
            @RequestParam(required = false) UUID codeQuestionId,
            @RequestHeader(value = "Access-Token", required = false) String accessToken,
            @RequestParam(required = false) List<UUID> filterTagIds,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) QueryOrderBy orderBy,
            @RequestParam(required = false) SharedSolution.SortedFields sortBy,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize
    ){
        String email = JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);

        GetSharedSolutionByCodeQuestionIdCommand command =
                GetSharedSolutionByCodeQuestionIdCommand.builder()
                        .codeQuestionId(codeQuestionId)
                        .email(email)
                        .filterTagIds(filterTagIds)
                        .search(search)
                        .orderBy(orderBy)
                        .sortBy(sortBy)
                        .pageNum(pageNo)
                        .pageSize(pageSize)
                        .build();

        if(command.getOrderBy() == null)
            command.setOrderBy(QueryOrderBy.DESC);
        if(command.getSortBy() == null)
            command.setSortBy(SharedSolution.SortedFields.createdAt);

        GetSharedSolutionsResponse response =
                service.getSharedSolutions(command);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/recent-shared-solutions")
    public ResponseEntity<GetSharedSolutionsResponse> getRecentSharedSolutions(
            @RequestParam(required = false) UUID codeQuestionId,
            @RequestParam(required = false) List<UUID> filterTagIds,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) QueryOrderBy orderBy,
            @RequestParam(required = false) SharedSolution.SortedFields sortBy,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam String email
    ){
        GetSharedSolutionByCodeQuestionIdCommand command =
                GetSharedSolutionByCodeQuestionIdCommand.builder()
                        .codeQuestionId(codeQuestionId)
                        .email(email)
                        .filterTagIds(filterTagIds)
                        .search(search)
                        .orderBy(orderBy)
                        .sortBy(sortBy)
                        .pageNum(pageNo)
                        .pageSize(pageSize)
                        .build();

        if(command.getOrderBy() == null)
            command.setOrderBy(QueryOrderBy.DESC);
        if(command.getSortBy() == null)
            command.setSortBy(SharedSolution.SortedFields.createdAt);

        GetSharedSolutionsResponse response =
                service.getSharedSolutions(command);
        return ResponseEntity.ok(response);
    }


    //view detail
    @GetMapping("/{shared-solution-id}")
    public ResponseEntity<GetSharedSolutionResponseItem> getDetailSharedSolution
    (@PathVariable("shared-solution-id") UUID sharedSolutionId,
     @CookieValue(value = "viewed_solution", defaultValue = "") String viewedArticles,
     @RequestHeader(value = "Access-Token") String accessToken,
     HttpServletResponse response){
        String email = JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);

        boolean increaseView = false;
        if (!viewedArticles.contains(sharedSolutionId.toString())) {
            ResponseCookie cookie = ResponseCookie.from("viewed_solution", sharedSolutionId.toString()) // key & value
                    .httpOnly(true)
                    .secure(false)
                    //    .domain("localhost")  // host
                    .path("/code-assessment/shared-solution/"+sharedSolutionId)
                    .maxAge(Duration.ofMinutes(10))
//                    .sameSite("Strict")  // sameSite
                    .build()
                    ;

            response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());
            increaseView = true;
        }

        GetSharedSolutionDetailCommand command = GetSharedSolutionDetailCommand.builder()
                .email(email)
                .sharedSolutionId(sharedSolutionId)
                .increaseView(increaseView)
                .build();

        GetSharedSolutionResponseItem item =
                service.getDetailSharedSolution(command);

        return ResponseEntity.ok(item);
    }


    //edit
    @PutMapping("/{shared-solution-id}")
    public ResponseEntity updateSharedSolution(
            @PathVariable("shared-solution-id") UUID sharedSolutionId,
            @RequestHeader(value = "Access-Token") String accessToken,
            @RequestBody UpdateSharedSolutionCommand command){
        String email = JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);

        command.setSharedSolutionId(sharedSolutionId);
        command.setEmail(email);
        service.updateSharedSolution(command);
        return ResponseEntity.noContent().build();
    }

    //delete
    @DeleteMapping("/{shared-solution-id}")
    public ResponseEntity deleteSharedSolution(
            @PathVariable("shared-solution-id") UUID sharedSolutionId,
            @RequestHeader(value = "Access-Token") String accessToken){
        String email = JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);

        DeleteSharedSolutionCommand command = DeleteSharedSolutionCommand.builder()
                .email(email)
                .sharedSolutionId(sharedSolutionId)
                .build();
        service.deleteSharedSolution(command);
        return ResponseEntity.ok().build();
    }


    //comment
    //comment reply
    @PostMapping("/{shared-solution-id}/comment")
    public ResponseEntity<CreateCommentResponse> createComment(
            @PathVariable("shared-solution-id") UUID sharedSolutionId,
            @RequestHeader(value = "Access-Token") String accessToken,
            @RequestBody CreateCommentCommand command){
        String email = JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);

        command.setEmail(email);
        command.setSharedSolutionId(sharedSolutionId);
        CreateCommentResponse response = service.createComment(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //edit comment
    @PutMapping("/comment/{comment-id}")
    public ResponseEntity updateComment(
            @PathVariable("comment-id") UUID commentId,
            @RequestHeader(value = "Access-Token") String accessToken,
            @RequestBody UpdateCommentCommand command){
        String email = JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);

        command.setEmail(email);
        command.setCommentId(commentId);
        service.updateComment(command);
        return ResponseEntity.noContent().build();
    }

    //delete comment
    @DeleteMapping("/comment/{comment-id}")
    public ResponseEntity deleteComment(
            @PathVariable("comment-id") UUID commentId,
            @RequestHeader(value = "Access-Token") String accessToken){
        String email = JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);

        DeleteCommentCommand command = DeleteCommentCommand.builder()
                .email(email)
                .commentId(commentId)
                .build();
        service.deleteComment(command);
        return ResponseEntity.noContent().build();
    }

    //get solution comments
    @GetMapping("/{shared-solution-id}/comment")
    public ResponseEntity<GetSolutionCommentResponse> getSolutionComments(
            @PathVariable("shared-solution-id") UUID sharedSolutionId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestHeader(value = "Access-Token") String accessToken,
            @RequestParam(defaultValue = "DESC") QueryOrderBy orderBy){
        String email = JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);

        GetSolutionCommentCommand command = GetSolutionCommentCommand.builder()
                .email(email)
                .orderBy(orderBy)
                .sharedSolutionId(sharedSolutionId)
                .pageNum(pageNo)
                .pageSize(pageSize)
                .build();

        GetSolutionCommentResponse response =  service.getComments(command);
        return ResponseEntity.ok(response);
    }

    //get reply comments
    @GetMapping("/reply-comment/{comment-id}")
    public ResponseEntity<List<CommentDto>> getReplyComment(
            @PathVariable("comment-id") UUID commentId,
//            @RequestParam(defaultValue = "${code-assessment-service.default-page-number}") Integer pageNo,
//            @RequestParam(defaultValue = "${code-assessment-service.default-page-size}") Integer pageSize,
            @RequestParam UUID userId){

        GetReplyCommentCommand command = GetReplyCommentCommand.builder()
                .userId(userId)
                .rootCommentId(commentId)
                .build();

        List<CommentDto> response =  service.getReplyComments(command);
        return ResponseEntity.ok(response);
    }

    //vote comment
    @PostMapping("/vote/comment/{comment-id}")
    public ResponseEntity<String> voteComment(
            @PathVariable("comment-id") UUID commentId,
            @RequestBody VoteCommentCommand command){

        command.setCommentId(commentId);

        service.voteComment(command);
        return ResponseEntity.ok("vote successfully");
    }

    //unvote comment
    @DeleteMapping("/vote/comment/{comment-id}")
    public ResponseEntity<String> unvoteComment(
            @PathVariable("comment-id") UUID commentId,
            @RequestBody UnvoteCommentCommand command){

        command.setCommentId(commentId);

        service.unvoteComment(command);
        return ResponseEntity.noContent().build();
    }




    //vote shared solution
    @PostMapping("/{shared-solution-id}/vote")
    public ResponseEntity<VoteSharedSolutionResponse> voteSharedSolution
    (@PathVariable("shared-solution-id") UUID sharedSolutionId,
     @RequestBody VoteSharedSolutionCommand command){
        command.setSharedSolutionId(sharedSolutionId);
        VoteSharedSolutionResponse response =
                service.voteSharedSolution(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //remove vote shared solution
    @DeleteMapping("/{shared-solution-id}/vote")
    public ResponseEntity deleteVoteSharedSolution
    (@PathVariable("shared-solution-id") UUID sharedSolutionId,
     @RequestBody DeleteSharedSolutionVoteCommand command){
        command.setSharedSolutionId(sharedSolutionId);
        service.deleteVote(command);
        return ResponseEntity.noContent().build();
    }
    
    //edit shared solution tag
    @PostMapping("/{solution-id}/tag")
    public ResponseEntity addTagToSolution(
            @PathVariable("solution-id") UUID sharedSolutionId,
            @RequestHeader(value = "Access-Token") String accessToken,
            @RequestParam(value="tagIds") List<UUID> tagIds){
        String email = JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);

        AddTagsToSharedSolutionCommand command = AddTagsToSharedSolutionCommand.builder()
                .email(email)
                .sharedSolutionId(sharedSolutionId)
                .tagIds(tagIds)
                .build();
        service.addTagToSolution(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{solution-id}/tag")
    public ResponseEntity deleteSharedSolutionTag(
            @PathVariable("solution-id") UUID sharedSolutionId,
            @RequestHeader(value = "Access-Token") String accessToken,
            @RequestParam List<UUID> tagIds){
        String email = JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);

        DeleteSharedSolutionTagCommand command = DeleteSharedSolutionTagCommand.builder()
                .email(email)
                .sharedSolutionId(sharedSolutionId)
                .tagIds(tagIds)
                .build();
        service.deleteSharedSolutionTag(command);
        return ResponseEntity.noContent().build();
    }
}
