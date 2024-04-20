package com.backend.programming.learning.system.ports.input.service.exam;

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
import com.backend.programming.learning.system.valueobject.ExamId;

import javax.validation.Valid;

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
            @Valid QueryAllExamCommand queryAllExamCommand);

    DeleteCourseResponse deleteExam(
            @Valid DeleteExamCommand deleteExamCommand);

    UpdateExamResponse updateExam(
            ExamId examId,
            @Valid UpdateExamCommand updateExamCommand);
}
