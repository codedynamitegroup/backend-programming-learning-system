package com.backend.programming.learning.system.core.service.dataaccess.plagiarismdetectionreport.repository;

import com.backend.programming.learning.system.core.service.dataaccess.plagiarismdetectionreport.entity.PlagiarismDetectionReportEntity;
import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.entity.ProgrammingLanguageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlagiarismDetectionReportJpaRepository extends JpaRepository<PlagiarismDetectionReportEntity, UUID> {
    Optional<PlagiarismDetectionReportEntity> findById(UUID plagiarismDetectionReportId);
    Optional<PlagiarismDetectionReportEntity> findByExamIdAndQuestionId(UUID examId, UUID questionId);
    Page<PlagiarismDetectionReportEntity> findAllByExamId(UUID examId, Pageable pageable);
}
