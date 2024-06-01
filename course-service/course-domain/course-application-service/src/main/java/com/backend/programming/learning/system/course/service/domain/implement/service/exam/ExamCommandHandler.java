package com.backend.programming.learning.system.course.service.domain.implement.service.exam;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam.CreateExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam.CreateExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.CreateExamQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course.DeleteCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.exam.DeleteExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryAllExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryAllExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryOverviewResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.exam.UpdateExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.exam.UpdateExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.exam.ExamResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.implement.service.exam_question.ExamQuestionCreateHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.exam_question.ExamQuestionDeleteHelper;
import com.backend.programming.learning.system.course.service.domain.mapper.exam.ExamDataMapper;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * com.backend.programming.learning.system.implemtent.exam
 * Create by Dang Ngoc Tien
 * Date 4/16/2024 - 2:28 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ExamCommandHandler {
    private final ExamCreateHelper examCreateHelper;
    private final ExamQueryHelper examQueryHelper;
    private final ExamDeleteHelper examDeleteHelper;
    private final ExamUpdateHelper examUpdateHelper;
    private final ExamDataMapper examDataMapper;
    private final ExamQuestionCreateHelper examQuestionCreateHelper;
    private final ExamQuestionDeleteHelper examQuestionDeleteHelper;

    @Transactional
    public CreateExamResponse createExam(CreateExamCommand createExamCommand) {
        Exam examCreated = examCreateHelper.persistExam(createExamCommand);
        examQuestionCreateHelper.assignExamToQuestions(
                CreateExamQuestionCommand.builder()
                        .examId(examCreated.getId().getValue())
                        .questionIds(createExamCommand.questionIds())
                        .build());
        log.info("Exam is created with id: {}", examCreated.getId());
        return examDataMapper.examToCreateExamResponse(examCreated, "Exam created successfully");
    }

    @Transactional(readOnly = true)
    public ExamResponseEntity findBy(QueryExamCommand queryExamCommand) {
        Exam exam = examQueryHelper.findBy(new ExamId(queryExamCommand.getExamId()));
        log.info("Returning exam: {}", exam);
        return examDataMapper.examToQueryExamResponse(exam);
    }

    @Transactional(readOnly = true)
    public QueryAllExamResponse findAll(CourseId courseId, QueryAllExamCommand queryAllExamCommand) {
        Page<Exam> exams = examQueryHelper.findAll(
                courseId,
                queryAllExamCommand.getSearch(),
                queryAllExamCommand.getPageNo(),
                queryAllExamCommand.getPageSize());
        return examDataMapper.examsToQueryAllExamResponse(exams);
    }

    @Transactional
    public DeleteCourseResponse deleteExam(DeleteExamCommand deleteExamCommand) {
        examDeleteHelper.deleteExam(new ExamId(deleteExamCommand.examId()));
        return new DeleteCourseResponse("Exam deleted successfully");
    }

    @Transactional
    public UpdateExamResponse updateExam(ExamId examId, UpdateExamCommand updateExamCommand) {
        Exam exam = examUpdateHelper.updateExam(examId, updateExamCommand);
        examQuestionDeleteHelper.deleteByExamId(examId);
        examQuestionCreateHelper.assignExamToQuestions(
                CreateExamQuestionCommand.builder()
                        .examId(examId.getValue())
                        .questionIds(updateExamCommand.questionIds())
                        .build());
        return examDataMapper.examToUpdateExamResponse(exam, "Exam updated successfully");
    }

    public QueryOverviewResponse overviewExam(ExamId examId) {
        return examQueryHelper.overviewExam(examId);
    }
}
