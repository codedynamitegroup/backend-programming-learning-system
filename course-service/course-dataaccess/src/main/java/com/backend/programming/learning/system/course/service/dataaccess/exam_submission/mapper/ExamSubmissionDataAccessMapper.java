package com.backend.programming.learning.system.course.service.dataaccess.exam_submission.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.exam.entity.ExamEntity;
import com.backend.programming.learning.system.course.service.dataaccess.exam.mapper.ExamDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.exam_submission.entity.ExamSubmissionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamSubmissionId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ExamSubmissionDataAccessMapper {
    private final ExamDataAccessMapper examDataAccessMapper;
    private final UserDataAccessMapper userDataAccessMapper;

    public ExamSubmissionEntity examSubmissionToExamSubmissionEntity(ExamSubmission examSubmission) {
        ExamEntity examEntity = examDataAccessMapper.examToExamEntity(examSubmission.getExam());
        UserEntity userEntity = userDataAccessMapper.userToUserEntity(examSubmission.getUser());
        return ExamSubmissionEntity.builder()
                .id(examSubmission.getId().getValue())
                .exam(examEntity)
                .user(userEntity)
                .startTime(examSubmission.getStartTime())
                .submitTime(examSubmission.getSubmitTime())
                .submitCount(examSubmission.getSubmissionCount())
                .status(examSubmission.status())
                .build();
    }

    public ExamSubmission examSubmissionEntityToExamSubmission(ExamSubmissionEntity examSubmissionEntity) {
        if(Objects.isNull(examSubmissionEntity)) {
            return ExamSubmission.builder()
                    .submissionCount(0)
                    .build();
        }

        Exam exam = examDataAccessMapper.examEntityToExam(examSubmissionEntity.getExam());
        User user = userDataAccessMapper.userEntityToUser(examSubmissionEntity.getUser());
        ExamSubmission examSubmission = ExamSubmission.builder()
                .exam(exam)
                .user(user)
                .startTime(examSubmissionEntity.getStartTime())
                .submitTime(examSubmissionEntity.getSubmitTime())
                .submissionCount(examSubmissionEntity.getSubmitCount())
                .status(examSubmissionEntity.getStatus())
                .build();
        examSubmission.setId(new ExamSubmissionId(examSubmissionEntity.getId()));
        return examSubmission;
    }
}
