package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity.CodeSubmissionEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CodeSubmissionJpaRepository extends JpaRepository<CodeSubmissionEntity, UUID> {
    @Modifying
    @Query("update CodeSubmissionEntity cse set cse.numOfTestCaseGraded = cse.numOfTestCaseGraded + 1 where cse.id = :id")
    void increaseNumOfTestCaseGradedByOne(@Param("id") UUID id);

    Optional<List<CodeSubmissionEntity>> findByUserIdAndCodeQuestionId(UUID userId, UUID codeQuestionId);

    @Query(value = """
            select count(*) from (
                                    select cse.*, DENSE_RANK() OVER (ORDER BY cse.avg_memory ASC) AS memRank
                                    from code_submission cse 
                                    where cse.grading_status = 'GRADED' and 
                                        cse.avg_runtime IS NOT NULL and 
                                        cse.avg_memory IS NOT NULL
                                    ) as rtb
            						where
                                    rtb.memRank > (select memRank from (
                                        			select cse.*, DENSE_RANK() OVER (ORDER BY cse.avg_memory ASC) AS memRank
                                        				from code_submission cse where cse.grading_status = 'GRADED' and 
                                                                                        cse.avg_runtime IS NOT NULL and 
                                                                                        cse.avg_memory IS NOT NULL
                                        			) as rtb2 where rtb2.id = ?1 )
            """, nativeQuery = true)
    Integer findNumberOfSubmissionUnderMySubmissionByMemory(UUID value);

    @Query(value = """
            select count(*) from (
                                    select cse.*, DENSE_RANK() OVER (ORDER BY cse.avg_runtime ASC) AS timeRank
                                    from code_submission cse where cse.grading_status = 'GRADED' and 
                                                                        cse.avg_runtime IS NOT NULL and 
                                                                        cse.avg_memory IS NOT NULL
                                    ) as rtb
            						where
                                    rtb.timeRank > (select timeRank from (
                                        			select cse.*, DENSE_RANK() OVER (ORDER BY cse.avg_runtime ASC) AS timeRank
                                        				from code_submission cse where cse.grading_status = 'GRADED' and 
                                                                                        cse.avg_runtime IS NOT NULL and 
                                                                                        cse.avg_memory IS NOT NULL
                                        			) as rtb2 where rtb2.id = ?1 )
            """, nativeQuery = true)
    Integer findNumberOfSubmissionUnderMySubmissionByRunTime(UUID value);

    @Query("""
            select count(cse) from CodeSubmissionEntity cse 
            where cse.codeQuestion.id = ?1 and 
                    cse.gradingStatus = 'GRADED' and 
                    cse.avgRuntime IS NOT NULL and 
                    cse.avgMemory IS NOT NULL
            """)
    Integer totalSubmissionHavingAvgMemoryAndRunTime(UUID value);

    @Query(value = """
            select count(*) from (
                                    select cse.*, DENSE_RANK() OVER (ORDER BY cse.grade DESC) AS scoreRank
                                    from code_submission cse where cse.grading_status = 'GRADED' and 
                                                                   cse.grade IS NOT NULL
                                    ) as rtb
            						where
                                    rtb.scoreRank > (select scoreRank from (
                                        			select cse.*, DENSE_RANK() OVER (ORDER BY cse.grade DESC) AS scoreRank
                                        				from code_submission cse where cse.grading_status = 'GRADED' and 
                                                                                        cse.grade IS NOT NULL
                                        			) as rtb2 where rtb2.id = ?1 )
            """, nativeQuery = true)
    Integer findNumberOfSubmissionUnderMySubmissionByScore(UUID value);

    @Query("""
            select count(cse) from CodeSubmissionEntity cse 
            where cse.codeQuestion.id = ?1 and 
                    cse.gradingStatus = 'GRADED' and 
                    cse.grade IS NOT NULL
            """)
    Integer totalSubmissionHavingScore(UUID value);

    @Query(value = """
            select scoreRank from (
                                    select cse.*, DENSE_RANK() OVER (ORDER BY cse.grade DESC) AS scoreRank
                                    from code_submission cse where cse.grading_status = 'GRADED' and 
                                                                   cse.grade IS NOT NULL
                                    ) as rtb where rtb.id = ?1
            """, nativeQuery = true)
    Integer findYourScoreRank(UUID value);

    Optional<CodeSubmissionEntity> findByUserIdAndCodeQuestionIdAndGrade(UUID value, UUID id, Double grade);

    Optional<CodeSubmissionEntity> findByCodeQuestionIdAndUserId(UUID codeQuestionId, UUID userId);
}
