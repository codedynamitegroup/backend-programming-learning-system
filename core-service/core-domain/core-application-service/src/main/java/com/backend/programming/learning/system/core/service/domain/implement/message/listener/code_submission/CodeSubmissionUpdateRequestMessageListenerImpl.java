package com.backend.programming.learning.system.core.service.domain.implement.message.listener.code_submission;

import com.backend.programming.learning.system.core.service.domain.dto.message.CodeSubmissionUpdateRequest;
import com.backend.programming.learning.system.core.service.domain.implement.message.listener.code_questions.CodeQuestionUpdateRequestHelper;
import com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.code_submission.CodeSubmissionUpdateRequestMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CodeSubmissionUpdateRequestMessageListenerImpl implements CodeSubmissionUpdateRequestMessageListener{
    final CodeSubmissionUpdateRequestHelper helper;

    public CodeSubmissionUpdateRequestMessageListenerImpl(CodeSubmissionUpdateRequestHelper helper) {
        this.helper = helper;
    }

    @Override
    public void persistCodeSubmission(CodeSubmissionUpdateRequest request) {
        helper.persistCodeSubmission(request);
    }

    @Override
    public void updateCodeSubmission(CodeSubmissionUpdateRequest request) {
        helper.updateCodeSubmission(request);
    }
}
