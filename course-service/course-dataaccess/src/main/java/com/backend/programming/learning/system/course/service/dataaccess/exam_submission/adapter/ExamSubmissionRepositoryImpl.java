package com.backend.programming.learning.system.course.service.dataaccess.exam_submission.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.exam_submission.mapper.ExamSubmissionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.exam_submission.repository.ExamSubmissionJpaRepository;
import com.backend.programming.learning.system.entity.ExamSubmission;
import com.backend.programming.learning.system.ports.output.repository.ExamSubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ExamSubmissionRepositoryImpl implements ExamSubmissionRepository {
    private final ExamSubmissionJpaRepository examSubmissionJpaRepository;
    private final ExamSubmissionDataAccessMapper examSubmissionDataAccessMapper;

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
}
