package com.backend.programming.learning.system.course.service.domain.implement.service.moodle_course;

import com.backend.programming.learning.system.course.service.domain.ports.input.service.moodle_course.MoodleCourseApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * com.backend.programming.learning.system.course.service.domain.implement.service.moodle_course
 * Create by Dang Ngoc Tien
 * Date 5/6/2024 - 11:15 PM
 * Description: ...
 */
@Service
@Validated
@Slf4j
@RequiredArgsConstructor
public class MoodleCourseApplicationServiceImpl implements MoodleCourseApplicationService {
    private final MoodleCourseCommandHandler moodleCourseCommandHandler;
    @Override
    public void syncCourse() {
        moodleCourseCommandHandler.syncCourse();
    }
}
