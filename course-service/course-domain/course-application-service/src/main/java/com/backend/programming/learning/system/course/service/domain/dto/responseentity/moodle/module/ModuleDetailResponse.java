package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleDetailResponse {
    private ModuleDetail cm;
    private Object warnings;
}
