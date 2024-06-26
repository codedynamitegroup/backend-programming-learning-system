package com.backend.programming.learning.system.course.service.domain.mapper.question_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.ExamQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.OneExamQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.OneExamQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.QuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question_submission.QueryQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.mapper.exam_submission.ExamSubmissionDataMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * com.backend.programming.learning.system.mapper.question_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 1:24 AM
 * Description: ...
 */
@Component
public class QuestionSubmissionDataMapper {
    private final ExamSubmissionDataMapper examSubmissionDataMapper;

    public QuestionSubmissionDataMapper(ExamSubmissionDataMapper examSubmissionDataMapper) {
        this.examSubmissionDataMapper = examSubmissionDataMapper;
    }

    public QuestionSubmission createQuestionSubmissionCommandToQuestionSubmission(ExamSubmission examSubmission, User user, Question question, CreateQuestionSubmissionCommand createQuestionSubmissionCommand) {
        return QuestionSubmission.builder()
                .examSubmission(examSubmission)
                .user(user)
                .question(question)
//                .rightAnswer(createQuestionSubmissionCommand.rightAnswer())
//                .passStatus(createQuestionSubmissionCommand.passStatus())
//                .grade(createQuestionSubmissionCommand.grade())
                .content(createQuestionSubmissionCommand.content())
                .numFile(createQuestionSubmissionCommand.numFile())
                .build();
    }

    public CreateQuestionSubmissionResponse mapToCreateQuestionSubmissionResponse(QuestionSubmission questionSubmission) {
        return CreateQuestionSubmissionResponse.builder()
                .questionSubmissionId(questionSubmission.getId().getValue())
                .examSubmissionId(questionSubmission.getExamSubmission().getId().getValue())
                .userId(questionSubmission.getUser().getId().getValue())
                .questionId(questionSubmission.getQuestion().getId().getValue())
//                .rightAnswer(questionSubmission.getRightAnswer())
//                .passStatus(questionSubmission.getPassStatus())
//                .grade(questionSubmission.getGrade())
                .content(questionSubmission.getContent())
                .numFile(questionSubmission.getNumFile())
                .build();
    }

    //
    public QuestionSubmission questionSubmissionCommandToQuestionSubmission(
            ExamSubmission examSubmission,
            User user,
            Question question,
            List<QuestionSubmissionFile> questionSubmissionFiles,
            QuestionSubmissionCommand questionSubmissionCommand) {
        return QuestionSubmission.builder()
                .examSubmission(examSubmission)
                .user(user)
                .question(question)
//                .rightAnswer(createQuestionSubmissionCommand.rightAnswer())
//                .passStatus(createQuestionSubmissionCommand.passStatus())
//                .grade(createQuestionSubmissionCommand.grade())
                .content(questionSubmissionCommand.content())
                .numFile(questionSubmissionCommand.files().size())
                .flag(questionSubmissionCommand.flag())
                .answerStatus(questionSubmissionCommand.answerStatus())
                .questionSubmissionFiles(questionSubmissionFiles)
                .build();
    }

    public ExamQuestionSubmissionResponse questionSubmissionsToExamQuestionSubmissionResponse() {
        return ExamQuestionSubmissionResponse.builder()
                .message("Submit exam question successfully")
                .build();
    }

    public OneExamQuestionSubmissionResponse questionSubmissionToOneExamQuestionSubmissionResponse(QuestionSubmission questionSubmission) {
        return OneExamQuestionSubmissionResponse.builder()
                .questionId(questionSubmission.getQuestion().getId().getValue())
                .grade(questionSubmission.getGrade())
                .answerStatus(questionSubmission.getAnswerStatus())
                .flag(questionSubmission.getFlag())
                .content(questionSubmission.getContent())
                .message("Submit one exam question successfully")
                .build();
    }

    public QueryQuestionSubmissionResponse questionSubmissionsToQueryQuestionSubmissionResponse(List<QuestionSubmission> questionSubmissionList) {
        return QueryQuestionSubmissionResponse.builder()
                .questionSubmissions(examSubmissionDataMapper.mapToQuestionSubmissions(questionSubmissionList))
                .build();
    }
}
