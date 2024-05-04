package com.backend.programming.learning.system.course.service.domain.implement.service.course_user;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_user.CreateCourseUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_user.CreateCourseUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course_user.DeleteCourseUserCommand;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.course_user.CourseUserApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * com.backend.programming.learning.system.implement.course_user
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 10:14 AM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class CourseUserApplicationServiceImpl implements CourseUserApplicationService {
    private final CourseUserCommandHandler courseUserCommandHandler;
    @Override
    public CreateCourseUserResponse assignCourseToUser(CreateCourseUserCommand createCourseUserCommand) {
        return courseUserCommandHandler.assignCourseToUser(createCourseUserCommand);
    }

    @Override
    public CreateCourseUserResponse unAssignCourseToUser(DeleteCourseUserCommand deleteCourseUserCommand) {
        return courseUserCommandHandler.unAssignCourseToUser(deleteCourseUserCommand);
    }
}
