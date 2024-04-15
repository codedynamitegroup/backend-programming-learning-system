package com.backend.programming.learning.system.course.service.dataaccess.assignment.mapper;


import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import com.backend.programming.learning.system.entity.Assignment;
import com.backend.programming.learning.system.valueobject.AssignmentId;
import org.springframework.stereotype.Component;
@Component
public class AssignmentDataAccessMapper {
    public AssignmentEntity assignmentToAssignmentEntity(Assignment assignment) {
       return AssignmentEntity.builder()
               .id(assignment.getId().getValue())
               .title(assignment.getTitle())
               .intro(assignment.getIntro())
               .score(assignment.getScores())
               .maxScore(assignment.getMaxScores())
               .timeOpen(assignment.getTime_open())
               .timeClose(assignment.getTime_close())
               .timeLimit(assignment.getTime_limit())
               .type(assignment.getType())
               .visible(assignment.getVisible())
               .build();
    }

    public Assignment assignmentEntityToAssignment(AssignmentEntity assignmentEntity) {
        return Assignment.builder()
                .id(new AssignmentId(assignmentEntity.getId()))
                .title(assignmentEntity.getTitle())
                .intro(assignmentEntity.getIntro())
                .scores(assignmentEntity.getScore())
                .maxScores(assignmentEntity.getMaxScore())
                .time_open(assignmentEntity.getTimeOpen())
                .time_close(assignmentEntity.getTimeClose())
                .time_limit(assignmentEntity.getTimeLimit())
                .type(assignmentEntity.getType())
                .visible(assignmentEntity.getVisible())
                .build();
    }


}
