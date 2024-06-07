package com.backend.programming.learning.system.course.service.dataaccess.exam_submission.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.exam.entity.ExamEntity;
import com.backend.programming.learning.system.course.service.dataaccess.exam.mapper.ExamDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.exam.repository.ExamJpaRepository;
import com.backend.programming.learning.system.course.service.dataaccess.exam_submission.entity.ExamSubmissionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.exam_submission.mapper.ExamSubmissionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.exam_submission.repository.ExamSubmissionJpaRepository;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionStartCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import com.backend.programming.learning.system.course.service.domain.valueobject.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ExamSubmissionRepositoryImpl implements ExamSubmissionRepository {
    private final ExamSubmissionJpaRepository examSubmissionJpaRepository;
    private final ExamJpaRepository examJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final ExamSubmissionDataAccessMapper examSubmissionDataAccessMapper;
    private final ExamDataAccessMapper examDataAccessMapper;
    private final UserDataAccessMapper userDataAccessMapper;

    @Override
    public ExamSubmission save(ExamSubmission examSubmission) {
        return examSubmissionDataAccessMapper
                .examSubmissionEntityToExamSubmission(examSubmissionJpaRepository
                        .save(examSubmissionDataAccessMapper.examSubmissionToExamSubmissionEntity(examSubmission)));
    }

    @Override
    public ExamSubmission findBy(UUID examSubmissionId) {
        return examSubmissionDataAccessMapper
                .examSubmissionEntityToExamSubmission(examSubmissionJpaRepository
                        .findById(examSubmissionId)
                        .orElseThrow(() -> new RuntimeException("Exam submission not found")));
    }

    @Override
    public ExamSubmission findByExamAndUser(Exam exam, User user) {
        ExamEntity examEntity = examDataAccessMapper.examToExamEntity(exam);
        UserEntity userEntity = userDataAccessMapper.userToUserEntity(user);
        ExamSubmissionEntity examSubmissionEntities = Objects.requireNonNull(examSubmissionJpaRepository
                        .findByExamAndUser(examEntity, userEntity)
                        .orElse(null))
                .stream()
                .min((e1, e2) -> e2.getSubmitCount().compareTo(e1.getSubmitCount()))
                .orElse(null);
        return examSubmissionDataAccessMapper.examSubmissionEntityToExamSubmission(examSubmissionEntities);
    }

    @Override
    public Integer countSubmission(ExamId examId) {
        return examSubmissionJpaRepository.countSubmission(examId.getValue());
    }

    @Override
    public ExamSubmission saveEnd(CreateExamSubmissionStartCommand createExamSubmissionStartCommand) {
        ExamEntity examEntity = examJpaRepository.findById(createExamSubmissionStartCommand.examId())
                .orElseThrow(() -> new RuntimeException("Exam not found"));
        UserEntity userEntity = userJpaRepository.findById(createExamSubmissionStartCommand.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        ExamSubmissionEntity examSubmissionEntity = Objects.requireNonNull(examSubmissionJpaRepository
                        .findByExamAndUser(examEntity, userEntity)
                        .orElse(null))
                .stream()
                .min((e1, e2) -> e2.getSubmitCount().compareTo(e1.getSubmitCount()))
                .orElse(null);
        examSubmissionEntity.setSubmitTime(ZonedDateTime.now());
        examSubmissionEntity.setStatus(Status.SUBMITTED);
        return examSubmissionDataAccessMapper.examSubmissionEntityToExamSubmission(examSubmissionJpaRepository.save(examSubmissionEntity));
    }

    @Override
    public ExamSubmission findByExamId(ExamId examId) {
    //   examSubmissionJpaRepository
    //                        .findByExamId(examId.getValue())
    //                        .orElse(null));
        // de tam
    return null;
    }

    @Override
    public List<ExamSubmission> findAllByExamIdAndUserId(UUID examId, UUID userId) {
     List<ExamSubmissionEntity> examSubmissionEntities = examSubmissionJpaRepository.findByExamIdAndUserId(examId, userId);
     return examSubmissionDataAccessMapper.examSubmissionEntitiesToExamSubmissions(examSubmissionEntities);
    }
}
