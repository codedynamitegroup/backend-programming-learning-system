package com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment.CreateSubmissionAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment.CreateSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment.DeleteSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment.QueryAllSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.SubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_file.SubmissionAssignmentFileResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_onlinetext.SubmissionAssignmentOnlineTextResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_grade.SubmissionGradeResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentFile;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentOnlineText;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionGrade;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment_file.SubmissionAssignmentFileDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment_onlinetext.SubmissionAssignmentOnlineTextDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_file.SubmissionFileDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_grade.SubmissionGradeDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentFileRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentOnlineTextRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionFileRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionGradeRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubmissionAssignmentDataMapper {

    private final UserDataMapper userDataMapper;
    private final SubmissionAssignmentFileDataMapper submissionAssignmentFileDataMapper;
    private final SubmissionAssignmentFileRepository submissionAssignmentFileRepository;

    private final SubmissionAssignmentOnlineTextDataMapper submissionAssignmentOnlineTextDataMapper;
    private final SubmissionAssignmentOnlineTextRepository submissionAssignmentOnlineTextRepository;

    private final SubmissionGradeDataMapper submissionGradeDataMapper;

    private final SubmissionGradeRepository submissionGradeRepository;

    private final SubmissionFileDataMapper submissionFileDataMapper;
    private final SubmissionFileRepository submissionFileRepository;

    public SubmissionAssignmentDataMapper(UserDataMapper userDataMapper, SubmissionAssignmentFileDataMapper submissionAssignmentFileDataMapper, SubmissionAssignmentFileRepository submissionAssignmentFileRepository, SubmissionAssignmentOnlineTextDataMapper submissionAssignmentOnlineTextDataMapper, SubmissionAssignmentOnlineTextRepository submissionAssignmentOnlineTextRepository, SubmissionGradeDataMapper submissionGradeDataMapper, SubmissionGradeRepository submissionGradeRepository, SubmissionFileDataMapper submissionFileDataMapper, SubmissionFileRepository submissionFileRepository) {
        this.userDataMapper = userDataMapper;
        this.submissionAssignmentFileDataMapper = submissionAssignmentFileDataMapper;
        this.submissionAssignmentFileRepository = submissionAssignmentFileRepository;
        this.submissionAssignmentOnlineTextDataMapper = submissionAssignmentOnlineTextDataMapper;
        this.submissionAssignmentOnlineTextRepository = submissionAssignmentOnlineTextRepository;
        this.submissionGradeDataMapper = submissionGradeDataMapper;
        this.submissionGradeRepository = submissionGradeRepository;
        this.submissionFileDataMapper = submissionFileDataMapper;
        this.submissionFileRepository = submissionFileRepository;
    }
    public SubmissionAssignment createSubmissionAssignmentCommandToSubmissionAssignment(CreateSubmissionAssignmentCommand createSubmissionAssignmentCommand) {
        return SubmissionAssignment.builder()
                .isGraded(false)
                .grade(createSubmissionAssignmentCommand.getGrade())
                .content(createSubmissionAssignmentCommand.getContent())
                .submittedAt(createSubmissionAssignmentCommand.getTimeSubmit())
                .build();
    }

    public CreateSubmissionAssignmentResponse submissionAssignmentToCreateSubmissionAssignmentResponse(SubmissionAssignment submissionAssignment,
                                                                                                       String message) {
        return CreateSubmissionAssignmentResponse.builder()
                .assignmentId(submissionAssignment.getAssignment().getId().getValue())
                .userId(submissionAssignment.getUser().getId().getValue())
                .submissionId(submissionAssignment.getId().getValue())
                .message(message)
                .build();
    }

    public SubmissionAssignmentResponseEntity submissionAssignmentToSubmissionAssignmentResponseEntity(SubmissionAssignment submissionAssignment) {
        if(submissionAssignment == null){
            return null;
        }
        SubmissionAssignmentFile submissionAssignmentFile = submissionAssignmentFileRepository
                .findBySubmissionAssignmentId(submissionAssignment.getId().getValue()).orElse(null);
        SubmissionAssignmentFileResponseEntity submissionAssignmentFileResponseEntity = null;
        if(submissionAssignmentFile != null){
            submissionAssignmentFileResponseEntity = submissionAssignmentFileDataMapper
                    .submissionAssignmentFileToSubmissionAssignmentFileResponseEntity(submissionAssignmentFile);

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

        UserResponseEntity userResponseEntity = userDataMapper.userToUserResponseEntity(submissionAssignment.getUser());
        return SubmissionAssignmentResponseEntity.builder()
                .id(submissionAssignment.getId().getValue())
                .assignmentName(submissionAssignment.getAssignment().getTitle())
                .user(userResponseEntity)
                .isGraded(submissionAssignment.getGradedStatus())
                .grade(submissionAssignment.getGrade())
                .submissionAssignmentFile(submissionAssignmentFileResponseEntity)
                .submissionAssignmentOnlineText(submissionAssignmentOnlineTextResponseEntity)
                .submissionGrade(submissionGradeResponseEntity)
                .content(submissionAssignment.getContent())
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
