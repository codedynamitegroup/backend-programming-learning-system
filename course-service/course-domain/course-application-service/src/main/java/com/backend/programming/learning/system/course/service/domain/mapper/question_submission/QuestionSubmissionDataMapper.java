package com.backend.programming.learning.system.course.service.domain.mapper.question_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.ExamQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.OneExamQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.OneExamQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.QuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.Question;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.mapper.question_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 1:24 AM
 * Description: ...
 */
@Component
public class QuestionSubmissionDataMapper {
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

    public QuestionSubmission questionSubmissionCommandToQuestionSubmission(ExamSubmission examSubmission, User user, Question question, QuestionSubmissionCommand questionSubmissionCommand) {
        return QuestionSubmission.builder()
                .examSubmission(examSubmission)
                .user(user)
                .question(question)
//                .rightAnswer(createQuestionSubmissionCommand.rightAnswer())
//                .passStatus(createQuestionSubmissionCommand.passStatus())
//                .grade(createQuestionSubmissionCommand.grade())
                .content(questionSubmissionCommand.content())
                .numFile(questionSubmissionCommand.numFile())
                .flag(questionSubmissionCommand.flag())
                .answerStatus(questionSubmissionCommand.answerStatus())
                .build();
    }

    public ExamQuestionSubmissionResponse questionSubmissionsToExamQuestionSubmissionResponse() {
        return ExamQuestionSubmissionResponse.builder()
                .message("Submit exam question successfully")
                .build();
    }

    public OneExamQuestionSubmissionResponse questionSubmissionToOneExamQuestionSubmissionResponse(QuestionSubmission questionSubmission) {
        return OneExamQuestionSubmissionResponse.builder()
                .questionSubmission(questionSubmission)
                .message("Submit one exam question successfully")
                .build();
    }
}
