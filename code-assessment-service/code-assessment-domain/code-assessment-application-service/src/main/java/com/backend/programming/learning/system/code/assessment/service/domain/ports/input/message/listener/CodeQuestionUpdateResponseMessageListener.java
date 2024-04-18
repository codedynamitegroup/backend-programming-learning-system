package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.CodeQuestionUpdateResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;

import java.util.List;

public interface CodeQuestionUpdateResponseMessageListener {
    void codeQuestionUpdatedFail(CodeQuestionUpdateResponse codeQuestionUpdateResponse, List<String> failureMessages);
    void codeQuestionUpdatedSuccess(CodeQuestionId codeQuestionId);
    void codeQuestionCreateFail(CodeQuestionId codeQuestionId, List<String> failureMessages);
    void codeQuestionCreateSuccess(CodeQuestionId codeQuestionId);
    void codeQuestionDeleteFail(CodeQuestionId codeQuestionId,  List<String> failureMessages);
    void codeQuestionDeleteSuccess(CodeQuestionId codeQuestionId);
}
