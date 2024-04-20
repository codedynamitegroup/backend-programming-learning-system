package com.backend.programming.learning.system.implement.assignment;

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
import com.backend.programming.learning.system.ports.input.service.AssignmentApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
    public UpdateAssignmentResponse updateAssignment(UpdateAssignmentCommand updateAssignmentCommand) {
        return assignmentCommandHandler.updateAssignment(updateAssignmentCommand);
    }

    @Override
    public DeleteAssignmentResponse deleteAssignment(DeleteAssignmentCommand deleteAssignmentCommand) {
        return assignmentCommandHandler.deleteAssignmentById(deleteAssignmentCommand);
    }
}
