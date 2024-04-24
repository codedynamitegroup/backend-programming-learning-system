package com.backend.programming.learning.system.dto.responseentity.call_moodle_api_function;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CallMoodleApiFunctionResponseEntity {
    private final UUID callMoodleApiFunctionId;
    private final String area;
    private final String name;
    private final String description;
}
