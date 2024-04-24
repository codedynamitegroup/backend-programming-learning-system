package com.backend.programming.learning.system.dto.method.create.call_moodle_api_function;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCallMoodleApiFunctionResponse {
    private final UUID callMoodleApiFunctionId;
    private final String message;
}
