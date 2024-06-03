package com.backend.programming.learning.system.core.service.dataaccess.code_submission_contest.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.code_submission_contest.entity.CodeSubmissionContestEntity;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmissionContest;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import org.springframework.stereotype.Component;

@Component
public class CodeSubmissionContestDataAccessMapper {

    public CodeSubmissionContestEntity codeSubmissionContestToCodeSubmissionContestEntity(CodeSubmissionContest codeSubmissionContest) {
        return CodeSubmissionContestEntity.builder()
                .codeSubmissionId(codeSubmissionContest.getId().getValue())
                .contestId(codeSubmissionContest.getContestId().getValue())
                .build();
    }

    public CodeSubmissionContest codeSubmissionContestEntityToCodeSubmissionContest(CodeSubmissionContestEntity codeSubmissionContestEntity) {
        return CodeSubmissionContest.builder()
                .id(new CodeSubmissionId(codeSubmissionContestEntity.getCodeSubmissionId()))
                .contestId(new ContestId(codeSubmissionContestEntity.getContestId()))
                .build();
    }
}
