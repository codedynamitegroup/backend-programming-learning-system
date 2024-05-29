package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.submission_assignment;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListSubmissionAssignmentUser {
    List<SubmissionAssignmentUser> assignments;
    Object warnings;
}
