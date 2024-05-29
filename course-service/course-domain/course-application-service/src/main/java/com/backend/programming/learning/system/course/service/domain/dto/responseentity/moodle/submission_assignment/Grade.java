package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.submission_assignment;

import lombok.*;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    private Integer id;
    private Integer userid;
    private Integer attemptnumber;
    private Integer timecreated;
    private Integer timemodified;
    private Integer grader;
    private String grade;
}
