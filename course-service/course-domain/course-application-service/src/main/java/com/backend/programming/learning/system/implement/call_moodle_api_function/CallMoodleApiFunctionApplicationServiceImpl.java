package com.backend.programming.learning.system.implement.call_moodle_api_function;

import com.backend.programming.learning.system.dto.method.create.call_moodle_api_function.CreateCallMoodleApiFunctionCommand;
import com.backend.programming.learning.system.dto.method.create.call_moodle_api_function.CreateCallMoodleApiFunctionResponse;
import com.backend.programming.learning.system.dto.method.query.call_moodle_api_function.QueryAllCallMoodleApiFunctionResponse;
import com.backend.programming.learning.system.dto.responseentity.call_moodle_api_function.CallMoodleApiFunctionResponseEntity;
import com.backend.programming.learning.system.ports.input.service.call_moodle_api_function.CallMoodleApiFunctionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
@Slf4j
public class CallMoodleApiFunctionApplicationServiceImpl implements CallMoodleApiFunctionApplicationService {
    private final CallMoodleApiFunctionCommandHandler callMoodleApiFunctionCommandHandler;

    public CallMoodleApiFunctionApplicationServiceImpl(CallMoodleApiFunctionCommandHandler callMoodleApiFunctionCommandHandler) {
        this.callMoodleApiFunctionCommandHandler = callMoodleApiFunctionCommandHandler;
    }

    @Override
    public CreateCallMoodleApiFunctionResponse createCallMoodleApiFunction(CreateCallMoodleApiFunctionCommand createCallMoodleApiFunctionCommand) {
        return callMoodleApiFunctionCommandHandler.createCallMoodleApiFunction(createCallMoodleApiFunctionCommand);
    }

    @Override
    public QueryAllCallMoodleApiFunctionResponse queryAllCallMoodleApiFunctions() {
        return callMoodleApiFunctionCommandHandler.queryAllCallMoodleApiFunctions();
    }

    @Override
    public CallMoodleApiFunctionResponseEntity queryCallMoodleApiFunctionById(UUID callMoodleApiFunctionId) {
        return callMoodleApiFunctionCommandHandler.queryCallMoodleApiFunctionById(callMoodleApiFunctionId);
    }
}
