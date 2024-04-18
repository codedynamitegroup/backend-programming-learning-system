package com.backend.programming.learning.system.auth.service.application.rest.post;

import com.backend.programming.learning.system.dto.method.create.post.CreatePostCommand;
import com.backend.programming.learning.system.dto.method.create.post.CreatePostResponse;
import com.backend.programming.learning.system.dto.method.query.post.QueryAllPostCommand;
import com.backend.programming.learning.system.dto.method.query.post.QueryAllPostResponse;
import com.backend.programming.learning.system.dto.method.query.post.QueryPostCommand;
import com.backend.programming.learning.system.dto.responseentity.post.PostResponseEntity;
import com.backend.programming.learning.system.ports.input.service.post.PostApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/create")
    public ResponseEntity<CreatePostResponse> createPost(@RequestBody CreatePostCommand createPostCommand) {
        log.info("Creating post: {}", createPostCommand);
        CreatePostResponse response = postApplicationService.createPost(createPostCommand);
        log.info("Created post: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<QueryAllPostResponse> findAll(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        log.info("Getting list post");
        QueryAllPostCommand queryAllPostCommand = QueryAllPostCommand.builder()
                .search(search)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .build();
        QueryAllPostResponse response = postApplicationService.findAll(queryAllPostCommand);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseEntity> findById(@PathVariable UUID postId) {
        log.info("Getting post by id: {}", postId);
        QueryPostCommand createPostCommand = QueryPostCommand.builder()
                .postId(postId)
                .build();
        PostResponseEntity response = postApplicationService.findById(createPostCommand);
        return ResponseEntity.ok(response);
    }
}
