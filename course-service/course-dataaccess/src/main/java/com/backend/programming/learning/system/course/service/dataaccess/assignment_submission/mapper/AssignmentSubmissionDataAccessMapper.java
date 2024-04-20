package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.assignment.mapper.AssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.entity.AssignmentSubmissionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.entity.Assignment;
import com.backend.programming.learning.system.entity.SubmissionAssignment;
import com.backend.programming.learning.system.entity.User;
import com.backend.programming.learning.system.valueobject.AssignmentId;
import com.backend.programming.learning.system.valueobject.SubmissionAssignmentId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AssignmentSubmissionDataAccessMapper {
    private final AssignmentDataAccessMapper assignmentDataAccessMapper;
    private final UserDataAccessMapper userDataAccessMapper;
    public AssignmentSubmissionEntity assignmentSubmissionToAssignmentSubmissionEntity(SubmissionAssignment submissionAssignment) {

        AssignmentEntity assignment = assignmentDataAccessMapper.assignmentToAssignmentEntity(submissionAssignment.getAssignment());
        UserEntity user = userDataAccessMapper.userToUserEntity(submissionAssignment.getUser());
        return AssignmentSubmissionEntity.builder()
                .id(submissionAssignment.getId().getValue())
                .assignment(assignment)
                .user(user)
                .pass_status(submissionAssignment.getPass_status())
                .grade(submissionAssignment.getGrade())
                .content(submissionAssignment.getContent())
                .submitTime(submissionAssignment.getSubmittedAt())
                .build();
    }

    public SubmissionAssignment assignmentSubmissionEntityToAssignmentSubmission(AssignmentSubmissionEntity assignmentSubmissionEntity) {
        Assignment assignment = assignmentDataAccessMapper.assignmentEntityToAssignment(assignmentSubmissionEntity.getAssignment());
        User user = userDataAccessMapper.userEntityToUser(assignmentSubmissionEntity.getUser());
        return SubmissionAssignment.builder()
                .id(new SubmissionAssignmentId(assignmentSubmissionEntity.getId()))
                .assignment(assignment)
                .user(user)
                .pass_status(assignmentSubmissionEntity.getPass_status())
                .grade(assignmentSubmissionEntity.getGrade())
                .content(assignmentSubmissionEntity.getContent())
                .submittedAt(assignmentSubmissionEntity.getSubmitTime())
                .build();
    }

    public List<SubmissionAssignment> assignmentSubmissionEntityListToAssignmentSubmissionList(List<AssignmentSubmissionEntity> assignmentSubmissionEntityList) {
        return assignmentSubmissionEntityList.stream().map(this::assignmentSubmissionEntityToAssignmentSubmission).toList();
    }
}
