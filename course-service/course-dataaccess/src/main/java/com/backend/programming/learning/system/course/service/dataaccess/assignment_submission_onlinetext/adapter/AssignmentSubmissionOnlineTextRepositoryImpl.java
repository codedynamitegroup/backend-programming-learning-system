package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_onlinetext.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_onlinetext.mapper.AssignmentSubmissionOnlineTextDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_onlinetext.repository.AssignmentSubmissionOnlineTextJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentOnlineText;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentOnlineTextRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component

public class AssignmentSubmissionOnlineTextRepositoryImpl implements SubmissionAssignmentOnlineTextRepository {

    private final AssignmentSubmissionOnlineTextJpaRepository assignmentSubmissionOnlineTextJpaRepository;

    private final AssignmentSubmissionOnlineTextDataAccessMapper assignmentSubmissionOnlineTextDataAccessMapper;

    public AssignmentSubmissionOnlineTextRepositoryImpl(AssignmentSubmissionOnlineTextJpaRepository assignmentSubmissionOnlineTextJpaRepository, AssignmentSubmissionOnlineTextDataAccessMapper assignmentSubmissionOnlineTextDataAccessMapper) {
        this.assignmentSubmissionOnlineTextJpaRepository = assignmentSubmissionOnlineTextJpaRepository;
        this.assignmentSubmissionOnlineTextDataAccessMapper = assignmentSubmissionOnlineTextDataAccessMapper;
    }

    @Override
    public SubmissionAssignmentOnlineText saveAssignmentSubmissionOnlineText(SubmissionAssignmentOnlineText submissionAssignmentOnlineText) {
        return assignmentSubmissionOnlineTextDataAccessMapper
                .assignmentSubmissionOnlineTextEntityToAssignmentSubmissionOnlineText(
                        assignmentSubmissionOnlineTextJpaRepository
                .save(assignmentSubmissionOnlineTextDataAccessMapper
                        .assignmentSubmissionOnlineTextToAssignmentSubmissionOnlineTextEntity(submissionAssignmentOnlineText)));
    }

    @Override
    public Optional<SubmissionAssignmentOnlineText> findById(UUID submissionAssignmentOnlineTextId) {
        return assignmentSubmissionOnlineTextJpaRepository.findById(submissionAssignmentOnlineTextId)
                .map(assignmentSubmissionOnlineTextDataAccessMapper::assignmentSubmissionOnlineTextEntityToAssignmentSubmissionOnlineText);
    }

    @Override
    public Optional<SubmissionAssignmentOnlineText> findBySubmissionAssignmentId(UUID submissionAssignmentId) {
        return assignmentSubmissionOnlineTextJpaRepository.findByAssignmentSubmission_Id(submissionAssignmentId)
                .map(assignmentSubmissionOnlineTextDataAccessMapper::assignmentSubmissionOnlineTextEntityToAssignmentSubmissionOnlineText);
    }

    @Override
    public void deleteSubmissionAssignmentOnlineTextById(UUID submissionAssignmentOnlineTextId) {
        assignmentSubmissionOnlineTextJpaRepository.deleteById(submissionAssignmentOnlineTextId);
    }

}
