package com.backend.programming.learning.system.implement.exam;

import com.backend.programming.learning.system.dto.method.create.exam.CreateExamCommand;
import com.backend.programming.learning.system.dto.method.create.exam.CreateExamResponse;
import com.backend.programming.learning.system.dto.method.delete.course.DeleteCourseResponse;
import com.backend.programming.learning.system.dto.method.delete.exam.DeleteExamCommand;
import com.backend.programming.learning.system.dto.method.query.exam.QueryAllExamCommand;
import com.backend.programming.learning.system.dto.method.query.exam.QueryAllExamResponse;
import com.backend.programming.learning.system.dto.method.query.exam.QueryExamCommand;
import com.backend.programming.learning.system.dto.method.update.exam.UpdateExamCommand;
import com.backend.programming.learning.system.dto.method.update.exam.UpdateExamResponse;
import com.backend.programming.learning.system.dto.responseentity.exam.ExamResponseEntity;
import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.mapper.exam.ExamDataMapper;
import com.backend.programming.learning.system.valueobject.ExamId;
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
    public CreateExamResponse createExam(CreateExamCommand createExamCommand) {
        Exam examCreated = examCreateHelper.persistExam(createExamCommand);
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
    public QueryAllExamResponse findAll(QueryAllExamCommand queryAllExamCommand) {
        Page<Exam> exams = examQueryHelper.findAll(
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

    public UpdateExamResponse updateExam(ExamId examId, UpdateExamCommand updateExamCommand) {
        Exam exam = examUpdateHelper.updateExam(examId, updateExamCommand);
        return examDataMapper.examToUpdateExamResponse(exam, "Exam updated successfully");
    }
}
