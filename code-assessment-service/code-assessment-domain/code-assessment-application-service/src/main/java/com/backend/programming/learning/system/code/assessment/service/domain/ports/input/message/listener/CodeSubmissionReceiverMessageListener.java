package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.code_submission.CodeSubmissionReceiver;

public interface CodeSubmissionReceiverMessageListener {
    void createCodeSubmission(CodeSubmissionReceiver receiver);
}
