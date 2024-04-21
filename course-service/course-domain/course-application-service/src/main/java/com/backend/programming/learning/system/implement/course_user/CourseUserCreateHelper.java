package com.backend.programming.learning.system.implement.course_user;

import com.backend.programming.learning.system.CourseDomainService;
import com.backend.programming.learning.system.dto.method.create.course_user.CreateCourseUserCommand;
import com.backend.programming.learning.system.entity.Course;
import com.backend.programming.learning.system.entity.CourseUser;
import com.backend.programming.learning.system.entity.User;
import com.backend.programming.learning.system.mapper.course_user.CourseUserDataMapper;
import com.backend.programming.learning.system.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.ports.output.repository.CourseUserRepository;
import com.backend.programming.learning.system.ports.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.implement.course_user
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 10:15 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CourseUserCreateHelper {
    private final CourseDomainService courseDomainService;
    private final CourseUserRepository courseUserRepository;
    private final CourseUserDataMapper courseUserDataMapper;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public void assignCourseToUser(CreateCourseUserCommand createCourseUserCommand) {
        log.info("Assign course to user");
        Course course = getCourse(createCourseUserCommand.getCourseId());
        List<User> users = getUsers(createCourseUserCommand.getUserIds());
        List<CourseUser> courseUsers = courseUserDataMapper.createCourseUserCommandToCourseUser(course, users);
        courseDomainService.createCourseUsers(courseUsers);
        courseUserRepository.saveAll(courseUsers);
    }


    private List<User> getUsers(List<UUID> userIds) {
        List<User> users = new ArrayList<>();
        for (UUID userId : userIds) {
            Optional<User> user = userRepository.findUser(userId);
            if (user.isEmpty()) {
                log.warn("User with id: {} not found", userId);
                throw new RuntimeException("User not found");
            }
            users.add(user.get());
        }
        return users;
    }

    private Course getCourse(UUID courseId) {
        Course course = courseRepository.findById(courseId);
        if (Objects.isNull(course)) {
            log.warn("Course with id: {} not found", courseId);
            throw new RuntimeException("Course not found");
        }
        return course;
    }
}
