package com.backend.programming.learning.system.course.service.domain.ports.input.service.call_moodle_api_function;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.call_moodle_api_function.CreateCallMoodleApiFunctionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.call_moodle_api_function.CreateCallMoodleApiFunctionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.call_moodle_api_function.QueryAllCallMoodleApiFunctionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.call_moodle_api_function.CallMoodleApiFunctionResponseEntity;

import jakarta.validation.Valid;
import java.util.UUID;

public interface CallMoodleApiFunctionApplicationService {

    CreateCallMoodleApiFunctionResponse createCallMoodleApiFunction(@Valid CreateCallMoodleApiFunctionCommand createCallMoodleApiFunctionCommand);

    QueryAllCallMoodleApiFunctionResponse queryAllCallMoodleApiFunctions();

    CallMoodleApiFunctionResponseEntity queryCallMoodleApiFunctionById(UUID callMoodleApiFunctionId);
}
