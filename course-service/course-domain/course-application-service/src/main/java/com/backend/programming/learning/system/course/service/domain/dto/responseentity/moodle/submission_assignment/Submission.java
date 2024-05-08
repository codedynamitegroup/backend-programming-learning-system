package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.submission_assignment;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Submission {
    private String id;
    private String userid;
    private String attemptnumber;
    private Integer timecreated;
    private Integer timemodified;
    private Integer timestarted;
    private String status;
    private Integer groupid;
    private List<SubmissionPlugin> plugins;
    private String gradingstatus;

}
