package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionEntity;
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
            where (?1 is null or sse.codeQuestion.id = ?1)
                    and ((?2 IS NULL) OR (sste.tag.id in ?2))
                    and (cast(?3 as text) is null or  sse.title like concat('%', cast(?3 as text), '%'))
                    and (?4 is null or sse.user.id = ?4)
            group by sse.id
            """)
    Page<SharedSolutionEntity> findByCodeQuestionId(UUID codeQuestionId, List<UUID> tagIds, String search, UUID userId, Pageable pageable);


//    List<SharedSolutionEntity> cc(UUID codeQuestionId)
    @Modifying
    @Query("""
            update SharedSolutionEntity sse
            set sse.viewNumber = sse.viewNumber + 1
            where sse.id = ?1
            """)
    void increaseOneViewById(UUID value);
}
