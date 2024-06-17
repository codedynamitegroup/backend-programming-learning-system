package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.tag.CodeQuestionTagEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.repository.CodeQuestionTagJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity.CodeSubmissionCerCourseEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity.contest.CodeSubmissionContestEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity.CodeSubmissionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.mapper.CodeSubmissionDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.repository.CodeSubmissionCerCourseJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.repository.CodeSubmissionContestJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.repository.CodeSubmissionJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.mapper.TagDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion.CodeSubmissionRepository;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class CodeSubmissionRepositoryImpl implements CodeSubmissionRepository {
    private final CodeSubmissionJpaRepository jpaRepository;
    private final CodeSubmissionDataAccessMapper dataAccessMapper;
    private final CodeQuestionTagJpaRepository codeQuestionTagJpaRepository;
    private final TagDataAccessMapper tagDataAccessMapper;
    private final CodeSubmissionContestJpaRepository codeSubmissionContestJpaRepository;
    private final CodeSubmissionCerCourseJpaRepository codeSubmissionCerCourseJpaRepository;

    public CodeSubmissionRepositoryImpl(CodeSubmissionJpaRepository jpaRepository, CodeSubmissionDataAccessMapper dataAccessMapper, CodeQuestionTagJpaRepository codeQuestionTagJpaRepository, TagDataAccessMapper tagDataAccessMapper, CodeSubmissionContestJpaRepository codeSubmissionContestJpaRepository, CodeSubmissionCerCourseJpaRepository codeSubmissionCerCourseJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.dataAccessMapper = dataAccessMapper;
        this.codeQuestionTagJpaRepository = codeQuestionTagJpaRepository;
        this.tagDataAccessMapper = tagDataAccessMapper;
        this.codeSubmissionContestJpaRepository = codeSubmissionContestJpaRepository;
        this.codeSubmissionCerCourseJpaRepository = codeSubmissionCerCourseJpaRepository;
    }

    @Override
    public CodeSubmission save(CodeSubmission codeSubmission) {
        CodeSubmissionEntity entity = dataAccessMapper.codeSubmissionToEntity(codeSubmission);
        return dataAccessMapper.entityToCodeSubmission(jpaRepository.save(entity));
    }

    @Override
    public void updateOneTestCase(CodeSubmissionId id) {
        jpaRepository.increaseNumOfTestCaseGradedByOne(id.getValue());
    }

    @Override
    public Optional<CodeSubmission> findById(CodeSubmissionId id) {
        return jpaRepository.findById(id.getValue()).map(dataAccessMapper::entityToCodeSubmission);
    }

    @Override
    public Page<CodeSubmission> findByUserIdAndQuestionId(UserId userId, CodeQuestionId codeQuestionId, UUID contestId, UUID cerCourseId, Integer pageNum, Integer pageSize) {

        if(contestId == null && cerCourseId == null) {
            Pageable pageable
                    = PageRequest
                    .of(pageNum, pageSize, Sort.by("createdAt").descending());
            return jpaRepository
                    .findByUserIdAndCodeQuestionId(
                            userId.getValue(),
                            codeQuestionId.getValue(),
                            pageable)
                    .map(dataAccessMapper::entityToCodeSubmission);
        }
        Pageable pageable
                = PageRequest
                .of(pageNum, pageSize, Sort.by("created_at").descending());
        return jpaRepository
                .findByUserIdAndCodeQuestionIdAndContestIdAndCerCourseId(
                        contestId,
                        cerCourseId,
                        userId.getValue(),
                        codeQuestionId.getValue(),
                        pageable)
                .map(dataAccessMapper::entityToCodeSubmission);
    }

    @Override
    public Integer findNumberOfSubmissionUnderMySubmissionByMemory(CodeSubmissionId id) {
        return jpaRepository.findNumberOfSubmissionUnderMySubmissionByMemory(id.getValue());
    }

    @Override
    public Integer findNumberOfSubmissionUnderMySubmissionByRunTime(CodeSubmissionId id) {
        return jpaRepository.findNumberOfSubmissionUnderMySubmissionByRunTime(id.getValue());
    }

    @Override
    public Integer totalSubmissionHavingAvgMemoryAndRunTime(CodeQuestionId id) {
        return jpaRepository.totalSubmissionHavingAvgMemoryAndRunTime(id.getValue());
    }

    @Override
    public Integer findNumberOfSubmissionUnderMySubmissionByScore(CodeSubmissionId id) {
        return jpaRepository.findNumberOfSubmissionUnderMySubmissionByScore(id.getValue());
    }

    @Override
    public Integer totalSubmissionHavingScore(CodeQuestionId id) {
        return jpaRepository.totalSubmissionHavingScore(id.getValue());
    }

    @Override
    public Integer findYourScoreRank(CodeSubmissionId id) {
        return jpaRepository.findYourScoreRank(id.getValue());
    }

    @Override
    public List<CodeSubmission> findLatestSubmissionEachLanguage(CodeQuestionId id, UserId id1) {
        List<CodeSubmissionEntity> codeSubmissionEntities = jpaRepository.findLatestSubmissionEachLanguageByCodeQuestionIdAndUserId(id.getValue(), id1.getValue());
        return codeSubmissionEntities.stream().map(dataAccessMapper::entityToCodeSubmission).toList();
    }

    @Override
    public Integer countPeopleAttend(CodeQuestionId id) {
        return jpaRepository.countPeopleAttend(id.getValue());
    }

    @Override
    public List<Tag> findTagByLastestSubmission(UserId id) {
        Optional<CodeSubmissionEntity> codeSubmissionEntity = jpaRepository.findFirstByUserIdOrderByCreatedAtDesc(id.getValue());
        if(codeSubmissionEntity.isPresent()){
            UUID codeQuestionId = codeSubmissionEntity.get().getCodeQuestion().getId();
            List<CodeQuestionTagEntity> codeQuestionTagEntities = codeQuestionTagJpaRepository.findAllByCodeQuestionId(codeQuestionId);
            return codeQuestionTagEntities.stream()
                    .map(CodeQuestionTagEntity::getTag)
                    .map(tagDataAccessMapper::entityToTag).toList();
        }
        return List.of();
    }

    @Override
    public void saveCerCourse(CodeSubmissionId id, UUID certificateCourseId) {
        codeSubmissionCerCourseJpaRepository.save(CodeSubmissionCerCourseEntity.builder()
                        .cerCourseId(certificateCourseId)
                        .codeSubmissionId(id.getValue())
                .build());
    }

    @Override
    public void saveContest(CodeSubmissionId id, UUID contestId) {
        codeSubmissionContestJpaRepository.save(CodeSubmissionContestEntity.builder()
                .contestId(contestId)
                .codeSubmissionId(id.getValue())
                .build());
    }

    @Override
    public Page<CodeSubmission> findByQuestionId(CodeQuestionId codeQuestionId, UUID contestId, UUID cerCourseId, Integer pageNum, Integer pageSize) {
        Pageable pageable
                = PageRequest
                .of(pageNum, pageSize, Sort.by("created_at").descending());
        return jpaRepository
                .findByContestIdAndCerCourseIdCodeQuestionId(
                        contestId,
                        cerCourseId,
                        codeQuestionId.getValue(),
                        pageable)
                .map(dataAccessMapper::entityToCodeSubmission);
    }
}
