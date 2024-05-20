package com.backend.programming.learning.system.course.service.domain.mapper.course;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course.QueryAllCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course.UpdateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.UserCourseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.course.CourseModel;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.CourseType;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class CourseDataMapper {
    public Course createCourseCommandToCourse(
            User user,
            CreateCourseCommand createCourseCommand) {
        return Course.builder()
                .name(createCourseCommand.name())
                .courseIdMoodle(createCourseCommand.courseIdMoodle())
                .courseType(createCourseCommand.courseType())
                .key(createCourseCommand.key())
                .visible(createCourseCommand.visible())
                .createdBy(user)
                .updatedBy(user)
                .build();
    }

    public Course courseModelToCourse(CourseModel courseModel,
                                      User user,
                                      Organization organization,
                                      CourseType courseType) {
        return Course.builder()
                .courseIdMoodle(Integer.valueOf(courseModel.getId()))
                .organization(organization)
                .name(courseModel.getFullname())
                .courseType(courseType)
                .key(courseModel.getIdnumber())
                .visible(courseModel.getVisible().equals(1))
                .createdBy(user)
                .updatedBy(user)
                .build();
    }

    public CreateCourseResponse courseToCreateCourseResponse(Course course, String message) {
        return CreateCourseResponse.builder()
                .id(course.getId().getValue())
                .name(course.getName())
                .courseType(course.getCourseType())
                .visible(course.getVisible())
                .createdBy(course.getCreatedBy().getId())
                .createdAt(course.getCreatedAt())
                .message(message)
                .build();
    }

    public CourseResponseEntity courseToQueryCourseResponse(Course course) {
        List<UserCourseEntity> teachers = course.getTeachers().stream()
                .map(user -> UserCourseEntity.builder()
                        .userId(user.getId().getValue())
                        .name(user.getName())
                        .build())
                .toList();
        return CourseResponseEntity.builder()
                .id(course.getId().getValue())
                .courseIdMoodle(course.getCourseIdMoodle())
                .teachers(teachers)
                .organization(course.getOrganization())
                .name(course.getName())
                .courseType(course.getCourseType())
                .visible(course.getVisible())
                .createdBy(course.getCreatedBy().getId())
                .updatedBy(course.getUpdatedBy().getId())
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .build();
    }

    public QueryAllCourseResponse coursesToQueryAllCourseResponse(Page<Course> courses) {
        return QueryAllCourseResponse.builder()
                .courses(courses.stream()
                        .map(this::courseToQueryCourseResponse)
                        .toList())
                .currentPage(courses.getNumber())
                .totalPages(courses.getTotalPages())
                .totalItems(courses.getTotalElements())
                .build();
    }

    public UpdateCourseResponse courseToUpdateCourseResponse(Course course, String message) {
        return UpdateCourseResponse.builder()
                .courseId(course.getId().getValue())
                .name(course.getName())
                .courseType(course.getCourseType())
                .visible(course.getVisible())
                .message(message)
                .build();
    }

    public void setCourse(Course previousCourse,
                          CourseModel courseModel,
                          User user,
                          CourseType courseType) {
        previousCourse.setName(courseModel.getFullname());
        previousCourse.setCourseType(courseType);
        previousCourse.setUpdatedBy(user);
        previousCourse.setName(courseModel.getFullname());
        previousCourse.setVisible(courseModel.getVisible().equals(1));
    }
}
