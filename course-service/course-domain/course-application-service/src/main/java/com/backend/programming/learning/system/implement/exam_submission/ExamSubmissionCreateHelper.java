package com.backend.programming.learning.system.implement.exam_submission;

import com.backend.programming.learning.system.CourseDomainService;
import com.backend.programming.learning.system.dto.method.create.exam_submisison.CreateExamSubmissionCommand;
import com.backend.programming.learning.system.dto.method.create.exam_submisison.CreateExamSubmissionStartCommand;
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

import java.util.List;
import java.util.Objects;

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
        ExamSubmission examSubmission = examSubmissionRepository.findBy(createExamSubmissionCommand.examSubmissionId());
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

    public ExamSubmission createStartExamSubmission(CreateExamSubmissionStartCommand createExamSubmissionCommand) {
        log.info("Create start exam submission");
        Exam exam = examRepository.findBy(new ExamId(createExamSubmissionCommand.examId()));
        User user = userRepository.findUser(createExamSubmissionCommand.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        ExamSubmission examSubmissionLast = examSubmissionRepository.findByExamAndUser(exam, user);
        ExamSubmission examSubmission = examSubmissionDataMapper
                .createStartExamSubmissionCommandToExamSubmission(exam, user,
                        Objects.isNull(examSubmissionLast) ? 1 : examSubmissionLast.getSubmissionCount() + 1,
                        createExamSubmissionCommand);
        courseDomainService.createStartExamSubmission(examSubmission);
        return saveExamSubmission(examSubmission);
    }
}
