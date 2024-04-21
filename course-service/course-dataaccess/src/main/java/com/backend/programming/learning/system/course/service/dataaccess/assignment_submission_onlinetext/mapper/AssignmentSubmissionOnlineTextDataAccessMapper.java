package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_onlinetext.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.entity.SubmissionAssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.mapper.SubmissionAssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_onlinetext.entity.AssignmentSubmissionOnlineTextEntity;
import com.backend.programming.learning.system.entity.SubmissionAssignment;
import com.backend.programming.learning.system.entity.SubmissionAssignmentOnlineText;
import com.backend.programming.learning.system.mapper.submission_assignment.SubmissionAssignmentDataMapper;
import com.backend.programming.learning.system.mapper.submission_assignment_onlinetext.SubmissionAssignmentOnlineTextDataMapper;
import com.backend.programming.learning.system.valueobject.SubmissionAssignmentOnlineTextId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssignmentSubmissionOnlineTextDataAccessMapper {

    private final SubmissionAssignmentDataAccessMapper submissionAssignmentDataAccessMapper;
    public AssignmentSubmissionOnlineTextEntity assignmentSubmissionOnlineTextToAssignmentSubmissionOnlineTextEntity(SubmissionAssignmentOnlineText submissionAssignmentOnlineText) {
        SubmissionAssignmentEntity submissionAssignment = submissionAssignmentDataAccessMapper.
                assignmentSubmissionToAssignmentSubmissionEntity(submissionAssignmentOnlineText.getSubmissionAssignment());
        return AssignmentSubmissionOnlineTextEntity.builder()
                .id(submissionAssignmentOnlineText.getId().getValue())
                .assignmentSubmission(submissionAssignment)
                .content(submissionAssignmentOnlineText.getContent())
                .build();
    }

    public SubmissionAssignmentOnlineText assignmentSubmissionOnlineTextEntityToAssignmentSubmissionOnlineText(AssignmentSubmissionOnlineTextEntity submissionAssignmentOnlineTextEntity) {
        SubmissionAssignment submissionAssignment = submissionAssignmentDataAccessMapper.
                assignmentSubmissionEntityToAssignmentSubmission(submissionAssignmentOnlineTextEntity.getAssignmentSubmission());
        return SubmissionAssignmentOnlineText.builder()
                .id(new SubmissionAssignmentOnlineTextId(submissionAssignmentOnlineTextEntity.getId()))
                .assignmentSubmission(submissionAssignment)
                .content(submissionAssignmentOnlineTextEntity.getContent())
                .build();
    }
}
