package com.backend.programming.learning.system.course.service.domain.implement.service.course_type;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_type.CreateCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_type.CreateCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course_type.DeleteCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryAllCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course_type.UpdateCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course_type.UpdateCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course_type.CourseTypeResponseEntity;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.course_type.CourseTypeApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

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

    @Override
    public CreateCourseTypeResponse createCourseType(CreateCourseTypeCommand createCourseTypeCommand) {
        return courseTypeCommandHandler.createCourseType(createCourseTypeCommand);
    }

    @Override
    public UpdateCourseTypeResponse updateCourseType(UpdateCourseTypeCommand updateCourseTypeCommand) {
        return courseTypeCommandHandler.updateCourseType(updateCourseTypeCommand);
    }

    @Override
    public DeleteCourseTypeResponse deleteCourseType(UUID courseTypeId) {
        return courseTypeCommandHandler.deleteCourseType(courseTypeId);
    }

    @Override
    public CourseTypeResponseEntity findById(UUID courseTypeId)
    {
        return courseTypeCommandHandler.findById(courseTypeId);
    }
}
