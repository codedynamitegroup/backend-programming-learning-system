package com.backend.programming.learning.system.course.service.domain.dto.method.query.call_moodle_api_function;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class QueryCallMoodleApiFunctionCommand {
    @NotNull
    private final String callMoodleApiFunctionId;
}
