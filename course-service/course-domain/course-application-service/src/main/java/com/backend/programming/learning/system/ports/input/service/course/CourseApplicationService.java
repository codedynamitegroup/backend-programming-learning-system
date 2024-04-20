package com.backend.programming.learning.system.ports.input.service.course;

import com.backend.programming.learning.system.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.dto.method.delete.course.DeleteCourseCommand;
import com.backend.programming.learning.system.dto.method.delete.course.DeleteCourseResponse;
import com.backend.programming.learning.system.dto.method.query.course.QueryAllCourseCommand;
import com.backend.programming.learning.system.dto.method.query.course.QueryAllCourseResponse;
import com.backend.programming.learning.system.dto.method.query.course.QueryCourseCommand;
import com.backend.programming.learning.system.dto.responseentity.course.CourseResponseEntity;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface CourseApplicationService {
    // Question
    CreateCourseResponse createQuestion(@Valid CreateCourseCommand createCourseCommand);

    // CertificateCourse
    CreateCourseResponse createCertificateCourse(@Valid CreateCourseCommand createCourseCommand);

    CreateCourseResponse createCourse(
            @Valid CreateCourseCommand createCourseCommand);

    QueryAllCourseResponse findAll(
            @Valid QueryAllCourseCommand queryAllCourseCommand);

    CourseResponseEntity findBy(
            @Valid QueryCourseCommand queryCourseCommand);

    DeleteCourseResponse deleteCourse(
            @Valid DeleteCourseCommand deleteCourseCommand);
}
