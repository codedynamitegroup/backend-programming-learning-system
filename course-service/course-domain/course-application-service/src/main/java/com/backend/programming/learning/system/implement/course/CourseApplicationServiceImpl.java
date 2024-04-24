package com.backend.programming.learning.system.implement.course;

import com.backend.programming.learning.system.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.dto.method.delete.course.DeleteCourseCommand;
import com.backend.programming.learning.system.dto.method.delete.course.DeleteCourseResponse;
import com.backend.programming.learning.system.dto.method.query.course.QueryAllCourseCommand;
import com.backend.programming.learning.system.dto.method.query.course.QueryAllCourseResponse;
import com.backend.programming.learning.system.dto.method.query.course.QueryCourseCommand;
import com.backend.programming.learning.system.dto.method.update.course.UpdateCourseCommand;
import com.backend.programming.learning.system.dto.method.update.course.UpdateCourseResponse;
import com.backend.programming.learning.system.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.ports.input.service.course.CourseApplicationService;
import com.backend.programming.learning.system.valueobject.CourseId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * com.backend.programming.learning.system.implemtent.course
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 2:13 AM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class CourseApplicationServiceImpl implements CourseApplicationService {
    private final CourseCommandHandler courseCommandHandler;

    @Override
    public CreateCourseResponse createCourse(CreateCourseCommand createCourseCommand) {
        return courseCommandHandler.createCourse(createCourseCommand);
    }

    @Override
    public QueryAllCourseResponse findAll(QueryAllCourseCommand queryAllCourseCommand) {
        return courseCommandHandler.findAll(queryAllCourseCommand);
    }

    @Override
    public CourseResponseEntity findBy(QueryCourseCommand queryCourseCommand) {
        return courseCommandHandler.findBy(queryCourseCommand);
    }

    @Override
    public DeleteCourseResponse deleteCourse(DeleteCourseCommand deleteCourseCommand) {
        return courseCommandHandler.deleteCourse(deleteCourseCommand);
    }

    @Override
    public UpdateCourseResponse updateCourse(CourseId courseId, UpdateCourseCommand updateCourseCommand) {
        return courseCommandHandler.updateCourse(courseId, updateCourseCommand);
    }
}
