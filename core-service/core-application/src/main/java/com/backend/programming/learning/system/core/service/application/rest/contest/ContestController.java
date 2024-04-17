package com.backend.programming.learning.system.core.service.application.rest.contest;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user.CreateCertificateCourseUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user.CreateCertificateCourseUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest_user.CreateContestUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest_user.CreateContestUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.chapter.DeleteChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.delete.chapter.DeleteChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.contest.DeleteContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.delete.contest.DeleteContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryAllCertificateCoursesCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryAllCertificateCoursesResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.chapter.QueryAllChaptersCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.chapter.QueryAllChaptersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.chapter.QueryChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.chapter.QueryChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.contest.QueryAllContestsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.contest.QueryAllContestsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.contest.QueryContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.contest.QueryContestResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.contest.ContestApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.contest_user.ContestUserApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.review.ReviewApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<CreateContestResponse> createCertificateCourse(
            @RequestBody CreateContestCommand createContestCommand) {
        log.info("Creating contest: {}", createContestCommand);
        CreateContestResponse createContestResponse =
                contestApplicationService.createContest(createContestCommand);
        log.info("Contest created: {}", createContestResponse);

        return ResponseEntity.ok(createContestResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<CreateContestUserResponse> registerContest(
            @RequestBody CreateContestUserCommand createContestUserCommand) {
        log.info("Creating Contest User course: {}", contestUserApplicationService);
        CreateContestUserResponse createContestUserResponse =
                contestUserApplicationService.createContestUser(createContestUserCommand);
        log.info("Contest User created: {}", createContestUserCommand);

        return ResponseEntity.ok(createContestUserResponse);
    }

    @GetMapping
    public ResponseEntity<QueryAllContestsResponse> getAllContests(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        QueryAllContestsResponse queryAllContestsResponse =
                contestApplicationService.queryAllContests(QueryAllContestsCommand
                        .builder()
                        .pageNo(pageNo)
                        .pageSize(pageSize)
                        .build());
        log.info("Returning all contests: {}", queryAllContestsResponse.getContests());
        return ResponseEntity.ok(queryAllContestsResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QueryContestResponse> getContest(@PathVariable UUID id) {
        QueryContestResponse queryContestResponse =
                contestApplicationService.queryContest(QueryContestCommand
                        .builder()
                        .contestId(id)
                        .build());
        log.info("Returning contest: {}", queryContestResponse.getContestId());
        return  ResponseEntity.ok(queryContestResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteContestResponse> deleteContest(@PathVariable UUID id) {
        DeleteContestResponse deleteContestResponse =
                contestApplicationService.deleteContest(DeleteContestCommand
                        .builder()
                        .contestId(id)
                        .build());
        log.info("Contest deleted: {}", id);
        return ResponseEntity.ok(deleteContestResponse);
    }

}
