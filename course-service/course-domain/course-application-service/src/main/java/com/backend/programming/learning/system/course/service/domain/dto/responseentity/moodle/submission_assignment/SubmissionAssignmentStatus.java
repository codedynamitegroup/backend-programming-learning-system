package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.submission_assignment;

import lombok.*;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionAssignmentStatus {
    private Object gradingsummary;
    private LastAttempt lastattempt;
    private Feedback feedback;
    private Object assignmentdata;
    private Object warnings;
}
