package com.backend.programming.learning.system.course.service.domain.mapper.assignment;


import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.assignment.DeleteAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment.QueryAllAssignmentGradeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment.QueryAllAssignmentsResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment.QueryAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment.*;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.intro_attachment.IntroAttachmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserSubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.implement.service.user.UserCommandHandler;
import com.backend.programming.learning.system.course.service.domain.mapper.activity_attachment.ActivityAttachmentDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.intro_attachment.IntroAttachmentDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.intro_file.IntroFileDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.course.service.domain.valueobject.Type;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AssignmentDataMapper {
    private final IntroAttachmentDataMapper introAttachmentDataMapper;
    private final IntroAttachmentRepository introAttachmentRepository;
    private final IntroFileDataMapper introFileDataMapper;
    private final IntroFileRepository introFileRepository;

    private final ActivityAttachmentDataMapper activityAttachmentDataMapper;

    private final ActivityAttachmentRepository activityAttachmentRepository;

    private final UserCommandHandler userCommandHandler;

    private final CourseRepository courseRepository;
    private final SubmissionAssignmentRepository submissionAssignmentRepository;
    private final SubmissionGradeRepository submissionGradeRepository;


    public AssignmentDataMapper(IntroAttachmentDataMapper introAttachmentDataMapper,
                                IntroAttachmentRepository introAttachmentRepository, IntroFileDataMapper introFileDataMapper,
                                IntroFileRepository introFileRepository, ActivityAttachmentDataMapper activityAttachmentDataMapper, ActivityAttachmentRepository activityAttachmentRepository, UserCommandHandler userCommandHandler, CourseRepository courseRepository, SubmissionAssignmentRepository submissionAssignmentRepository, SubmissionGradeRepository submissionGradeRepository) {
        this.introAttachmentDataMapper = introAttachmentDataMapper;
        this.introAttachmentRepository = introAttachmentRepository;
        this.introFileDataMapper = introFileDataMapper;
        this.introFileRepository = introFileRepository;
        this.activityAttachmentDataMapper = activityAttachmentDataMapper;
        this.activityAttachmentRepository = activityAttachmentRepository;
        this.userCommandHandler = userCommandHandler;
        this.courseRepository = courseRepository;
        this.submissionAssignmentRepository = submissionAssignmentRepository;
        this.submissionGradeRepository = submissionGradeRepository;
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

        List<IntroAttachmentResponseEntity> introAttachmentResponseEntities = List.of();
        List<IntroAttachment> introAttachments = introAttachmentRepository.findAllByAssignmentId(assignment.getId().getValue());
        if(introAttachments != null && !introAttachments.isEmpty())
        {
            introAttachmentResponseEntities = introAttachments.stream()
                    .map(introAttachmentDataMapper::introAttachmentToIntroAttachmentResponseEntity)
                    .toList();
        }
        return QueryAssignmentResponse.builder()
                .id(assignment.getId().getValue())
                .moodleId(assignment.getAssignmentIdMoodle())
                .title(assignment.getTitle())
                .intro(assignment.getIntro())
                .activity(assignment.getActivity())
                .introAttachments(introAttachmentResponseEntities)
                .maxScore(assignment.getMaxScores())
                .wordLimit(assignment.getWordLimit())
                .maxFileSize(assignment.getMaxFileSize())
                .maxUploadFiles(assignment.getMaxUploadFiles())
                .timeOpen(assignment.getTime_open())
                .timeClose(assignment.getTime_close())
                .type(assignment.getType().name())
                .visible(assignment.getVisible())
                .allowSubmitLate(assignment.getAllowSubmitLate())
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


    public AssignmentResponseEntity assignmentToAssignmentResponseEntity(Assignment assignment) {
        return AssignmentResponseEntity.builder()
                .id(assignment.getId().getValue())
                .title(assignment.getTitle())
                .intro(assignment.getIntro())
                .timeClose(assignment.getTime_close())
                .build();
    }

    public List<AssignmentResponseEntity> assignmentsToAssignmentResponseEntities(List<Assignment> assignments) {
        return assignments.stream()
                .map(this::assignmentToAssignmentResponseEntity)
                .collect(Collectors.toList());
    }

    public ListSubmissionAssignmentResponseEntity assignmentToAssignmentDetailResponseEntity(Assignment assignment) {

        List<IntroAttachmentResponseEntity> introAttachmentResponseEntities = List.of();
        List<IntroAttachment> introAttachments = introAttachmentRepository.findAllByAssignmentId(assignment.getId().getValue());
        if(introAttachments != null && !introAttachments.isEmpty())
        {
            introAttachmentResponseEntities = introAttachments.stream()
                    .map(introAttachmentDataMapper::introAttachmentToIntroAttachmentResponseEntity)
                    .toList();
        }

        List<UserSubmissionAssignmentResponseEntity> userSubmissionAssignmentResponseEntities =
                userCommandHandler.queryAllUserByAssignmentId(assignment.getId().getValue());


        Course course = courseRepository.findById(assignment.getCourseId().getValue());
        return ListSubmissionAssignmentResponseEntity.builder()
                .id(assignment.getId().getValue())
                .title(assignment.getTitle())
                .courseName(course.getName())
                .users(userSubmissionAssignmentResponseEntities)
                .build();
    }

    public AssignmentGradeResponseEntity assignmentToAssignmentGradeResponseEntity(Assignment assignment, User user) {
        SubmissionAssignment submissionAssignment = submissionAssignmentRepository.findByAssignmentIdAndUserId(assignment.getId().getValue(), user.getId().getValue());
        if(submissionAssignment == null)
        {
            return AssignmentGradeResponseEntity.builder()
                    .id(assignment.getId().getValue())
                    .title(assignment.getTitle())
                    .grade(null)
                    .maxScore(assignment.getMaxScores())
                    .feedback("")
                    .type("ASSIGNMENT")
                    .build();
        }
        Optional<SubmissionGrade> submissionGrade = submissionGradeRepository.findBySubmissionAssignmentId(submissionAssignment.getId().getValue());
        if(submissionGrade.isEmpty())
        {
            return AssignmentGradeResponseEntity.builder()
                    .id(assignment.getId().getValue())
                    .title(assignment.getTitle())
                    .grade(null)
                    .maxScore(assignment.getMaxScores())
                    .feedback("")
                    .type("ASSIGNMENT")
                    .build();
        }
        return AssignmentGradeResponseEntity.builder()
                .id(assignment.getId().getValue())
                .title(assignment.getTitle())
                .type("ASSIGNMENT")
                .grade(submissionGrade.get().getGrade())
                .maxScore(assignment.getMaxScores())
                .feedback(submissionAssignment.getFeedback())
                .build();
    }

    public List<AssignmentGradeResponseEntity> assignmentsToAssignmentGradeResponseEntity(List<Assignment> assignments, User user) {
        return assignments.stream()
                .map(assignment -> assignmentToAssignmentGradeResponseEntity(assignment, user))
                .collect(Collectors.toList());
    }


    public QueryAllAssignmentGradeResponse assignmentsToQueryAllAssignmentGradeResponse(List<Assignment> assignments, User user) {

        Integer countSubmission=0;
        for(Assignment assignment: assignments)
        {
            SubmissionAssignment submissionAssignment = submissionAssignmentRepository.findByAssignmentIdAndUserId(assignment.getId().getValue(), user.getId().getValue());
            if(submissionAssignment.getSubmittedAt() != null)
            {
                countSubmission++;
            }
        }
        List<AssignmentGradeResponseEntity> assignmentGradeResponseEntities = assignments.stream()
                .map(assignment -> assignmentToAssignmentGradeResponseEntity(assignment, user))
                .collect(Collectors.toList());
        return QueryAllAssignmentGradeResponse.builder()
                .assignments(assignmentGradeResponseEntities)
                .countSubmission(countSubmission)
                .build();
    }

    public StudentAssignmentList assignmentsToStudentAssignmentList(List<Assignment> assignments,List<User> users) {

        List<StudentGrade> studentGrades = users.stream()
                .map(user -> {
                    List<AssignmentGradeResponseEntity> assignmentGradeResponseEntities = assignments.stream()
                            .map(assignment -> assignmentToAssignmentGradeResponseEntity(assignment, user))
                            .collect(Collectors.toList());
                    return StudentGrade.builder()
                            .fullName(user.getFirstName()+" "+user.getLastName())
                            .email(user.getEmail())
                            .grades(assignmentGradeResponseEntities.stream()
                                    .map(AssignmentGradeResponseEntity::getGrade)
                                    .collect(Collectors.toList()))
                            .build();
                })
                .collect(Collectors.toList());
        return StudentAssignmentList.builder()
                .assignments(
                        assignments.stream()
                                .map(assignment -> AssignmentMaxGradeInfo.builder()
                                        .name(assignment.getTitle())
                                        .maxGrade(assignment.getMaxScores())
                                        .build())
                                .collect(Collectors.toList())

                )
                .students(studentGrades)
                .build();
    }





}
