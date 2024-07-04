package com.backend.programming.learning.system.course.service.domain.ports.input.service.moodle;

import java.util.UUID;

public interface MoodleApplicationService {

    String syncCourse(UUID organizationId);

    String syncUser(UUID organizationId);

    String syncResource(UUID organizationId);

    String syncCourseExam();
}
