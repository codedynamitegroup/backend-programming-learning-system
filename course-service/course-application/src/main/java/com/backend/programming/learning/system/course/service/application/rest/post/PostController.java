package com.backend.programming.learning.system.course.service.application.rest.post;

import com.backend.programming.learning.system.course.service.domain.dto.post.create.CreatePostCommand;
import com.backend.programming.learning.system.course.service.domain.dto.post.create.CreatePostResponse;
import com.backend.programming.learning.system.course.service.domain.dto.post.get.PostResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.post.PostApplicationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.backend.programming.learning.system.course.service.application.rest.post
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 1:08 AM
 * Description: ...
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/post", produces = "application/vnd.api.v1+json")
public class PostController {
    private final PostApplicationService postApplicationService;
    @GetMapping
    public ResponseEntity<PostResponse> findAll(
            @RequestParam(value = "search", required = false) String search
    ) {
        log.info("Getting list post");
        PostResponse response = postApplicationService.findAll(search);
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<CreatePostResponse> createPost(@RequestBody CreatePostCommand createPostCommand) {
        log.info("Creating post");
        CreatePostResponse response = postApplicationService.createPost(createPostCommand);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{postId}")
    public ResponseEntity<CreatePostResponse> getPost(@PathVariable @NonNull Long postId) {
        log.info("Getting post with id: {}", postId);
        CreatePostResponse response = postApplicationService.getPost(postId);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable @NonNull Long postId) {
        log.info("Deleting post with id: {}", postId);
        postApplicationService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }
}
