package com.backend.programming.learning.system.course.service.dataaccess.assignment.mapper;


import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.valueobject.AssignmentId;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssignmentDataAccessMapper {
    public AssignmentEntity assignmentToAssignmentEntity(Assignment assignment) {
        if(assignment == null) {
            return null;
        }
        CourseEntity courseEntity = CourseEntity.builder().id(assignment.getCourseId().getValue()).build();
        return AssignmentEntity.builder()
                .course(courseEntity)
                .id(assignment.getId().getValue())
                .assignmentIdMoodle(assignment.getAssignmentIdMoodle())
                .title(assignment.getTitle())
                .intro(assignment.getIntro())
                .activity(assignment.getActivity())
                .maxFileSize(assignment.getMaxFileSize())
                .maxUploadFiles(assignment.getMaxUploadFiles())
                .wordLimit(assignment.getWordLimit())
                .maxScore(assignment.getMaxScores())
                .timeOpen(assignment.getTime_open())
                .timeClose(assignment.getTime_close())
                .timeLimit(assignment.getTime_limit())
                .type(assignment.getType())
                .allowSubmitLate(assignment.getAllowSubmitLate())
                .visible(assignment.getVisible())
                .createdAt(assignment.getCreatedAt())
                .build();
    }

    public Assignment assignmentEntityToAssignment(AssignmentEntity assignmentEntity) {
        if(assignmentEntity == null) {
            return null;
        }
        return Assignment.builder()
                .id(new AssignmentId(assignmentEntity.getId()))
                .assignmentIdMoodle(assignmentEntity.getAssignmentIdMoodle())
                .courseId(new CourseId(assignmentEntity.getCourse().getId()))
                .title(assignmentEntity.getTitle())
                .intro(assignmentEntity.getIntro())
                .activity(assignmentEntity.getActivity())
                .maxFileSize(assignmentEntity.getMaxFileSize())
                .maxUploadFiles(assignmentEntity.getMaxUploadFiles())
                .wordLimit(assignmentEntity.getWordLimit())
                .maxScores(assignmentEntity.getMaxScore())
                .allowSubmitLate(assignmentEntity.getAllowSubmitLate())
                .time_open(assignmentEntity.getTimeOpen())
                .time_close(assignmentEntity.getTimeClose())
                .time_limit(assignmentEntity.getTimeLimit())
                .type(assignmentEntity.getType())
                .visible(assignmentEntity.getVisible())
                .createdAt(assignmentEntity.getCreatedAt())
                .build();
    }

    public List<Assignment> assignmentEntityListToAssignmentList (List<AssignmentEntity> assignmentEntityList) {
        return assignmentEntityList.stream().map(this::assignmentEntityToAssignment).toList();
    }


}
