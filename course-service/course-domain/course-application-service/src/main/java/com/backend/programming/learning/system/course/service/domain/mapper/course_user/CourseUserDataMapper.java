package com.backend.programming.learning.system.course.service.domain.mapper.course_user;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course_user.CourseUserResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.CourseUser;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * com.backend.programming.learning.system.mapper.course_user
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 10:24 AM
 * Description: ...
 */
@Component
public class CourseUserDataMapper {
    public List<CourseUser> createCourseUserCommandToCourseUser(Course course, List<User> users) {
        return users.stream()
                .map(user -> CourseUser.builder()
                        .course(course)
                        .user(user)
                        .build())
                .toList();
    }

    public CourseUser buildCourseUser(Course course, User user) {
        return CourseUser.builder()
                .course(course)
                .user(user)
                .build();
    }

    public CourseUserResponseEntity courseUsersToCourseUserResponseEntity(List<CourseUser> courseUsers) {
        if(courseUsers.isEmpty()) {
            return CourseUserResponseEntity.builder()
                    .course(null)
                    .users(null)
                    .build();
        }

        return CourseUserResponseEntity.builder()
                .course(courseUsers.get(0).getCourse())
                .users(courseUsers.stream()
                        .map(CourseUser::getUser)
                        .toList())
                .build();
    }
}
