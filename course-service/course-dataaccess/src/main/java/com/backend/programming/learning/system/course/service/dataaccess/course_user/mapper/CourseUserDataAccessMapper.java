package com.backend.programming.learning.system.course.service.dataaccess.course_user.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.course_user.entity.CourseUserEntity;
import com.backend.programming.learning.system.entity.CourseUser;
import com.backend.programming.learning.system.valueobject.CourseUserId;
import org.springframework.stereotype.Component;

@Component
public class CourseUserDataAccessMapper {
    public CourseUserEntity courseUserToCourseUserEntity(CourseUser courseUser) {
        return CourseUserEntity.builder()
                .id(courseUser.getId().getValue())
                .build();
    }

    public CourseUser courseUserEntityToCourseUser(CourseUserEntity courseUserEntity) {
        return CourseUser.builder()
                .id(new CourseUserId(courseUserEntity.getId()))
                .build();
    }
}
