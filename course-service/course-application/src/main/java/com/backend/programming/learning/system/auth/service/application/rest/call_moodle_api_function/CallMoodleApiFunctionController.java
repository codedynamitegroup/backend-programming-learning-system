//package com.backend.programming.learning.system.auth.service.application.rest.call_moodle_api_function;
//
//import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventResponse;
//import com.backend.programming.learning.system.course.service.domain.dto.method.create.call_moodle_api_function.CreateCallMoodleApiFunctionCommand;
//import com.backend.programming.learning.system.course.service.domain.dto.method.create.call_moodle_api_function.CreateCallMoodleApiFunctionResponse;
//import com.backend.programming.learning.system.course.service.domain.dto.method.query.call_moodle_api_function.QueryAllCallMoodleApiFunctionResponse;
//import com.backend.programming.learning.system.course.service.domain.dto.responseentity.call_moodle_api_function.CallMoodleApiFunctionResponseEntity;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.UUID;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping(value = "/organization/call_moodle_api_function", produces = "application/vnd.api.v1+json")
//public class CallMoodleApiFunctionController {
//    private final CallMoodleApiFunctionApplicationService callMoodleApiFunctionApplicationService;
//
//    @PostMapping
//    @Operation(summary = "Create call_moodle_api_function.")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Success.", content = {
//                    @Content(mediaType = "application/vnd.api.v1+json",
//                            schema = @Schema(implementation = CreateCallMoodleApiFunctionResponse.class))
//            }),
//            @ApiResponse(responseCode = "400", description = "Not found."),
//            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
//    public ResponseEntity<CreateCallMoodleApiFunctionResponse> createCallMoodleApiFunction(
//            @RequestBody CreateCallMoodleApiFunctionCommand createCallMoodleApiFunctionCommand
//    ) {
//        log.info("Creating call_moodle_api_function");
//        CreateCallMoodleApiFunctionResponse response = callMoodleApiFunctionApplicationService.createCallMoodleApiFunction(createCallMoodleApiFunctionCommand);
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//    }
//
//    @GetMapping
//    @Operation(summary = "Get all call_moodle_api_functions.")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Success.", content = {
//                    @Content(mediaType = "application/vnd.api.v1+json",
//                            schema = @Schema(implementation = QueryAllCallMoodleApiFunctionResponse.class))
//            }),
//            @ApiResponse(responseCode = "400", description = "Not found."),
//            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
//    public ResponseEntity<QueryAllCallMoodleApiFunctionResponse> queryAllCallMoodleApiFunctions() {
//        log.info("Querying all call_moodle_api_functions");
//        QueryAllCallMoodleApiFunctionResponse response = callMoodleApiFunctionApplicationService.queryAllCallMoodleApiFunctions();
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/{callMoodleApiFunctionId}")
//    @Operation(summary = "Get call_moodle_api_function by id.")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Success.", content = {
//                    @Content(mediaType = "application/vnd.api.v1+json",
//                            schema = @Schema(implementation = CallMoodleApiFunctionResponseEntity.class))
//            }),
//            @ApiResponse(responseCode = "400", description = "Not found."),
//            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
//    public ResponseEntity<CallMoodleApiFunctionResponseEntity> queryCallMoodleApiFunctionById(
//            @PathVariable UUID callMoodleApiFunctionId
//    ) {
//        log.info("Querying call_moodle_api_function by id: {}", callMoodleApiFunctionId);
//        CallMoodleApiFunctionResponseEntity response = callMoodleApiFunctionApplicationService.queryCallMoodleApiFunctionById(callMoodleApiFunctionId);
//        return ResponseEntity.ok(response);
//    }
//}
