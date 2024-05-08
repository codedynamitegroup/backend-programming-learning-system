package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment;

import lombok.*;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentConfigModel {
    private String plugin;
    private String subtype;
    private String name;
    private String value;
}
