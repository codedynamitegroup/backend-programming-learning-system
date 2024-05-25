package com.backend.programming.learning.system.course.service.domain.implement.service.intro_file;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.intro_file.QueryAllIntroFileResponse;
import com.backend.programming.learning.system.course.service.domain.entity.IntroFile;
import com.backend.programming.learning.system.course.service.domain.mapper.intro_file.IntroFileDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.IntroFileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class IntroFileCommandHandler {
    private final IntroFileQueryHelper introFileQueryHelper;
    private final IntroFileDataMapper introFileDataMapper;


    @Transactional(readOnly = true)
    public QueryAllIntroFileResponse queryAllByAssignmentId(UUID assignmentId) {
        List<IntroFile> introFiles = introFileQueryHelper.queryAllByAssignmentId(assignmentId);
        return introFileDataMapper.introFilesToQueryAllIntroFileResponse(introFiles);
    }
}
