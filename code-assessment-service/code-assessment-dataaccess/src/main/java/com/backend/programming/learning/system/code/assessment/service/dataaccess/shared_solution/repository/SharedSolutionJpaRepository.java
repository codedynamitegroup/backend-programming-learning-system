package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.entity.TagEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SharedSolutionJpaRepository extends JpaRepository<SharedSolutionEntity, UUID> {

    @Query("""
            select sse
            from SharedSolutionEntity sse LEFT JOIN SharedSolutionTagEntity sste
            on sse.id = sste.sharedSolution.id
            where sse.codeQuestion.id = ?1 
                    and ((?2 IS NULL) OR (sste.tag.id in ?2))
            group by sse.id
            """)
    Page<SharedSolutionEntity> findByCodeQuestionId(UUID codeQuestionId, List<UUID> tagIds, Pageable pageable);


//    List<SharedSolutionEntity> cc(UUID codeQuestionId)
    @Modifying
    @Query("""
            update SharedSolutionEntity sse
            set sse.viewNumber = sse.viewNumber + 1
            where sse.id = ?1
            """)
    void increaseOneViewById(UUID value);
}
