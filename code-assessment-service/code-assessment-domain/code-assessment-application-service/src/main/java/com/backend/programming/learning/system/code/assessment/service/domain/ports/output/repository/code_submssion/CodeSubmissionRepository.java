package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CodeSubmissionRepository {
    CodeSubmission save(CodeSubmission codeSubmission);
    void updateOneTestCase(CodeSubmissionId id);
    Optional<CodeSubmission> findById(CodeSubmissionId id);

    Page<CodeSubmission> findByUserIdAndQuestionId(UserId userId, CodeQuestionId codeQuestionId, Integer pageNum, Integer pageSize);

    Integer findNumberOfSubmissionUnderMySubmissionByMemory(CodeSubmissionId id);

    Integer findNumberOfSubmissionUnderMySubmissionByRunTime(CodeSubmissionId id);

    Integer totalSubmissionHavingAvgMemoryAndRunTime(CodeQuestionId id);

    Integer findNumberOfSubmissionUnderMySubmissionByScore(CodeSubmissionId id);

    Integer totalSubmissionHavingScore(CodeQuestionId id);

    Integer findYourScoreRank(CodeSubmissionId id);

    List<CodeSubmission> findLatestSubmissionEachLanguage(CodeQuestionId id, UserId id1);

    Integer countPeopleAttend(CodeQuestionId id);
}
