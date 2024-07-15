package com.backend.programming.learning.system.auth.service.application.rest.post;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.organization.CreateOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.post.CreatePostCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.post.CreatePostResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.post.DeletePostCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.post.DeletePostResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.post.QueryAllPostByCourseIdCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.post.QueryAllPostByCourseIdResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.post.QueryPostCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.post.UpdatePostCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.post.UpdatePostResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.post.PostResponseEntity;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.post.PostApplicationService;
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

/**
 * com.backend.programming.learning.system.auth.service.application.rest.post
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 10:48 PM
 * Description: ...
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/post", produces = "application/vnd.api.v1+json")
public class PostController {
    private final PostApplicationService postApplicationService;

    @PostMapping
    @Operation(summary = "Create post.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreatePostResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreatePostResponse> createPost(@RequestBody CreatePostCommand createPostCommand) {
        log.info("Creating post: {}", createPostCommand);
        CreatePostResponse response = postApplicationService.createPost(createPostCommand);
        log.info("Created post: {}", response);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/course/{courseId}")
    @Operation(summary = "Query all post by courseId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllPostByCourseIdResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllPostByCourseIdResponse> findAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @PathVariable UUID courseId
    ) {
        log.info("Getting list post");
        QueryAllPostByCourseIdResponse response = postApplicationService.findAllByCourseId(
                QueryAllPostByCourseIdCommand.builder()
                        .courseId(courseId)
                        .pageNo(pageNo)
                        .pageSize(pageSize)
                        .build()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{postId}")
    @Operation(summary = "Query post by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = PostResponseEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<PostResponseEntity> findById(@PathVariable UUID postId) {
        log.info("Getting post by id: {}", postId);
        QueryPostCommand createPostCommand = QueryPostCommand.builder()
                .postId(postId)
                .build();
        PostResponseEntity response = postApplicationService.findById(createPostCommand);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{postId}")
    @Operation(summary = "Update post.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreatePostResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdatePostResponse> updatePost(
            @PathVariable UUID postId,
            @RequestBody UpdatePostCommand updatePostCommand) {
        log.info("Updating post: {}", updatePostCommand);
        UpdatePostResponse response = postApplicationService.updatePost(UpdatePostCommand.builder()
                .postId(postId)
                .title(updatePostCommand.title())
                .content(updatePostCommand.content())
                .build());
        log.info("Created post: {}", response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{postId}")
    @Operation(summary = "Delete post by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeletePostResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<DeletePostResponse> deleteById(
            @PathVariable UUID postId) {
        log.info("Deleting post by id: {}", postId);
        DeletePostCommand deletePostCommand = DeletePostCommand.builder()
                .postId(postId)
                .build();
        DeletePostResponse response = postApplicationService.deleteById(deletePostCommand);
        return ResponseEntity.ok(response);
    }
}
