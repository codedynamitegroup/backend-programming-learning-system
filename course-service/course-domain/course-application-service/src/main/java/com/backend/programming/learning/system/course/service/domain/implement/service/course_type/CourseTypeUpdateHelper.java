package com.backend.programming.learning.system.course.service.domain.implement.service.course_type;

import com.backend.programming.learning.system.course.service.domain.dto.method.update.course_type.UpdateCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Component
public class CourseTypeUpdateHelper {
    private final CourseTypeRepository courseTypeRepository;

    public CourseTypeUpdateHelper(CourseTypeRepository courseTypeRepository) {
        this.courseTypeRepository = courseTypeRepository;
    }

    @Transactional
    public CourseType updateCourseType(UpdateCourseTypeCommand updateCourseTypeCommand) {
        CourseType courseType = getCourseType(updateCourseTypeCommand.id());

        if (updateCourseTypeCommand.name() != null) {
            courseType.setName(updateCourseTypeCommand.name());
        }
        CourseType courseTypeSaved = courseTypeRepository.save(courseType);
        return courseTypeSaved;
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
