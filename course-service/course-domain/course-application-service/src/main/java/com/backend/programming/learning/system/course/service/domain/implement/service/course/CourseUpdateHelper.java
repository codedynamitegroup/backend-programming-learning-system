package com.backend.programming.learning.system.course.service.domain.implement.service.course;

import com.backend.programming.learning.system.course.service.domain.dto.method.update.course.UpdateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.course.CourseModel;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.course.service.domain.implement.service.moodle.MoodleCommandHandler;
import com.backend.programming.learning.system.course.service.domain.mapper.course.CourseDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseTypeRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
public class CourseUpdateHelper {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final MoodleCommandHandler moodleCommandHandler;
    private final CourseTypeRepository courseTypeRepository;
    private final CourseDataMapper courseDataMapper;

    public CourseUpdateHelper(
            CourseRepository courseRepository,
            UserRepository userRepository,
            MoodleCommandHandler moodleCommandHandler,
            CourseTypeRepository courseTypeRepository, CourseDataMapper courseDataMapper) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.moodleCommandHandler = moodleCommandHandler;
        this.courseTypeRepository = courseTypeRepository;
        this.courseDataMapper = courseDataMapper;
    }

    public Course updateCourse(CourseId courseId, UpdateCourseCommand updateCourseCommand) {
        Course course = courseRepository.findById(courseId.getValue());
        User updatedBy = getUser(updateCourseCommand.getUpdatedBy());
        course.setName(updateCourseCommand.getName());
        course.setVisible(updateCourseCommand.getVisible());
        Course response = courseRepository.save(course);
        log.info("Course is updated with id: {}", course.getId());
        return response;
    }

    @Transactional
    public Course updateCourse(WebhookMessage webhookMessage) {
        CourseModel courseModel = moodleCommandHandler.getCourse(webhookMessage.getCourseId());
        User user = getUser(Integer.valueOf(webhookMessage.getUserId()));
        CourseType courseType = findCourseType(courseModel.getCategoryid());

        Course previousCourse = findCourse(Integer.valueOf(courseModel.getId()));
        courseDataMapper.setCourse(previousCourse, courseModel, user, courseType);

        Course saveResult = courseRepository.save(previousCourse);
        log.info("Course is updated from moodle with id: {} ", previousCourse.getId());

        return saveResult;
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new RuntimeException("User not found");
        }
        return user.get();
    }

    private User getUser(Integer moodleUserId) {
        Optional<User> user = userRepository.findByUserIdMoodle(moodleUserId);

        if (user.isEmpty()) {
            log.warn("User with moodleUserId: {} not found", moodleUserId);
            throw new UserNotFoundException("User not found with moodle id: " + moodleUserId);
        }

        return user.get();
    }
    private CourseType findCourseType(Integer courseTypeMoodleId) {
        Optional<CourseType> courseType = courseTypeRepository.findByMoodleId(courseTypeMoodleId);

        if (courseType.isEmpty()) {
            log.warn("Course type not found with moodle id: {}", courseTypeMoodleId);
            throw new RuntimeException("Course type not found");
        }
        return courseType.get();
    }

    private Course findCourse(Integer courseIdMoodle) {
        Optional<Course> course = courseRepository.findByCourseIdMoodle(courseIdMoodle);

        if (course.isEmpty()) {
            log.warn("Course not found with courseIdMoodle: {}", courseIdMoodle);
            throw new RuntimeException("Course not found");
        }

        return course.get();
    }
}
