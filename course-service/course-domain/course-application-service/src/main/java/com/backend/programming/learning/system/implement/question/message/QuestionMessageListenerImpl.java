package com.backend.programming.learning.system.implement.question.message;

import com.backend.programming.learning.system.dto.method.message.QuestionDeleteRequest;
import com.backend.programming.learning.system.ports.input.message.listener.question.QuestionMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class QuestionMessageListenerImpl implements QuestionMessageListener {
    @Override
    public void createQuestion() {

    }

    @Override
    public void updateQuestion() {

    }

    @Override
    public void deleteQuestion(QuestionDeleteRequest questionDeleteRequest) {

    }
}
