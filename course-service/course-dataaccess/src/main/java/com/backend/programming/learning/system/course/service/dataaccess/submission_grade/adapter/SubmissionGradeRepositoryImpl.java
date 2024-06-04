package com.backend.programming.learning.system.course.service.dataaccess.submission_grade.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.submission_grade.mapper.SubmissionGradeDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.submission_grade.repository.SubmissionGradeJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionFile;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionGrade;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionFileRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionGradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SubmissionGradeRepositoryImpl implements SubmissionGradeRepository {

    private final SubmissionGradeJpaRepository submissionGradeJpaRepository;
    private final SubmissionGradeDataAccessMapper submissionGradeDataAccessMapper;


    @Override
    public SubmissionGrade save(SubmissionGrade submissionGrade) {
        return  submissionGradeDataAccessMapper.submissionGradeEntityToSubmissionGrade(
                submissionGradeJpaRepository.save(
                        submissionGradeDataAccessMapper.submissionGradeToSubmissionGradeEntity(submissionGrade)
                )
        );
    }

    @Override
    public Optional<SubmissionGrade> findById(UUID submissionGradeId) {
        return submissionGradeJpaRepository.findById(submissionGradeId)
                .map(submissionGradeDataAccessMapper::submissionGradeEntityToSubmissionGrade);
    }

    @Override
    public Optional<SubmissionGrade> findBySubmissionAssignmentId(UUID submissionId) {
        return submissionGradeJpaRepository.findBySubmissionAssignmentId(submissionId)
                .map(submissionGradeDataAccessMapper::submissionGradeEntityToSubmissionGrade);
    }
}
