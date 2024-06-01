package com.backend.programming.learning.system.course.service.domain.implement.service.exam_question;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.CreateExamQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_question.QueryAllQuestionByExamIdCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_question.QueryAllQuestionByExamIdResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_question.QueryAllQuestionByExamIdWithPageAttResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question.QuestionExamDTO;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.ExamQuestion;
import com.backend.programming.learning.system.course.service.domain.entity.Question;
import com.backend.programming.learning.system.course.service.domain.mapper.exam_question.ExamQuestionDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamQuestionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private final QuestionDataMapper questionDataMapper;

    public void assignExamToQuestions(CreateExamQuestionCommand createExamQuestionCommand) {
        log.info("Create exam question");
        Exam exam = examRepository.findBy(new ExamId(createExamQuestionCommand.examId()));
        Map<Question, Integer> questions = new HashMap<>();
        createExamQuestionCommand.questionIds().forEach(questionId -> {
            Question question = questionRepository.findById(questionId.questionId());
            questions.put(question, questionId.page());
        });

        List<ExamQuestion> examQuestions = examQuestionDataMapper.createExamQuestionCommandToExamQuestion(exam, questions);
        courseDomainService.createExamQuestions(examQuestions);
        examQuestionRepository.assignExamToQuestions(examQuestions);
    }

    public QueryAllQuestionByExamIdWithPageAttResponse findAllQuestionByExamId(
            ExamId examId, QueryAllQuestionByExamIdCommand queryAllQuestionByExamIdCommand) {
        log.info("Get all question by exam id");
        List<QuestionExamDTO> questions = questionRepository.findAllByExamId(
                examId.getValue(),
                queryAllQuestionByExamIdCommand.search(),
                queryAllQuestionByExamIdCommand.currentPage());
        return QueryAllQuestionByExamIdWithPageAttResponse.builder()
                .questions(questionDataMapper.questionListToQuestionResponseEntityList(questions))
                .build();
    }
}
