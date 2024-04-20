package com.backend.programming.learning.system.ports.input.service.post;

import com.backend.programming.learning.system.dto.method.create.post.CreatePostCommand;
import com.backend.programming.learning.system.dto.method.create.post.CreatePostResponse;
import com.backend.programming.learning.system.dto.method.delete.post.DeletePostCommand;
import com.backend.programming.learning.system.dto.method.delete.post.DeletePostResponse;
import com.backend.programming.learning.system.dto.method.query.post.QueryAllPostCommand;
import com.backend.programming.learning.system.dto.method.query.post.QueryAllPostResponse;
import com.backend.programming.learning.system.dto.method.query.post.QueryPostCommand;
import com.backend.programming.learning.system.dto.responseentity.post.PostResponseEntity;

import javax.validation.Valid;

/**
 * com.backend.programming.learning.system.ports.input.service.post
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 10:54 PM
 * Description: ...
 */
public interface PostApplicationService {
    CreatePostResponse createPost(
            @Valid CreatePostCommand createPostCommand);

    QueryAllPostResponse findAll(
            @Valid QueryAllPostCommand queryAllPostCommand);

    PostResponseEntity findById(
            @Valid QueryPostCommand createPostCommand);

    DeletePostResponse deleteById(
            @Valid DeletePostCommand deletePostCommand);
}
