package com.backend.programming.learning.system.course.service.domain.implement.service.course_type;

import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course_user.DeleteCourseUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course_type.UpdateCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.CourseType;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.entity.WebhookMessage;
import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseTypeRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseUserRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CourseTypeDeleteHelper {
    private final CourseTypeRepository courseTypeRepository;

    public CourseTypeDeleteHelper(CourseTypeRepository courseTypeRepository) {
        this.courseTypeRepository = courseTypeRepository;
    }

    @Transactional
    public void deleteCourseType(UUID courseTypeId) {
        CourseType courseType = getCourseType(courseTypeId);

        if (courseType.getMoodleId() != null) {
            log.warn("Course type with id: {} has moodle id: {}", courseTypeId, courseType.getMoodleId());
            throw new CourseDomainException("Course type has associated moodle id! Cannot delete course type");
        }
        courseTypeRepository.deleteCourseTypeById(courseTypeId);
    }

    private CourseType getCourseType(UUID courseTypeId) {
        Optional<CourseType> courseType = courseTypeRepository.findById(courseTypeId);
        if (courseType.isEmpty()) {
            log.warn("Course type with id: {} not found", courseTypeId);
            throw new CourseDomainException("Course type not found");
        }
        return courseType.get();
    }
}
