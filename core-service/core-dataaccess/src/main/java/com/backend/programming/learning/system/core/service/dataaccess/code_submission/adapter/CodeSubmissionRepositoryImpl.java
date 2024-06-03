package com.backend.programming.learning.system.core.service.dataaccess.code_submission.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper.ChapterDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.repository.ChapterJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.code_submission.mapper.CodeSubmissionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.code_submission.repository.CodeSubmissionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CodeSubmissionRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CodeSubmissionRepositoryImpl implements CodeSubmissionRepository {
    private final CodeSubmissionJpaRepository codeSubmissionJpaRepository;
    private final CodeSubmissionDataAccessMapper codeSubmissionDataAccessMapper;

    public CodeSubmissionRepositoryImpl(CodeSubmissionJpaRepository codeSubmissionJpaRepository,
                                         CodeSubmissionDataAccessMapper codeSubmissionDataAccessMapper) {
        this.codeSubmissionJpaRepository = codeSubmissionJpaRepository;
        this.codeSubmissionDataAccessMapper = codeSubmissionDataAccessMapper;
    }

    @Override
    public CodeSubmission saveCodeSubmission(CodeSubmission codeSubmission) {
        return codeSubmissionDataAccessMapper.codeSubmissionEntityToCodeSubmission(
                codeSubmissionJpaRepository.save(
                        codeSubmissionDataAccessMapper.
                                codeSubmissionToCodeSubmissionEntity(codeSubmission)));
    }

    @Override
    public List<CodeSubmission> findAllCodeSubmissionsByUserIdAndQuestionIdAndContestId(
            UUID userID, UUID questionId, UUID contestId) {
        return codeSubmissionDataAccessMapper.codeSubmissionEntityListToCodeSubmissionList(
                codeSubmissionJpaRepository.findAllCodeSubmissionsByUserIdAndQuestionIdAndContestId(
                        userID, questionId, contestId
                ));
    }

    @Override
    public List<CodeSubmission> findAllCodeSubmissionsByUserIdAndQuestionIdAndCertificateCourseId(
            UUID userId, UUID questionId, UUID certificateCourseId) {
        return codeSubmissionDataAccessMapper.codeSubmissionEntityListToCodeSubmissionList(
                codeSubmissionJpaRepository.findAllCodeSubmissionsByUserIdAndQuestionIdAndCertificateCourseId(
                        userId, questionId, certificateCourseId
                ));
    }

    @Override
    public int countAllByUserIdAndCodeQuestionIdAndContestId(UUID userId, UUID codeQuestionId, UUID contestId) {
        return codeSubmissionJpaRepository.countAllByUserIdAndCodeQuestionIdAndContestId(userId, codeQuestionId, contestId);
    }

    @Override
    public Optional<CodeSubmission> findLatestPassedCodeSubmissionByUserIdAndCodeQuestionIdAndContestId(
            UUID userId, UUID codeQuestionId, UUID contestId) {
        return codeSubmissionJpaRepository.findLatestPassedCodeSubmissionByUserIdAndCodeQuestionIdAndContestId(
                userId, codeQuestionId, contestId)
                .map(codeSubmissionDataAccessMapper::codeSubmissionEntityToCodeSubmission);
    }

    @Override
    public int countAllPassedCodeSubmissionsByUserIdAndCodeQuestionIdAndContestId(UUID userId, UUID codeQuestionId, UUID contestId) {
        return codeSubmissionJpaRepository
                .countAllPassedCodeSubmissionsByUserIdAndCodeQuestionIdAndContestId(
                        userId, codeQuestionId, contestId);
    }

    @Override
    public int countAllPassedCodeSubmissionsByCodeQuestionIdAndContestId(UUID codeQuestionId, UUID contestId) {
        return codeSubmissionJpaRepository.countAllPassedCodeSubmissionsByCodeQuestionIdAndContestId(codeQuestionId, contestId);
    }

    @Override
    public int countAllCodeSubmissionsByCodeQuestionIdAndContestId(UUID codeQuestionId, UUID contestId) {
        return codeSubmissionJpaRepository.countAllCodeSubmissionsByCodeQuestionIdAndContestId(codeQuestionId, contestId);
    }
}
