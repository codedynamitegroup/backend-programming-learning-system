package com.backend.programming.learning.system.course.service.domain.dto.responseentity.course_user;

import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CourseUserResponseEntity {
    private final Course course;
    private final List<User> users;
}
