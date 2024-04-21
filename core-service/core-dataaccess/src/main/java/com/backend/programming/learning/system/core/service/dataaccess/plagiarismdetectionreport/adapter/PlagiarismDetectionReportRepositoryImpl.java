package com.backend.programming.learning.system.core.service.dataaccess.plagiarismdetectionreport.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.plagiarismdetectionreport.mapper.PlagiarismDetectionReportDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.plagiarismdetectionreport.repository.PlagiarismDetectionReportJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.PlagiarismDetectionReport;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.PlagiarismDetectionReportRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.PlagiarismDetectionReportId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class PlagiarismDetectionReportRepositoryImpl implements PlagiarismDetectionReportRepository {
    private final PlagiarismDetectionReportJpaRepository plagiarismDetectionReportJpaRepository;
    private final PlagiarismDetectionReportDataAccessMapper plagiarismDetectionReportDataAccessMapper;

    public PlagiarismDetectionReportRepositoryImpl(PlagiarismDetectionReportJpaRepository plagiarismDetectionReportJpaRepository,
                                                   PlagiarismDetectionReportDataAccessMapper plagiarismDetectionReportDataAccessMapper) {
        this.plagiarismDetectionReportJpaRepository = plagiarismDetectionReportJpaRepository;
        this.plagiarismDetectionReportDataAccessMapper = plagiarismDetectionReportDataAccessMapper;
    }

    @Override
    public Optional<PlagiarismDetectionReport> findById(PlagiarismDetectionReportId plagiarismDetectionReportId) {
        return plagiarismDetectionReportJpaRepository.findById(plagiarismDetectionReportId.getValue())
                .map(plagiarismDetectionReportDataAccessMapper::
                        plagiarismDetectionReportEntityToPlagiarismDetectionReport);
    }

    @Override
    public Page<PlagiarismDetectionReport> findAllByExamId(UUID examId, Integer pageNo, Integer pageSize, Boolean fetchAll) {
        Pageable paging = fetchAll ? Pageable.unpaged() : Pageable.ofSize(pageSize).withPage(pageNo);
        return plagiarismDetectionReportJpaRepository.findAllByExamId(examId, paging)
                .map(plagiarismDetectionReportDataAccessMapper
                        ::plagiarismDetectionReportEntityToPlagiarismDetectionReport);
    }

    @Override
    public void deletePlagiarismDetectionReportById(UUID plagiarismDetectionReportId) {
        plagiarismDetectionReportJpaRepository.deleteById(plagiarismDetectionReportId);
    }
}
