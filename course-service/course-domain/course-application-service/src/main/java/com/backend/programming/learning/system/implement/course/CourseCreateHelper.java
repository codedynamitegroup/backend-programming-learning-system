package com.backend.programming.learning.system.implement.course;

import com.backend.programming.learning.system.CourseDomainService;
import com.backend.programming.learning.system.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.entity.Course;
import com.backend.programming.learning.system.entity.User;
import com.backend.programming.learning.system.mapper.course.CourseDataMapper;
import com.backend.programming.learning.system.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.ports.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.implemtent.course
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 2:16 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CourseCreateHelper {
    private final CourseDomainService courseDomainService;
    private final CourseDataMapper courseDataMapper;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    @Transactional
    public Course createCourse(CreateCourseCommand createCourseCommand) {
        User user = getUser(createCourseCommand.createdBy());
        Course course = courseDataMapper.createCourseCommandToCourse(user, createCourseCommand);

        courseDomainService.createCourse(course);

        Course createResult = saveCourse(course);
        log.info("Course is created with id: {}", createResult.getId());
        return createResult;
    }

    private Course saveCourse(Course course) {
        Course saveCourse = courseRepository.save(course);

        if (Objects.isNull(saveCourse)) {
            log.error("Failed to save course");
            throw new RuntimeException("Failed to save course");
        }
        log.info("Course saved successfully with id: {}", saveCourse.getId());
        return saveCourse;
    }
    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new RuntimeException("User not found");
        }
        return user.get();
    }
}
