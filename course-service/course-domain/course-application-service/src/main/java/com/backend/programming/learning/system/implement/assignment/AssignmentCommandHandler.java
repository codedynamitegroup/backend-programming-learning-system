package com.backend.programming.learning.system.implement.assignment;

import com.backend.programming.learning.system.dto.method.create.assignment.CreateAssignmentCommand;
import com.backend.programming.learning.system.dto.method.create.assignment.CreateAssignmentResponse;
import com.backend.programming.learning.system.dto.method.delete.assignment.DeleteAssignmentCommand;
import com.backend.programming.learning.system.dto.method.delete.assignment.DeleteAssignmentResponse;
import com.backend.programming.learning.system.dto.method.query.assignment.QueryAllAssignmentsCommand;
import com.backend.programming.learning.system.dto.method.query.assignment.QueryAllAssignmentsResponse;
import com.backend.programming.learning.system.dto.method.query.assignment.QueryAssignmentCommand;
import com.backend.programming.learning.system.dto.method.query.assignment.QueryAssignmentResponse;
import com.backend.programming.learning.system.dto.method.update.assignment.UpdateAssignmentCommand;
import com.backend.programming.learning.system.dto.method.update.assignment.UpdateAssignmentResponse;
import com.backend.programming.learning.system.entity.Assignment;
import com.backend.programming.learning.system.mapper.assignment.AssignmentDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
public class AssignmentCommandHandler {
    private final AssignmentCreateHelper assignmentCreateHelper;
    private final AssignmentQueryHelper assignmentQueryHelper;

    private final AssignmentDeleteHelper assignmentDeleteHelper;

    private final AssignmentUpdateHelper assignmentUpdateHelper;

    private final AssignmentDataMapper assignmentDataMapper;

    public AssignmentCommandHandler(AssignmentCreateHelper assignmentCreateHelper,
                                    AssignmentQueryHelper assignmentQueryHelper,
                                    AssignmentDeleteHelper assignmentDeleteHelper,
                                    AssignmentUpdateHelper assignmentUpdateHelper,
                                    AssignmentDataMapper assignmentDataMapper) {
        this.assignmentCreateHelper = assignmentCreateHelper;
        this.assignmentQueryHelper = assignmentQueryHelper;
        this.assignmentDeleteHelper = assignmentDeleteHelper;
        this.assignmentUpdateHelper = assignmentUpdateHelper;
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

    @Transactional
    public DeleteAssignmentResponse deleteAssignmentById(DeleteAssignmentCommand deleteAssignmentCommand) {
        log.info("Delete assignment by id command received");
        assignmentDeleteHelper.deleteAssignmentById(deleteAssignmentCommand.getAssignmentId());
        return DeleteAssignmentResponse.builder()
                .assignmentId(deleteAssignmentCommand.getAssignmentId())
                .message("Assignment deleted successfully")
                .build();
    }

    @Transactional
    public UpdateAssignmentResponse updateAssignment(UpdateAssignmentCommand updateAssignmentCommand) {
        log.info("Update assignment command received");
        assignmentUpdateHelper.persistAssignment(updateAssignmentCommand);
        return UpdateAssignmentResponse.builder()
                .assignmentId(updateAssignmentCommand.getAssignmentId())
                .message("Assignment updated successfully")
                .build();

    }
}
