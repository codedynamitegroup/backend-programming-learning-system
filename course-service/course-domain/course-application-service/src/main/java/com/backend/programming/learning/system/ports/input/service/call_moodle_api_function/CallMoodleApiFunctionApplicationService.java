package com.backend.programming.learning.system.ports.input.service.call_moodle_api_function;

import com.backend.programming.learning.system.dto.method.create.call_moodle_api_function.CreateCallMoodleApiFunctionCommand;
import com.backend.programming.learning.system.dto.method.create.call_moodle_api_function.CreateCallMoodleApiFunctionResponse;
import com.backend.programming.learning.system.dto.method.query.call_moodle_api_function.QueryAllCallMoodleApiFunctionResponse;
import com.backend.programming.learning.system.dto.responseentity.call_moodle_api_function.CallMoodleApiFunctionResponseEntity;

import javax.validation.Valid;
import java.util.UUID;

public interface CallMoodleApiFunctionApplicationService {

    CreateCallMoodleApiFunctionResponse createCallMoodleApiFunction(@Valid CreateCallMoodleApiFunctionCommand createCallMoodleApiFunctionCommand);

    QueryAllCallMoodleApiFunctionResponse queryAllCallMoodleApiFunctions();

    CallMoodleApiFunctionResponseEntity queryCallMoodleApiFunctionById(UUID callMoodleApiFunctionId);
}
