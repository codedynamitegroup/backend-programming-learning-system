package com.backend.programming.learning.system.course.service.domain.implement.service.course_user;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_user.CreateCourseUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_user.CreateCourseUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course_user.DeleteCourseUserCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.backend.programming.learning.system.implement.course_user
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 10:14 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CourseUserCommandHandler {
    private final CourseUserCreateHelper courseUserCreateHelper;
    private final CourseUserDeleteHelper courseUserDeleteHelper;
    @Transactional
    public CreateCourseUserResponse assignCourseToUser(CreateCourseUserCommand createCourseUserCommand) {
        courseUserCreateHelper.assignCourseToUser(createCourseUserCommand);
        log.info("Course assigned to user successfully");
        return CreateCourseUserResponse.builder().message("Course assigned to users successfully").build();
    }

    @Transactional
    public CreateCourseUserResponse unAssignCourseToUser(DeleteCourseUserCommand deleteCourseUserCommand) {
        courseUserDeleteHelper.unAssignCourseToUser(deleteCourseUserCommand);
        log.info("Course un-assigned to user successfully");
        return CreateCourseUserResponse.builder().message("Course un-assigned to users successfully").build();
    }
}
