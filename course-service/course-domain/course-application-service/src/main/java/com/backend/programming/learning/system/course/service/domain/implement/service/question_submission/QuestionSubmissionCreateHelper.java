package com.backend.programming.learning.system.course.service.domain.implement.service.question_submission;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.ExamQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.OneExamQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.MarkQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.exception.ExamClosedException;
import com.backend.programming.learning.system.course.service.domain.exception.ExamSubmissionNotFoundException;
import com.backend.programming.learning.system.course.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.course.service.domain.mapper.question_submission.QuestionSubmissionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import com.backend.programming.learning.system.domain.exception.question.QuestionNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    private final ExamRepository examRepository;

    public QuestionSubmission createQuestionSubmission(CreateQuestionSubmissionCommand createQuestionSubmissionCommand) {
        ExamSubmission examSubmission = examSubmissionRepository.findBy(createQuestionSubmissionCommand.examSubmissionId());
        User user = userRepository.findUser(createQuestionSubmissionCommand.userId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        Optional<Question> question = questionRepository.findById(createQuestionSubmissionCommand.questionId());

        if (question.isEmpty()) {
            log.error("Question not found with id: {}", createQuestionSubmissionCommand.questionId());
            throw new QuestionNotFoundException("Question not found with id: " + createQuestionSubmissionCommand.questionId());
        }

        QuestionSubmission questionSubmission = questionSubmissionDataMapper
                .createQuestionSubmissionCommandToQuestionSubmission(examSubmission, user, question.get(), createQuestionSubmissionCommand);
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

    // Submit many questions
    public void submitExamQuestion(ExamQuestionSubmissionCommand examQuestionSubmissionCommand) {
        Exam exam = examRepository.findBy(new ExamId(examQuestionSubmissionCommand.examId()));

        if(isExamClosed(exam)) {
            log.error("Exam is closed with id: {}", exam.getId().getValue());
            throw new ExamClosedException("Exam is closed");
        }

        User user = userRepository.findUser(examQuestionSubmissionCommand.userId())
                .orElseThrow(() -> {
                    log.info("User not found with id: {}", examQuestionSubmissionCommand.userId());

                    return new UserNotFoundException("User not found");
                });
        ExamSubmission examSubmission = examSubmissionRepository.findByExamAndUser(exam, user);

        if (examSubmission == null) {
            log.error("Exam submission not found with examId: {} and userId: {}", examQuestionSubmissionCommand.examId(), examQuestionSubmissionCommand.userId());
            throw new ExamSubmissionNotFoundException("Exam submission not found");
        }

        // Find all submitted question and convert to map
        Map<UUID, QuestionSubmission> submittedQuestion = questionSubmissionRepository
                .findAllByExamSubmissionId(examSubmission.getId().getValue())
                .stream().collect(Collectors.toMap(questionSubmission -> questionSubmission.getQuestion().getId().getValue(), Function.identity()));
        List<QuestionSubmission> toUpdate = new ArrayList<>(); // list of question submission which are about to be updated
        List<QuestionSubmission> toCreate = new ArrayList<>(); // list of question submission which are about to be created

        examQuestionSubmissionCommand.questionSubmissionCommands().forEach(questionSubmissionCommand -> {
            // Update question submission
            if(submittedQuestion.containsKey(questionSubmissionCommand.questionId())) {
                QuestionSubmission questionSubmission = submittedQuestion.get(questionSubmissionCommand.questionId());

                questionSubmission.setAnswerStatus(questionSubmissionCommand.answerStatus());
                questionSubmission.setContent(questionSubmissionCommand.content());
                questionSubmission.setNumFile(questionSubmissionCommand.numFile());
                questionSubmission.setFlag(questionSubmissionCommand.flag());

                toUpdate.add(questionSubmission);
            }
            else { // Create new question with new content
                Question question = questionRepository.findById(questionSubmissionCommand.questionId())
                        .orElseThrow(() -> {
                            log.error("Question not found with id: {} when creating question submission", questionSubmissionCommand.questionId());
                            return new QuestionNotFoundException("Question not found");
                        });

                QuestionSubmission questionSubmission = questionSubmissionDataMapper
                        .questionSubmissionCommandToQuestionSubmission(examSubmission, user, question, questionSubmissionCommand);
                courseDomainService.createQuestionSubmission(questionSubmission);

                toCreate.add(questionSubmission);
            }
        });

        // Save all updated question submission
        questionSubmissionRepository.saveAll(toUpdate);

        // Save all new question submission
        questionSubmissionRepository.saveAll(toCreate);
    }

    // Submit one question
    public QuestionSubmission submitOneExamQuestion(OneExamQuestionSubmissionCommand oneExamQuestionSubmissionCommand) {
        Exam exam = examRepository.findBy(new ExamId(oneExamQuestionSubmissionCommand.examId()));

        if (isExamClosed(exam)) {
            log.error("Exam is closed with id: {}", exam.getId().getValue());
            throw new ExamClosedException("Exam is closed");
        }

        User user = userRepository.findUser(oneExamQuestionSubmissionCommand.userId())
                .orElseThrow(() -> {
                    log.info("User not found with id: {}", oneExamQuestionSubmissionCommand.userId());

                    return new UserNotFoundException("User not found");
                });
        ExamSubmission examSubmission = examSubmissionRepository.findByExamAndUser(exam, user);
        Question question = questionRepository.findById(oneExamQuestionSubmissionCommand.questionSubmissionCommand().questionId())
                .orElseThrow(() -> {
                    log.error("Question not found with id: {} when creating question submission ", oneExamQuestionSubmissionCommand.questionSubmissionCommand().questionId());
                    return new QuestionNotFoundException("Question not found");
                });
        Optional<QuestionSubmission> questionSubmission = questionSubmissionRepository.findByExamSubmissionIdAndQuestionId(examSubmission.getId().getValue(), question.getId().getValue());

        // Question is already created --> update
        if(questionSubmission.isPresent()) {
            QuestionSubmission updateQuestionSubmission = questionSubmission.get();
            updateQuestionSubmission.setAnswerStatus(oneExamQuestionSubmissionCommand.questionSubmissionCommand().answerStatus());
            updateQuestionSubmission.setContent(oneExamQuestionSubmissionCommand.questionSubmissionCommand().content());
            updateQuestionSubmission.setNumFile(oneExamQuestionSubmissionCommand.questionSubmissionCommand().numFile());
            updateQuestionSubmission.setFlag(oneExamQuestionSubmissionCommand.questionSubmissionCommand().flag());

            return questionSubmissionRepository.save(updateQuestionSubmission);
        }
        else {
            QuestionSubmission newQuestionSubmission = questionSubmissionDataMapper
                    .questionSubmissionCommandToQuestionSubmission(examSubmission, user, question, oneExamQuestionSubmissionCommand.questionSubmissionCommand());
            courseDomainService.createQuestionSubmission(newQuestionSubmission);

            return questionSubmissionRepository.save(newQuestionSubmission);
        }
    }

    private Boolean isExamClosed(Exam exam) {
        return exam.getTimeClose().isBefore(ZonedDateTime.now());
    }
}
