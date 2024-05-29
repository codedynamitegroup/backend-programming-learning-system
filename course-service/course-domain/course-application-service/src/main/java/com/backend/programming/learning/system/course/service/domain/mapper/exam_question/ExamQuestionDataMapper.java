package com.backend.programming.learning.system.course.service.domain.mapper.exam_question;

import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.ExamQuestion;
import com.backend.programming.learning.system.course.service.domain.entity.Question;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * com.backend.programming.learning.system.mapper.exam_question
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 2:17 AM
 * Description: ...
 */
@Component
public class ExamQuestionDataMapper {
    public List<ExamQuestion> createExamQuestionCommandToExamQuestion(Exam exam, Map<Question, Integer> questions) {
        return questions.entrySet().stream()
                .map(entry -> ExamQuestion.builder()
                        .exam(exam)
                        .question(entry.getKey())
                        .page(entry.getValue())
                        .build())
                .toList();
    }
}
