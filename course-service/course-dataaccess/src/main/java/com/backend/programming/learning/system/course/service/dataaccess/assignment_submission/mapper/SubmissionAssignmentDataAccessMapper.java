package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.assignment.mapper.AssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.entity.SubmissionAssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.projection.AllSubmissionAssignmentProjection;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.AllSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentFile;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentFileRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.SubmissionAssignmentId;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubmissionAssignmentDataAccessMapper {
    private final AssignmentDataAccessMapper assignmentDataAccessMapper;
    private final UserDataAccessMapper userDataAccessMapper;
    public SubmissionAssignmentEntity assignmentSubmissionToAssignmentSubmissionEntity(SubmissionAssignment submissionAssignment) {

        if(submissionAssignment == null) return null;
        AssignmentEntity assignment = assignmentDataAccessMapper.assignmentToAssignmentEntity(submissionAssignment.getAssignment());
        UserEntity user = userDataAccessMapper.userToUserEntity(submissionAssignment.getUser());
        return SubmissionAssignmentEntity.builder()
                .id(submissionAssignment.getId().getValue())
                .assignment(assignment)
                .user(user)
                .isGraded(submissionAssignment.getGradedStatus())
                .timemodified(submissionAssignment.getTimemodified())
                .grade(submissionAssignment.getGrade())
                .feedback(submissionAssignment.getFeedback())
                .content(submissionAssignment.getContent())
                .submitTime(submissionAssignment.getSubmittedAt())
                .build();
    }

    public SubmissionAssignment assignmentSubmissionEntityToAssignmentSubmission(SubmissionAssignmentEntity submissionAssignmentEntity) {
        if(submissionAssignmentEntity == null) return null;
        Assignment assignment = assignmentDataAccessMapper.assignmentEntityToAssignment(submissionAssignmentEntity.getAssignment());
        User user = userDataAccessMapper.userEntityToUser(submissionAssignmentEntity.getUser());
        return SubmissionAssignment.builder()
                .id(new SubmissionAssignmentId(submissionAssignmentEntity.getId()))
                .assignment(assignment)
                .user(user)
                .isGraded(submissionAssignmentEntity.getIsGraded())
                .grade(submissionAssignmentEntity.getGrade())
                .content(submissionAssignmentEntity.getContent())
                .timemodified(submissionAssignmentEntity.getTimemodified())
                .feedback(submissionAssignmentEntity.getFeedback())
                .submittedAt(submissionAssignmentEntity.getSubmitTime())
                .build();
    }

    public List<SubmissionAssignment> assignmentSubmissionEntityListToAssignmentSubmissionList(List<SubmissionAssignmentEntity> submissionAssignmentEntityList) {
        return submissionAssignmentEntityList.stream().map(this::assignmentSubmissionEntityToAssignmentSubmission).toList();
    }

    public SubmissionAssignment submissionAssignmentEntityToSubmissionAssignment(SubmissionAssignmentEntity submissionAssignment) {
        if(submissionAssignment == null) return null;
        return SubmissionAssignment.builder()
                .id(new SubmissionAssignmentId(submissionAssignment.getId()))
                .assignment(assignmentDataAccessMapper.assignmentEntityToAssignment(submissionAssignment.getAssignment()))
                .user(userDataAccessMapper.userEntityToUser(submissionAssignment.getUser()))
                .isGraded(submissionAssignment.getIsGraded())
                .grade(submissionAssignment.getGrade())
                .content(submissionAssignment.getContent())
                .timemodified(submissionAssignment.getTimemodified())
                .submittedAt(submissionAssignment.getSubmitTime())
                .build();
    }


    public AllSubmissionAssignmentResponse allSubmissionAssignmentProjectionToAllSubmissionAssignmentResponse(AllSubmissionAssignmentProjection allSubmissionAssignmentProjection) {
        if(allSubmissionAssignmentProjection == null) return null;
        return AllSubmissionAssignmentResponse.builder()
                .id(allSubmissionAssignmentProjection.getSubmissionAssignmentId())
                .userId(allSubmissionAssignmentProjection.getUserId())
                .fullName(allSubmissionAssignmentProjection.getFullName())
                .email(allSubmissionAssignmentProjection.getEmail())
                .content(allSubmissionAssignmentProjection.getContent())
                .feedback(allSubmissionAssignmentProjection.getFeedback())
                .isGraded(allSubmissionAssignmentProjection.getIsGraded())
                .submitTime(allSubmissionAssignmentProjection.getSubmitTime())
                .timemodified(allSubmissionAssignmentProjection.getTimeModified())
                .build();
    }


}
