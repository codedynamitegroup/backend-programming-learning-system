package com.backend.programming.learning.system.core.service.domain.implement.message.listener.code_submission;

import com.backend.programming.learning.system.core.service.domain.dto.message.CodeSubmissionUpdateRequest;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.core.service.domain.mapper.code_submission.CodeSubmissionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CodeSubmissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CodeSubmissionUpdateRequestHelper {
    final CodeSubmissionRepository codeSubmissionRepository;
    final CodeSubmissionDataMapper codeSubmissionDataMapper;

    public CodeSubmissionUpdateRequestHelper(CodeSubmissionRepository codeSubmissionRepository, CodeSubmissionDataMapper codeSubmissionDataMapper) {

        this.codeSubmissionRepository = codeSubmissionRepository;
        this.codeSubmissionDataMapper = codeSubmissionDataMapper;
    }

    public void persistCodeSubmission(CodeSubmissionUpdateRequest request) {
        CodeSubmission codeSubmission = codeSubmissionDataMapper.CodeSubmissionUpdateRequestToCodeSubmission(request);
        codeSubmissionRepository.saveCodeSubmission(codeSubmission);
    }

    public void updateCodeSubmission(CodeSubmissionUpdateRequest request) {
        CodeSubmission codeSubmission = codeSubmissionDataMapper.CodeSubmissionUpdateRequestToCodeSubmission(request);
        codeSubmissionRepository.saveCodeSubmission(codeSubmission);
    }
}
