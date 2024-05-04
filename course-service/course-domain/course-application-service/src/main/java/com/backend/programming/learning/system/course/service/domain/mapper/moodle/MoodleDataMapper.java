package com.backend.programming.learning.system.course.service.domain.mapper.moodle;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.CourseModel;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.CourseUser;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseUserId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.UUID;

@Component

public class MoodleDataMapper {

    public Course createCourse(CourseModel courseModel) {
        return Course.builder()
                .id(new CourseId(UUID.randomUUID()))
                .name(courseModel.getFullname())
                .courseType(courseModel.getShortname())
                .key(courseModel.getIdnumber())
                .visible(courseModel.getVisible()==1)
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();
    }


    public CourseUser createCourseUser(Course course, User user) {
        return CourseUser.builder()
                .id(new CourseUserId(UUID.randomUUID()))
                .course(course)
                .user(user)
                .build();
    }
    public CourseResponseEntity courseToCourseResponseEntity(Course course) {
        return CourseResponseEntity.builder()
                .id(course.getId().getValue())
                .name(course.getName())
                .visible(course.getVisible())
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .build();
    }
}
