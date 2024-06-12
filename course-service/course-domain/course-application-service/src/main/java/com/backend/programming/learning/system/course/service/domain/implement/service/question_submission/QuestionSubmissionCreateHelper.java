package com.backend.programming.learning.system.course.service.domain.implement.service.question_submission;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.MarkQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.Question;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.mapper.question_submission.QuestionSubmissionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * com.backend.programming.learning.system.implement.question_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 1:23 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionSubmissionCreateHelper {
    private final CourseDomainService courseDomainService;
    private final ExamSubmissionRepository examSubmissionRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final QuestionSubmissionRepository questionSubmissionRepository;
    private final QuestionSubmissionDataMapper questionSubmissionDataMapper;
    public QuestionSubmission createQuestionSubmission(CreateQuestionSubmissionCommand createQuestionSubmissionCommand) {
        ExamSubmission examSubmission = examSubmissionRepository.findBy(createQuestionSubmissionCommand.examSubmissionId());
        User user = userRepository.findUser(createQuestionSubmissionCommand.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Question question = questionRepository.findById(createQuestionSubmissionCommand.questionId());
        QuestionSubmission questionSubmission = questionSubmissionDataMapper
                .createQuestionSubmissionCommandToQuestionSubmission(examSubmission, user, question, createQuestionSubmissionCommand);
        courseDomainService.createQuestionSubmission(questionSubmission);
        return saveQuestionSubmission(questionSubmission);
    }

    private QuestionSubmission saveQuestionSubmission(QuestionSubmission questionSubmission) {
        QuestionSubmission saveQuestionSubmission = questionSubmissionRepository.save(questionSubmission);
        if (saveQuestionSubmission == null) {
            log.error("Failed to save question submission");
            throw new RuntimeException("Failed to save question submission");
        }
        log.info("Question submission saved successfully with id: {}", saveQuestionSubmission.getId().getValue());
        return saveQuestionSubmission;
    }

    public void markQuestion(List<MarkQuestionSubmissionCommand> markQuestionSubmissionCommandList) {
        questionSubmissionRepository.markQuestion(markQuestionSubmissionCommandList);
    }
}
