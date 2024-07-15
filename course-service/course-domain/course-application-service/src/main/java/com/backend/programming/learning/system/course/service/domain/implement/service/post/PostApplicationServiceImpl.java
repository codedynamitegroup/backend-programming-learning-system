package com.backend.programming.learning.system.course.service.domain.implement.service.post;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.post.CreatePostCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.post.CreatePostResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.post.DeletePostCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.post.DeletePostResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.post.QueryAllPostByCourseIdCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.post.QueryAllPostByCourseIdResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.post.QueryPostCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.post.PostResponseEntity;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.post.PostApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * com.backend.programming.learning.system.implemtent.post
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 10:57 PM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class PostApplicationServiceImpl implements PostApplicationService {
    private final PostCommandHandler postCommandHandler;
    @Override
    public CreatePostResponse createPost(CreatePostCommand createPostCommand) {
        return postCommandHandler.createPost(createPostCommand);
    }

    @Override
    public QueryAllPostByCourseIdResponse findAll(QueryAllPostByCourseIdCommand queryAllPostCommand) {
        return postCommandHandler.findAll(queryAllPostCommand);
    }

    @Override
    public PostResponseEntity findById(QueryPostCommand createPostCommand) {
        return postCommandHandler.findById(createPostCommand);
    }

    @Override
    public DeletePostResponse deleteById(DeletePostCommand deletePostCommand) {
        return postCommandHandler.deleteById(deletePostCommand);
    }
}
