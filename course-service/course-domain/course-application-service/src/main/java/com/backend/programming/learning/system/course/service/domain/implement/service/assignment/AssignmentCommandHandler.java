package com.backend.programming.learning.system.course.service.domain.implement.service.assignment;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.assignment.DeleteAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.assignment.DeleteAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.calendarevent.DeleteCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment.*;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.assignment.UpdateAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.assignment.UpdateAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.calendarevent.UpdateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment.ListSubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment.StudentAssignmentListResponse;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.implement.service.calendarevent.CalendarEventCommandHandler;
import com.backend.programming.learning.system.course.service.domain.mapper.assignment.AssignmentDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class AssignmentCommandHandler {
    private final AssignmentCreateHelper assignmentCreateHelper;
    private final AssignmentQueryHelper assignmentQueryHelper;
    private final AssignmentDeleteHelper assignmentDeleteHelper;
    private final AssignmentUpdateHelper assignmentUpdateHelper;
    private final AssignmentDataMapper assignmentDataMapper;
    private final UserRepository userRepository;
    private final ExamRepository examRepository;
    private final ExamSubmissionRepository examSubmissionRepository;
    private final CalendarEventCommandHandler calendarEventCommandHandler;

    @Transactional
    public CreateAssignmentResponse createAssignment(CreateAssignmentCommand createAssignmentCommand) {
        log.info("Create assignment command received");
        Assignment assignment= assignmentCreateHelper.persistAssignment(createAssignmentCommand);

        CreateCalendarEventCommand createCalendarEventCommand = CreateCalendarEventCommand.builder()
                .name("Assignment " + assignment.getTitle())
                .description(assignment.getIntro())
                .eventType("COURSE")
                .startTime(assignment.getTime_open())
                .endTime(assignment.getTime_close())
                .courseId(assignment.getCourse().getId().getValue())
                .assignmentId(assignment.getId().getValue())
                .component("ASSIGNMENT")
                .build();

        calendarEventCommandHandler.createCalendarEvent(createCalendarEventCommand);

        return assignmentDataMapper.assignmentToCreateAssignmentResponse(assignment, "Assignment created successfully");
    }
    @Transactional
    public QueryAllAssignmentsResponse queryAllAssignments(QueryAllAssignmentsCommand queryAllAssignmentsCommand) {
        log.info("Query all assignments command received");
        List<Assignment> assignments= assignmentQueryHelper
                .queryAllAssignments(queryAllAssignmentsCommand.getCourseId());
        return assignmentDataMapper.assignmentsToQueryAllAssignmentsResponse(assignments);
    }
    @Transactional
    public QueryAssignmentResponse queryAssignmentById(QueryAssignmentCommand queryAssignmentCommand) {
        log.info("Query assignment by id command received");
        Assignment assignment= assignmentQueryHelper.queryAssignmentById(queryAssignmentCommand.getAssignmentId());
        return assignmentDataMapper.assignmentToQueryAssignmentResponse(assignment);
    }

    @Transactional
    public DeleteAssignmentResponse deleteAssignmentById(DeleteAssignmentCommand deleteAssignmentCommand) {
        log.info("Delete assignment by id command received");
        assignmentDeleteHelper.deleteAssignmentById(deleteAssignmentCommand.getAssignmentId());

        CalendarEvent calendarEvent = calendarEventCommandHandler.findByAssignmentId(deleteAssignmentCommand.getAssignmentId());
        if (calendarEvent != null) {
            DeleteCalendarEventCommand deleteCalendarEventCommand = DeleteCalendarEventCommand.builder()
                    .calendarEventId(calendarEvent.getId().getValue())
                    .build();
            calendarEventCommandHandler.deleteCalendarEvent(deleteCalendarEventCommand);
        }

        return DeleteAssignmentResponse.builder()
                .assignmentId(deleteAssignmentCommand.getAssignmentId())
                .message("Assignment deleted successfully")
                .build();
    }

    @Transactional
    public UpdateAssignmentResponse updateAssignment(UpdateAssignmentCommand updateAssignmentCommand, UUID assignmentId) {
        log.info("Update assignment command received");
        assignmentUpdateHelper.persistAssignment(updateAssignmentCommand,assignmentId);

        CalendarEvent calendarEvent = calendarEventCommandHandler.findByAssignmentId(assignmentId);
        if (calendarEvent != null) {
            UpdateCalendarEventCommand updateCalendarEventCommand = UpdateCalendarEventCommand.builder()
                    .name(updateAssignmentCommand.getTitle() == null
                            ? null
                            : "Assignment " + updateAssignmentCommand.getTitle())
                    .description(updateAssignmentCommand.getIntro() == null
                            ? null
                            : updateAssignmentCommand.getIntro())
                    .startTime(updateAssignmentCommand.getTimeOpen() == null
                                    ? null
                                    : updateAssignmentCommand.getTimeOpen())
                    .endTime(updateAssignmentCommand.getTimeClose() == null
                                    ? null
                                    : updateAssignmentCommand.getTimeClose())
                    .build();
            calendarEventCommandHandler.updateCalendarEvent(calendarEvent.getId().getValue(), updateCalendarEventCommand);
        }

        return UpdateAssignmentResponse.builder()
                .assignmentId(assignmentId)
                .message("Assignment updated successfully")
                .build();

    }

    @Transactional
    public ListSubmissionAssignmentResponseEntity queryAssignmentDetailById(UUID assignmentId) {
        log.info("Query assignment detail by id command received");
        Assignment assignment= assignmentQueryHelper.queryAssignmentById(assignmentId);
        return assignmentDataMapper.assignmentToAssignmentDetailResponseEntity(assignment);
    }

    @Transactional(readOnly = true)
    public QueryAllAssignmentGradeResponse queryAssignmentGrade(QueryAllAssignmentGradeByStudentCommand queryAllAssignmentGradeByStudentCommand) {
        log.info("Query assignment grade command received");
        List<Assignment> assignments= assignmentQueryHelper.queryAssignmentGrade(
                queryAllAssignmentGradeByStudentCommand.getCourseId(),
                queryAllAssignmentGradeByStudentCommand.getUserId(),
                queryAllAssignmentGradeByStudentCommand.getSearchName(),
                queryAllAssignmentGradeByStudentCommand.getPageNo(),
                queryAllAssignmentGradeByStudentCommand.getPageSize());
        List<ExamSubmission> exams = examSubmissionRepository.findByCourseIdAndUserId(
                queryAllAssignmentGradeByStudentCommand.getCourseId(),
                queryAllAssignmentGradeByStudentCommand.getUserId(),
                queryAllAssignmentGradeByStudentCommand.getSearchName());

        UUID userId= queryAllAssignmentGradeByStudentCommand.getUserId();
        User user= userRepository.findById(new UserId(userId)).get();
        return assignmentDataMapper.toQueryAllAssignmentGradeResponse(assignments, exams ,user,
                queryAllAssignmentGradeByStudentCommand.getPageNo(), queryAllAssignmentGradeByStudentCommand.getPageSize());
    }

    @Transactional(readOnly = true)
    public StudentAssignmentListResponse retrieveStudentAssignmentGrades(QueryStudentAssignmentListCommand queryStudentAssignmentListCommand) {
        log.info("Query assignment grade command received");
        List<Assignment> assignments = assignmentQueryHelper.findAllGradeStudentAssignment(queryStudentAssignmentListCommand.getCourseId());
        Page<User> users = userRepository.findAllByCourseId(
                queryStudentAssignmentListCommand.getCourseId(),
                queryStudentAssignmentListCommand.getPageNo(),
                queryStudentAssignmentListCommand.getPageSize(),
                queryStudentAssignmentListCommand.getSearchName());
        List<Exam> exams = examRepository.findAllByCourseId(queryStudentAssignmentListCommand.getCourseId());
        return assignmentDataMapper.assignmentsToStudentAssignmentList(assignments, exams, users);
    }



}
