package com.backend.programming.learning.system.ports.input.service;

import com.backend.programming.learning.system.dto.method.create.assignment.CreateAssignmentCommand;
import com.backend.programming.learning.system.dto.method.create.assignment.CreateAssignmentResponse;
import com.backend.programming.learning.system.dto.method.delete.assignment.DeleteAssignmentCommand;
import com.backend.programming.learning.system.dto.method.delete.assignment.DeleteAssignmentResponse;
import com.backend.programming.learning.system.dto.method.query.assignment.QueryAllAssignmentsCommand;
import com.backend.programming.learning.system.dto.method.query.assignment.QueryAllAssignmentsResponse;
import com.backend.programming.learning.system.dto.method.query.assignment.QueryAssignmentCommand;
import com.backend.programming.learning.system.dto.method.query.assignment.QueryAssignmentResponse;
import com.backend.programming.learning.system.dto.update.assignment.UpdateAssignmentCommand;
import com.backend.programming.learning.system.dto.update.assignment.UpdateAssignmentResponse;

import javax.validation.Valid;

public interface AssignmentApplicationService {
    CreateAssignmentResponse createAssignment(
            @Valid CreateAssignmentCommand createAssignmentCommand);

    QueryAllAssignmentsResponse queryAllAssignments(
            @Valid QueryAllAssignmentsCommand queryAllAssignmentsCommand);

    QueryAssignmentResponse queryAssignment(
            @Valid QueryAssignmentCommand queryAssignmentCommand);

    UpdateAssignmentResponse updateAssignment(
            @Valid UpdateAssignmentCommand updateAssignmentCommand);


    DeleteAssignmentResponse deleteAssignment(
            @Valid DeleteAssignmentCommand deleteAssignmentCommand);
}
