package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user;

import lombok.*;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrolledCourse {
    private Integer id;
    private String fullname;
    private String shortname;
}
