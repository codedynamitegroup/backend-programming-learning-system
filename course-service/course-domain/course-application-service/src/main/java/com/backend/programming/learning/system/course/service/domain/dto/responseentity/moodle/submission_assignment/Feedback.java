package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.submission_assignment;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    private Grade grade;
    private String gradefordisplay;
    private Integer gradeddate;
    private List<SubmissionPlugin> plugins;
}
