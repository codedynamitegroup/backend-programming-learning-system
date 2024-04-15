package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_onlinetext.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_onlinetext.mapper.AssignmentSubmissionOnlineTextDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_onlinetext.repository.AssignmentSubmissionOnlineTextJpaRepository;
import com.backend.programming.learning.system.entity.AssignmentSubmissionOnlineText;
import com.backend.programming.learning.system.ports.output.repository.SubmissionAssignmentOnlineTextRepository;

public class AssignmentSubmissionOnlineTextRepositoryImpl implements SubmissionAssignmentOnlineTextRepository {

    private final AssignmentSubmissionOnlineTextJpaRepository assignmentSubmissionOnlineTextJpaRepository;

    private final AssignmentSubmissionOnlineTextDataAccessMapper assignmentSubmissionOnlineTextDataAccessMapper;

    public AssignmentSubmissionOnlineTextRepositoryImpl(AssignmentSubmissionOnlineTextJpaRepository assignmentSubmissionOnlineTextJpaRepository, AssignmentSubmissionOnlineTextDataAccessMapper assignmentSubmissionOnlineTextDataAccessMapper) {
        this.assignmentSubmissionOnlineTextJpaRepository = assignmentSubmissionOnlineTextJpaRepository;
        this.assignmentSubmissionOnlineTextDataAccessMapper = assignmentSubmissionOnlineTextDataAccessMapper;
    }

    @Override
    public AssignmentSubmissionOnlineText saveAssignmentSubmissionOnlineText(AssignmentSubmissionOnlineText assignmentSubmissionOnlineText) {
        return assignmentSubmissionOnlineTextDataAccessMapper.assignmentSubmissionOnlineTextEntityToAssignmentSubmissionOnlineText(assignmentSubmissionOnlineTextJpaRepository
                .save(assignmentSubmissionOnlineTextDataAccessMapper
                        .assignmentSubmissionOnlineTextToAssignmentSubmissionOnlineTextEntity(assignmentSubmissionOnlineText)));
    }
}
