package com.backend.programming.learning.system.course.service.domain.mapper.exam_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionStartCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.Status;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.mapper.exam_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 12:23 AM
 * Description: ...
 */
@Component
public class ExamSubmissionDataMapper {
    public ExamSubmission createExamSubmissionCommandToExamSubmission(
            Exam exam, User user,
            Integer submissionCount,
            CreateExamSubmissionCommand createExamSubmissionCommand) {
        return ExamSubmission.builder()
                .exam(exam)
                .user(user)
                .submissionCount(submissionCount)
                .startTime(createExamSubmissionCommand.startTime())
                .build();
    }

    public CreateExamSubmissionResponse mapToCreateExamSubmissionResponse(ExamSubmission examSubmission) {
        return new CreateExamSubmissionResponse(
                examSubmission.getId().getValue(),
                examSubmission.getExam().getId().getValue(),
                examSubmission.getUser().getId().getValue(),
                examSubmission.getStartTime(),
                examSubmission.getSubmitTime(),
                examSubmission.status()
        );
    }

    public ExamSubmission createStartExamSubmissionCommandToExamSubmission(
            Exam exam,
            User user,
            Integer submissionCount,
            CreateExamSubmissionStartCommand createExamSubmissionStartCommand) {
        return ExamSubmission.builder()
                .exam(exam)
                .user(user)
                .submissionCount(submissionCount)
                .status(Status.NOT_SUBMITTED)
                .build();
    }
}
