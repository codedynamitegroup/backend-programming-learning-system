package com.backend.programming.learning.system.implement.exam_submission;

import com.backend.programming.learning.system.CourseDomainService;
import com.backend.programming.learning.system.dto.method.create.exam_submisison.CreateExamSubmissionCommand;
import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.entity.ExamSubmission;
import com.backend.programming.learning.system.entity.User;
import com.backend.programming.learning.system.mapper.exam_submission.ExamSubmissionDataMapper;
import com.backend.programming.learning.system.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.ports.output.repository.ExamSubmissionRepository;
import com.backend.programming.learning.system.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.valueobject.ExamId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.implement.exam_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 12:26 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ExamSubmissionCreateHelper {
    private final CourseDomainService courseDomainService;
    private final ExamSubmissionRepository examSubmissionRepository;
    private final ExamRepository examRepository;
    private final UserRepository userRepository;
    private final ExamSubmissionDataMapper examSubmissionDataMapper;
    public ExamSubmission createExamSubmission(CreateExamSubmissionCommand createExamSubmissionCommand) {
        log.info("Create exam submission");
        Exam exam = examRepository.findBy(new ExamId(createExamSubmissionCommand.examId()));
        User user = userRepository.findUser(createExamSubmissionCommand.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        ExamSubmission examSubmission = examSubmissionDataMapper.createExamSubmissionCommandToExamSubmission(exam, user, createExamSubmissionCommand);
        courseDomainService.createExamSubmission(examSubmission);
        return saveExamSubmission(examSubmission);
    }

    private ExamSubmission saveExamSubmission(ExamSubmission examSubmission) {
        ExamSubmission saveExamSubmission = examSubmissionRepository.save(examSubmission);
        if (saveExamSubmission == null) {
            log.error("Failed to save exam submission");
            throw new RuntimeException("Failed to save exam submission");
        }
        log.info("Exam submission saved successfully with id: {}", saveExamSubmission.getId().getValue());
        return saveExamSubmission;
    }
}
