package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.mapper.AssignmentSubmissionFileDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.repository.AssignmentSubmissionFileJpaRepository;
import com.backend.programming.learning.system.entity.SubmissionAssignmentFile;
import com.backend.programming.learning.system.ports.output.repository.SubmissionAssignmentFileRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AssignmentSubmissionFileRepositoryImpl implements SubmissionAssignmentFileRepository {

    private final AssignmentSubmissionFileJpaRepository assignmentSubmissionFileJpaRepository;

    private final AssignmentSubmissionFileDataAccessMapper assignmentSubmissionFileDataAccessMapper;

    public AssignmentSubmissionFileRepositoryImpl(AssignmentSubmissionFileJpaRepository assignmentSubmissionFileJpaRepository, AssignmentSubmissionFileDataAccessMapper assignmentSubmissionFileDataAccessMapper) {
        this.assignmentSubmissionFileJpaRepository = assignmentSubmissionFileJpaRepository;
        this.assignmentSubmissionFileDataAccessMapper = assignmentSubmissionFileDataAccessMapper;
    }

    @Override
    public SubmissionAssignmentFile saveAssignmentSubmissionFile(SubmissionAssignmentFile submissionAssignmentFile) {
        return assignmentSubmissionFileDataAccessMapper.assignmentSubmissionFileEntityToAssignmentSubmissionFile(assignmentSubmissionFileJpaRepository
                .save(assignmentSubmissionFileDataAccessMapper
                        .assignmentSubmissionFileToAssignmentSubmissionFileEntity(submissionAssignmentFile)));
    }
}
