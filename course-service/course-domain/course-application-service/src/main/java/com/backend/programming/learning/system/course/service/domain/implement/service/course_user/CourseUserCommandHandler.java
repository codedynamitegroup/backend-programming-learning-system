package com.backend.programming.learning.system.course.service.domain.implement.service.course_user;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_user.CreateCourseUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_user.CreateCourseUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course_user.DeleteCourseUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_user.QueryCourseUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course_user.CourseUserResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.CourseUser;
import com.backend.programming.learning.system.course.service.domain.mapper.course_user.CourseUserDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    private final CourseUserQueryHelper courseUserQueryHelper;
    private final CourseUserDataMapper courseUserDataMapper;
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

    @Transactional(readOnly = true)
    public CourseUserResponseEntity queryAllByCourseId(QueryCourseUserCommand queryCourseUserCommand) {
        List<CourseUser> courseUsers = courseUserQueryHelper.findByCourseId(queryCourseUserCommand.getCourseId());
        return courseUserDataMapper.courseUsersToCourseUserResponseEntity(courseUsers);
    }

    @Transactional(readOnly = true)
    public CourseUserResponseEntity queryAllByCourseIdAndRoleTeacher(QueryCourseUserCommand queryCourseUserCommand) {
        List<CourseUser> courseUsers = courseUserQueryHelper.findByCourseIdAndRoleTeacher(queryCourseUserCommand.getCourseId());
        return courseUserDataMapper.courseUsersToCourseUserResponseEntity(courseUsers);
    }
}
