package com.backend.programming.learning.system.core.service.dataaccess.code_submission.repository;

import com.backend.programming.learning.system.core.service.dataaccess.code_submission.entity.CodeSubmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CodeSubmissionJpaRepository extends JpaRepository<CodeSubmissionEntity, UUID> {
    Optional<CodeSubmissionEntity> findById(UUID id);

    @Query(value = """
            SELECT cse.*
            FROM code_submission cse
            join question qe
            on cse.code_question_id = qe.id
            join qtype_code_question qcqe
            on qcqe.id = cse.code_question_id
            join code_submission_contest csce on cse.id = csce.code_submission_id
            WHERE cse.code_question_id = qcqe.id
            AND qcqe.question_id = qe.id
            AND cse.user_id = ?1
            AND qe.id = ?2
            AND csce.contest_id = ?3
""",nativeQuery = true)
    List<CodeSubmissionEntity> findAllCodeSubmissionsByUserIdAndQuestionIdAndContestId(UUID userId, UUID questionId, UUID contestId);

    @Query(value = """
            SELECT cse.*
            FROM code_submission cse
            join question qe 
            on cse.code_question_id = qe.id
            join qtype_code_question qcqe
            on qcqe.id = cse.code_question_id
            join code_submission_certificate_course cscce on cse.id = cscce.code_submission_id
            WHERE cse.code_question_id = qcqe.id
            AND qcqe.question_id = qe.id
            AND cse.user_id = ?1
            AND qe.id = ?2
            AND cscce.certificate_course_id = ?3
""", nativeQuery = true)
    List<CodeSubmissionEntity> findAllCodeSubmissionsByUserIdAndQuestionIdAndCertificateCourseId(
            UUID userId, UUID questionId, UUID certificateCourseId);

    @Query(value = """
            SELECT count(cse)
            FROM code_submission cse
            join qtype_code_question qcqe
            on qcqe.id = cse.code_question_id
            join code_submission_contest csce on cse.id = csce.code_submission_id
            WHERE cse.code_question_id = qcqe.id
            AND cse.user_id = ?1
            AND qcqe.id = ?2
            AND csce.contest_id = ?3
""", nativeQuery = true)
    int countAllByUserIdAndCodeQuestionIdAndContestId(UUID userId, UUID codeQuestionId, UUID contestId);


    @Query(value = """
            SELECT count(cse)
            FROM code_submission cse
            JOIN qtype_code_question qcqe
            ON qcqe.id = cse.code_question_id
            join code_submission_contest csce 
            on cse.id = csce.code_submission_id
            WHERE cse.code_question_id = qcqe.id
            AND cse.user_id = ?1
            AND qcqe.id = ?2
            AND csce.contest_id = ?3
            AND cse.pass = true
""", nativeQuery = true)
    int countAllPassedCodeSubmissionsByUserIdAndCodeQuestionIdAndContestId(UUID userId, UUID codeQuestionId, UUID contestId);

    @Query(value = """
            SELECT cse.*
            FROM code_submission cse
            JOIN qtype_code_question qcqe
            ON qcqe.id = cse.code_question_id
            join code_submission_contest csce on cse.id = csce.code_submission_id
            WHERE cse.code_question_id = qcqe.id
            AND cse.user_id = ?1
            AND qcqe.id = ?2
            AND csce.contest_id = ?3
            AND cse.pass = true
            ORDER BY cse.created_at DESC
            LIMIT 1
""", nativeQuery = true)
    Optional<CodeSubmissionEntity> findLatestPassedCodeSubmissionByUserIdAndCodeQuestionIdAndContestId(
            UUID userId, UUID codeQuestionId, UUID contestId);

    @Query(value = """
            SELECT count(cse)
            FROM code_submission cse
            join qtype_code_question qcqe
            on qcqe.id = cse.code_question_id
            join code_submission_contest csce
            on cse.id = csce.code_submission_id
            WHERE cse.code_question_id = ?1
            AND csce.contest_id = ?2
            AND cse.pass = true
""", nativeQuery = true)
    int countAllPassedCodeSubmissionsByCodeQuestionIdAndContestId(UUID codeQuestionId, UUID contestId);

    @Query(value = """
            SELECT count(cse)
            FROM code_submission cse
            join qtype_code_question qcqe
            on qcqe.id = cse.code_question_id
            join code_submission_contest csce
            on cse.id = csce.code_submission_id
            WHERE cse.code_question_id = ?1
            AND csce.contest_id = ?2
""", nativeQuery = true)
    int countAllCodeSubmissionsByCodeQuestionIdAndContestId(UUID codeQuestionId, UUID contestId);
}
