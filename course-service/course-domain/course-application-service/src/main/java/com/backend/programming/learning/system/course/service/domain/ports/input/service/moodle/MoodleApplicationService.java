package com.backend.programming.learning.system.course.service.domain.ports.input.service.moodle;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;

import java.util.List;

public interface MoodleApplicationService {
    List<CourseResponseEntity> syncCourse();

}
