package com.backend.programming.learning.system.course.service.domain.mapper.course_type;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryAllCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course_type.CourseTypeResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.CourseType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CourseTypeDataMapper {


    public CourseTypeResponseEntity mapToCourseTypeResponseEntity(CourseType courseType) {
        return CourseTypeResponseEntity.builder()
                .courseTypeId(courseType.getId().getValue())
                .organizationId(courseType.getOrganization().getId().getValue())
                .moodleId(courseType.getMoodleId())
                .name(courseType.getName())
                .build();
    }

    public QueryAllCourseTypeResponse mapToQueryAllCourseTypeResponse(List<CourseType> courseTypes) {
        return QueryAllCourseTypeResponse.builder()
                .courseTypes(courseTypes.stream()
                        .map(this::mapToCourseTypeResponseEntity)
                        .toList())
                .build();
    }

}
