package com.backend.programming.learning.system.course.service.domain.implement.service.moodle;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.moodle.MoodleApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Slf4j
@RequiredArgsConstructor
public class MoodleApplicationServiceImpl implements MoodleApplicationService {
    private final MoodleCommandHandler moodleCommandHandler;
    @Override
    public List<CourseResponseEntity> syncCourse() {
        return moodleCommandHandler.syncCourse();
    }
}
