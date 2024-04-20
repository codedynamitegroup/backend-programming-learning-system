package com.backend.programming.learning.system.mapper.course_user;

import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.dto.method.create.course_user.CreateCourseUserCommand;
import com.backend.programming.learning.system.entity.Course;
import com.backend.programming.learning.system.entity.CourseUser;
import com.backend.programming.learning.system.entity.User;
import com.backend.programming.learning.system.valueobject.CourseId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
}
