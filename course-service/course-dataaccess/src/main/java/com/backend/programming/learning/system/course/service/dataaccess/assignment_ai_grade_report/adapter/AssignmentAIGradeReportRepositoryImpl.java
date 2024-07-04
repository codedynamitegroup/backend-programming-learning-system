package com.backend.programming.learning.system.course.service.dataaccess.assignment_ai_grade_report.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_ai_grade_report.mapper.AssignmentAIGradeReportDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_ai_grade_report.repository.AssignmentAIGradeReportJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.AssignmentAIGradeReport;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.AssignmentAIGradeReportRepository;
import com.backend.programming.learning.system.domain.valueobject.AssignmentAIGradeReportStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Repository
@RequiredArgsConstructor
public class AssignmentAIGradeReportRepositoryImpl implements AssignmentAIGradeReportRepository {
    private final AssignmentAIGradeReportDataAccessMapper assignmentAIGradeReportDataAccessMapper;
    private final AssignmentAIGradeReportJpaRepository assignmentAIGradeReportJpaRepository;

    @Override
    public AssignmentAIGradeReport save(AssignmentAIGradeReport rubricUser) {
        return assignmentAIGradeReportDataAccessMapper
                .assignmentAIGradeReportEntityToAssignmentAIGradeReport(assignmentAIGradeReportJpaRepository
                        .save(assignmentAIGradeReportDataAccessMapper
                                .assignmentAIGradeReportToAssignmentAIGradeReportEntity(rubricUser)));
    }

    @Override
    public Optional<AssignmentAIGradeReport> findByReportId(UUID reportId) {
        return assignmentAIGradeReportJpaRepository.findById(reportId)
                .map(assignmentAIGradeReportDataAccessMapper::assignmentAIGradeReportEntityToAssignmentAIGradeReport);
    }

    @Override
    public List<AssignmentAIGradeReport> findByStatus(AssignmentAIGradeReportStatus assignmentAIGradeReportStatus) {
        return assignmentAIGradeReportJpaRepository.findByStatus(assignmentAIGradeReportStatus)
                .stream()
                .map(assignmentAIGradeReportDataAccessMapper::assignmentAIGradeReportEntityToAssignmentAIGradeReport)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AssignmentAIGradeReport> findAllByAssignmentId(UUID assignmentId, int pageNo, int pageSize, String search) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return assignmentAIGradeReportJpaRepository.findAllByAssignmentId(assignmentId, search, paging)
                .map(assignmentAIGradeReportDataAccessMapper::assignmentAIGradeReportEntityToAssignmentAIGradeReport);
    }
}
