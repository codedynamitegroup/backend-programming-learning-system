package com.backend.programming.learning.system.course.service.domain.ports.input.service.post;

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

import jakarta.validation.Valid;

/**
 * com.backend.programming.learning.system.ports.input.service.post
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 10:54 PM
 * Description: ...
 */
public interface PostApplicationService {
    CreatePostResponse createPost(
            @Valid CreatePostCommand createPostCommand);

    QueryAllPostByCourseIdResponse findAllByCourseId(
            @Valid QueryAllPostByCourseIdCommand queryAllPostByCourseIdCommand);

    PostResponseEntity findById(
            @Valid QueryPostCommand createPostCommand);

    DeletePostResponse deleteById(
            @Valid DeletePostCommand deletePostCommand);

    UpdatePostResponse updatePost(UpdatePostCommand updatePostCommand);
}
