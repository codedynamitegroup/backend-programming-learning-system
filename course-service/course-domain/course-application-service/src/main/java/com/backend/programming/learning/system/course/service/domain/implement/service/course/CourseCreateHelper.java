package com.backend.programming.learning.system.course.service.domain.implement.service.course;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.course.CourseModel;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.course.service.domain.implement.service.moodle.MoodleCommandHandler;
import com.backend.programming.learning.system.course.service.domain.mapper.course.CourseDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseTypeRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
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
public class CourseCreateHelper {
    private final CourseDomainService courseDomainService;
    private final CourseDataMapper courseDataMapper;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final MoodleCommandHandler moodleCommandHandler;
    private final CourseTypeRepository courseTypeRepository;

    public CourseCreateHelper(
            CourseDomainService courseDomainService,
            CourseDataMapper courseDataMapper,
            CourseRepository courseRepository,
            UserRepository userRepository,
            MoodleCommandHandler moodleCommandHandler,
            CourseTypeRepository courseTypeRepository) {
        this.courseDomainService = courseDomainService;
        this.courseDataMapper = courseDataMapper;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.moodleCommandHandler = moodleCommandHandler;
        this.courseTypeRepository = courseTypeRepository;
    }

    @Transactional
    public Course createCourse(CreateCourseCommand createCourseCommand) {
        User user = getUser(createCourseCommand.createdBy());
        Course course = courseDataMapper.createCourseCommandToCourse(user, createCourseCommand);

        courseDomainService.createCourse(course);

        Course createResult = saveCourse(course);
        log.info("Course is created with id: {}", createResult.getId());
        return createResult;
    }

    @Transactional
    public Course createCourse(WebhookMessage webhookMessage, Organization organization) {
        CourseModel courseModel = moodleCommandHandler.getCourse(webhookMessage.getCourseId());
        User user = getUser(Integer.valueOf(webhookMessage.getUserId()));
        CourseType courseType = findCourseType(courseModel.getCategoryid());
        Course course = courseDataMapper.courseModelToCourse(courseModel, user, organization, courseType );

        courseDomainService.createCourse(course);

        Course result = saveCourse(course);

        log.info("Course created from moodle with id: {}", course.getId());

        return result;
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
}
