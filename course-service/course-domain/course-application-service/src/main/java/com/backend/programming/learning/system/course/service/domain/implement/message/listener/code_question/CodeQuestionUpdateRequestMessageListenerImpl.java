package com.backend.programming.learning.system.course.service.domain.implement.message.listener.code_question;

import com.backend.programming.learning.system.course.service.domain.dto.messaging.CodeQuestionsUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.code_question.CodeQuestionUpdateRequestMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CodeQuestionUpdateRequestMessageListenerImpl implements CodeQuestionUpdateRequestMessageListener {
    private final CodeQuestionUpdateRequestHelper codeQuestionUpdateRequestHelper;

    public CodeQuestionUpdateRequestMessageListenerImpl(CodeQuestionUpdateRequestHelper codeQuestionUpdateRequestHelper) {
        this.codeQuestionUpdateRequestHelper = codeQuestionUpdateRequestHelper;
    }

    @Override
    public void persistCodeQuestion(CodeQuestionsUpdateRequest codeQuestionsUpdateRequest) {
        codeQuestionUpdateRequestHelper.persistCodeQuestion(codeQuestionsUpdateRequest);
    }

    @Override
    public void updateCodeQuestion(CodeQuestionsUpdateRequest codeQuestionsUpdateRequest) {
        codeQuestionUpdateRequestHelper.updateCodeQuestion(codeQuestionsUpdateRequest);
    }

    @Override
    public void deleteCodeQuestion(CodeQuestionsUpdateRequest codeQuestionsUpdateRequest) {
        codeQuestionUpdateRequestHelper.deleteCodeQuestion(codeQuestionsUpdateRequest);
    }
}
