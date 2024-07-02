package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CodeQuestionJpaRepository extends JpaRepository<CodeQuestionEntity, UUID> {
    Optional<CodeQuestionEntity> findByQuestionId(UUID questionId);
    Optional<CodeQuestionEntity> findByName(String name);
    @Query(value= """
            (select cqe.*
                from (select cse.* from code_submission cse
                order by cse.created_at
                limit 100) as cseTemp join qtype_code_questions cqe on cqe.id = cseTemp.code_question_id
            group by cqe.id
            order by count(cseTemp) DESC
            limit 3)
            """, nativeQuery = true)

    List<CodeQuestionEntity> findTop3ByTop100RecentSubmitData();

    @Query(value = """
            select cqe.* from qtype_code_questions cqe
            where 
                cqe.id in ( select cqe2.id from qtype_code_questions cqe2 
                                    LEFT JOIN tag_code_question cqte
                                    on cqe2.id = cqte.code_question_id 
                                    where (COALESCE(?1,NULL) IS NULL OR cqte.tag_id in ?1)
                                    group by cqe2.id
                                    )
                AND (cast(?3 as text) IS NULL or 
                    cqe.fts_document @@ (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'') ) ) or
                    cqe.fts_document @@ (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,'')) ) ) or
                    (cast(?8 as text) is not null and cqe.name like concat('%', cast(?8 as text), '%'))
                    )
                AND (cast(?4 as text) is NULL OR cast(?4 as text) = cast(cqe.difficulty as text))
                AND ((?5 is null) or (?6 is null) or ((?5 = true) AND EXISTS (
                                    select cse from code_submission cse
                                    where cse.code_question_id = cqe.id
                                    and cse.grade = cqe.max_grade
                                    and ?6 = cse.user_id
                                ))
                    or ((?5 = false) and not exists (
                                    select cse from code_submission cse
                                    where cse.code_question_id = cqe.id
                                    and cse.grade = cqe.max_grade
                                    and ?6 = cse.user_id
                                ))
                )
                AND cqe.is_public = ?7
                
                order by
                ts_rank(cqe.fts_document, 
                    case
                        when cast(?3 as text) is null then to_tsquery('')
                        else (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'')) )
                    end
                ) desc,
                ts_rank(cqe.fts_document,
                    case
                        when cast(?3 as text) is null then to_tsquery('')
                        else (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,''))))
                    end
                ) desc,
                cqe.created_at asc
                
            """, nativeQuery = true)
    Page<CodeQuestionEntity> findAndFilterByTagIds(List<UUID> tagIs,
                                                   String searchExcludeFinalWord,
                                                   String searchFinalWord,
                                                   String difficulty,
                                                   Boolean solved,
                                                   UUID value,
                                                   boolean isPublic,
                                                   String search,
                                                   Pageable pageable);

    @Query(value = """
            select cqe.* from qtype_code_questions cqe 
            join tag_code_question tcqe on tcqe.code_question_id = cqe.id
            where COALESCE(?1,NULL) IS NOT NULL AND tcqe.tag_id in ?1
                and cqe.id not in (
                    select cqe2.id from qtype_code_questions cqe2
                    join code_submission cse on cse.code_question_id = cqe2.id
                    where cse.grade = cqe2.max_grade
                )
            group by cqe.id
            limit 3
            """, nativeQuery = true)
    List<CodeQuestionEntity> findByNotSolvedTagsAndUserId(List<UUID> tagIds, UUID value);

    @Query(value = """
            select cqe.* from qtype_code_questions cqe
            where 
                cqe.id in ( select cqe2.id from qtype_code_questions cqe2 
                                    LEFT JOIN tag_code_question cqte
                                    on cqe2.id = cqte.code_question_id 
                                    where (COALESCE(?1,NULL) IS NULL OR cqte.tag_id in ?1)
                                    group by cqe2.id
                                    )
                AND (cast(?3 as text) IS NULL or 
                    cqe.fts_document @@ (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'') ) ) or
                    cqe.fts_document @@ (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,'')) ) ) or
                    (cast(?6 as text) is not null and cqe.name like concat('%', cast(?6 as text), '%'))
                    )
                AND (cast(?4 as text) is NULL OR cast(?4 as text) = cast(cqe.difficulty as text))
                AND (?5 is null or cqe.is_public = ?5)
                AND (cqe.org_id is null)
                order by
                ts_rank(cqe.fts_document, 
                    case
                        when cast(?3 as text) is null then to_tsquery('')
                        else (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'')) )
                    end
                ) desc,
                ts_rank(cqe.fts_document,
                    case
                        when cast(?3 as text) is null then to_tsquery('')
                        else (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,''))))
                    end
                ) desc,
                cqe.created_at asc
                
            """, nativeQuery = true)
    Page<CodeQuestionEntity> adminFindAndFilterByTagIds(List<UUID> tagEntityId,
                                                        String searchExcludeFinalWord,
                                                        String searchFinalWord,
                                                        String difficulty,
                                                        Boolean isPublic,
                                                        String search,
                                                        Pageable pageable);
}
