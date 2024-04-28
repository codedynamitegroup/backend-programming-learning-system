package com.backend.programming.learning.system.course.service.domain.implement.course_user;

import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course_user.DeleteCourseUserCommand;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.implement.course_user
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 12:08 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CourseUserDeleteHelper {
    private final CourseUserRepository courseUserRepository;
    public void unAssignCourseToUser(DeleteCourseUserCommand deleteCourseUserCommand) {
        log.info("Un-assigning course to user");
        courseUserRepository.deleteByCourseIdAndUserIdIn(
                deleteCourseUserCommand.courseId(),
                deleteCourseUserCommand.userIds());
    }
}
