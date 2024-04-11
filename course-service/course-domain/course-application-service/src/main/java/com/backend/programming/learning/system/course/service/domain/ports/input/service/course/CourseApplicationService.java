package com.backend.programming.learning.system.course.service.domain.ports.input.service.course;

import com.backend.programming.learning.system.course.service.domain.dto.course.create.CreateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.course.create.CreateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.course.get.CourseResponse;

/**
 * com.backend.programming.learning.system.course.service.domain.ports.input.service.course
 * Create by Dang Ngoc Tien
 * Date 4/10/2024 - 11:59 PM
 * Description: ...
 */
public interface CourseApplicationService {
    CreateCourseResponse createCourse(CreateCourseCommand createCourseCommand);

    CourseResponse findAll(String search);
}
