package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.mapper.SubmissionAssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.repository.AssignmentSubmissionJpaRepository;
import com.backend.programming.learning.system.entity.SubmissionAssignment;
import com.backend.programming.learning.system.ports.output.repository.SubmissionAssignmentRepository;
import com.backend.programming.learning.system.valueobject.AssignmentId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class SubmissionAssignmentRepositoryImpl implements SubmissionAssignmentRepository {

    private final AssignmentSubmissionJpaRepository assignmentSubmissionJpaRepository;

    private final SubmissionAssignmentDataAccessMapper submissionAssignmentDataAccessMapper;

    public SubmissionAssignmentRepositoryImpl(AssignmentSubmissionJpaRepository assignmentSubmissionJpaRepository, SubmissionAssignmentDataAccessMapper submissionAssignmentDataAccessMapper) {
        this.assignmentSubmissionJpaRepository = assignmentSubmissionJpaRepository;
        this.submissionAssignmentDataAccessMapper = submissionAssignmentDataAccessMapper;
    }

    @Override
    public SubmissionAssignment saveSubmissionAssignment(SubmissionAssignment submissionAssignment) {
          return submissionAssignmentDataAccessMapper.assignmentSubmissionEntityToAssignmentSubmission(assignmentSubmissionJpaRepository
                .save(submissionAssignmentDataAccessMapper
                        .assignmentSubmissionToAssignmentSubmissionEntity(submissionAssignment)));
    }

    @Override
    public Optional<SubmissionAssignment> findById(UUID submissionAssignmentId) {
        return assignmentSubmissionJpaRepository.findById(submissionAssignmentId)
                .map(submissionAssignmentDataAccessMapper::assignmentSubmissionEntityToAssignmentSubmission);
    }

    @Override
    public List<SubmissionAssignment> findAllByAssignmentId(AssignmentId assignmentId) {
        return submissionAssignmentDataAccessMapper.assignmentSubmissionEntityListToAssignmentSubmissionList(assignmentSubmissionJpaRepository.findAllByAssignmentId(assignmentId.getValue()));
    }

    @Override
    public void deleteSubmissionAssignmentById(UUID submissionAssignmentId) {
        assignmentSubmissionJpaRepository.deleteById(submissionAssignmentId);
    }
}
