package com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment.CreateSubmissionAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment.CreateSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment.DeleteSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment.QueryAllSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.SubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.SubmissionAssignmentUserResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_file.SubmissionAssignmentFileResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_onlinetext.SubmissionAssignmentOnlineTextResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_grade.SubmissionGradeResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment_file.SubmissionAssignmentFileDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment_onlinetext.SubmissionAssignmentOnlineTextDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_grade.SubmissionGradeDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentFileRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentOnlineTextRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionGradeRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubmissionAssignmentDataMapper {

    private final SubmissionAssignmentFileDataMapper submissionAssignmentFileDataMapper;
    private final SubmissionAssignmentFileRepository submissionAssignmentFileRepository;

    private final SubmissionAssignmentOnlineTextDataMapper submissionAssignmentOnlineTextDataMapper;
    private final SubmissionAssignmentOnlineTextRepository submissionAssignmentOnlineTextRepository;

    private final SubmissionGradeDataMapper submissionGradeDataMapper;

    private final SubmissionGradeRepository submissionGradeRepository;

    public SubmissionAssignmentDataMapper(SubmissionAssignmentFileDataMapper submissionAssignmentFileDataMapper, SubmissionAssignmentFileRepository submissionAssignmentFileRepository, SubmissionAssignmentOnlineTextDataMapper submissionAssignmentOnlineTextDataMapper, SubmissionAssignmentOnlineTextRepository submissionAssignmentOnlineTextRepository, SubmissionGradeDataMapper submissionGradeDataMapper, SubmissionGradeRepository submissionGradeRepository) {
        this.submissionAssignmentFileDataMapper = submissionAssignmentFileDataMapper;
        this.submissionAssignmentFileRepository = submissionAssignmentFileRepository;
        this.submissionAssignmentOnlineTextDataMapper = submissionAssignmentOnlineTextDataMapper;
        this.submissionAssignmentOnlineTextRepository = submissionAssignmentOnlineTextRepository;
        this.submissionGradeDataMapper = submissionGradeDataMapper;
        this.submissionGradeRepository = submissionGradeRepository;
    }
    public SubmissionAssignment createSubmissionAssignmentCommandToSubmissionAssignment(CreateSubmissionAssignmentCommand createSubmissionAssignmentCommand) {
        return SubmissionAssignment.builder()
                .isGraded(false)
                .grade(createSubmissionAssignmentCommand.getGrade())
                .content(createSubmissionAssignmentCommand.getContent())
                .submittedAt(createSubmissionAssignmentCommand.getSubmitTime())
                .feedback(createSubmissionAssignmentCommand.getFeedback())
                .timemodified(createSubmissionAssignmentCommand.getTimemodified())
                .build();
    }

    public CreateSubmissionAssignmentResponse submissionAssignmentToCreateSubmissionAssignmentResponse(SubmissionAssignment submissionAssignment,
                                                                                                       String message) {
        return CreateSubmissionAssignmentResponse.builder()
                .assignmentId(submissionAssignment.getAssignment().getId().getValue())
                .userId(submissionAssignment.getUser().getId().getValue())
                .id(submissionAssignment.getId().getValue())
                .message(message)
                .build();
    }

    public SubmissionAssignmentResponseEntity submissionAssignmentToSubmissionAssignmentResponseEntity(SubmissionAssignment submissionAssignment) {
        if(submissionAssignment == null){
            return null;
        }
       List<SubmissionAssignmentFile> submissionAssignmentFiles = submissionAssignmentFileRepository
                .findBySubmissionAssignmentId(submissionAssignment.getId().getValue());
        List<SubmissionAssignmentFileResponseEntity> submissionAssignmentFileResponseEntity = null;
        if( submissionAssignmentFiles != null){
            submissionAssignmentFileResponseEntity = submissionAssignmentFileDataMapper
                    .submissionAssignmentFilesToSubmissionAssignmentFileResponseEntities(submissionAssignmentFiles);
        }
        SubmissionAssignmentOnlineText submissionAssignmentOnlineText = submissionAssignmentOnlineTextRepository
                .findBySubmissionAssignmentId(submissionAssignment.getId().getValue()).orElse(null);

        SubmissionAssignmentOnlineTextResponseEntity submissionAssignmentOnlineTextResponseEntity = null;

        if(submissionAssignmentOnlineText != null){
            submissionAssignmentOnlineTextResponseEntity = submissionAssignmentOnlineTextDataMapper
                    .submissionAssignmentOnlineTextToSubmissionAssignmentOnlineTextResponseEntity(submissionAssignmentOnlineText);
        }

        SubmissionGradeResponseEntity submissionGradeResponseEntity=null;
        if(submissionAssignment.getGradedStatus()){
           SubmissionGrade submissionGrade = submissionGradeRepository.findBySubmissionAssignmentId(submissionAssignment.getId().getValue()).orElse(null);
              if(submissionGrade != null){
                submissionGradeResponseEntity = submissionGradeDataMapper.submissionGradeToSubmissionGradeResponseEntity(submissionGrade);
              }
        }
        User user=submissionAssignment.getUser();

        UserResponseEntity userResponseEntity = UserResponseEntity.builder()
                .userId(user.getId().getValue())
                .roleMoodle(user.getRoleMoodle())
                .fullName(user.getFirstName() + " " + user.getLastName())
                .email(user.getEmail())
                .build();
        return SubmissionAssignmentResponseEntity.builder()
                .id(submissionAssignment.getId().getValue())
                .assignmentName(submissionAssignment.getAssignment().getTitle())
                .user(userResponseEntity)
                .isGraded(submissionAssignment.getGradedStatus())
                .grade(submissionAssignment.getGrade())
                .submissionAssignmentFiles(submissionAssignmentFileResponseEntity)
                .submissionAssignmentOnlineText(submissionAssignmentOnlineTextResponseEntity)
                .submissionGrade(submissionGradeResponseEntity)
                .content(submissionAssignment.getContent())
                .feedback(submissionAssignment.getFeedback())
                .timemodefied(submissionAssignment.getTimemodified())
                .submitTime(submissionAssignment.getSubmittedAt())
                .build();
    }

    public SubmissionAssignmentUserResponseEntity submissionAssignmentToSubmissionAssignmentUserResponseEntity(SubmissionAssignment submissionAssignment) {
        if(submissionAssignment == null){
            return null;
        }
        List<SubmissionAssignmentFile> submissionAssignmentFiles = submissionAssignmentFileRepository
                .findBySubmissionAssignmentId(submissionAssignment.getId().getValue());
        List<SubmissionAssignmentFileResponseEntity> submissionAssignmentFileResponseEntity = null;
        if( submissionAssignmentFiles != null){
            submissionAssignmentFileResponseEntity = submissionAssignmentFileDataMapper
                    .submissionAssignmentFilesToSubmissionAssignmentFileResponseEntities(submissionAssignmentFiles);
        }
        SubmissionAssignmentOnlineText submissionAssignmentOnlineText = submissionAssignmentOnlineTextRepository
                .findBySubmissionAssignmentId(submissionAssignment.getId().getValue()).orElse(null);

        SubmissionAssignmentOnlineTextResponseEntity submissionAssignmentOnlineTextResponseEntity = null;

        if(submissionAssignmentOnlineText != null){
            submissionAssignmentOnlineTextResponseEntity = submissionAssignmentOnlineTextDataMapper
                    .submissionAssignmentOnlineTextToSubmissionAssignmentOnlineTextResponseEntity(submissionAssignmentOnlineText);
        }

        SubmissionGradeResponseEntity submissionGradeResponseEntity=null;
        if(submissionAssignment.getGradedStatus()){
            SubmissionGrade submissionGrade = submissionGradeRepository.findBySubmissionAssignmentId(submissionAssignment.getId().getValue()).orElse(null);
            if(submissionGrade != null){
                submissionGradeResponseEntity = submissionGradeDataMapper.submissionGradeToSubmissionGradeResponseEntity(submissionGrade);
            }
        }

        return SubmissionAssignmentUserResponseEntity.builder()
                .id(submissionAssignment.getId().getValue())
                .isGraded(submissionAssignment.getGradedStatus())
                .submissionAssignmentFiles(submissionAssignmentFileResponseEntity)
                .submissionAssignmentOnlineText(submissionAssignmentOnlineTextResponseEntity)
                .submissionGrade(submissionGradeResponseEntity)
                .content(submissionAssignment.getContent())
                .feedback(submissionAssignment.getFeedback())
                .timemodefied(submissionAssignment.getTimemodified())
                .submitTime(submissionAssignment.getSubmittedAt())
                .build();
    }

    public QueryAllSubmissionAssignmentResponse submissionAssignmentsToQueryAllSubmissionAssignmentResponse(List<SubmissionAssignment> submissionAssignments) {
        return QueryAllSubmissionAssignmentResponse.builder()
                .submissionAssignments(submissionAssignments.stream()
                        .map(this::submissionAssignmentToSubmissionAssignmentResponseEntity)
                        .toList())
                .build();
    }

    public DeleteSubmissionAssignmentResponse submissionAssignmentToDeleteSubmissionAssignmentResponse(SubmissionAssignment submissionAssignment) {
        return DeleteSubmissionAssignmentResponse.builder()
                .submissionAssignmentId(submissionAssignment.getId().getValue())
                .message("Submission assignment deleted successfully")
                .build();
    }
}
