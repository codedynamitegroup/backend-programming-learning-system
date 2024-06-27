package com.backend.programming.learning.system.course.service.domain.implement.service.assignment;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.assignment.DeleteAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.assignment.DeleteAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment.*;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.assignment.UpdateAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.assignment.UpdateAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment.AssignmentGradeResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment.ListSubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment.StudentAssignmentList;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.assignment.AssignmentApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Service
@Validated
@Slf4j
public class AssignmentApplicationServiceImpl implements AssignmentApplicationService {
    private final AssignmentCommandHandler assignmentCommandHandler;

    public AssignmentApplicationServiceImpl(AssignmentCommandHandler assignmentCommandHandler) {
        this.assignmentCommandHandler = assignmentCommandHandler;
    }

    @Override
    public CreateAssignmentResponse createAssignment(CreateAssignmentCommand createAssignmentCommand) {
        return assignmentCommandHandler.createAssignment(createAssignmentCommand);
    }

    @Override
    public QueryAllAssignmentsResponse queryAllAssignments(QueryAllAssignmentsCommand queryAllAssignmentsCommand) {
        return assignmentCommandHandler.queryAllAssignments(queryAllAssignmentsCommand);
    }

    @Override
    public QueryAssignmentResponse queryAssignment(QueryAssignmentCommand queryAssignmentCommand) {
        return assignmentCommandHandler.queryAssignmentById(queryAssignmentCommand);
    }

    @Override
    public UpdateAssignmentResponse updateAssignment(UpdateAssignmentCommand updateAssignmentCommand, UUID assignmentId) {
        return assignmentCommandHandler.updateAssignment(updateAssignmentCommand,assignmentId);
    }

    @Override
    public DeleteAssignmentResponse deleteAssignment(DeleteAssignmentCommand deleteAssignmentCommand) {
        return assignmentCommandHandler.deleteAssignmentById(deleteAssignmentCommand);
    }

    @Override
    public ListSubmissionAssignmentResponseEntity queryAssignmentDetail(QueryAssignmentCommand queryAssignmentCommand) {
        return assignmentCommandHandler.queryAssignmentDetailById(queryAssignmentCommand.getAssignmentId());
    }

    @Override
    public QueryAllAssignmentGradeResponse queryAssignmentGrade(UUID courseId, UUID userId) {
        return assignmentCommandHandler.queryAssignmentGrade(courseId, userId);
    }

    @Override
    public StudentAssignmentList retrieveStudentAssignmentGrades(UUID courseId) {
        return
                assignmentCommandHandler.retrieveStudentAssignmentGrades(courseId);
    }
}
