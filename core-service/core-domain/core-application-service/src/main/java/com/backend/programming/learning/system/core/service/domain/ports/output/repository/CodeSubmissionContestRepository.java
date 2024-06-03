package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmissionContest;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CodeSubmissionContestRepository {

    CodeSubmissionContest saveCodeSubmissionContest(CodeSubmissionContest codeSubmissionContest);
}
