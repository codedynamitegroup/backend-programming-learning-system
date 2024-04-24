package com.backend.programming.learning.system.implement.post;

import com.backend.programming.learning.system.CourseDomainService;
import com.backend.programming.learning.system.dto.method.create.post.CreatePostCommand;
import com.backend.programming.learning.system.entity.Course;
import com.backend.programming.learning.system.entity.Post;
import com.backend.programming.learning.system.entity.User;
import com.backend.programming.learning.system.mapper.post.PostDataMapper;
import com.backend.programming.learning.system.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.ports.output.repository.PostRepository;
import com.backend.programming.learning.system.ports.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.implemtent.post
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 10:58 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PostCreateHelper {
    private final CourseDomainService courseDomainService;
    private final PostDataMapper postDataMapper;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    @Transactional
    public Post createPost(CreatePostCommand createPostCommand) {
        Course course = getCourse(createPostCommand.getCourseId());
        User createdBy = getUser(createPostCommand.getCreatedBy());

        Post post = postDataMapper.createPostCommandToPost(createPostCommand, course, createdBy);
        courseDomainService.createPost(post);
        return savePost(post);
    }

    private Course getCourse(UUID courseId) {
       Course course = courseRepository.findById(courseId);
        if (Objects.isNull(course)) {
            log.warn("Course with id: {} not found", courseId);
            throw new RuntimeException("Course not found");
        }
        return course;
    }

    private Post savePost(Post post) {
        Post postResult = postRepository.save(post);
        log.info("Post is created with id: {}", postResult.getId());
        return postResult;
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new RuntimeException("User not found");
        }
        return user.get();
    }
}
