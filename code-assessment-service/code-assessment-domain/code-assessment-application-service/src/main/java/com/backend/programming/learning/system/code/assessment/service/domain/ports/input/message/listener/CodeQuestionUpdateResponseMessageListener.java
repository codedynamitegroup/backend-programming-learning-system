package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.CodeQuestionsUpdateResponse;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;

import java.util.List;

public interface CodeQuestionUpdateResponseMessageListener {
    void codeQuestionCreatedUpdatedOrDeletedFail(CodeQuestionsUpdateResponse codeQuestionsUpdateResponse);
    void codeQuestionCreatedUpdatedOrDeletedSuccess(CodeQuestionsUpdateResponse codeQuestionsUpdateResponse);
}
