package com.backend.programming.learning.system.course.service.domain.implement.service.course_type;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryAllCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course_type.CourseTypeResponseEntity;
import com.backend.programming.learning.system.course.service.domain.mapper.course_type.CourseTypeDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class CourseTypeCommandHandler {

    private final CourseTypeQueryHelper courseTypeQueryHelper;
    private final CourseTypeDataMapper courseTypeDataMapper;

    @Transactional(readOnly = true)
    public QueryAllCourseTypeResponse findAll()
    {
        return courseTypeDataMapper.mapToQueryAllCourseTypeResponse(courseTypeQueryHelper.findAll());
    }

    @Transactional(readOnly = true)
    public QueryAllCourseTypeResponse findAllByOrganizationId(QueryCourseTypeCommand queryCourseTypeCommand)
    {
        return courseTypeDataMapper.
                mapToQueryAllCourseTypeResponse(courseTypeQueryHelper.
                        findAllByOrganizationId(queryCourseTypeCommand.getOrganizationId()));
    }



}
