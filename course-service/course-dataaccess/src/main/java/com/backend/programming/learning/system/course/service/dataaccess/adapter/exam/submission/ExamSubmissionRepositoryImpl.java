package com.backend.programming.learning.system.course.service.dataaccess.adapter.exam.submission;

import com.backend.programming.learning.system.course.service.dataaccess.mapper.exam.submission.ExamSubmissionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.repository.exam.submission.ExamSubmissionJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.exam.submission.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.mapper.exam.submission.ExamSubmissionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.exam.submission.ExamSubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.adapter.exam.submission
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 11:59 PM
 * Description: ...
 */
@Component
@RequiredArgsConstructor
public class ExamSubmissionRepositoryImpl implements ExamSubmissionRepository {
    private final ExamSubmissionJpaRepository examSubmissionJpaRepository;
    private final ExamSubmissionDataAccessMapper examSubmissionDataAccessMapper;
    @Override
    public void createExamSubmission(ExamSubmission examSubmission) {
        examSubmissionJpaRepository.save(examSubmissionDataAccessMapper.examSubmissionToExamSubmissionEntity(examSubmission));
    }
}
