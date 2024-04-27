package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.codequestion.CodeQuestionsUpdateResponse;

public interface CodeQuestionUpdateResponseMessageListener {
    void codeQuestionCreatedUpdatedOrDeletedFail(CodeQuestionsUpdateResponse codeQuestionsUpdateResponse);
    void codeQuestionCreatedUpdatedOrDeletedSuccess(CodeQuestionsUpdateResponse codeQuestionsUpdateResponse);
}
