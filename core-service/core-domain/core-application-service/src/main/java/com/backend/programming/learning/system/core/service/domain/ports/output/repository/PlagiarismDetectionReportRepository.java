package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.PlagiarismDetectionReport;
import com.backend.programming.learning.system.core.service.domain.valueobject.PlagiarismDetectionReportId;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface PlagiarismDetectionReportRepository {
    Optional<PlagiarismDetectionReport> findById(PlagiarismDetectionReportId plagiarismDetectionReportId);
    Page<PlagiarismDetectionReport> findAllByExamId(UUID examId, Integer pageNo, Integer pageSize, Boolean fetchAll);
    void deletePlagiarismDetectionReportById(UUID plagiarismDetectionReportId);
}
