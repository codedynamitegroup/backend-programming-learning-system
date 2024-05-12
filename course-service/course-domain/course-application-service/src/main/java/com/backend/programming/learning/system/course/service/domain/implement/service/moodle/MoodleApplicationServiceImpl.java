package com.backend.programming.learning.system.course.service.domain.implement.service.moodle;

import com.backend.programming.learning.system.course.service.domain.ports.input.service.moodle.MoodleApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
@RequiredArgsConstructor
public class MoodleApplicationServiceImpl implements MoodleApplicationService {
    private final MoodleCommandHandler moodleCommandHandler;
    @Override
    public String syncCourse() {
        return moodleCommandHandler.syncCourse();
    }

    @Override
    public String syncUser() {
        return moodleCommandHandler.syncUser();
    }

    @Override
    public String syncCourseExam() {
        return moodleCommandHandler.syncCourseExam();
    }
}
