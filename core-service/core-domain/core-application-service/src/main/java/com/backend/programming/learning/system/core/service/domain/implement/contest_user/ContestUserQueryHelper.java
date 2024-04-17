package com.backend.programming.learning.system.core.service.domain.implement.contest_user;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseUserRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Component
public class ContestUserQueryHelper {
    private final ContestUserRepository contestUserRepository;

    public ContestUserQueryHelper(ContestUserRepository contestUserRepository) {
        this.contestUserRepository = contestUserRepository;
    }

    @Transactional(readOnly = true)
    public Page<ContestUser> queryAllContestUsers(
            UUID contestId,
            Integer pageNo,
            Integer pageSize,
            Boolean fetchAll) {
        return contestUserRepository.
                findAllByContestId(contestId, pageNo, pageSize, fetchAll);
    }

}





















