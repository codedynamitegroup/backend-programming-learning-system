package com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.code_submission;

import com.backend.programming.learning.system.core.service.domain.dto.message.CodeSubmissionUpdateRequest;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmission;

public interface CodeSubmissionUpdateRequestMessageListener {
    public void persistCodeSubmission(CodeSubmissionUpdateRequest request);
    public void updateCodeSubmission(CodeSubmissionUpdateRequest request);
}
