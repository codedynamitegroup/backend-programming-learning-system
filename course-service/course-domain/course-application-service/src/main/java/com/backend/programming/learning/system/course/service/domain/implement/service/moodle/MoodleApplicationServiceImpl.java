package com.backend.programming.learning.system.course.service.domain.implement.service.moodle;

import com.backend.programming.learning.system.course.service.domain.ports.input.service.moodle.MoodleApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
@Slf4j
@RequiredArgsConstructor
public class MoodleApplicationServiceImpl implements MoodleApplicationService {
    private final MoodleCommandHandler moodleCommandHandler;
    @Override
    public String syncCourse(UUID organizationId) {
        return moodleCommandHandler.syncCourse(organizationId);
    }

    @Override
    public String syncUser(UUID organizationId) {
        return moodleCommandHandler.syncUser(organizationId);
    }

    @Override
    public String syncResource(UUID organizationId) {
        return moodleCommandHandler.syncResource(organizationId);
    }


}
