package com.backend.programming.learning.system.course.service.domain.service.exam.submission;

import com.backend.programming.learning.system.course.service.domain.entity.exam.submission.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.mapper.exam.ExamDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.exam.submission.ExamSubmissionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.exam.submission.ExamSubmissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.backend.programming.learning.system.course.service.domain.service.exam.submission
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 11:29 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ExamSubmissionCreateCommandHandler {
//    private final ExamSubmissionDomainService examSubmissionDomainService;
    private final ExamSubmissionRepository examSubmissionRepository;
    private final ExamSubmissionDataMapper examSubmissionDataMapper;
    @Transactional
    public void submitExam(Long examId) {
        log.info("Submitting exam with id: {}", examId);
        ExamSubmission examSubmission = examSubmissionDataMapper.createExamSubmission(examId);
        examSubmissionRepository.createExamSubmission(examSubmission);
    }
}
