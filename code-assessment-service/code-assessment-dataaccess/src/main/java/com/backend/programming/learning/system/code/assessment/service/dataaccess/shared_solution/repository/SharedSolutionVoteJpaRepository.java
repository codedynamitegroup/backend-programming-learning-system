package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.vote.SharedSolutionVoteEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.vote.SharedSolutionVoteEntityId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SharedSolutionVoteJpaRepository extends JpaRepository<SharedSolutionVoteEntity, SharedSolutionVoteEntityId> {

//    @Query("""
//            select count(*)
//            from VoteSharedSolutionEntity vsse
//            where vsse.sharedSolution.id = ?1
//            and vsse.voteType in ?2
//            """)
    long countBySharedSolutionIdAndVoteTypeIn(UUID sharedSolutionId, List<Vote> votes);


}
