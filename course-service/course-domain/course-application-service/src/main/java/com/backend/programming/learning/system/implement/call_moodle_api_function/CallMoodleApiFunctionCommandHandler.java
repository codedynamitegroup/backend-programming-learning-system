package com.backend.programming.learning.system.implement.call_moodle_api_function;

import com.backend.programming.learning.system.dto.method.create.call_moodle_api_function.CreateCallMoodleApiFunctionCommand;
import com.backend.programming.learning.system.dto.method.create.call_moodle_api_function.CreateCallMoodleApiFunctionResponse;
import com.backend.programming.learning.system.dto.method.query.call_moodle_api_function.QueryAllCallMoodleApiFunctionResponse;
import com.backend.programming.learning.system.dto.responseentity.call_moodle_api_function.CallMoodleApiFunctionResponseEntity;
import com.backend.programming.learning.system.entity.CallMoodleApiFunction;
import com.backend.programming.learning.system.mapper.call_moodle_api_function.CallMoodleApiFunctionDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class CallMoodleApiFunctionCommandHandler {

    private final CallMoodleApiFunctionCreateHelper callMoodleApiFunctionCreateHelper;

    private final CallMoodleApiFunctionQueryHelper callMoodleApiFunctionQueryHelper;
    private final CallMoodleApiFunctionDataMapper callMoodleApiFunctionDataMapper;


    public CallMoodleApiFunctionCommandHandler(CallMoodleApiFunctionCreateHelper callMoodleApiFunctionCreateHelper,
                                               CallMoodleApiFunctionQueryHelper callMoodleApiFunctionQueryHelper,
                                               CallMoodleApiFunctionDataMapper callMoodleApiFunctionDataMapper) {
        this.callMoodleApiFunctionCreateHelper = callMoodleApiFunctionCreateHelper;
        this.callMoodleApiFunctionQueryHelper = callMoodleApiFunctionQueryHelper;
        this.callMoodleApiFunctionDataMapper = callMoodleApiFunctionDataMapper;
    }

    public CreateCallMoodleApiFunctionResponse createCallMoodleApiFunction(CreateCallMoodleApiFunctionCommand createCallMoodleApiFunctionCommand) {
        CallMoodleApiFunction callMoodleApiFunction = callMoodleApiFunctionCreateHelper.persistCallMoodleApiFunction(createCallMoodleApiFunctionCommand);
        return callMoodleApiFunctionDataMapper.callMoodleApiFunctionToCreateCallMoodleApiFunctionResponse(callMoodleApiFunction, "Call Moodle Api Function is created");
    }


    public QueryAllCallMoodleApiFunctionResponse queryAllCallMoodleApiFunctions() {
        return callMoodleApiFunctionDataMapper.callMoodleApiFunctionListToQueryAllCallMoodleApiFunctionResponse(callMoodleApiFunctionQueryHelper.queryAllCallMoodleApiFunctions());
    }

    public CallMoodleApiFunctionResponseEntity queryCallMoodleApiFunctionById(UUID callMoodleApiFunctionId) {
        return callMoodleApiFunctionDataMapper.
                callMoodleApiFunctionToCallMoodleApiFunctionResponseEntity(callMoodleApiFunctionQueryHelper.
                        queryCallMoodleApiFunctionById(callMoodleApiFunctionId));
    }

}
