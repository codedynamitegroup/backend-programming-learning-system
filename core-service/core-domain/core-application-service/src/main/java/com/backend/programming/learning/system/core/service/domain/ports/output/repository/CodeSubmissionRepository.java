package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmission;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CodeSubmissionRepository {
    CodeSubmission saveCodeSubmission(CodeSubmission codeSubmission);
    List<CodeSubmission> findAllCodeSubmissionsByUserIdAndQuestionIdAndContestId(
            UUID userId, UUID questionId, UUID contestId);
    List<CodeSubmission> findAllCodeSubmissionsByUserIdAndQuestionIdAndCertificateCourseId(
            UUID userId, UUID questionId, UUID certificateCourseId);
    int countAllByUserIdAndCodeQuestionIdAndContestId(
            UUID userId, UUID codeQuestionId, UUID contestId);
    Optional<CodeSubmission> findLatestPassedCodeSubmissionByUserIdAndCodeQuestionIdAndContestId(
            UUID userId, UUID codeQuestionId, UUID contestId);
    int countAllPassedCodeSubmissionsByUserIdAndCodeQuestionIdAndContestId(
            UUID userId, UUID codeQuestionId, UUID contestId);
    int countAllPassedCodeSubmissionsByCodeQuestionIdAndContestId(UUID codeQuestionId, UUID contestId);
    int countAllCodeSubmissionsByCodeQuestionIdAndContestId(UUID codeQuestionId, UUID contestId);
}
