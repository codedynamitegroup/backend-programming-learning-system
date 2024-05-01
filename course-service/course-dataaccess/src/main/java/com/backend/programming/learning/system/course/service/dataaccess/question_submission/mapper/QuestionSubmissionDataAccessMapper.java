package com.backend.programming.learning.system.course.service.dataaccess.question_submission.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.exam_submission.entity.ExamSubmissionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.exam_submission.mapper.ExamSubmissionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.question.mapper.QuestionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question_submission.entity.QuestionSubmissionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.Question;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.QuestionSubmissionId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionSubmissionDataAccessMapper {
    private final ExamSubmissionDataAccessMapper examSubmissionDataAccessMapper;
    private final UserDataAccessMapper userDataAccessMapper;
    private final QuestionDataAccessMapper questionDataAccessMapper;

    public QuestionSubmissionEntity questionSubmissionToQuestionSubmissionEntity(QuestionSubmission questionSubmission) {
        UserEntity userEntity = userDataAccessMapper.userToUserEntity(questionSubmission.getUser());
        QuestionEntity questionEntity = questionDataAccessMapper.questionToQuestionEntity(questionSubmission.getQuestion());
        ExamSubmissionEntity examSubmissionEntity = examSubmissionDataAccessMapper.examSubmissionToExamSubmissionEntity(questionSubmission.getExamSubmission());
        return QuestionSubmissionEntity.builder()
                .id(questionSubmission.getId().getValue())
                .examSubmission(examSubmissionEntity)
                .user(userEntity)
                .question(questionEntity)
                .passStatus(questionSubmission.getPassStatus())
                .grade(questionSubmission.getGrade())
                .content(questionSubmission.getContent())
                .rightAnswer(questionSubmission.getRightAnswer())
                .numFile(questionSubmission.getNumFile())
                .build();
    }

    public QuestionSubmission questionSubmissionEntityToQuestionSubmission(QuestionSubmissionEntity questionSubmissionEntity) {
        ExamSubmission examSubmission = examSubmissionDataAccessMapper.examSubmissionEntityToExamSubmission(questionSubmissionEntity.getExamSubmission());
        Question question = questionDataAccessMapper.questionEntityToQuestion(questionSubmissionEntity.getQuestion());
        User user = userDataAccessMapper.userEntityToUser(questionSubmissionEntity.getUser());
        QuestionSubmission response = QuestionSubmission.builder()
                .user(user)
                .question(question)
                .examSubmission(examSubmission)
                .passStatus(questionSubmissionEntity.getPassStatus())
                .grade(questionSubmissionEntity.getGrade())
                .content(questionSubmissionEntity.getContent())
                .rightAnswer(questionSubmissionEntity.getRightAnswer())
                .numFile(questionSubmissionEntity.getNumFile())
                .build();
        response.setId(new QuestionSubmissionId(questionSubmissionEntity.getId()));
        return response;
    }
}
