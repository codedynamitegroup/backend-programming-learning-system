package com.backend.programming.learning.system.course.service.domain.ports.input.service.assignment;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.assignment.DeleteAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.assignment.DeleteAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment.*;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.assignment.UpdateAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.assignment.UpdateAssignmentResponse;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment.ListSubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment.StudentAssignmentListResponse;
import jakarta.validation.Valid;

import java.util.UUID;

public interface AssignmentApplicationService {
    CreateAssignmentResponse createAssignment(
            @Valid CreateAssignmentCommand createAssignmentCommand);

    QueryAllAssignmentsResponse queryAllAssignments(
            @Valid QueryAllAssignmentsCommand queryAllAssignmentsCommand);

    QueryAssignmentResponse queryAssignment(
            @Valid QueryAssignmentCommand queryAssignmentCommand);

    UpdateAssignmentResponse updateAssignment(
            @Valid UpdateAssignmentCommand updateAssignmentCommand, UUID assignmentId);


    DeleteAssignmentResponse deleteAssignment(
            @Valid DeleteAssignmentCommand deleteAssignmentCommand);

    ListSubmissionAssignmentResponseEntity queryAssignmentDetail(
            @Valid QueryAssignmentCommand queryAssignmentCommand);

    QueryAllAssignmentGradeResponse queryAssignmentGrade(QueryAllAssignmentGradeByStudentCommand queryAllAssignmentGradeByStudentCommand) ;
    StudentAssignmentListResponse retrieveStudentAssignmentGrades(QueryStudentAssignmentListCommand queryStudentAssignmentListCommand);
}
