package com.backend.programming.learning.system.course.service.domain.ports.input.service.course_user;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_user.CreateCourseUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_user.CreateCourseUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course_user.DeleteCourseUserCommand;

import javax.validation.Valid;

/**
 * com.backend.programming.learning.system.ports.input.service.course_user
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 10:05 AM
 * Description: ...
 */
public interface CourseUserApplicationService {
    CreateCourseUserResponse assignCourseToUser(
            @Valid CreateCourseUserCommand createCourseUserCommand);

    CreateCourseUserResponse unAssignCourseToUser(
            @Valid DeleteCourseUserCommand deleteCourseUserCommand);
}
