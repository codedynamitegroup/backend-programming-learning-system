package com.backend.programming.learning.system.course.service.domain.implement.service.course_user;

import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course_user.DeleteCourseUserCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.entity.WebhookMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseUserRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.implement.course_user
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 12:08 PM
 * Description: ...
 */
@Slf4j
@Component
public class CourseUserDeleteHelper {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CourseUserRepository courseUserRepository;

    public CourseUserDeleteHelper(CourseRepository courseRepository, UserRepository userRepository, CourseUserRepository courseUserRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.courseUserRepository = courseUserRepository;
    }

    public void unAssignCourseToUser(DeleteCourseUserCommand deleteCourseUserCommand) {
        log.info("Un-assigning course to user");
        courseUserRepository.deleteByCourseIdAndUserIdIn(
                deleteCourseUserCommand.courseId(),
                deleteCourseUserCommand.userIds());
    }

    @Transactional
    public void unenrollUserToCourse(WebhookMessage webhookMessage, Organization organization) {
        User user = getUser(Integer.valueOf(webhookMessage.getRelatedUserId()),organization.getId().getValue());
        Course course = getCourse(Integer.valueOf(webhookMessage.getCourseId()), organization.getId().getValue());

        courseUserRepository.deleteByCourseIdAndUserId(course.getId().getValue(), user.getId().getValue());

        log.info("Un-enrolled user with moodle id: {} and user id: {} from course with id: {}",
                webhookMessage.getRelatedUserId(), user.getId(), course.getId());
    }

    private User getUser(Integer userMoodleId, UUID organizationId) {
        Optional<User> user = userRepository.findByUserIdMoodleAndOrganizationId(userMoodleId, organizationId);

        if (user.isEmpty()) {
            log.warn("User with moodle id: {} not found", userMoodleId);
            throw new RuntimeException("User not found");
        }

        return user.get();
    }
    private Course getCourse(Integer courseIdMoodle, UUID organizationId) {
        Optional<Course> course = courseRepository.findByCourseIdMoodleAndOrganizationId(courseIdMoodle, organizationId);

        if (course.isEmpty()) {
            log.warn("Course with moodle id: {} not found", courseIdMoodle);
            throw new RuntimeException("Course not found");
        }

        return course.get();
    }
}
