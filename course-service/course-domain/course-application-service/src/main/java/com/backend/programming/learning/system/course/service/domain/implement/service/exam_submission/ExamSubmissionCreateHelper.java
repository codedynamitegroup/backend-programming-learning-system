package com.backend.programming.learning.system.course.service.domain.implement.service.exam_submission;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionEndCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionStartCommand;
import com.backend.programming.learning.system.course.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.Question;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.exception.ExamClosedException;
import com.backend.programming.learning.system.course.service.domain.exception.ExamSubmissionConflictException;
import com.backend.programming.learning.system.course.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.course.service.domain.mapper.exam_submission.ExamSubmissionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.AnswerOfQuestionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamSubmissionId;
import com.backend.programming.learning.system.course.service.domain.valueobject.Status;
import com.backend.programming.learning.system.domain.exception.question.QuestionNotFoundException;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

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
    private final AnswerOfQuestionRepository answerOfQuestionRepository;
    private final ExamSubmissionDataMapper examSubmissionDataMapper;

    public ExamSubmission createExamSubmission(CreateExamSubmissionCommand createExamSubmissionCommand) {
        log.info("Create exam submission");
        Exam exam = examRepository.findBy(new ExamId(createExamSubmissionCommand.examId()));
        User user = userRepository.findUser(createExamSubmissionCommand.userId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
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
                    Optional<Question> questionExam = questionRepository.findById(question.questionId());

                    if (questionExam.isEmpty()) {
                        log.error("Question not found with id: {}", question.questionId());
                        throw new QuestionNotFoundException("Question not found with id: " + question.questionId());
                    }

                    List<AnswerOfQuestion> answerOfQuestion = answerOfQuestionRepository.findAllByQuestionId(question.questionId());

                    Float defaultMark = questionExam.get().getDefaultMark();
                    AtomicReference<Float> grade = new AtomicReference<>(0F);
                    String contentStudent = question.content();
                    if (questionExam.get().getQtype().equals(QuestionType.SHORT_ANSWER)) {
                        answerOfQuestion.forEach(answer -> {
                            String answerText = answer.getAnswer().replaceAll("<p>|</p>", "");
                            if (answerText.equals(contentStudent)) {
                                grade.set(defaultMark * answer.getFraction());
                            }
                        });
                    } else if (questionExam.get().getQtype().equals(QuestionType.MULTIPLE_CHOICE)) {
                        answerOfQuestion.forEach(answer -> {
                            String answerText = answer.getAnswer().replaceAll("<p>|</p>", "");
                            if (answer.getId().getValue().toString().equals(contentStudent)) {
                                grade.updateAndGet(v -> v + defaultMark * answer.getFraction());
                            }
                        });
                    } else if (questionExam.get().getQtype().equals(QuestionType.TRUE_FALSE)) {
                        answerOfQuestion.forEach(answer -> {
                            String answerText = answer.getAnswer().replaceAll("<p>|</p>", "");
                            if (answerText.equals(contentStudent)) {
                                grade.set(defaultMark * answer.getFraction());
                            }
                        });
                    }

                    QuestionSubmission questionSubmission = QuestionSubmission.builder()
                            .user(submission.getUser())
                            .examSubmission(submission)
                            .question(questionExam.get())
                            .content(question.content())
                            .numFile(question.numFile())
                            .grade(grade.get())
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

        if (isExamClosed(exam)) {
            log.error("Exam is closed");
            throw new ExamClosedException("Exam is closed");
        }

        // Calculate endtime
        ZonedDateTime endTime = createExamSubmissionCommand.examStartTime().plusSeconds(exam.getTimeLimit());

        User user = userRepository.findUser(createExamSubmissionCommand.userId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        // Get the latest exam submission
        ExamSubmission examSubmissionLast = examSubmissionRepository.findByExamAndUser(exam, user);

        // Max attempt check
        if (exam.getMaxAttempts() > 0 && // Unlimited attempt
                examSubmissionLast.getSubmissionCount() >= exam.getMaxAttempts() &&
                isExamSubmissionSubmitted(examSubmissionLast)
        ) {
            log.error("Submission limit exceeded");
            throw new ExamSubmissionConflictException("Submission limit exceeded");
        }

        //check there is other on-going exam submission being taken
        if (!Objects.isNull(examSubmissionLast.getExam()) && // No last submission --> first submission
                !isExamSubmissionSubmitted(examSubmissionLast)) { // Exam time is not over
            log.error("There is an on-going exam submission");
            throw new RuntimeException("There is an on-going exam submission");
        }

        ExamSubmission examSubmission = examSubmissionDataMapper
                .createStartExamSubmissionCommandToExamSubmission(exam, user,
                        Objects.isNull(examSubmissionLast.getExam()) ? 1 : examSubmissionLast.getSubmissionCount() + 1,
                        createExamSubmissionCommand, endTime);
        courseDomainService.createStartExamSubmission(examSubmission);
        return saveExamSubmission(examSubmission);
    }

    public ExamSubmission createEndExamSubmission(CreateExamSubmissionEndCommand createExamSubmissionStartCommand) {
        return examSubmissionRepository.saveEnd(createExamSubmissionStartCommand);
    }

    private Boolean isExamClosed(Exam exam) {
        return exam.getTimeClose().isBefore(ZonedDateTime.now());
    }

    private Boolean isExamSubmissionSubmitted(ExamSubmission examSubmission) {
        // Haven't submit and exam time is not over
        return !Objects.isNull(examSubmission.getSubmitTime()) || !examSubmission.getEndTime()
                .isAfter(ZonedDateTime.now());
    }

    public void gradingExam(CreateExamSubmissionEndCommand createExamSubmissionEndCommand) {
        Exam exam = examRepository.findBy(new ExamId(createExamSubmissionEndCommand.examId()));
        User user = userRepository.findUser(createExamSubmissionEndCommand.userId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        ExamSubmission examSubmissionLast = examSubmissionRepository.findByExamAndUser(exam, user);
        List<QuestionSubmission> questionSubmissions = questionSubmissionRepository
                .findAllByExamSubmissionId(examSubmissionLast.getId().getValue());

        AtomicReference<Float> mark = new AtomicReference<>(0F);
        AtomicReference<Float> totleMark = new AtomicReference<>(0F);

        questionSubmissions.forEach(question -> {
            Optional<Question> questionExam = questionRepository.findById(question.getQuestion().getId().getValue());

            if (questionExam.isEmpty()) {
                log.error("Question not found with id: {}", question.getQuestion().getId().getValue());
                throw new QuestionNotFoundException("Question not found with id: " + question.getQuestion().getId().getValue());
            }

            List<AnswerOfQuestion> answerOfQuestion = answerOfQuestionRepository
                    .findAllByQuestionId(question.getQuestion().getId().getValue());

            Float defaultMark = questionExam.get().getDefaultMark();
            AtomicReference<Float> grade = new AtomicReference<>(0F);
            String contentStudent = question.getContent();

            if (questionExam.get().getQtype().equals(QuestionType.SHORT_ANSWER)) {
                answerOfQuestion.forEach(answer -> {
                    String answerText = answer.getAnswer().replaceAll("<p>|</p>", "");
                    if (answerText.equals(contentStudent)) {
                        grade.set(defaultMark * answer.getFraction());
                    }
                });
            } else if (questionExam.get().getQtype().equals(QuestionType.MULTIPLE_CHOICE)) {
                answerOfQuestion.forEach(answer -> {
                    String answerText = answer.getAnswer().replaceAll("<p>|</p>", "");
                    if (answer.getId().getValue().toString().equals(contentStudent)) {
                        grade.updateAndGet(v -> v + defaultMark * answer.getFraction());
                    }
                });
            } else if (questionExam.get().getQtype().equals(QuestionType.TRUE_FALSE)) {
                answerOfQuestion.forEach(answer -> {
                    String answerText = answer.getAnswer().replaceAll("<p>|</p>", "");
                    if (answerText.equals(contentStudent)) {
                        grade.set(defaultMark * answer.getFraction());
                    }
                });
            }

            mark.updateAndGet(v -> v + grade.get());
            totleMark.updateAndGet(v -> v + defaultMark);
            question.setGrade(grade.get());
            questionSubmissionRepository.save(question);
        });

        examSubmissionLast.setScore(mark.get());

        examSubmissionRepository.save(examSubmissionLast);
    }

    public void updateStatusGrade(ExamSubmissionId examSubmissionId) {
        ExamSubmission examSubmission = examSubmissionRepository.findBy(examSubmissionId.getValue());
        examSubmission.setStatus(Status.GRADED);
        List<QuestionSubmission> questionSubmissions = questionSubmissionRepository
                .findAllByExamSubmissionId(examSubmission.getId().getValue());
        Double mark = questionSubmissions.stream()
                .filter(questionSubmission -> questionSubmission.getGrade() != null)
                .mapToDouble(QuestionSubmission::getGrade)
                .sum();
        Double totalMark = questionSubmissions.stream()
                .filter(value -> value.getQuestion() != null)
                .mapToDouble(value -> value.getQuestion().getDefaultMark())
                .sum();
        Double maxGrade = Double.valueOf(examSubmission.getExam().getMaxScore());
        Float grade = (float) (Math.round((mark / totalMark) * maxGrade * 100.0) / 100.0);

        examSubmission.setScore(grade);

        examSubmissionRepository.save(examSubmission);
    }
}
