package com.backend.programming.learning.system.course.service.dataaccess.exam_submission.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.exam_submission.mapper.ExamSubmissionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.exam_submission.repository.ExamSubmissionJpaRepository;
import com.backend.programming.learning.system.entity.ExamSubmission;
import com.backend.programming.learning.system.ports.output.repository.ExamSubmissionRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ExamSubmissionRepositoryImpl implements ExamSubmissionRepository {
    private final ExamSubmissionJpaRepository examSubmissionJpaRepository;
    private final ExamSubmissionDataAccessMapper examSubmissionDataAccessMapper;

    public ExamSubmissionRepositoryImpl(ExamSubmissionJpaRepository examSubmissionJpaRepository, ExamSubmissionDataAccessMapper examSubmissionDataAccessMapper) {
        this.examSubmissionJpaRepository = examSubmissionJpaRepository;
        this.examSubmissionDataAccessMapper = examSubmissionDataAccessMapper;
    }


    @Override
    public ExamSubmission saveExamSubmission(ExamSubmission examSubmission) {
        return examSubmissionDataAccessMapper.examSubmissionEntityToExamSubmission(examSubmissionJpaRepository
                .save(examSubmissionDataAccessMapper
                        .examSubmissionToExamSubmissionEntity(examSubmission)));
    }
}
