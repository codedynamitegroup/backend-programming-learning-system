package com.backend.programming.learning.system.core.service.dataaccess.code_submission_contest.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.code_submission_certificatecourse.mapper.CodeSubmissionCertificateCourseDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.code_submission_certificatecourse.repository.CodeSubmissionCertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.code_submission_contest.mapper.CodeSubmissionContestDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.code_submission_contest.repository.CodeSubmissionContestJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.contest.mapper.ContestDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.contest.repository.ContestJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmissionCertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmissionContest;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CodeSubmissionContestRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestStartTimeFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CodeSubmissionContestRepositoryImpl implements CodeSubmissionContestRepository {

    private final CodeSubmissionContestJpaRepository codeSubmissionContestJpaRepository;
    private final CodeSubmissionContestDataAccessMapper codeSubmissionContestDataAccessMapper;

    public CodeSubmissionContestRepositoryImpl(CodeSubmissionContestJpaRepository codeSubmissionContestJpaRepository,
                                               CodeSubmissionContestDataAccessMapper codeSubmissionContestDataAccessMapper) {
        this.codeSubmissionContestJpaRepository = codeSubmissionContestJpaRepository;
        this.codeSubmissionContestDataAccessMapper = codeSubmissionContestDataAccessMapper;
    }

    @Override
    public CodeSubmissionContest saveCodeSubmissionContest(
            CodeSubmissionContest codeSubmissionContest) {
        return codeSubmissionContestDataAccessMapper
                .codeSubmissionContestEntityToCodeSubmissionContest(
                        codeSubmissionContestJpaRepository
                                .save(codeSubmissionContestDataAccessMapper
                                        .codeSubmissionContestToCodeSubmissionContestEntity(
                                                codeSubmissionContest)));
    }

}
