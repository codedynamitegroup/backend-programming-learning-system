package com.backend.programming.learning.system.code.assessment.service.domain.implement.message.listener.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.code_submission.CodeSubmissionReceiver;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.ValidateHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_submission.CodeSubmissionCommandHandler;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_submission.CodeSubmissionDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener.CodeSubmissionReceiverMessageListener;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class CodeSubmissionReceiverMessageListenerImpl implements CodeSubmissionReceiverMessageListener {
    private final CodeSubmissionReceiverMessageHelper codeSubmissionReceiverMessageHelper;

    @Override
    public void createCodeSubmission(CodeSubmissionReceiver receiver) {
        codeSubmissionReceiverMessageHelper.createCodeSubmission(receiver);
    }

}
