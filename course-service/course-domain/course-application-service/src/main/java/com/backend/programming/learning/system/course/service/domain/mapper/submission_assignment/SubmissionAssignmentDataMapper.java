package com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment.CreateSubmissionAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment.CreateSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment.DeleteSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment.QueryAllSubmissionAssignmentAIGradeEssayResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment.QueryAllSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment.QueryAllUserSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.AIGradeEssaySubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.AllSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.SubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.SubmissionAssignmentUserResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_file.SubmissionAssignmentFileResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_grade.SubmissionGradeResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment_file.SubmissionAssignmentFileDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_grade.SubmissionGradeDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentFileRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionGradeRepository;
import org.jsoup.Jsoup;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubmissionAssignmentDataMapper {

    private final SubmissionAssignmentFileDataMapper submissionAssignmentFileDataMapper;
    private final SubmissionAssignmentFileRepository submissionAssignmentFileRepository;



    private final SubmissionGradeDataMapper submissionGradeDataMapper;

    private final SubmissionGradeRepository submissionGradeRepository;

    public SubmissionAssignmentDataMapper(SubmissionAssignmentFileDataMapper submissionAssignmentFileDataMapper, SubmissionAssignmentFileRepository submissionAssignmentFileRepository, SubmissionGradeDataMapper submissionGradeDataMapper, SubmissionGradeRepository submissionGradeRepository) {
        this.submissionAssignmentFileDataMapper = submissionAssignmentFileDataMapper;
        this.submissionAssignmentFileRepository = submissionAssignmentFileRepository;
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
                .roleMoodleId(user.getRoleMoodle().getId().getValue().toString())
                .fullName(user.getFirstName() + " " + user.getLastName())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
        return SubmissionAssignmentResponseEntity.builder()
                .id(submissionAssignment.getId().getValue())
                .assignmentName(submissionAssignment.getAssignment().getTitle())
                .user(userResponseEntity)
                .isGraded(submissionAssignment.getGradedStatus())
                .grade(submissionAssignment.getGrade())
                .submissionAssignmentFiles(submissionAssignmentFileResponseEntity)
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
                .submissionGrade(submissionGradeResponseEntity)
                .content(submissionAssignment.getContent())
                .feedback(submissionAssignment.getFeedback())
                .timemodefied(submissionAssignment.getTimemodified())
                .submitTime(submissionAssignment.getSubmittedAt())
                .build();
    }

    public QueryAllSubmissionAssignmentResponse submissionAssignmentsToQueryAllSubmissionAssignmentResponse(Page<SubmissionAssignment> submissionAssignments) {
        return QueryAllSubmissionAssignmentResponse.builder()
                .submissionAssignments(submissionAssignments.map(this::submissionAssignmentToSubmissionAssignmentResponseEntity).getContent())
                .currentPage(submissionAssignments.getNumber())
                .totalItems(submissionAssignments.getTotalElements())
                .totalPages(submissionAssignments.getTotalPages())
                .build();
    }

    public DeleteSubmissionAssignmentResponse submissionAssignmentToDeleteSubmissionAssignmentResponse(SubmissionAssignment submissionAssignment) {
        return DeleteSubmissionAssignmentResponse.builder()
                .submissionAssignmentId(submissionAssignment.getId().getValue())
                .message("Submission assignment deleted successfully")
                .build();
    }

    public QueryAllSubmissionAssignmentAIGradeEssayResponse queryAllSubmissionAssignmentResponseToQueryAllSubmissionAssignmentAIGradeEssayResponse(QueryAllSubmissionAssignmentResponse queryAllSubmissionAssignmentResponse) {
        return QueryAllSubmissionAssignmentAIGradeEssayResponse.builder()
                .submissionAssignments(queryAllSubmissionAssignmentResponse.getSubmissionAssignments().stream().map(
                        submissionAssignmentResponseEntity -> AIGradeEssaySubmissionAssignmentResponseEntity.builder()
                                .studentSubmissionId(submissionAssignmentResponseEntity.getId())
                                .studentAnswer(Jsoup.parse(submissionAssignmentResponseEntity.getContent()).text())
                                .build()
                ).toList())
                .totalItems(queryAllSubmissionAssignmentResponse.getTotalItems())
                .build();
    }

    public QueryAllUserSubmissionAssignmentResponse allSubmissionAssignmentResponsesToQueryAllUserSubmissionAssignmentResponse(Page<AllSubmissionAssignmentResponse> allSubmissionAssignmentResponses) {
        allSubmissionAssignmentResponses.getContent().forEach(allSubmissionAssignmentResponse -> {
            List<SubmissionAssignmentFile> submissionAssignmentFiles = submissionAssignmentFileRepository.findBySubmissionAssignmentId(allSubmissionAssignmentResponse.getId());
            allSubmissionAssignmentResponse.setSubmissionAssignmentFiles(submissionAssignmentFileDataMapper.submissionAssignmentFilesToSubmissionAssignmentFileResponseEntities(submissionAssignmentFiles));

            SubmissionGrade submissionGrade = submissionGradeRepository.findBySubmissionAssignmentId(allSubmissionAssignmentResponse.getId()).orElse(null);
            if(submissionGrade != null){
                allSubmissionAssignmentResponse.setSubmissionGrade(submissionGradeDataMapper.submissionGradeToSubmissionGradeResponseEntity(submissionGrade));
            }
        });
        return QueryAllUserSubmissionAssignmentResponse.builder()
                .submissionAssignments(allSubmissionAssignmentResponses.getContent())
                .currentPage(allSubmissionAssignmentResponses.getNumber())
                .totalItems(allSubmissionAssignmentResponses.getTotalElements())
                .totalPages(allSubmissionAssignmentResponses.getTotalPages())
                .build();
    }

    public AllSubmissionAssignmentResponse submissionAssignmentToAllSubmissionAssignmentResponse(SubmissionAssignment submissionAssignment) {
        if(submissionAssignment == null){
            return null;
        }
        List<SubmissionAssignmentFile> submissionAssignmentFiles = submissionAssignmentFileRepository.findBySubmissionAssignmentId(submissionAssignment.getId().getValue());
        List<SubmissionAssignmentFileResponseEntity> submissionAssignmentFileResponseEntity = null;
        submissionAssignmentFileResponseEntity = submissionAssignmentFileDataMapper.submissionAssignmentFilesToSubmissionAssignmentFileResponseEntities(submissionAssignmentFiles);

        SubmissionGrade submissionGrade = submissionGradeRepository.findBySubmissionAssignmentId(submissionAssignment.getId().getValue()).orElse(null);
        SubmissionGradeResponseEntity submissionGradeResponseEntity =null;
        if(submissionGrade != null){
            submissionGradeResponseEntity = submissionGradeDataMapper.submissionGradeToSubmissionGradeResponseEntity(submissionGrade);
        }



        return AllSubmissionAssignmentResponse.builder()
                .id(submissionAssignment.getId().getValue())
                .assignmentName(submissionAssignment.getAssignment().getTitle())
                .userId(submissionAssignment.getUser().getId().getValue())
                .fullName(submissionAssignment.getUser().getFirstName() + " " + submissionAssignment.getUser().getLastName())
                .email(submissionAssignment.getUser().getEmail())
                .submissionAssignmentFiles(submissionAssignmentFileResponseEntity)
                .submissionGrade(submissionGradeResponseEntity)
                .content(submissionAssignment.getContent())
                .feedback(submissionAssignment.getFeedback())
                .isGraded(submissionAssignment.getGradedStatus())
                .submitTime(submissionAssignment.getSubmittedAt())
                .timemodified(submissionAssignment.getTimemodified())
                .build();
    }
}
