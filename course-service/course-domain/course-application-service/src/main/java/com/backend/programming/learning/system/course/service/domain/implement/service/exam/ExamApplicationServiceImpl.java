package com.backend.programming.learning.system.course.service.domain.implement.service.exam;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam.CreateExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam.CreateExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course.DeleteCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.exam.DeleteExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryAllExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryAllExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryOverviewResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.exam.UpdateExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.exam.UpdateExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.exam.ExamResponseEntity;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.exam.ExamApplicationService;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * com.backend.programming.learning.system.implemtent.exam
 * Create by Dang Ngoc Tien
 * Date 4/16/2024 - 2:25 AM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class ExamApplicationServiceImpl implements ExamApplicationService {
    private final ExamCommandHandler examCommandHandler;

    @Override
    public CreateExamResponse createExam(CreateExamCommand createExamCommand) {
       return examCommandHandler.createExam(createExamCommand);
    }

    @Override
    public ExamResponseEntity findBy(QueryExamCommand queryExamCommand) {
        return examCommandHandler.findBy(queryExamCommand);
    }

    @Override
    public QueryAllExamResponse findAll(
            CourseId courseId,
            QueryAllExamCommand queryAllExamCommand) {
        return examCommandHandler.findAll(courseId, queryAllExamCommand);
    }

    @Override
    public DeleteCourseResponse deleteExam(DeleteExamCommand deleteExamCommand) {
        return examCommandHandler.deleteExam(deleteExamCommand);
    }

    @Override
    public UpdateExamResponse updateExam(ExamId examId, UpdateExamCommand updateExamCommand) {
        return examCommandHandler.updateExam(examId, updateExamCommand);
    }

    @Override
    public QueryOverviewResponse overviewExam(ExamId examId) {
        return examCommandHandler.overviewExam(examId);
    }
}
