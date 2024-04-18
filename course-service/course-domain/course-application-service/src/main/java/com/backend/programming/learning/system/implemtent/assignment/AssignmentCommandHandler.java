package com.backend.programming.learning.system.implemtent.assignment;

import com.backend.programming.learning.system.dto.create.assignment.CreateAssignmentCommand;
import com.backend.programming.learning.system.dto.create.assignment.CreateAssignmentResponse;
import com.backend.programming.learning.system.dto.query.assignment.QueryAllAssignmentsCommand;
import com.backend.programming.learning.system.dto.query.assignment.QueryAllAssignmentsResponse;
import com.backend.programming.learning.system.dto.query.assignment.QueryAssignmentCommand;
import com.backend.programming.learning.system.dto.query.assignment.QueryAssignmentResponse;
import com.backend.programming.learning.system.entity.Assignment;
import com.backend.programming.learning.system.mapper.assignment.AssignmentDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class AssignmentCommandHandler {
    private final AssignmentCreateHelper assignmentCreateHelper;
    private final AssignmentQueryHelper assignmentQueryHelper;

    private final AssignmentDataMapper assignmentDataMapper;

    public AssignmentCommandHandler(AssignmentCreateHelper assignmentCreateHelper, AssignmentQueryHelper assignmentQueryHelper, AssignmentDataMapper assignmentDataMapper) {
        this.assignmentCreateHelper = assignmentCreateHelper;
        this.assignmentQueryHelper = assignmentQueryHelper;
        this.assignmentDataMapper = assignmentDataMapper;
    }

    @Transactional
    public CreateAssignmentResponse createAssignment(CreateAssignmentCommand createAssignmentCommand) {
        log.info("Create assignment command received");
        Assignment assignment= assignmentCreateHelper.persistAssignment(createAssignmentCommand);
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
}
