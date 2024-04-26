package com.backend.programming.learning.system.implement.exam_question;

import com.backend.programming.learning.system.CourseDomainService;
import com.backend.programming.learning.system.dto.method.create.exam_submisison.exam_question.CreateExamQuestionCommand;
import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.entity.ExamQuestion;
import com.backend.programming.learning.system.entity.Question;
import com.backend.programming.learning.system.mapper.exam_question.ExamQuestionDataMapper;
import com.backend.programming.learning.system.ports.output.repository.ExamQuestionRepository;
import com.backend.programming.learning.system.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.valueobject.ExamId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * com.backend.programming.learning.system.implement.exam_question
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 1:57 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ExamQuestionCreateHelper {
    private final CourseDomainService courseDomainService;
    private final ExamQuestionRepository examQuestionRepository;
    private final ExamRepository examRepository;
    private final QuestionRepository questionRepository;
    private final ExamQuestionDataMapper examQuestionDataMapper;
    public void assignExamToQuestions(CreateExamQuestionCommand createExamQuestionCommand) {
        log.info("Create exam question");
        Exam exam = examRepository.findBy(new ExamId(createExamQuestionCommand.examId()));
        List<Question> questions = new ArrayList<>();
        createExamQuestionCommand.questionIds().forEach(questionId -> {
            Question question = questionRepository.findById(questionId);
            questions.add(question);
        });

        List<ExamQuestion> examQuestions = examQuestionDataMapper.createExamQuestionCommandToExamQuestion(exam, questions);
        courseDomainService.createExamQuestions(examQuestions);
        examQuestionRepository.assignExamToQuestions(examQuestions);
    }
}
