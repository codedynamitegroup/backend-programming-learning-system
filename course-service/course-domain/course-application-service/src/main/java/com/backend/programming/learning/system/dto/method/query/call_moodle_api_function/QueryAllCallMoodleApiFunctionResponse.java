package com.backend.programming.learning.system.dto.method.query.call_moodle_api_function;

import com.backend.programming.learning.system.dto.responseentity.call_moodle_api_function.CallMoodleApiFunctionResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllCallMoodleApiFunctionResponse {
    private final List<CallMoodleApiFunctionResponseEntity> callMoodleApiFunctionResponseEntities;
}
