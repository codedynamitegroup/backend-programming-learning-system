package com.backend.programming.learning.system.course.service.dataaccess.post.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course.mapper.CourseDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.post.entity.PostEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.Post;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.PostId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;
    private final CourseDataAccessMapper courseDataAccessMapper;

    public PostEntity postToPostEntity(Post post) {
        CourseEntity courseEntity = courseDataAccessMapper.courseToCourseEntity(post.getCourse());
        UserEntity userEntity = userDataAccessMapper.userToUserEntity(post.getCreatedBy());
        return PostEntity.builder()
                .id(post.getId().getValue())
                .course(courseEntity)
                .title(post.getTitle())
                .summary(post.getSummary())
                .content(post.getContent())
                .publishState(post.getPublished())
                .createdBy(userEntity)
                .updatedBy(userEntity)
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

    public Post postEntityToPost(PostEntity postEntity) {
        User createdBy = userDataAccessMapper.userEntityToUser(postEntity.getCreatedBy());
        User updatedBy = userDataAccessMapper.userEntityToUser(postEntity.getUpdatedBy());
        Course course = courseDataAccessMapper.courseEntityToCourse(postEntity.getCourse());
        return Post.builder()
                .id(new PostId(postEntity.getId()))
                .course(course)
                .title(postEntity.getTitle())
                .summary(postEntity.getSummary())
                .content(postEntity.getContent())
                .isPublished(postEntity.getPublishState())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(postEntity.getCreatedAt())
                .updatedAt(postEntity.getUpdatedAt())
                .build();
    }
}
