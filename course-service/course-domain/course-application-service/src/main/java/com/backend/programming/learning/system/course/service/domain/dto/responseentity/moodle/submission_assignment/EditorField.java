package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.submission_assignment;

import lombok.*;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditorField {
    private String name;
    private String description;
    private String text;
    private Integer format;
}
