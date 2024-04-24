package com.backend.programming.learning.system.implement.question;

import com.backend.programming.learning.system.dto.method.delete.question.DeleteQuestionCommand;
import com.backend.programming.learning.system.ports.output.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.implement.question
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 11:43 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionDeleteHelper {
    private final QuestionRepository questionRepository;
    public void deleteById(DeleteQuestionCommand deleteQuestionCommand) {
        questionRepository.deleteById(deleteQuestionCommand.questionId());
        log.info("Question is deleted with id: {}", deleteQuestionCommand.questionId());
    }
}
