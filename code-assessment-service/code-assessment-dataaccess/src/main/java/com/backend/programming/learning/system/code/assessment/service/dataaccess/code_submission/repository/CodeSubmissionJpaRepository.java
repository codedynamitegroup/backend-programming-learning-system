package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity.CodeSubmissionEntity;
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
                                    from code_submission cse where cse.grading_status = 'GRADED'
                                    ) as rtb
            						where
                                    rtb.memRank > (select memRank from (
                                        			select cse.*, DENSE_RANK() OVER (ORDER BY cse.avg_memory ASC) AS memRank
                                        				from code_submission cse where cse.grading_status = 'GRADED'
                                        			) as rtb2 where rtb2.id = ?1 )
            """, nativeQuery = true)
    Integer findNumberOfSubmissionUnderMySubmissionByMemory(UUID value);

    @Query(value = """
            select count(*) from (
                                    select cse.*, DENSE_RANK() OVER (ORDER BY cse.avg_runtime ASC) AS timeRank
                                    from code_submission cse where cse.grading_status = 'GRADED'
                                    ) as rtb
            						where
                                    rtb.timeRank > (select timeRank from (
                                        			select cse.*, DENSE_RANK() OVER (ORDER BY cse.avg_runtime ASC) AS timeRank
                                        				from code_submission cse where cse.grading_status = 'GRADED'
                                        			) as rtb2 where rtb2.id = ?1 )
            """, nativeQuery = true)
    Integer findNumberOfSubmissionUnderMySubmissionByRunTime(UUID value);

    @Query("""
            select count(cse) from CodeSubmissionEntity cse where cse.codeQuestion.id = ?1 and cse.gradingStatus = 'GRADED'
            """)
    Integer countGradedByCodeQuestionId(UUID value);
}
