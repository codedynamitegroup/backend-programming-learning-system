package com.backend.programming.learning.system.implement.question.message;

import com.backend.programming.learning.system.dto.method.message.QuestionCreateRequest;
import com.backend.programming.learning.system.dto.method.message.QuestionDeleteRequest;
import com.backend.programming.learning.system.dto.method.message.QuestionUpdateRequest;
import com.backend.programming.learning.system.ports.input.message.listener.question.QuestionMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class QuestionMessageListenerImpl implements QuestionMessageListener {
    @Override
    public void createQuestion(QuestionCreateRequest questionCreateRequest) {

    }

    @Override
    public void updateQuestion(QuestionUpdateRequest questionUpdateRequest) {

    }

    @Override
    public void deleteQuestion(QuestionDeleteRequest questionDeleteRequest) {

    }
}
