package com.backend.programming.learning.system.auth.service.application.rest.call_moodle_api_function;

import com.backend.programming.learning.system.dto.method.create.call_moodle_api_function.CreateCallMoodleApiFunctionCommand;
import com.backend.programming.learning.system.dto.method.create.call_moodle_api_function.CreateCallMoodleApiFunctionResponse;
import com.backend.programming.learning.system.dto.method.query.call_moodle_api_function.QueryAllCallMoodleApiFunctionResponse;
import com.backend.programming.learning.system.dto.responseentity.call_moodle_api_function.CallMoodleApiFunctionResponseEntity;
import com.backend.programming.learning.system.ports.input.service.call_moodle_api_function.CallMoodleApiFunctionApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/organization/call_moodle_api_function", produces = "application/vnd.api.v1+json")
public class CallMoodleApiFunctionController {
    private final CallMoodleApiFunctionApplicationService callMoodleApiFunctionApplicationService;

    @PostMapping
    public ResponseEntity<CreateCallMoodleApiFunctionResponse> createCallMoodleApiFunction(
            @RequestBody CreateCallMoodleApiFunctionCommand createCallMoodleApiFunctionCommand
    ) {
        log.info("Creating call_moodle_api_function");
        CreateCallMoodleApiFunctionResponse response = callMoodleApiFunctionApplicationService.createCallMoodleApiFunction(createCallMoodleApiFunctionCommand);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<QueryAllCallMoodleApiFunctionResponse> queryAllCallMoodleApiFunctions() {
        log.info("Querying all call_moodle_api_functions");
        QueryAllCallMoodleApiFunctionResponse response = callMoodleApiFunctionApplicationService.queryAllCallMoodleApiFunctions();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{callMoodleApiFunctionId}")
    public ResponseEntity<CallMoodleApiFunctionResponseEntity> queryCallMoodleApiFunctionById(
            @PathVariable UUID callMoodleApiFunctionId
    ) {
        log.info("Querying call_moodle_api_function by id: {}", callMoodleApiFunctionId);
        CallMoodleApiFunctionResponseEntity response = callMoodleApiFunctionApplicationService.queryCallMoodleApiFunctionById(callMoodleApiFunctionId);
        return ResponseEntity.ok(response);
    }
}
