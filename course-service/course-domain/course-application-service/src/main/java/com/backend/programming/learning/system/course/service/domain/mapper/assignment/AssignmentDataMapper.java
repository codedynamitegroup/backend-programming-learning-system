package com.backend.programming.learning.system.course.service.domain.mapper.assignment;


import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.assignment.DeleteAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment.QueryAllAssignmentsResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment.QueryAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.valueobject.Type;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssignmentDataMapper {
    public Assignment createAssignmentCommandToAssignment(CreateAssignmentCommand createAssignmentCommand) {
        return Assignment.builder()
                .title(createAssignmentCommand.getTitle())
                .intro(createAssignmentCommand.getIntro())
                .scores(createAssignmentCommand.getScore())
                .maxScores(createAssignmentCommand.getMaxScore())
                .time_open(createAssignmentCommand.getTimeOpen())
                .time_close(createAssignmentCommand.getTimeClose())
                .time_limit(createAssignmentCommand.getTimeLimit())
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
        return QueryAssignmentResponse.builder()
                .assignmentId(assignment.getId().getValue())
                .courseId(assignment.getCourseId().getValue())
                .title(assignment.getTitle())
                .intro(assignment.getIntro())
                .score(assignment.getScores())
                .maxScore(assignment.getMaxScores())
                .timeOpen(assignment.getTime_open())
                .timeClose(assignment.getTime_close())
                .timeLimit(assignment.getTime_limit())
                .type(assignment.getType().name())
                .visible(assignment.getVisible())
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

}