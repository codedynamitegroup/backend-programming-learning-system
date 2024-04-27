package com.backend.programming.learning.system.code.assessment.service.domain.implement.message.listener;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.codequestion.CodeQuestionsUpdateResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.codequestion.CodeQuestionsUpdateSaga;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener.CodeQuestionUpdateResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class CodeQuestionUpdateResponseMessageListenerImpl
        implements CodeQuestionUpdateResponseMessageListener {
    private final CodeQuestionsUpdateSaga codeQuestionsUpdateSaga;

    public CodeQuestionUpdateResponseMessageListenerImpl(
            CodeQuestionsUpdateSaga codeQuestionsUpdateSaga) {
        this.codeQuestionsUpdateSaga = codeQuestionsUpdateSaga;
    }

    @Override
    public void codeQuestionCreatedUpdatedOrDeletedFail(CodeQuestionsUpdateResponse codeQuestionsUpdateResponse) {
        codeQuestionsUpdateSaga.rollback(codeQuestionsUpdateResponse);

    }

    @Override
    public void codeQuestionCreatedUpdatedOrDeletedSuccess(CodeQuestionsUpdateResponse codeQuestionsUpdateResponse) {
        codeQuestionsUpdateSaga.process(codeQuestionsUpdateResponse);
    }

}
