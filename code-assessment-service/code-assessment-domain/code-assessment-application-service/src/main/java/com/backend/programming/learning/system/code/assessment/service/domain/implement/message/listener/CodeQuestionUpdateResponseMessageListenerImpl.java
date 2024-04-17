package com.backend.programming.learning.system.code.assessment.service.domain.implement.message.listener;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.CodeQuestionUpdateResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener.CodeQuestionUpdateResponseMessageListener;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Slf4j
@Validated
@Service
public class CodeQuestionUpdateResponseMessageListenerImpl implements CodeQuestionUpdateResponseMessageListener {
    @Override
    public void codeQuestionUpdatedFail(CodeQuestionUpdateResponse codeQuestionUpdateResponse, List<String> failureMessages) {

    }

    @Override
    public void codeQuestionUpdatedSuccess(CodeQuestionId codeQuestionId) {

    }

    @Override
    public void codeQuestionCreateFail(CodeQuestionId codeQuestionId, List<String> failureMessages) {

    }

    @Override
    public void codeQuestionCreateSuccess(CodeQuestionId codeQuestionId) {

    }

    @Override
    public void codeQuestionDeleteFail(CodeQuestionId codeQuestionId, List<String> failureMessages) {

    }

    @Override
    public void codeQuestionDeleteSuccess(CodeQuestionId codeQuestionId) {

    }
}
