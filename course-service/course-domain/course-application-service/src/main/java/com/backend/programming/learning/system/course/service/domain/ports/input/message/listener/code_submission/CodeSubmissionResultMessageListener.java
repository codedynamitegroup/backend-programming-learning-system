package com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.code_submission;

import com.backend.programming.learning.system.course.service.domain.dto.messaging.CodeSubmissionResultRequest;

public interface CodeSubmissionResultMessageListener {
    void handleCodeSubmissionResultRequest(CodeSubmissionResultRequest request);
}
