package com.backend.programming.learning.system.implement.course;

import com.backend.programming.learning.system.dto.method.update.course.UpdateCourseCommand;
import com.backend.programming.learning.system.entity.Course;
import com.backend.programming.learning.system.entity.User;
import com.backend.programming.learning.system.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.valueobject.CourseId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.implement.course
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 10:31 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CourseUpdateHelper {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public Course updateCourse(CourseId courseId, UpdateCourseCommand updateCourseCommand) {
        Course course = courseRepository.findById(courseId.getValue());
        User updatedBy = getUser(updateCourseCommand.getUpdatedBy());
        course.setName(updateCourseCommand.getName());
        course.setVisible(updateCourseCommand.getVisible());
        course.setUpdatedBy(updatedBy);
        Course response = courseRepository.save(course);
        log.info("Course is updated with id: {}", course.getId());
        return response;
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
