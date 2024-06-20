package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.mapper.SubmissionAssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.repository.SubmissionAssignmentJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.AssignmentId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class SubmissionAssignmentRepositoryImpl implements SubmissionAssignmentRepository {

    private final SubmissionAssignmentJpaRepository submissionAssignmentJpaRepository;

    private final SubmissionAssignmentDataAccessMapper submissionAssignmentDataAccessMapper;

    public SubmissionAssignmentRepositoryImpl(SubmissionAssignmentJpaRepository submissionAssignmentJpaRepository, SubmissionAssignmentDataAccessMapper submissionAssignmentDataAccessMapper) {
        this.submissionAssignmentJpaRepository = submissionAssignmentJpaRepository;
        this.submissionAssignmentDataAccessMapper = submissionAssignmentDataAccessMapper;
    }

    @Override
    public SubmissionAssignment saveSubmissionAssignment(SubmissionAssignment submissionAssignment) {
          return submissionAssignmentDataAccessMapper.assignmentSubmissionEntityToAssignmentSubmission(submissionAssignmentJpaRepository
                .save(submissionAssignmentDataAccessMapper
                        .assignmentSubmissionToAssignmentSubmissionEntity(submissionAssignment)));
    }

    @Override
    public Optional<SubmissionAssignment> findById(UUID submissionAssignmentId) {
        return submissionAssignmentJpaRepository.findById(submissionAssignmentId)
                .map(submissionAssignmentDataAccessMapper::assignmentSubmissionEntityToAssignmentSubmission);
    }

    @Override
    public List<SubmissionAssignment> findAllByAssignmentId(AssignmentId assignmentId) {
        return submissionAssignmentDataAccessMapper.assignmentSubmissionEntityListToAssignmentSubmissionList(submissionAssignmentJpaRepository.findAllByAssignmentId(assignmentId.getValue()));
    }

    @Override
    public void deleteSubmissionAssignmentById(UUID submissionAssignmentId) {
        submissionAssignmentJpaRepository.deleteById(submissionAssignmentId);
    }

    @Override
    public SubmissionAssignment findByAssignmentIdAndUserId(UUID assignmentId, UUID userId) {
        return submissionAssignmentDataAccessMapper.
                assignmentSubmissionEntityToAssignmentSubmission(submissionAssignmentJpaRepository.
                        findByAssignmentIdAndUserId(assignmentId, userId).orElse(null));
    }

    @Override
    public SubmissionAssignment update(SubmissionAssignment submissionAssignment) {
        return submissionAssignmentDataAccessMapper.
                assignmentSubmissionEntityToAssignmentSubmission(submissionAssignmentJpaRepository.
                        save(submissionAssignmentDataAccessMapper.
                                assignmentSubmissionToAssignmentSubmissionEntity(submissionAssignment)));
    }

    @Override
    public Integer countSubmissionsToGradeByAssignmentId(UUID assignmentId) {
        return submissionAssignmentJpaRepository.countSubmissionsToGradeByAssignmentId(assignmentId);
    }

    @Override
    public Integer countAllByAssignmentId(UUID assignmentId) {
        return submissionAssignmentJpaRepository.countAllByAssignmentId(assignmentId);
    }
}
