package com.backend.programming.learning.system.auth.service.application.rest.post;

import com.backend.programming.learning.system.dto.method.create.post.CreatePostCommand;
import com.backend.programming.learning.system.dto.method.create.post.CreatePostResponse;
import com.backend.programming.learning.system.ports.input.service.post.PostApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<CreatePostResponse> createPost(@RequestBody CreatePostCommand createPostCommand) {
        log.info("Creating post: {}", createPostCommand);
        CreatePostResponse response = postApplicationService.createPost(createPostCommand);
        log.info("Created post: {}", response);
        return ResponseEntity.ok(response);
    }
}
