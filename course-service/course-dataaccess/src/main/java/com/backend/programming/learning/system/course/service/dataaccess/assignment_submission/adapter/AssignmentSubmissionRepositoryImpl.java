package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.mapper.AssignmentSubmissionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.repository.AssignmentSubmissionJpaRepository;
import com.backend.programming.learning.system.entity.SubmissionAssignment;
import com.backend.programming.learning.system.ports.output.repository.SubmissionAssignmentRepository;
import com.backend.programming.learning.system.valueobject.AssignmentId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AssignmentSubmissionRepositoryImpl implements SubmissionAssignmentRepository {

    private final AssignmentSubmissionJpaRepository assignmentSubmissionJpaRepository;

    private final AssignmentSubmissionDataAccessMapper assignmentSubmissionDataAccessMapper;

    public AssignmentSubmissionRepositoryImpl(AssignmentSubmissionJpaRepository assignmentSubmissionJpaRepository, AssignmentSubmissionDataAccessMapper assignmentSubmissionDataAccessMapper) {
        this.assignmentSubmissionJpaRepository = assignmentSubmissionJpaRepository;
        this.assignmentSubmissionDataAccessMapper = assignmentSubmissionDataAccessMapper;
    }

    @Override
    public SubmissionAssignment saveSubmissionAssignment(SubmissionAssignment submissionAssignment) {
          return assignmentSubmissionDataAccessMapper.assignmentSubmissionEntityToAssignmentSubmission(assignmentSubmissionJpaRepository
                .save(assignmentSubmissionDataAccessMapper
                        .assignmentSubmissionToAssignmentSubmissionEntity(submissionAssignment)));
    }

    @Override
    public Optional<SubmissionAssignment> findById(UUID submissionAssignmentId) {
        return assignmentSubmissionJpaRepository.findById(submissionAssignmentId)
                .map(assignmentSubmissionDataAccessMapper::assignmentSubmissionEntityToAssignmentSubmission);
    }

    @Override
    public List<SubmissionAssignment> findAllByAssignmentId(AssignmentId assignmentId) {
        return assignmentSubmissionDataAccessMapper.assignmentSubmissionEntityListToAssignmentSubmissionList(assignmentSubmissionJpaRepository.findAllByAssignmentId(assignmentId.getValue()));
    }

    @Override
    public void deleteSubmissionAssignmentById(UUID submissionAssignmentId) {
        assignmentSubmissionJpaRepository.deleteById(submissionAssignmentId);
    }
}
