package com.backend.programming.learning.system.implement.exam_submission;

import com.backend.programming.learning.system.dto.method.create.exam_submisison.CreateExamSubmissionCommand;
import com.backend.programming.learning.system.dto.method.create.exam_submisison.CreateExamSubmissionResponse;
import com.backend.programming.learning.system.ports.input.service.exam_submission.ExamSubmissionApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * com.backend.programming.learning.system.implement.exam_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 12:25 AM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class ExamSubmissionApplicationImpl implements ExamSubmissionApplicationService {
    private final ExamSubmissionCommandHandler examSubmissionCommandHandler;
    @Override
    public CreateExamSubmissionResponse submitExam(CreateExamSubmissionCommand createExamSubmissionCommand) {
        return examSubmissionCommandHandler.submitExam(createExamSubmissionCommand);
    }
}
