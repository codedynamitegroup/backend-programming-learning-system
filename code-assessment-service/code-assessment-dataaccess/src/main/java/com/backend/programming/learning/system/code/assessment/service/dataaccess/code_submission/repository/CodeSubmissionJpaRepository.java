package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity.CodeSubmissionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query(value = """
            select cse.* from code_submission cse
            left join code_submission_contest csce on csce.code_submission_id = cse.id
            left join code_submission_cer_course cscce on cscce.code_submission_id = cse.id
            where ((?1 is not null and csce.contest_id = ?1)
            or (?2 is not null and cscce.cer_course_id = ?2))
            and ?3 is not null and cse.user_id = ?3
            and ?4 is not null and cse.code_question_id = ?4
            group by cse.id
            """,
            nativeQuery = true)
    Page<CodeSubmissionEntity> findByUserIdAndCodeQuestionIdAndContestIdAndCerCourseId(
            UUID contestId,
            UUID cerCourseId,
            UUID userId,
            UUID codeQuestionIdValue,
            Pageable pageable);
    Page<CodeSubmissionEntity> findByUserIdAndCodeQuestionId(UUID userId, UUID codeQuestionId, Pageable pageable);




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

    Optional<CodeSubmissionEntity> findFirstByUserIdAndCodeQuestionIdAndGrade(UUID value, UUID id, Double grade);

    @Query("""
            select cse from CodeSubmissionEntity cse 
            where cse.codeQuestion.id = ?1 and cse.user.id = ?2 
                and cse.createdAt in (select max(cse2.createdAt) as createdAt
                                      from CodeSubmissionEntity cse2
                                      where cse2.user.id = ?2 
                                      and cse2.codeQuestion.id = cse.codeQuestion.id 
                                      and cse.programmingLanguage.id = cse2.programmingLanguage.id
                                      group by cse2.programmingLanguage.id)
            """)
    List<CodeSubmissionEntity> findLatestSubmissionEachLanguageByCodeQuestionIdAndUserId(UUID codeQuestionId, UUID userId);

    @Query(value = """
    select count(distinct cse.user) 
    from CodeSubmissionEntity cse
    where cse.codeQuestion.id = ?1
    """)
    Integer countPeopleAttend(UUID id);

    Optional<CodeSubmissionEntity> findFirstByUserIdOrderByCreatedAtDesc(UUID id);

    @Query(value = """
            select cse.* from code_submission cse
            left join code_submission_contest csce on csce.code_submission_id = cse.id
            left join code_submission_cer_course cscce on cscce.code_submission_id = cse.id
            where ((?1 is not null and csce.contest_id = ?1)
            or (?2 is not null and cscce.cer_course_id = ?2))
            group by cse.id
            """,
    nativeQuery = true)
    Page<CodeSubmissionEntity> findByContestIdAndCerCourseIdCodeQuestionIds(UUID contestId, UUID cerCourseId, Pageable pageable);
}
