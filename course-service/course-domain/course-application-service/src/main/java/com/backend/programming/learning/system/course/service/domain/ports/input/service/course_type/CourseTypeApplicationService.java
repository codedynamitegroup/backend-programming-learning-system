package com.backend.programming.learning.system.course.service.domain.ports.input.service.course_type;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryAllCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryCourseTypeCommand;

public interface CourseTypeApplicationService {
    QueryAllCourseTypeResponse findAll();

    QueryAllCourseTypeResponse findAllByOrganizationId(QueryCourseTypeCommand queryCourseTypeCommand);
}
