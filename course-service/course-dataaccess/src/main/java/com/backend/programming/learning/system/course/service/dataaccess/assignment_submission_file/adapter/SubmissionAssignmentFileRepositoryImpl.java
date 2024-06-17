package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.mapper.SubmissionAssignmentFileDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.repository.SubmissionAssignmentFileJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentFile;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentFileRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class SubmissionAssignmentFileRepositoryImpl implements SubmissionAssignmentFileRepository {

    private final SubmissionAssignmentFileJpaRepository submissionAssignmentFileJpaRepository;

    private final SubmissionAssignmentFileDataAccessMapper submissionAssignmentFileDataAccessMapper;



    public SubmissionAssignmentFileRepositoryImpl(SubmissionAssignmentFileJpaRepository submissionAssignmentFileJpaRepository, SubmissionAssignmentFileDataAccessMapper submissionAssignmentFileDataAccessMapper) {
        this.submissionAssignmentFileJpaRepository = submissionAssignmentFileJpaRepository;
        this.submissionAssignmentFileDataAccessMapper = submissionAssignmentFileDataAccessMapper;
    }

    @Override
    public SubmissionAssignmentFile saveSubmissionAssignmentFile(SubmissionAssignmentFile submissionAssignmentFile) {
        return submissionAssignmentFileDataAccessMapper.assignmentSubmissionFileEntityToAssignmentSubmissionFile(submissionAssignmentFileJpaRepository
                .save(submissionAssignmentFileDataAccessMapper
                        .assignmentSubmissionFileToAssignmentSubmissionFileEntity(submissionAssignmentFile)));
    }

    @Override
    public List<SubmissionAssignmentFile> findBySubmissionAssignmentId(UUID submissionAssignmentId) {
        return submissionAssignmentFileJpaRepository.findBySubmissionAssignmentId(submissionAssignmentId)
                .stream()
                .map(submissionAssignmentFileDataAccessMapper::assignmentSubmissionFileEntityToAssignmentSubmissionFile)
                .toList();
    }
}
