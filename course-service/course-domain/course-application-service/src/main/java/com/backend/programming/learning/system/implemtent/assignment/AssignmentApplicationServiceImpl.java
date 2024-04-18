package com.backend.programming.learning.system.implemtent.assignment;

import com.backend.programming.learning.system.dto.create.assignment.CreateAssignmentCommand;
import com.backend.programming.learning.system.dto.create.assignment.CreateAssignmentResponse;
import com.backend.programming.learning.system.dto.query.assignment.QueryAllAssignmentsCommand;
import com.backend.programming.learning.system.dto.query.assignment.QueryAllAssignmentsResponse;
import com.backend.programming.learning.system.dto.query.assignment.QueryAssignmentCommand;
import com.backend.programming.learning.system.dto.query.assignment.QueryAssignmentResponse;
import com.backend.programming.learning.system.ports.input.service.AssignmentApplicationService;
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
}
