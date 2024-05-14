package com.backend.programming.learning.system.core.service.domain.implement.service.plagiarismdetectionreport;

import com.backend.programming.learning.system.core.service.domain.entity.PlagiarismDetectionReport;
import com.backend.programming.learning.system.core.service.domain.exception.PlagiarismDetectionReportNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.PlagiarismDetectionReportRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.PlagiarismDetectionReportId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class PlagiarismDetectionReportQueryHelper {
    private final PlagiarismDetectionReportRepository plagiarismDetectionReportRepository;

    public PlagiarismDetectionReportQueryHelper(
            PlagiarismDetectionReportRepository plagiarismDetectionReportRepository) {
        this.plagiarismDetectionReportRepository = plagiarismDetectionReportRepository;
    }

    @Transactional(readOnly = true)
    public PlagiarismDetectionReport queryPlagiarismDetectionReportById(
            UUID plagiarismDetectionReportId) {
        Optional<PlagiarismDetectionReport> plagiarismDetectionReport = plagiarismDetectionReportRepository
                .findById(new PlagiarismDetectionReportId(plagiarismDetectionReportId));

        if (plagiarismDetectionReport.isEmpty()) {
            log.error("Plagiarism detection report not found with id: {}", plagiarismDetectionReportId);
            throw new PlagiarismDetectionReportNotFoundException(
                    "Plagiarism detection report not found with id: " + plagiarismDetectionReportId);
        }

        return plagiarismDetectionReport.get();
    }

    @Transactional(readOnly = true)
    public Page<PlagiarismDetectionReport> queryAllPlagiarismDetectionReportsByExamId(
            UUID examId, Integer pageNo, Integer pageSize, Boolean fetchAll) {
        return plagiarismDetectionReportRepository.findAllByExamId(examId, pageNo, pageSize, fetchAll);
    }

}





















