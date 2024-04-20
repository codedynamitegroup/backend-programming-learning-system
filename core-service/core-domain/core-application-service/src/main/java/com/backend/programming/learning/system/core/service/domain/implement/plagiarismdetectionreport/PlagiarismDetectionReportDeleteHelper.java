package com.backend.programming.learning.system.core.service.domain.implement.plagiarismdetectionreport;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.plagiarismdetectionreport.DeletePlagiarismDetectionReportCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.review.DeleteReviewCommand;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.PlagiarismDetectionReport;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.exception.*;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.PlagiarismDetectionReportRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ReviewRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.PlagiarismDetectionReportId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class PlagiarismDetectionReportDeleteHelper {
    private final PlagiarismDetectionReportRepository plagiarismDetectionReportRepository;

    public PlagiarismDetectionReportDeleteHelper(PlagiarismDetectionReportRepository plagiarismDetectionReportRepository) {
        this.plagiarismDetectionReportRepository = plagiarismDetectionReportRepository;
    }

    @Transactional
    public void deletePlagiarismDetectionReportById(
            DeletePlagiarismDetectionReportCommand deletePlagiarismDetectionReportCommand) {
        checkPlagiarismDetectionReportExists(deletePlagiarismDetectionReportCommand.getPlagiarismDetectionReportId());
        plagiarismDetectionReportRepository.deletePlagiarismDetectionReportById(
                deletePlagiarismDetectionReportCommand.getPlagiarismDetectionReportId());
    }

    private void checkPlagiarismDetectionReportExists(UUID plagiarismDetectionReportId) {
        Optional<PlagiarismDetectionReport> plagiarismDetectionReport = plagiarismDetectionReportRepository
                .findById(new PlagiarismDetectionReportId(plagiarismDetectionReportId));
        if (plagiarismDetectionReport.isEmpty()) {
            log.warn("Could not find plagiarism detection report with id: {}", plagiarismDetectionReportId);
            throw new PlagiarismDetectionReportNotFoundException(
                    "Could not find plagiarism detection report with id: " + plagiarismDetectionReportId);
        }
    }

}