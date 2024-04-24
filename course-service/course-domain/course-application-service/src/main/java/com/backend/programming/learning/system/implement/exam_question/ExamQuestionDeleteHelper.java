package com.backend.programming.learning.system.implement.exam_question;

import com.backend.programming.learning.system.dto.method.create.exam_question.CreateExamQuestionCommand;
import com.backend.programming.learning.system.ports.output.repository.ExamQuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.implement.exam_question
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 1:57 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ExamQuestionDeleteHelper {
    private final ExamQuestionRepository examQuestionRepository;
    public void unAssignExamToQuestions(CreateExamQuestionCommand createExamQuestionCommand) {
        log.info("Un-assigning exam to question");
        examQuestionRepository.deleteByExamIdAndQuestionIdIn(createExamQuestionCommand.getExamId(), createExamQuestionCommand.getQuestionIds());
    }
}
