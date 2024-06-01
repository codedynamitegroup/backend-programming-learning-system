package com.backend.programming.learning.system.course.service.domain.implement.service.course_type;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryAllCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.course_type.CourseTypeApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class CourseTypeApplicationServiceImpl implements CourseTypeApplicationService {
    private final CourseTypeCommandHandler courseTypeCommandHandler;
    @Override
    public QueryAllCourseTypeResponse findAll() {
        return courseTypeCommandHandler.findAll();
    }

    @Override
    public QueryAllCourseTypeResponse findAllByOrganizationId(QueryCourseTypeCommand queryCourseTypeCommand) {
        return courseTypeCommandHandler.findAllByOrganizationId(queryCourseTypeCommand);
    }
}
