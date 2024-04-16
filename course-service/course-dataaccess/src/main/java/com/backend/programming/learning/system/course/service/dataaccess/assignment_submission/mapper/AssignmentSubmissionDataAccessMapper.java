package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.entity.AssignmentSubmissionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.entity.AssignmentSubmission;
import com.backend.programming.learning.system.valueobject.AssignmentSubmissionId;
import org.springframework.stereotype.Component;

@Component
public class AssignmentSubmissionDataAccessMapper {
    public AssignmentSubmissionEntity assignmentSubmissionToAssignmentSubmissionEntity(AssignmentSubmission assignmentSubmission) {

        return AssignmentSubmissionEntity.builder()
                .id(assignmentSubmission.getId().getValue())
                .pass_status(assignmentSubmission.getPass_status())
                .grade(assignmentSubmission.getGrade())
                .content(assignmentSubmission.getContent())
                .submitTime(assignmentSubmission.getSubmittedAt())
                .build();
    }

    public AssignmentSubmission assignmentSubmissionEntityToAssignmentSubmission(AssignmentSubmissionEntity assignmentSubmissionEntity) {

        return AssignmentSubmission.builder()
                .id(new AssignmentSubmissionId(assignmentSubmissionEntity.getId()))
                .pass_status(assignmentSubmissionEntity.getPass_status())
                .grade(assignmentSubmissionEntity.getGrade())
                .content(assignmentSubmissionEntity.getContent())
                .submittedAt(assignmentSubmissionEntity.getSubmitTime())
                .build();
    }
}
