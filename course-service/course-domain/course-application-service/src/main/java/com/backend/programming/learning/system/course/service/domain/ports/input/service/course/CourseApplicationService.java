package com.backend.programming.learning.system.course.service.domain.ports.input.service.course;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course.DeleteCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course.DeleteCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course.QueryAllCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course.QueryAllCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course.QueryCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course.QueryGeneralCourseStatisticsResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course.UpdateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course.UpdateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;

import jakarta.validation.Valid;

public interface CourseApplicationService {
    CreateCourseResponse createCourse(
            @Valid CreateCourseCommand createCourseCommand);

    QueryAllCourseResponse findAll(
            @Valid QueryAllCourseCommand queryAllCourseCommand);

    CourseResponseEntity findBy(
            @Valid QueryCourseCommand queryCourseCommand);

    DeleteCourseResponse deleteCourse(
            @Valid DeleteCourseCommand deleteCourseCommand);

    UpdateCourseResponse updateCourse(
            CourseId courseId,
            @Valid UpdateCourseCommand updateCourseCommand);

    QueryGeneralCourseStatisticsResponse getCourseStatistics();
}
