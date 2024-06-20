package com.backend.programming.learning.system.core.service.application.rest.review;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.review.DeleteReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.review.DeleteReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryAllReviewsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryAllReviewsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.review.UpdateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.review.UpdateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.review.ReviewResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.review.ReviewApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/core/reviews", produces = "application/vnd.api.v1+json")
public class ReviewController {
    private final ReviewApplicationService reviewApplicationService;

    public ReviewController(ReviewApplicationService reviewApplicationService) {
        this.reviewApplicationService = reviewApplicationService;
    }

    @PostMapping("/create")
    @Operation(summary = "Create review.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateReviewResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateReviewResponse> createReview(
            @RequestBody CreateReviewCommand createReviewCommand) {
        String email = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            Jwt token = jwtAuthenticationToken.getToken();
            email = token.getClaim("preferred_username");
        }

        log.info("Creating review: {}", createReviewCommand);
        CreateReviewResponse createReviewResponse =
                reviewApplicationService.createReview(CreateReviewCommand
                        .builder()
                        .certificateCourseId(createReviewCommand.getCertificateCourseId())
                        .rating(createReviewCommand.getRating())
                        .content(createReviewCommand.getContent())
                        .email(email)
                        .build());
        log.info("Review created: {}", createReviewResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(createReviewResponse);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update review.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateReviewResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateReviewResponse> updateReview(
            @PathVariable UUID id,
            @RequestBody UpdateReviewCommand updateReviewCommand) {
        log.info("Updating review: {}", id);
        UpdateReviewResponse updateReviewResponse =
                reviewApplicationService.updateReview(UpdateReviewCommand
                        .builder()
                        .reviewId(id)
                        .rating(updateReviewCommand.getRating())
                        .content(updateReviewCommand.getContent())
                        .updatedBy(updateReviewCommand.getUpdatedBy())
                        .build());
        log.info("Review updated: {}", updateReviewResponse.getReviewId());
        return ResponseEntity.ok(updateReviewResponse);
    }

    @GetMapping
    @Operation(summary = "Get all reviews by certificate course id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllReviewsResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllReviewsResponse> getAllReviewsByCertificateCourseId(
            @RequestParam UUID certificateCourseId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        QueryAllReviewsResponse queryAllReviewsResponse =
                reviewApplicationService.queryAllReviewsByCertificateCourseId(QueryAllReviewsCommand
                        .builder()
                        .certificateCourseId(certificateCourseId)
                        .pageNo(pageNo)
                        .pageSize(pageSize)
                        .build());
        log.info("Returning all reviews: {}", queryAllReviewsResponse);
        return ResponseEntity.ok(queryAllReviewsResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get review by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = ReviewResponseEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<ReviewResponseEntity> getReview(
            @PathVariable UUID id) {
        ReviewResponseEntity reviewResponseEntity =
                reviewApplicationService.queryReview(QueryReviewCommand
                        .builder()
                        .reviewId(id)
                        .build());
        log.info("Returning review: {}", reviewResponseEntity);
        return ResponseEntity.ok(reviewResponseEntity);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete review.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeleteReviewResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<DeleteReviewResponse> deleteReview(
            @PathVariable UUID id,
            @RequestParam UUID deletedBy) {
        DeleteReviewResponse deleteReviewResponse =
                reviewApplicationService.deleteReview(DeleteReviewCommand
                        .builder()
                        .reviewId(id)
                        .deletedBy(deletedBy)
                        .build());
        log.info("Review deleted: {}", id);
        return ResponseEntity.ok(deleteReviewResponse);
    }

}
