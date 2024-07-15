package com.backend.programming.learning.system.course.service.domain.implement.service.post;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.post.CreatePostCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.post.UpdatePostCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.Post;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.mapper.post.PostDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.PostRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class PostUpdateHelper {
    private final PostDataMapper postDataMapper;
    private final PostRepository postRepository;

    @Transactional
    public Post updatePost(UpdatePostCommand updatePostCommand) {
        Post postFound = getPost(updatePostCommand.postId());

        if (updatePostCommand.title() != null) {
            postFound.setTitle(updatePostCommand.title());
        }
        if (updatePostCommand.content() != null) {
            postFound.setContent(updatePostCommand.content());
        }

        return savePost(postFound);
    }

    private Post getPost(UUID postId) {
       Optional<Post> postFound = postRepository.findById(postId);
        if (postFound.isEmpty()) {
            log.warn("Post with id: {} not found", postId);
            throw new CourseDomainException("Course not found");
        }
        return postFound.get();
    }

    private Post savePost(Post post) {
        Post postResult = postRepository.save(post);
        if (Objects.isNull(postResult)) {
            log.warn("Post save failed");
            throw new CourseDomainException("Post save failed");
        }
        return postResult;
    }

}
