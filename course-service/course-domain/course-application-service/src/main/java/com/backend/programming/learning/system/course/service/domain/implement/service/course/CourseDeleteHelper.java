package com.backend.programming.learning.system.course.service.domain.implement.service.course;

import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.implement.course
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 11:10 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CourseDeleteHelper {
    private final CourseRepository courseRepository;
    public void deleteCourse(UUID courseId) {
        log.info("Course deleted with id: {}", courseId);
        courseRepository.deleteById(courseId);
    }

    public void deleteCourse(Integer courseMoodleId) {
        courseRepository.deleteByMoodleId(courseMoodleId);
        log.info("Course deleted with course moodle id: {}", courseMoodleId);
    }
}
