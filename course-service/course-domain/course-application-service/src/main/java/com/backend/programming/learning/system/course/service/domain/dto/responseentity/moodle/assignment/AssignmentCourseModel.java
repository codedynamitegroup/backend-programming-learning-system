package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentCourseModel
{
    private String id;
    private String fullname;
    private String shortname;
    private Integer timemodified;
    private List<AssignmentModel> assignments;

}
