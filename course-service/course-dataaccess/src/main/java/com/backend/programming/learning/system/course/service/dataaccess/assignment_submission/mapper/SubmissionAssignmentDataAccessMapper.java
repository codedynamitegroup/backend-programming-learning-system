package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.assignment.mapper.AssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.entity.SubmissionAssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.SubmissionAssignmentId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubmissionAssignmentDataAccessMapper {
    private final AssignmentDataAccessMapper assignmentDataAccessMapper;
    private final UserDataAccessMapper userDataAccessMapper;
    public SubmissionAssignmentEntity assignmentSubmissionToAssignmentSubmissionEntity(SubmissionAssignment submissionAssignment) {

        AssignmentEntity assignment = assignmentDataAccessMapper.assignmentToAssignmentEntity(submissionAssignment.getAssignment());
        UserEntity user = userDataAccessMapper.userToUserEntity(submissionAssignment.getUser());
        return SubmissionAssignmentEntity.builder()
                .id(submissionAssignment.getId().getValue())
                .assignment(assignment)
                .user(user)
                .pass_status(submissionAssignment.getPass_status())
                .grade(submissionAssignment.getGrade())
                .content(submissionAssignment.getContent())
                .submitTime(submissionAssignment.getSubmittedAt())
                .build();
    }

    public SubmissionAssignment assignmentSubmissionEntityToAssignmentSubmission(SubmissionAssignmentEntity submissionAssignmentEntity) {
        Assignment assignment = assignmentDataAccessMapper.assignmentEntityToAssignment(submissionAssignmentEntity.getAssignment());
        User user = userDataAccessMapper.userEntityToUser(submissionAssignmentEntity.getUser());
        return SubmissionAssignment.builder()
                .id(new SubmissionAssignmentId(submissionAssignmentEntity.getId()))
                .assignment(assignment)
                .user(user)
                .pass_status(submissionAssignmentEntity.getPass_status())
                .grade(submissionAssignmentEntity.getGrade())
                .content(submissionAssignmentEntity.getContent())
                .submittedAt(submissionAssignmentEntity.getSubmitTime())
                .build();
    }

    public List<SubmissionAssignment> assignmentSubmissionEntityListToAssignmentSubmissionList(List<SubmissionAssignmentEntity> submissionAssignmentEntityList) {
        return submissionAssignmentEntityList.stream().map(this::assignmentSubmissionEntityToAssignmentSubmission).toList();
    }
}
