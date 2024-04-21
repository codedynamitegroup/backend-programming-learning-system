package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.codequestion.message.listener;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.CodeQuestionsUpdateResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.codequestion.CodeQuestionsUpdateSaga;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener.CodeQuestionUpdateResponseMessageListener;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;

import java.util.List;

public class CodeQuestionUpdateResponseMessageListenerImpl
        implements CodeQuestionUpdateResponseMessageListener {
    private final CodeQuestionsUpdateSaga codeQuestionsUpdateSaga;

    public CodeQuestionUpdateResponseMessageListenerImpl(
            CodeQuestionsUpdateSaga codeQuestionsUpdateSaga) {
        this.codeQuestionsUpdateSaga = codeQuestionsUpdateSaga;
    }

    @Override
    public void codeQuestionUpdatedFail(CodeQuestionsUpdateResponse codeQuestionsUpdateResponse, List<String> failureMessages) {
        return;
    }

    @Override
    public void codeQuestionUpdatedSuccess(CodeQuestionId codeQuestionId) {

    }

    @Override
    public void codeQuestionCreateFail(CodeQuestionId codeQuestionId, List<String> failureMessages) {
        return;
    }

    @Override
    public void codeQuestionCreateSuccess(CodeQuestionId codeQuestionId) {

    }

    @Override
    public void codeQuestionDeleteFail(CodeQuestionId codeQuestionId, List<String> failureMessages) {
        return;
    }

    @Override
    public void codeQuestionDeleteSuccess(CodeQuestionId codeQuestionId) {

    }
}
