package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.submission_assignment;

import lombok.*;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LastAttempt {
    private Submission submission;
    private Object submissiongroupmemberswhoneedtosubmit;
    private Boolean submissionsenabled;
    private Boolean locked;
    private Boolean graded;
    private Boolean canedit;
    private Boolean caneditowner;
    private Boolean cansubmit;
    private Integer extensionduedate;
    private Integer timelimit;
    private Boolean blindmarking;
    private String gradingstatus;
    private Object usergroups;
}
