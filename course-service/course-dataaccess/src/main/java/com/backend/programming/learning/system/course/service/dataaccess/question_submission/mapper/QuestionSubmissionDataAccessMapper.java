package com.backend.programming.learning.system.course.service.dataaccess.question_submission.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.exam_submission.entity.ExamSubmissionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.exam_submission.mapper.ExamSubmissionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.question.mapper.QuestionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question_submission.entity.QuestionSubmissionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.question_submission_file.entity.QuestionSubmissionFileEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.valueobject.QuestionSubmissionFileId;
import com.backend.programming.learning.system.course.service.domain.valueobject.QuestionSubmissionId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

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

        QuestionSubmissionEntity questionSubmissionEntity =  QuestionSubmissionEntity.builder()
                .id(questionSubmission.getId().getValue())
                .examSubmission(examSubmissionEntity)
                .user(userEntity)
                .question(questionEntity)
                .passStatus(questionSubmission.getPassStatus())
                .grade(questionSubmission.getGrade())
                .content(questionSubmission.getContent())
                .rightAnswer(questionSubmission.getRightAnswer())
                .numFile(questionSubmission.getNumFile())
                .answerStatus(questionSubmission.getAnswerStatus())
                .flag(questionSubmission.getFlag())
                .build();

        List<QuestionSubmissionFileEntity> questionSubmissionFiles = questionSubmissionFileListToQuestionSubmissionFileEntityList(questionSubmission.getQuestionSubmissionFiles(), questionSubmissionEntity);
        questionSubmissionEntity.setQuestionSubmissionFiles(questionSubmissionFiles);

        return questionSubmissionEntity;
    }

    private QuestionSubmissionFileEntity questionSubmissionFileToQuestionSubmissionFileEntity(QuestionSubmissionFile questionSubmissionFile, QuestionSubmissionEntity questionSubmissionEntity) {
        return QuestionSubmissionFileEntity.builder()
                .id(questionSubmissionFile.getId().getValue())
                .questionSubmission(questionSubmissionEntity)
                .url(questionSubmissionFile.getUrl())
                .name(questionSubmissionFile.getName())
                .fileSize(questionSubmissionFile.getSize())
                .type(questionSubmissionFile.getType())
                .build();
    }

    private List<QuestionSubmissionFileEntity> questionSubmissionFileListToQuestionSubmissionFileEntityList(List<QuestionSubmissionFile> questionSubmissionFiles, QuestionSubmissionEntity questionSubmissionEntity) {
        return questionSubmissionFiles.stream()
                .map(questionSubmissionFile -> questionSubmissionFileToQuestionSubmissionFileEntity(questionSubmissionFile, questionSubmissionEntity))
                .toList();
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
                .feedback(questionSubmissionEntity.getFeedback())
                .numFile(questionSubmissionEntity.getNumFile())
                .answerStatus(questionSubmissionEntity.getAnswerStatus())
                .flag(questionSubmissionEntity.getFlag())
                .questionSubmissionFiles(questionSubmissionFileEntityListToQuestionSubmissionFileList(questionSubmissionEntity.getQuestionSubmissionFiles()))
                .build();

        response.setId(new QuestionSubmissionId(questionSubmissionEntity.getId()));

        return response;
    }

    private QuestionSubmissionFile questionSubmissionFileEntityToQuestionSubmissionFile(QuestionSubmissionFileEntity questionSubmissionFileEntity) {
        return QuestionSubmissionFile.builder()
                .id(new QuestionSubmissionFileId(questionSubmissionFileEntity.getId()))
//                .questionSubmission(questionSubmissionEntityToQuestionSubmission(questionSubmissionFileEntity.getQuestionSubmission()))
                .url(questionSubmissionFileEntity.getUrl())
                .name(questionSubmissionFileEntity.getName())
                .size(questionSubmissionFileEntity.getFileSize())
                .type(questionSubmissionFileEntity.getType())
                .build();
    }

    private List<QuestionSubmissionFile> questionSubmissionFileEntityListToQuestionSubmissionFileList(List<QuestionSubmissionFileEntity> questionSubmissionFileEntities) {
        return questionSubmissionFileEntities.stream()
                .map(this::questionSubmissionFileEntityToQuestionSubmissionFile)
                .toList();
    }

    public List<QuestionSubmission> questionSubmissionEntityListToQuestionSubmissionList(List<QuestionSubmissionEntity> questionSubmissionEntities) {
        return questionSubmissionEntities.stream()
                .map(this::questionSubmissionEntityToQuestionSubmission)
                .toList();
    }
}
