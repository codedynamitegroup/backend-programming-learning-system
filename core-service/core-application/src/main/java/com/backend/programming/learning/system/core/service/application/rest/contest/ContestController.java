package com.backend.programming.learning.system.core.service.application.rest.contest;

import com.backend.programming.learning.system.core.service.application.utils.JwtUtils;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_user.CreateContestUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_user.CreateContestUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest.DeleteContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest.DeleteContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest.QueryGeneralStatisticsContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.*;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.contest.UpdateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.contest.UpdateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.ContestResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.contest.ContestApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.contest_user.ContestUserApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/core/contests", produces = "application/vnd.api.v1+json")
public class ContestController {
    private final ContestApplicationService contestApplicationService;
    private final ContestUserApplicationService contestUserApplicationService;

    public ContestController(ContestApplicationService contestApplicationService,
                             ContestUserApplicationService contestUserApplicationService) {
        this.contestApplicationService = contestApplicationService;
        this.contestUserApplicationService = contestUserApplicationService;
    }

    @PostMapping("/create")
    @Operation(summary = "Create contest.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateContestResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateContestResponse> createContest(
            @RequestBody CreateContestCommand createContestCommand) {
        String email = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            Jwt token = jwtAuthenticationToken.getToken();
            email = token.getClaim("preferred_username");
        }

        log.info("Creating contest: {}", createContestCommand);
        CreateContestResponse createContestResponse =
                contestApplicationService.createContest(
                        CreateContestCommand
                                .builder()
                                .name(createContestCommand.getName())
                                .description(createContestCommand.getDescription())
                                .prizes(createContestCommand.getPrizes())
                                .rules(createContestCommand.getRules())
                                .scoring(createContestCommand.getScoring())
                                .thumbnailUrl(createContestCommand.getThumbnailUrl())
                                .startTime(createContestCommand.getStartTime())
                                .endTime(createContestCommand.getEndTime())
                                .email(email)
                                .build()
                );
        log.info("Contest created: {}", createContestResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(createContestResponse);
    }

    @PostMapping("/{id}/register")
    @Operation(summary = "Register contest.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateContestUserResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateContestUserResponse> registerContest(
            @PathVariable UUID id) {
        String email = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            Jwt token = jwtAuthenticationToken.getToken();
            email = token.getClaim("preferred_username");
        }

        log.info("User registering for contest: {}", id);
        CreateContestUserResponse createContestUserResponse =
                contestUserApplicationService.createContestUser(CreateContestUserCommand
                        .builder()
                        .email(email)
                        .contestId(id)
                        .build());
        log.info("User registered for contest: {}", id);

        return ResponseEntity.status(HttpStatus.CREATED).body(createContestUserResponse);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update contest.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateContestResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateContestResponse> updateContest(
            @PathVariable UUID id,
            @RequestBody UpdateContestCommand updateContestCommand) {
        String email = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            Jwt token = jwtAuthenticationToken.getToken();
            email = token.getClaim("preferred_username");
        }

        log.info("Updating contest: {}", id);
        UpdateContestResponse updateContestResponse =
                contestApplicationService.updateContest(UpdateContestCommand
                        .builder()
                        .contestId(id)
                        .name(updateContestCommand.getName())
                        .description(updateContestCommand.getDescription())
                        .thumbnailUrl(updateContestCommand.getThumbnailUrl())
                        .prizes(updateContestCommand.getPrizes())
                        .rules(updateContestCommand.getRules())
                        .scoring(updateContestCommand.getScoring())
                        .startTime(updateContestCommand.getStartTime())
                        .endTime(updateContestCommand.getEndTime())
                        .isPublic(updateContestCommand.getIsPublic())
                        .email(email)
                        .build());
        log.info("Contest updated: {}", updateContestResponse.getContestId());
        return ResponseEntity.ok(updateContestResponse);
    }

    @GetMapping
    @Operation(summary = "Get all contests.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllContestsResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllContestsResponse> getAllContests(
            @RequestHeader(value = "Access-Token", required = false) String accessToken,
            @RequestParam(defaultValue = "") String searchName,
            @RequestParam(defaultValue = "ALL") String startTimeFilter,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        String email = JwtUtils.getEmailFromJwtString(accessToken);

        QueryAllContestsResponse queryAllContestsResponse =
                contestApplicationService.queryAllContests(QueryAllContestsCommand
                        .builder()
                        .pageNo(pageNo)
                        .pageSize(pageSize)
                        .searchName(searchName)
                        .startTimeFilter(startTimeFilter)
                        .email(email)
                        .build());
        log.info("Returning all contests: {}", queryAllContestsResponse.getContests());
        return ResponseEntity.ok(queryAllContestsResponse);
    }

    @GetMapping("/admin")
    @Operation(summary = "Get all contests for admin.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllContestsResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllContestsResponse> getAllContestsForAdmin(
            @RequestParam(defaultValue = "") String searchName,
            @RequestParam(defaultValue = "ALL") String startTimeFilter,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        String email = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            Jwt token = jwtAuthenticationToken.getToken();
            email = token.getClaim("preferred_username");
        }

        QueryAllContestsResponse queryAllContestsResponse =
                contestApplicationService.queryAllContestsForAdmin(QueryAllContestsCommand
                        .builder()
                        .pageNo(pageNo)
                        .pageSize(pageSize)
                        .searchName(searchName)
                        .startTimeFilter(startTimeFilter)
                        .email(email)
                        .build());
        log.info("Returning all contests: {}", queryAllContestsResponse.getContests());
        return ResponseEntity.ok(queryAllContestsResponse);
    }

    @GetMapping("/popular")
    @Operation(summary = "Get most popular contests.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllContestsResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryMostPopularContestsResponse> getMostPopularContests(
            @RequestHeader(value = "Access-Token", required = false) String accessToken
    ) {
        String email = JwtUtils.getEmailFromJwtString(accessToken);

        QueryMostPopularContestsResponse queryMostPopularContestsResponse =
                contestApplicationService.queryMostPopularContests(
                        QueryMostPopularContestsCommand
                                .builder()
                                .email(email)
                                .build()
                );
        log.info("Returning most popular upcoming contests: {}",
                queryMostPopularContestsResponse.getMostPopularContests());
        return ResponseEntity.ok(queryMostPopularContestsResponse);
    }

    @GetMapping("/{id}/users")
    @Operation(summary = "Get all users of contest.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllContestUsersResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllContestUsersResponse> getAllUsersOfContest(
            @PathVariable UUID id,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "false") Boolean fetchAll) {
        QueryAllContestUsersResponse queryAllContestUsersResponse =
                contestUserApplicationService.queryAllContestUsers(
                        QueryAllContestUsersCommand
                                .builder()
                                .contestId(id)
                                .pageNo(pageNo)
                                .pageSize(pageSize)
                                .fetchAll(fetchAll)
                                .build());
        log.info("Returning all users of contest: {}", id);
        return ResponseEntity.ok(queryAllContestUsersResponse);
    }

    @GetMapping("/{id}/leaderboard")
    @Operation(summary = "Get leaderboard of contest.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryLeaderboardOfContestResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryLeaderboardOfContestResponse> getLeaderboardOfContest
            (@RequestHeader(value = "Access-Token", required = false) String accessToken,
            @PathVariable UUID id,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        String email = JwtUtils.getEmailFromJwtString(accessToken);

        QueryLeaderboardOfContestResponse queryLeaderboardOfContestResponse =
                contestApplicationService.queryLeaderboardOfContest(
                        QueryLeaderboardOfContestCommand
                                .builder()
                                .contestId(id)
                                .email(email)
                                .pageNo(pageNo)
                                .pageSize(pageSize)
                                .build());
        log.info("Returning leaderboard of contest: {}", id);
        return ResponseEntity.ok(queryLeaderboardOfContestResponse);
    }

    @GetMapping("/{id}/admin/statistics")
    @Operation(summary = "Get statistics of a contest for admin.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryLeaderboardOfContestResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryStatisticsOfContestResponse> getStatisticsOfContestsForAdmin
            (@PathVariable UUID id) {
        QueryStatisticsOfContestResponse queryStatisticsOfContestResponse =
                contestApplicationService.queryStatisticsOfContestResponse(
                        QueryStatisticsOfContestCommand
                                .builder()
                                .contestId(id)
                                .build());
        log.info("Returning statistics of contest: {}", id);
        return ResponseEntity.ok(queryStatisticsOfContestResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get contest by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = ContestResponseEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<ContestResponseEntity> getContest(
            @RequestHeader(value = "Access-Token", required = false) String accessToken,
            @PathVariable UUID id) {
        String email = JwtUtils.getEmailFromJwtString(accessToken);

        ContestResponseEntity contestResponseEntity =
                contestApplicationService.queryContest(QueryContestCommand
                        .builder()
                        .contestId(id)
                        .email(email)
                        .build());
        log.info("Returning contest: {}", contestResponseEntity.getContestId());
        return  ResponseEntity.ok(contestResponseEntity);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete contest by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeleteContestResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<DeleteContestResponse> deleteContest(@PathVariable UUID id) {
        DeleteContestResponse deleteContestResponse =
                contestApplicationService.deleteContest(DeleteContestCommand
                        .builder()
                        .contestId(id)
                        .build());
        log.info("Contest deleted: {}", id);
        return ResponseEntity.ok(deleteContestResponse);
    }

    @GetMapping("/contest/dashboard-statistics")
    @Operation(summary = "Get statistics of contests for admin dashboard.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryGeneralStatisticsContestResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryGeneralStatisticsContestResponse> getStatisticsOfContests() {
        QueryGeneralStatisticsContestResponse queryStatisticContestResponse = contestApplicationService.getStatisticContest();

        log.info("Returning statistics of contests.");
        return ResponseEntity.ok(queryStatisticContestResponse);
    }
}
