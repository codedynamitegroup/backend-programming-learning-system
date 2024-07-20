package com.backend.programming.learning.system.course.service.dataaccess.course.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course_type.entity.CourseTypeEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course_type.mapper.CourseTypeDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.CourseType;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseDataAccessMapper {
    private final CourseTypeDataAccessMapper courseTypeDataAccessMapper;
    private final OrganizationDataAccessMapper organizationDataAccessMapper;

    public CourseEntity courseToCourseEntity(Course course) {
        CourseTypeEntity courseType =
                course.getCourseType() == null ? null :
                courseTypeDataAccessMapper.courseTypeToCourseTypeEntity(course.getCourseType());
        OrganizationEntity organization =
                course.getOrganization() == null ? null :
                organizationDataAccessMapper.organizationToOrganizationEntity(course.getOrganization());
        return CourseEntity.builder()
                .id(course.getId().getValue())
                .courseIdMoodle(course.getCourseIdMoodle())
                .name(course.getName())
                .courseType(courseType)
                .visible(course.getVisible())
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .organization(organization)
                .build();
    }

    public CourseEntity courseToCourseEntityHideSensitiveData(Course course) {
        CourseTypeEntity courseType =
                course.getCourseType() == null ? null :
                        courseTypeDataAccessMapper.courseTypeToCourseTypeEntity(course.getCourseType());
        OrganizationEntity organization =
                course.getOrganization() == null ? null :
                        organizationDataAccessMapper.organizationToOrganizationEntityHideSensitiveData(course.getOrganization());
        return CourseEntity.builder()
                .id(course.getId().getValue())
                .courseIdMoodle(course.getCourseIdMoodle())
                .name(course.getName())
                .courseType(courseType)
                .visible(course.getVisible())
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .organization(organization)
                .build();
    }
    public Course courseEntityToCourse(CourseEntity courseEntity) {
        CourseType courseType = courseTypeDataAccessMapper.courseTypeEntityToCourseType(courseEntity.getCourseType());
        Course response = Course.builder()
                .name(courseEntity.getName())
                .courseIdMoodle(courseEntity.getCourseIdMoodle())
                .courseType(courseType)
                .visible(courseEntity.getVisible())
                .createdAt(courseEntity.getCreatedAt())
                .updatedAt(courseEntity.getUpdatedAt())
                .organization(courseEntity.getOrganization() == null ? null :
                        organizationDataAccessMapper.organizationEntityToOrganization(courseEntity.getOrganization()))
                .build();
        response.setId(new CourseId(courseEntity.getId()));
        return response;
    }
}
