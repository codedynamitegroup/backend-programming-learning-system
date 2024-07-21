package com.backend.programming.learning.system.course.service.domain.implement.message.listener.code_submission;

import com.backend.programming.learning.system.course.service.domain.dto.messaging.CodeSubmissionResultRequest;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.code_submission.CodeSubmissionResultMessageListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CodeSubmissionResultMessageListenerImpl implements CodeSubmissionResultMessageListener {
    private final CodeSubmissionResultRequestHelper helper;

    @Override
    public void handleCodeSubmissionResultRequest(CodeSubmissionResultRequest request) {
        QuestionSubmission questionSubmission = helper.handleCodeSubmissionResultRequest(request);
        if(questionSubmission != null){
            helper.updateExamSubmissionScore(questionSubmission);
        }
    }
}
