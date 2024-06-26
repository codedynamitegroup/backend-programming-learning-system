package com.backend.programming.learning.system.course.service.domain.mapper.exam_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionStartCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.QuestionSubmissionFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.ExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionOverviewResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.valueobject.Status;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;

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
                .files(questionSubmissionFileListToQuestionSubmissionFileCommandList(questionSubmission.getQuestionSubmissionFiles()))
                .flag(questionSubmission.getFlag())
                .answerStatus(questionSubmission.getAnswerStatus())
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

    private List<QuestionSubmissionFileCommand> questionSubmissionFileListToQuestionSubmissionFileCommandList(List<QuestionSubmissionFile> questionSubmissionFiles) {
        return questionSubmissionFiles.stream()
                .map(this::questionSubmissionFileToQuestionSubmissionFileCommand)
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

}
