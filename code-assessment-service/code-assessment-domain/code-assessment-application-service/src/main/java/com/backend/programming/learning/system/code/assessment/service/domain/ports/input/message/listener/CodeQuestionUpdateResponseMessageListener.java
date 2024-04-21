package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.CodeQuestionsUpdateResponse;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;

import java.util.List;

public interface CodeQuestionUpdateResponseMessageListener {
    void codeQuestionUpdatedFail(CodeQuestionsUpdateResponse codeQuestionsUpdateResponse, List<String> failureMessages);
    void codeQuestionUpdatedSuccess(CodeQuestionId codeQuestionId);
    void codeQuestionCreateFail(CodeQuestionId codeQuestionId, List<String> failureMessages);
    void codeQuestionCreateSuccess(CodeQuestionId codeQuestionId);
    void codeQuestionDeleteFail(CodeQuestionId codeQuestionId,  List<String> failureMessages);
    void codeQuestionDeleteSuccess(CodeQuestionId codeQuestionId);
}
