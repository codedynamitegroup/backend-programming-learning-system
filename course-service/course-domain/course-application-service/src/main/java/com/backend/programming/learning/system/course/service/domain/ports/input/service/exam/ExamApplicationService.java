package com.backend.programming.learning.system.course.service.domain.ports.input.service.exam;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam.CreateExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam.CreateExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course.DeleteCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.exam.DeleteExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryAllExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryAllExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.exam.UpdateExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.exam.UpdateExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.exam.ExamResponseEntity;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;

import jakarta.validation.Valid;

/**
 * com.backend.programming.learning.system.ports.input.service
 * Create by Dang Ngoc Tien
 * Date 4/16/2024 - 2:18 AM
 * Description: ...
 */
public interface ExamApplicationService {

    CreateExamResponse createExam(
            @Valid CreateExamCommand createExamCommand);

    ExamResponseEntity findBy(
            @Valid QueryExamCommand queryExamCommand);

    QueryAllExamResponse findAll(
            @Valid CourseId courseId,
            @Valid QueryAllExamCommand queryAllExamCommand);

    DeleteCourseResponse deleteExam(
            @Valid DeleteExamCommand deleteExamCommand);

    UpdateExamResponse updateExam(
            ExamId examId,
            @Valid UpdateExamCommand updateExamCommand);
}
