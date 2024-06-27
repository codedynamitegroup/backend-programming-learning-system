package com.backend.programming.learning.system.course.service.domain.dto.responseentity.course;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course_type.CourseTypeResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.organization.OrganizationResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.CourseType;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.responseentity.course
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 8:09 PM
 * Description: ...
 */

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Setter
@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class CourseResponseEntity {
    private UUID id;
    private Integer courseIdMoodle;
    private List<UserCourseEntity> teachers;
    private OrganizationResponseEntity organization;
    private String name;
    private CourseTypeResponseEntity courseType;
    private Boolean visible;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
