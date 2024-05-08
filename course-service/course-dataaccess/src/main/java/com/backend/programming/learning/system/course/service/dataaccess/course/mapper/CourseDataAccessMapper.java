package com.backend.programming.learning.system.course.service.dataaccess.course.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;

    public CourseEntity courseToCourseEntity(Course course) {
        UserEntity createdBy = userDataAccessMapper.userToUserEntity(course.getCreatedBy());
        UserEntity updatedBy = userDataAccessMapper.userToUserEntity(course.getUpdatedBy());
        return CourseEntity.builder()
                .id(course.getId().getValue())
                .courseIdMoodle(course.getCourseIdMoodle())
                .name(course.getName())
                .courseType(course.getCourseType())
                .visible(course.getVisible())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .build();
    }
    public Course courseEntityToCourse(CourseEntity courseEntity) {
        User createdBy = userDataAccessMapper.userEntityToUser(courseEntity.getCreatedBy());
        User updatedBy = userDataAccessMapper.userEntityToUser(courseEntity.getUpdatedBy());
        Course response = Course.builder()
                .name(courseEntity.getName())
                .courseIdMoodle(courseEntity.getCourseIdMoodle())
                .courseType(courseEntity.getCourseType())
                .visible(courseEntity.getVisible())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(courseEntity.getCreatedAt())
                .updatedAt(courseEntity.getUpdatedAt())
                .build();
        response.setId(new CourseId(courseEntity.getId()));
        return response;
    }
}
