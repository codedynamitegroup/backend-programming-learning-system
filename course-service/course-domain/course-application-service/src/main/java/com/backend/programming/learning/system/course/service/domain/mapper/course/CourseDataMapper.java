package com.backend.programming.learning.system.course.service.domain.mapper.course;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course.QueryAllCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course.UpdateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.UserCourseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course_type.CourseTypeResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.course.CourseModel;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.mapper.organization.OrganizationDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseUserRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseDataMapper {

    private final CourseUserRepository courseUserRepository;
    private final OrganizationDataMapper organizationDataMapper;

    public CourseDataMapper(CourseUserRepository courseUserRepository,
                            OrganizationDataMapper organizationDataMapper) {
        this.courseUserRepository = courseUserRepository;
        this.organizationDataMapper = organizationDataMapper;
    }

    public Course createCourseCommandToCourse(
            User user,
            CreateCourseCommand createCourseCommand) {
        return Course.builder()
                .name(createCourseCommand.name())
                .courseIdMoodle(createCourseCommand.courseIdMoodle())
                .courseType(createCourseCommand.courseType())
                .key(createCourseCommand.key())
                .visible(createCourseCommand.visible())
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
                .build();
    }

    public CreateCourseResponse courseToCreateCourseResponse(Course course, String message) {
        return CreateCourseResponse.builder()
                .id(course.getId().getValue())
                .name(course.getName())
                .courseType(course.getCourseType())
                .visible(course.getVisible())
                .message(message)
                .build();
    }

    public CourseResponseEntity courseToQueryCourseResponse(Course course) {
        List<CourseUser> teachers=courseUserRepository.findByCourseIdAndRoleTeacher(course.getId().getValue());
        List<UserCourseEntity> teachersResponse = teachers.stream()
                .map(courseUser -> UserCourseEntity.builder()
                        .userId(courseUser.getUser().getId().getValue())
                        .firstName(courseUser.getUser().getFirstName())
                        .lastName(courseUser.getUser().getLastName())
                        .email(courseUser.getUser().getEmail())
                        .roleMoodleId(courseUser.getRoleMoodle().getId().getValue())
                        .role(courseUser.getRoleMoodle().getName())
                        .build())
                .toList();
        CourseTypeResponseEntity courseType = CourseTypeResponseEntity.builder()
                .courseTypeId(course.getCourseType().getId().getValue())
                .name(course.getCourseType().getName())
                .moodleId(course.getCourseType().getMoodleId())
                .build();
        return CourseResponseEntity.builder()
                .id(course.getId().getValue())
                .courseIdMoodle(course.getCourseIdMoodle())
                .teachers(teachersResponse)
                .organization(
                        organizationDataMapper.organizationToOrganizationResponseEntity(course.getOrganization())
                )
                .name(course.getName())
                .courseType(courseType)
                .visible(course.getVisible())
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
        previousCourse.setName(courseModel.getFullname());
        previousCourse.setVisible(courseModel.getVisible().equals(1));
    }
}
