package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.course;

import lombok.*;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseFormat {

    private String name;
    private Integer value;
}
