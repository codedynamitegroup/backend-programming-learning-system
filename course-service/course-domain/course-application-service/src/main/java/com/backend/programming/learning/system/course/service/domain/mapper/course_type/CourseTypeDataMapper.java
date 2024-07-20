package com.backend.programming.learning.system.course.service.domain.mapper.course_type;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_type.CreateCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryAllCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course_type.UpdateCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course_type.CourseTypeResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.CourseType;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CourseTypeDataMapper {


    public CourseTypeResponseEntity mapToCourseTypeResponseEntity(CourseType courseType) {
        return CourseTypeResponseEntity.builder()
                .courseTypeId(courseType.getId().getValue())
                .organizationId(courseType.getOrganization() == null ? null : courseType.getOrganization().getId().getValue())
                .moodleId(courseType.getMoodleId())
                .name(courseType.getName())
                .build();
    }

    public QueryAllCourseTypeResponse mapToQueryAllCourseTypeResponse(Page<CourseType> courseTypes) {
        List<CourseTypeResponseEntity> courseTypeResponseEntities = courseTypes
                .map(this::mapToCourseTypeResponseEntity).getContent();
        return QueryAllCourseTypeResponse.builder()
                .courseTypes(courseTypeResponseEntities)
                .currentPage(courseTypes.getNumber())
                .totalPages(courseTypes.getTotalPages())
                .totalItems(courseTypes.getTotalElements())
                .build();
    }

    public CourseType createCourseTypeCommandToCourseType(
            CreateCourseTypeCommand createCourseTypeCommand) {
        return CourseType.builder()
                .name(createCourseTypeCommand.name())
                .build();
    }
}
