package com.backend.programming.learning.system.implement.exam_submission;

import com.backend.programming.learning.system.dto.method.create.exam_submisison.CreateExamSubmissionCommand;
import com.backend.programming.learning.system.dto.method.create.exam_submisison.CreateExamSubmissionResponse;
import com.backend.programming.learning.system.entity.ExamSubmission;
import com.backend.programming.learning.system.mapper.exam_submission.ExamSubmissionDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.backend.programming.learning.system.implement.exam_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 12:26 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ExamSubmissionCommandHandler {
    private final ExamSubmissionCreateHelper examSubmissionCreateHelper;
    private final ExamSubmissionDataMapper examSubmissionDataMapper;
    @Transactional
    public CreateExamSubmissionResponse submitExam(CreateExamSubmissionCommand createExamSubmissionCommand) {
        ExamSubmission examSubmission = examSubmissionCreateHelper.createExamSubmission(createExamSubmissionCommand);
        return examSubmissionDataMapper.mapToCreateExamSubmissionResponse(examSubmission);
    }
}
