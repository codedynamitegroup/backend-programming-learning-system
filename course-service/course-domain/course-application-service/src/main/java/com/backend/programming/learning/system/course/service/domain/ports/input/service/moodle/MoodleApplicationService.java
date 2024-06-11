package com.backend.programming.learning.system.course.service.domain.ports.input.service.moodle;

import java.util.UUID;

public interface MoodleApplicationService {

    String syncCourse();

    String syncUser(UUID organizationId);

    String syncCourseExam();
}
