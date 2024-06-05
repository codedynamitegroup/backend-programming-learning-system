package com.backend.programming.learning.system.course.service.domain.mapper.course_user;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_user.QueryAllCourseByUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_user.QueryAllCourseUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.UserCourseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course_user.CourseUserResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.CourseUser;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.mapper.course.CourseDataMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * com.backend.programming.learning.system.mapper.course_user
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 10:24 AM
 * Description: ...
 */
@Component
public class CourseUserDataMapper {
    private final CourseDataMapper courseDataMapper;

    public CourseUserDataMapper(CourseDataMapper courseDataMapper) {
        this.courseDataMapper = courseDataMapper;
    }

    public List<CourseUser> createCourseUserCommandToCourseUser(Course course, List<User> users) {
        return users.stream()
                .map(user -> CourseUser.builder()
                        .course(course)
                        .user(user)
                        .build())
                .toList();
    }

    public CourseUser buildCourseUser(Course course, User user) {
        return CourseUser.builder()
                .course(course)
                .user(user)
                .build();
    }

    public CourseUserResponseEntity courseUsersToCourseUserResponseEntity(List<CourseUser> courseUsers) {
        if(courseUsers.isEmpty()) {
            return CourseUserResponseEntity.builder()
                    .course(null)
                    .users(null)
                    .build();
        }

        return CourseUserResponseEntity.builder()
                .course(courseUsers.get(0).getCourse())
                .users(courseUsers.stream()
                        .map(CourseUser::getUser)
                        .toList())
                .build();
    }

    private List<UserCourseEntity> courseUsersToUserCourseEntities(List<CourseUser> courseUsers) {
        return courseUsers.stream()
                .map(courseUser -> UserCourseEntity.builder()
                        .userId(courseUser.getUser().getId().getValue())
                        .firstName(courseUser.getUser().getFirstName())
                        .lastName(courseUser.getUser().getLastName())
                        .email(courseUser.getUser().getEmail())
                        .role(courseUser.getRoleMoodle().getName())
                        .build())
                .toList();
    }

    public QueryAllCourseUserResponse courseUsersToQueryAllCourseUserResponse(Page<CourseUser> courseUsers) {
        return QueryAllCourseUserResponse.builder()
                .users(courseUsersToUserCourseEntities(courseUsers.getContent()))
                .currentPage(courseUsers.getNumber())
                .totalItems(courseUsers.getTotalElements())
                .totalPages(courseUsers.getTotalPages())
                .build();
    }

    public CourseResponseEntity courseUserToCourseResponseEntity(CourseUser courseUser) {
        return courseDataMapper.courseToQueryCourseResponse(courseUser.getCourse());
    }

    public QueryAllCourseByUserResponse courseUsersToQueryAllCourseByUserResponse(Page<CourseUser> courseUsers) {
        return QueryAllCourseByUserResponse.builder()
                .courses(courseUsers.stream()
                        .map(courseUser -> courseDataMapper.courseToQueryCourseResponse(courseUser.getCourse()))
                        .toList())
                .currentPage(courseUsers.getNumber())
                .totalItems(courseUsers.getTotalElements())
                .totalPages(courseUsers.getTotalPages())
                .build();
    }
}
