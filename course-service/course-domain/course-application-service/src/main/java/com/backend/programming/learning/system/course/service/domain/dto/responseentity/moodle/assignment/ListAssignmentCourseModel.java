package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListAssignmentCourseModel {
    List<AssignmentCourseModel> courses;
    Object warnings;

}
