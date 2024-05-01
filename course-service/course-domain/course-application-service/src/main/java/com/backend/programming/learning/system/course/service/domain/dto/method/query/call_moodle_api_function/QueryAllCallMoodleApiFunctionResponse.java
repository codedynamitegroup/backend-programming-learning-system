package com.backend.programming.learning.system.course.service.domain.dto.method.query.call_moodle_api_function;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.call_moodle_api_function.CallMoodleApiFunctionResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllCallMoodleApiFunctionResponse {
    private final List<CallMoodleApiFunctionResponseEntity> callMoodleApiFunctionResponseEntities;
}
