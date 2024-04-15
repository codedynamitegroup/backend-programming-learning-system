package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.mapper.AssignmentSubmissionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.repository.AssignmentSubmissionJpaRepository;
import com.backend.programming.learning.system.entity.AssignmentSubmission;
import com.backend.programming.learning.system.ports.output.repository.SubmissionAssignmentRepository;
import org.springframework.stereotype.Component;

@Component
public class AssignmentSubmissionRepositoryImpl implements SubmissionAssignmentRepository {

    private final AssignmentSubmissionJpaRepository assignmentSubmissionJpaRepository;

    private final AssignmentSubmissionDataAccessMapper assignmentSubmissionDataAccessMapper;

    public AssignmentSubmissionRepositoryImpl(AssignmentSubmissionJpaRepository assignmentSubmissionJpaRepository, AssignmentSubmissionDataAccessMapper assignmentSubmissionDataAccessMapper) {
        this.assignmentSubmissionJpaRepository = assignmentSubmissionJpaRepository;
        this.assignmentSubmissionDataAccessMapper = assignmentSubmissionDataAccessMapper;
    }

    @Override
    public AssignmentSubmission saveSubmissionAssignment(AssignmentSubmission submissionAssignment) {
          return assignmentSubmissionDataAccessMapper.assignmentSubmissionEntityToAssignmentSubmission(assignmentSubmissionJpaRepository
                .save(assignmentSubmissionDataAccessMapper
                        .assignmentSubmissionToAssignmentSubmissionEntity(submissionAssignment)));
    }
}
