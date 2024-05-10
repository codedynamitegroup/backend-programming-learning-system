package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.module;

import lombok.*;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeFrame {
    private String label;
    private Integer timestamp;
    private String dataid;
}
