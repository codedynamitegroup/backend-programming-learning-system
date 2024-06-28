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
import com.backend.programming.learning.system.course.service.domain.mapper.intro_attachment.IntroAttachmentDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.course.service.domain.valueobject.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AssignmentDataMapper {
    private final IntroAttachmentDataMapper introAttachmentDataMapper;
    private final UserCommandHandler userCommandHandler;
    private final IntroAttachmentRepository introAttachmentRepository;
    private final CourseRepository courseRepository;
    private final SubmissionAssignmentRepository submissionAssignmentRepository;
    private final SubmissionGradeRepository submissionGradeRepository;
    private final ExamSubmissionRepository examSubmissionRepository;

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

    public StudentAssignmentListResponse assignmentsToStudentAssignmentList(List<Assignment> assignments,
                                                                            List<Exam> exams, Page<User> users) {
        List<User> userResponses = users.getContent();
        List<StudentGrade> studentGrades = userResponses.stream()
                .map(user -> {
                    List<AssignmentGradeResponseEntity> assignmentGradeResponseEntities = assignments.stream()
                            .map(assignment -> assignmentToAssignmentGradeResponseEntity(assignment, user))
                            .collect(Collectors.toList());
                    return StudentGrade.builder()
                            .studentId(user.getId().getValue())
                            .fullName(user.getFirstName() + " " + user.getLastName())
                            .email(user.getEmail())
                            .grades(assignmentGradeResponseEntities.stream()
                                    .map(AssignmentGradeResponseEntity::getGrade)
                                    .collect(Collectors.toList()))
                            .build();
                })
                .collect(Collectors.toList());

        studentGrades.forEach(studentGrade -> {
            exams.forEach(exam -> {
                ExamSubmission examSubmission = examSubmissionRepository
                        .findLatestExamSubmissionByExamIdAndUserId(exam.getId().getValue(), studentGrade.getStudentId())
                        .orElse(null);
                if (examSubmission != null) studentGrade.getGrades().add(examSubmission.getScore());
                else studentGrade.getGrades().add(null);
            });
        });

        StudentAssignmentListResponse studentAssignmentList = StudentAssignmentListResponse.builder()
                .assignments(assignments.stream()
                        .map(assignment -> AssignmentMaxGradeInfo.builder()
                                .name(assignment.getTitle())
                                .maxGrade(assignment.getMaxScores())
                                .build())
                        .collect(Collectors.toList()))
                .students(studentGrades)
                .currentPage(users.getNumber())
                .totalItems(users.getTotalElements())
                .totalPages(users.getTotalPages())
                .build();

        List<AssignmentMaxGradeInfo> examMaxGradeInfo = exams.stream()
                .map(exam -> AssignmentMaxGradeInfo.builder()
                        .name(exam.getName())
                        .maxGrade(exam.getMaxScore())
                        .build())
                .toList();
        studentAssignmentList.getAssignments().addAll(examMaxGradeInfo);

        return studentAssignmentList;
    }
}
