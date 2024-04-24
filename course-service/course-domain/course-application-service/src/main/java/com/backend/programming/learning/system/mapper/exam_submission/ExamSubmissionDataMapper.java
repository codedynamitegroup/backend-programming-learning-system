package com.backend.programming.learning.system.mapper.exam_submission;

import com.backend.programming.learning.system.dto.method.create.exam_submisison.CreateExamSubmissionCommand;
import com.backend.programming.learning.system.dto.method.create.exam_submisison.CreateExamSubmissionResponse;
import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.entity.ExamSubmission;
import com.backend.programming.learning.system.entity.User;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.mapper.exam_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 12:23 AM
 * Description: ...
 */
@Component
public class ExamSubmissionDataMapper {
    public ExamSubmission createExamSubmissionCommandToExamSubmission(Exam exam, User user, CreateExamSubmissionCommand createExamSubmissionCommand) {
        return ExamSubmission.builder()
                .exam(exam)
                .user(user)
                .type(createExamSubmissionCommand.type())
                .passStatus(createExamSubmissionCommand.passStatus())
                .build();
    }

    public CreateExamSubmissionResponse mapToCreateExamSubmissionResponse(ExamSubmission examSubmission) {
        return new CreateExamSubmissionResponse(
                examSubmission.getId().getValue(),
                examSubmission.getExam().getId().getValue(),
                examSubmission.getUser().getId().getValue(),
                examSubmission.getType(),
                examSubmission.getPassStatus()
        );
    }
}
