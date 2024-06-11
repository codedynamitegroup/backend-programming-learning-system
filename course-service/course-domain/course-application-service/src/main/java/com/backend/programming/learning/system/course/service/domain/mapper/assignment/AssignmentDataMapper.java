package com.backend.programming.learning.system.course.service.domain.mapper.assignment;


import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.assignment.DeleteAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment.QueryAllAssignmentsResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment.QueryAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.activity_attachment.ActivityAttachmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.intro_attachment.IntroAttachmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.intro_file.IntroFileResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.ActivityAttachment;
import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.entity.IntroAttachment;
import com.backend.programming.learning.system.course.service.domain.entity.IntroFile;
import com.backend.programming.learning.system.course.service.domain.mapper.activity_attachment.ActivityAttachmentDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.intro_attachment.IntroAttachmentDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.intro_file.IntroFileDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ActivityAttachmentRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.IntroAttachmentRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.IntroFileRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.Type;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class AssignmentDataMapper {
    private final IntroAttachmentDataMapper introAttachmentDataMapper;
    private final IntroAttachmentRepository introAttachmentRepository;
    private final IntroFileDataMapper introFileDataMapper;
    private final IntroFileRepository introFileRepository;

    private final ActivityAttachmentDataMapper activityAttachmentDataMapper;

    private final ActivityAttachmentRepository activityAttachmentRepository;

    public AssignmentDataMapper(IntroAttachmentDataMapper introAttachmentDataMapper,
                                IntroAttachmentRepository introAttachmentRepository, IntroFileDataMapper introFileDataMapper,
                                IntroFileRepository introFileRepository, ActivityAttachmentDataMapper activityAttachmentDataMapper, ActivityAttachmentRepository activityAttachmentRepository) {
        this.introAttachmentDataMapper = introAttachmentDataMapper;
        this.introAttachmentRepository = introAttachmentRepository;
        this.introFileDataMapper = introFileDataMapper;
        this.introFileRepository = introFileRepository;
        this.activityAttachmentDataMapper = activityAttachmentDataMapper;
        this.activityAttachmentRepository = activityAttachmentRepository;
    }

    public Assignment createAssignmentCommandToAssignment(CreateAssignmentCommand createAssignmentCommand) {
        return Assignment.builder()
                .title(createAssignmentCommand.getTitle())
                .intro(createAssignmentCommand.getIntro())
                .activity(createAssignmentCommand.getActivity())
                .wordLimit(createAssignmentCommand.getWordLimit())
                .maxFileSize(createAssignmentCommand.getMaxFileSize())
                .maxUploadFiles(createAssignmentCommand.getMaxUploadFiles())
                .maxScores(createAssignmentCommand.getMaxScore())
                .time_open(createAssignmentCommand.getTimeOpen())
                .time_close(createAssignmentCommand.getTimeClose())
                .allowSubmitLate(createAssignmentCommand.getAllowSubmitLate())
                .type(Type.valueOf(createAssignmentCommand.getType().toUpperCase()))
                .visible(createAssignmentCommand.getVisible())
                .build();
    }

    public CreateAssignmentResponse assignmentToCreateAssignmentResponse(Assignment assignment, String message) {
        return CreateAssignmentResponse.builder()
                .assignmentId(assignment.getId().getValue())
                .name(assignment.getTitle())
                .message(message)
                .build();
    }

    public QueryAssignmentResponse assignmentToQueryAssignmentResponse(Assignment assignment) {
        List<IntroFileResponseEntity> introFileResponseEntities = List.of();
        List<IntroFile> introFile = introFileRepository.findAllByAssignmentId(assignment.getId().getValue());
        if(introFile != null && !introFile.isEmpty())
        {
            introFileResponseEntities = introFile.stream()
                    .map(introFileDataMapper::introFileToIntroFileResponseEntity)
                    .toList();
        }

        List<IntroAttachmentResponseEntity> introAttachmentResponseEntities = List.of();
        List<IntroAttachment> introAttachments = introAttachmentRepository.findAllByAssignmentId(assignment.getId().getValue());
        if(introAttachments != null && !introAttachments.isEmpty())
        {
            introAttachmentResponseEntities = introAttachments.stream()
                    .map(introAttachmentDataMapper::introAttachmentToIntroAttachmentResponseEntity)
                    .toList();
        }

        List<ActivityAttachmentResponseEntity> activityAttachmentResponseEntities = List.of();
        List<ActivityAttachment> activityAttachments = activityAttachmentRepository.findByAssignmentId(assignment.getId().getValue());
        if(activityAttachments != null && !activityAttachments.isEmpty())
        {
            activityAttachmentResponseEntities = activityAttachments.stream()
                    .map(activityAttachmentDataMapper::activityAttachmentToActivityAttachmentResponseEntity)
                    .toList();
        }
        return QueryAssignmentResponse.builder()
                .id(assignment.getId().getValue())
                .moodleId(assignment.getAssignmentIdMoodle())
                .title(assignment.getTitle())
                .intro(assignment.getIntro())
                .activity(assignment.getActivity())
                .introFiles(introFileResponseEntities)
                .introAttachments(introAttachmentResponseEntities)
                .activityAttachments(activityAttachmentResponseEntities)
                .maxScore(assignment.getMaxScores())
                .wordLimit(assignment.getWordLimit())
                .maxFileSize(assignment.getMaxFileSize())
                .maxUploadFiles(assignment.getMaxUploadFiles())
                .timeOpen(assignment.getTime_open())
                .timeClose(assignment.getTime_close())
                .type(assignment.getType().name())
                .visible(assignment.getVisible())
                .build();
    }

    public QueryAllAssignmentsResponse assignmentsToQueryAllAssignmentsResponse(List<Assignment> assignments) {
        List<QueryAssignmentResponse> queryAssignmentResponses = assignments.stream()
                .map(this::assignmentToQueryAssignmentResponse)
                .collect(Collectors.toList());
        return QueryAllAssignmentsResponse.builder()
                .assignments(queryAssignmentResponses)
                .build();
    }

    public DeleteAssignmentResponse assignmentIdToDeleteAssignmentResponse(Assignment assignment) {
        return DeleteAssignmentResponse.builder()
                .assignmentId(assignment.getId().getValue())
                .message("Assignment deleted successfully")
                .build();
    }

}
