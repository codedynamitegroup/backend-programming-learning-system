package com.backend.programming.learning.system.course.service.dataaccess.question_submission.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.question_submission.entity.QuestionSubmissionEntity;
import com.backend.programming.learning.system.entity.QuestionSubmission;
import com.backend.programming.learning.system.valueobject.QuestionSubmissionId;
import org.springframework.stereotype.Component;

@Component
public class QuestionSubmissionDataAccessMapper {
    public QuestionSubmissionEntity questionSubmissionToQuestionSubmissionEntity(QuestionSubmission questionSubmission) {
        return QuestionSubmissionEntity.builder()
                .id(questionSubmission.getId().getValue())
                .pass_status(questionSubmission.getPass_status())
                .grade(questionSubmission.getGrade())
                .content(questionSubmission.getContent())
                .right_answer(questionSubmission.getRightAnswer())
                .num_file(questionSubmission.getNum_file())
                .build();
    }

    public QuestionSubmission questionSubmissionEntityToQuestionSubmission(QuestionSubmissionEntity questionSubmissionEntity) {
        return QuestionSubmission.builder()
                .id(new QuestionSubmissionId(questionSubmissionEntity.getId()))
                .pass_status(questionSubmissionEntity.getPass_status())
                .grade(questionSubmissionEntity.getGrade())
                .content(questionSubmissionEntity.getContent())
                .rightAnswer(questionSubmissionEntity.getRight_answer())
                .num_file(questionSubmissionEntity.getNum_file())
                .build();
    }
}
