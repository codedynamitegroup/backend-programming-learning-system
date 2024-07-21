package com.backend.programming.learning.system.course.service.domain.mapper.exam_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionStartCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.QuestionSubmissionFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.QuestionSubmissionFileResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.ExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionOverviewResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.outbox.model.code_submission_sender.CodeSubmissionEventPayload;
import com.backend.programming.learning.system.course.service.domain.outbox.model.code_submission_sender.CodeSubmissionSenderOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.valueobject.Status;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.mapper.exam_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 12:23 AM
 * Description: ...
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class ExamSubmissionDataMapper {
    private final ObjectMapper objectMapper;
    public ExamSubmission createExamSubmissionCommandToExamSubmission(
            Exam exam, User user,
            Integer submissionCount,
            CreateExamSubmissionCommand createExamSubmissionCommand) {
        return ExamSubmission.builder()
                .exam(exam)
                .user(user)
                .submissionCount(submissionCount)
                .startTime(createExamSubmissionCommand.startTime())
                .submitTime(createExamSubmissionCommand.submitTime())
                .build();
    }

    public CreateExamSubmissionResponse mapToCreateExamSubmissionResponse(ExamSubmission examSubmission) {
        return new CreateExamSubmissionResponse(
                examSubmission.getId().getValue(),
                examSubmission.getExam().getId().getValue(),
                examSubmission.getUser().getId().getValue(),
                examSubmission.getStartTime(),
                examSubmission.getEndTime(),
                examSubmission.getSubmitTime(),
                examSubmission.status()
        );
    }

    public ExamSubmission createStartExamSubmissionCommandToExamSubmission(
            Exam exam,
            User user,
            Integer submissionCount,
            CreateExamSubmissionStartCommand createExamSubmissionStartCommand,
            ZonedDateTime endTime) {
        return ExamSubmission.builder()
                .exam(exam)
                .user(user)
                .submissionCount(submissionCount)
                .startTime(createExamSubmissionStartCommand.examStartTime())
                .endTime(endTime)
                .status(Status.NOT_SUBMITTED)
                .build();
    }

    public QueryExamSubmissionResponse mapToQueryExamSubmissionResponse(
            ExamSubmission examSubmission, List<QuestionSubmission> questionSubmissions) {

        return QueryExamSubmissionResponse.builder()
                .examSubmissionId(examSubmission.getId().getValue())
                .examId(examSubmission.getExam().getId().getValue())
                .userId(examSubmission.getUser().getId().getValue())
                .courseId(examSubmission.getExam().getCourse().getId().getValue())
                .courseName(examSubmission.getExam().getCourse().getName())
                .name(examSubmission.getExam().getName())
                .intro(examSubmission.getExam().getIntro())
                .attemptCount(examSubmission.getSubmissionCount())
                .maxScores(examSubmission.getExam().getMaxScore())
                .startTime(examSubmission.getStartTime())
                .endTime(examSubmission.getEndTime())
                .submitTime(examSubmission.getSubmitTime())
                .status(examSubmission.status())
                .questionSubmissionResponses(mapToQuestionSubmissions(questionSubmissions))
                .build();
    }

    public List<QuestionSubmissionResponse> mapToQuestionSubmissions(List<QuestionSubmission> questionSubmissions) {
        return questionSubmissions.stream()
                .map(this::questionSubmissionToQuestionSubmissionResponse)
                .toList();
    }

    private QuestionSubmissionResponse questionSubmissionToQuestionSubmissionResponse(QuestionSubmission questionSubmission) {
        return QuestionSubmissionResponse.builder()
                .questionId(questionSubmission.getQuestion().getId().getValue())
                .passStatus(questionSubmission.getPassStatus())
                .grade(questionSubmission.getGrade())
                .content(questionSubmission.getContent())
                .rightAnswer(questionSubmission.getRightAnswer())
                .feedback(questionSubmission.getFeedback())
                .files(questionSubmissionFileListToQuestionSubmissionFileResponseList(questionSubmission.getQuestionSubmissionFiles()))
                .flag(questionSubmission.getFlag())
                .answerStatus(questionSubmission.getAnswerStatus())
                .feedback(questionSubmission.getFeedback())
                .build();
    }

    private QuestionSubmissionFileCommand questionSubmissionFileToQuestionSubmissionFileCommand(QuestionSubmissionFile questionSubmissionFile) {
        return QuestionSubmissionFileCommand.builder()
                .fileUrl(questionSubmissionFile.getUrl())
                .fileName(questionSubmissionFile.getName())
                .fileSize(questionSubmissionFile.getSize())
                .fileType(questionSubmissionFile.getType())
                .build();
    }

    private QuestionSubmissionFileResponse questionSubmissionFileToQuestionSubmissionFileResponse(QuestionSubmissionFile questionSubmissionFile) {
        return QuestionSubmissionFileResponse.builder()
                .id(questionSubmissionFile.getId().getValue().toString())
                .fileName(questionSubmissionFile.getName())
                .fileSize(questionSubmissionFile.getSize())
                .fileType(questionSubmissionFile.getType())
                .build();
    }
    private List<QuestionSubmissionFileCommand> questionSubmissionFileListToQuestionSubmissionFileCommandList(List<QuestionSubmissionFile> questionSubmissionFiles) {
        return questionSubmissionFiles.stream()
                .map(this::questionSubmissionFileToQuestionSubmissionFileCommand)
                .toList();
    }

    private List<QuestionSubmissionFileResponse> questionSubmissionFileListToQuestionSubmissionFileResponseList(List<QuestionSubmissionFile> questionSubmissionFiles) {
        return questionSubmissionFiles.stream()
                .map(this::questionSubmissionFileToQuestionSubmissionFileResponse)
                .toList();
    }

    public QueryExamSubmissionOverviewResponse mapToQueryExamSubmissionResponseWithTotal(ExamSubmission examSubmission, Double markTotal) {
        return QueryExamSubmissionOverviewResponse.builder()
                .examSubmissionId(examSubmission.getId().getValue())
                .examSubmissionExamResponse(examToQueryExamSubmissionExamResponse(examSubmission.getExam()))
                .userId(examSubmission.getUser().getId().getValue())
                .startTime(examSubmission.getStartTime())
                .endTime(examSubmission.getEndTime())
                .submitTime(examSubmission.getSubmitTime())
                .status(examSubmission.status())
                .markTotal(markTotal)
                .build();
    }

    public QueryExamSubmissionOverviewResponse mapToQueryExamSubmissionResponse(ExamSubmission examSubmission,
                                                                                         Double mark,
                                                                                         Double markTotal,
                                                                                         Double grade,
                                                                                         Double gradeTotal) {
        return QueryExamSubmissionOverviewResponse.builder()
                .examSubmissionId(examSubmission.getId().getValue())
                .examSubmissionExamResponse(examToQueryExamSubmissionExamResponse(examSubmission.getExam()))
                .userId(examSubmission.getUser().getId().getValue())
                .startTime(examSubmission.getStartTime())
                .endTime(examSubmission.getEndTime())
                .submitTime(examSubmission.getSubmitTime())
                .status(examSubmission.status())
                .mark(mark)
                .markTotal(markTotal)
                .grade(grade)
                .gradeTotal(gradeTotal)
                .build();
    }

    private QueryExamSubmissionExamResponse examToQueryExamSubmissionExamResponse(Exam exam) {
        return QueryExamSubmissionExamResponse.builder()
                .examId(exam.getId().getValue())
                .courseId(exam.getCourse().getId().getValue())
                .name(exam.getName())
                .overdueHanding(exam.getOverdueHanding().name())
                .shuffleAnswers(exam.getShuffleAnswers())
                .canRedoQuestions(exam.getCanRedoQuestions())
                .intro(exam.getIntro())
                .timeLimit(exam.getTimeLimit())
                .timeOpen(exam.getTimeOpen().toString())
                .timeClose(exam.getTimeClose().toString())
                .build();
    }

    public List<ExamSubmissionResponse> examSubmissionToQueryExamSubmission(List<ExamSubmission> examSubmission) {
        return examSubmission.stream()
                .map(this::examSubmissionToQueryExamSubmissionResponse)
                .toList();
    }

    private ExamSubmissionResponse examSubmissionToQueryExamSubmissionResponse(ExamSubmission examSubmission) {
        return ExamSubmissionResponse.builder()
                .examSubmissionId(examSubmission.getId().getValue())
                .studentId(examSubmission.getUser().getId().getValue())
                .firstName(examSubmission.getUser().getFirstName())
                .lastName(examSubmission.getUser().getLastName())
                .startTime(examSubmission.getStartTime())
                .submitTime(examSubmission.getSubmitTime())
                .status(examSubmission.status())
                .build();
    }

    public CodeSubmissionSenderOutboxMessage codeQuestionSubmissionToCodeSubmissionSenderOutboxMessage(QuestionSubmission codeQuestionSubmission) {
        CodeSubmissionEventPayload payload = CodeSubmissionEventPayload.builder()
                .submissionId(codeQuestionSubmission.getId().getValue().toString())
                .questionId(codeQuestionSubmission.getQuestion().getId().getValue().toString())
                .userId(codeQuestionSubmission.getUser().getId().getValue().toString())
                .content(codeQuestionSubmission.getContent())
                .build();

        return CodeSubmissionSenderOutboxMessage.builder()
                .id(UUID.randomUUID())
                .sagaId(UUID.randomUUID())
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .processedAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .sendStatus(false)
                .outboxStatus(OutboxStatus.STARTED)
                .payload(createPayload(payload))
                .build();
    }
    private String createPayload(CodeSubmissionEventPayload payload) {
        try {
            return objectMapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            log.error("Could not create CodeSubmissionEventPayload object for id: {}",
                    payload.getSubmissionId(), e);
            throw new CourseDomainException("Could not create CodeSubmissionEventPayload object for id: " +
                    payload.getSubmissionId(), e);
        }
    }
}
