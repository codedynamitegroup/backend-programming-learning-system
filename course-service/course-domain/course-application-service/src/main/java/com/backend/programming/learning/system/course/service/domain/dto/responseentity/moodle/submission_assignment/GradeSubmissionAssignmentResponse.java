package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.submission_assignment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradeSubmissionAssignmentResponse {
    private List<GradeSubmissionAssignment> assignments;
    private Object warnings;
}
