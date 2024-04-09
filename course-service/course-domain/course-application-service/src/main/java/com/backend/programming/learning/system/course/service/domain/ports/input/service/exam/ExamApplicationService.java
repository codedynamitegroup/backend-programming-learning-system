package com.backend.programming.learning.system.course.service.domain.ports.input.service.exam;

import com.backend.programming.learning.system.course.service.domain.dto.exam.create.CreateExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.exam.create.CreateExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.exam.get.ExamsResponse;

/**
 * com.backend.programming.learning.system.course.service.domain.ports.input.output.service
 * Create by Dang Ngoc Tien
 * Date 3/21/2024 - 12:20 AM
 * Description: ...
 */
public interface ExamApplicationService {

    CreateExamResponse createExam(CreateExamCommand createExamCommand);

    ExamsResponse findAll(String search);

    void deleteExam(Long examId);

    CreateExamResponse updateExam(Long examId, CreateExamCommand createExamCommand);

    CreateExamResponse getExam(Long examId);
}
