package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.submission_assignment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListSubmissionAssignmentUser {
    List<SubmissionAssignmentUser> assignments;
    Object warnings;
}
