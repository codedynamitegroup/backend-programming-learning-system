package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.VoteSharedSolutionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.VoteSharedSolutionEntityId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VoteSharedSolutionJpaRepository extends JpaRepository<VoteSharedSolutionEntity, VoteSharedSolutionEntityId> {

//    @Query("""
//            select count(*)
//            from VoteSharedSolutionEntity vsse
//            where vsse.sharedSolution.id = ?1
//            and vsse.voteType in ?2
//            """)
    long countBySharedSolutionIdAndVoteTypeIn(UUID sharedSolutionId, List<Vote> votes);


}
