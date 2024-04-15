package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_onlinetext.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_onlinetext.entity.AssignmentSubmissionOnlineTextEntity;
import com.backend.programming.learning.system.entity.AssignmentSubmissionOnlineText;
import com.backend.programming.learning.system.valueobject.AssignmentSubmissionOnlineTextId;
import org.springframework.stereotype.Component;

@Component
public class AssignmentSubmissionOnlineTextDataAccessMapper {

    public AssignmentSubmissionOnlineTextEntity assignmentSubmissionOnlineTextToAssignmentSubmissionOnlineTextEntity(AssignmentSubmissionOnlineText submissionAssignmentOnlineText) {
        return AssignmentSubmissionOnlineTextEntity.builder()
                .id(submissionAssignmentOnlineText.getId().getValue())
                .content(submissionAssignmentOnlineText.getContent())
                .build();
    }

    public AssignmentSubmissionOnlineText assignmentSubmissionOnlineTextEntityToAssignmentSubmissionOnlineText(AssignmentSubmissionOnlineTextEntity submissionAssignmentOnlineTextEntity) {
        return AssignmentSubmissionOnlineText.builder()
                .id(new AssignmentSubmissionOnlineTextId(submissionAssignmentOnlineTextEntity.getId()))
                .content(submissionAssignmentOnlineTextEntity.getContent())
                .build();
    }
}
