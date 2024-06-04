package com.backend.programming.learning.system.course.service.domain.implement.service.exam_submission;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionStartCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.Question;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.mapper.exam_submission.ExamSubmissionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
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
    private final QuestionSubmissionRepository questionSubmissionRepository;
    private final QuestionRepository questionRepository;
    private final ExamRepository examRepository;
    private final UserRepository userRepository;
    private final ExamSubmissionDataMapper examSubmissionDataMapper;

    public ExamSubmission createExamSubmission(CreateExamSubmissionCommand createExamSubmissionCommand) {
        log.info("Create exam submission");
        Exam exam = examRepository.findBy(new ExamId(createExamSubmissionCommand.examId()));
        User user = userRepository.findUser(createExamSubmissionCommand.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        ExamSubmission examSubmissionLast = examSubmissionRepository.findByExamAndUser(exam, user);
        ExamSubmission examSubmission = examSubmissionDataMapper
                .createExamSubmissionCommandToExamSubmission(exam, user,
                        Objects.isNull(examSubmissionLast) ? 1 : examSubmissionLast.getSubmissionCount() + 1,
                        createExamSubmissionCommand);

        courseDomainService.createExamSubmission(examSubmission);
        ExamSubmission submission = saveExamSubmission(examSubmission);

        List<QuestionSubmission> questionSubmissions = createExamSubmissionCommand
                .questions()
                .stream()
                .map(question -> {
                    Question questionExam = questionRepository.findById(question.questionId());
                    QuestionSubmission questionSubmission = QuestionSubmission.builder()
                            .user(submission.getUser())
                            .examSubmission(submission)
                            .question(questionExam)
                            .content(question.content())
                            .numFile(question.numFile())
                            .build();
                    questionSubmission.initializeQuestionSubmission();
                    return questionSubmission;
                })
                .toList();

        questionSubmissionRepository.saveAll(questionSubmissions);

        return submission;
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

    public ExamSubmission createEndExamSubmission(CreateExamSubmissionStartCommand createExamSubmissionStartCommand) {
        ExamSubmission saveExamSubmission = examSubmissionRepository.saveEnd(createExamSubmissionStartCommand);
        return saveExamSubmission;
    }
}
