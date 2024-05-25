package com.backend.programming.learning.system.course.service.domain.implement.service.intro_file;

import com.backend.programming.learning.system.course.service.domain.entity.IntroFile;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.IntroFileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class IntroFileQueryHelper {
    private final IntroFileRepository introFileRepository;

    public IntroFileQueryHelper(IntroFileRepository introFileRepository) {
        this.introFileRepository = introFileRepository;
    }

    @Transactional(readOnly = true)
    public List<IntroFile> queryAllByAssignmentId(UUID assignmentId) {
        return introFileRepository.findAllByAssignmentId(assignmentId);
    }

}
