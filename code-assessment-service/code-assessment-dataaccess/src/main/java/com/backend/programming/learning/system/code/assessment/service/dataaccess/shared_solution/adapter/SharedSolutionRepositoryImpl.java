package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionTagEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.mapper.SharedSolutionDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.mapper.SharedSolutionTagDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.repository.SharedSolutionJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.repository.SharedSolutionTagJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.repository.VoteSharedSolutionJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.SharedSolutionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.Vote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class SharedSolutionRepositoryImpl implements SharedSolutionRepository {
    final SharedSolutionDataAccessMapper dataAccessMapper;
    final SharedSolutionJpaRepository sharedSolutionJpaRepository;
    final SharedSolutionTagJpaRepository sharedSolutionTagJpaRepository;
    final SharedSolutionTagDataAccessMapper sharedSolutionTagDataAccessMapper;
    final VoteSharedSolutionJpaRepository voteSharedSolutionJpaRepository;

    public SharedSolutionRepositoryImpl(SharedSolutionDataAccessMapper dataAccessMapper, SharedSolutionJpaRepository sharedSolutionJpaRepository, SharedSolutionTagJpaRepository sharedSolutionTagJpaRepository, SharedSolutionTagDataAccessMapper sharedSolutionTagDataAccessMapper, VoteSharedSolutionJpaRepository voteSharedSolutionJpaRepository) {
        this.dataAccessMapper = dataAccessMapper;
        this.sharedSolutionJpaRepository = sharedSolutionJpaRepository;
        this.sharedSolutionTagJpaRepository = sharedSolutionTagJpaRepository;
        this.sharedSolutionTagDataAccessMapper = sharedSolutionTagDataAccessMapper;
        this.voteSharedSolutionJpaRepository = voteSharedSolutionJpaRepository;
    }

    @Override
    public SharedSolution save(SharedSolution sharedSolution) {
        SharedSolutionEntity entity = sharedSolutionJpaRepository.save(dataAccessMapper.sharedSoltionToEntity(sharedSolution));
        List<Tag> tags = sharedSolution.getTags();
        if(tags != null && !tags.isEmpty()){
            List<SharedSolutionTagEntity> sharedSolutionTagEntities =
                    tags.stream().map(tag -> dataAccessMapper.tagToSharedSolutionTagEntity(tag, entity))
                            .toList();
//        sharedSolutionTagEntities.forEach(a-> log.info("ccaa {} {}", a.getSharedSolution().getId(), a.getTag().getId() ));
            sharedSolutionTagJpaRepository.saveAll(sharedSolutionTagEntities);
        }
        return dataAccessMapper.entityToSharedSolution(entity, tags);
    }

    @Override
    public void saveTag(List<Tag> tags, UUID id) {
        List<SharedSolutionTagEntity> sharedSolutionTagEntities =
                tags.stream().map(tag -> dataAccessMapper.tagToSharedSolutionTagEntity(tag, SharedSolutionEntity.builder().id(id).build()))
                        .toList();
//        sharedSolutionTagEntities.forEach(a-> log.info("ccaa {} {}", a.getSharedSolution().getId(), a.getTag().getId() ));
        sharedSolutionTagJpaRepository.saveAll(sharedSolutionTagEntities);
    }

    @Override
    public Optional<SharedSolution> findDetailById(SharedSolutionId sharedSolutionId) {
//        Optional
        return Optional.empty();
    }

    @Override
    public Optional<SharedSolution> findById(UUID id) {
        List<SharedSolutionTagEntity> sst = sharedSolutionTagJpaRepository.findBySharedSolutionId(id);
        List<Tag> tags = sst.stream().map(sharedSolutionTagDataAccessMapper::sharedSolutionTagEntityToTag).toList();
        return sharedSolutionJpaRepository.findById(id).map(item -> dataAccessMapper.entityToSharedSolution(item, tags));
    }

    @Override
    public Integer countVoteById(UUID sharedSolutionId) {
        long numUpvote = voteSharedSolutionJpaRepository.countBySharedSolutionIdAndVoteTypeIn(sharedSolutionId, List.of(Vote.UPVOTE));
        long numDownvote = voteSharedSolutionJpaRepository.countBySharedSolutionIdAndVoteTypeIn(sharedSolutionId, List.of(Vote.DOWNVOTE));

        return (int) (numUpvote - numDownvote);
    }

    @Override
    public List<SharedSolution> findByCodeQuestionId(UUID codeQuestionId) {
        List<SharedSolutionEntity> sharedSolutionEntities = sharedSolutionJpaRepository.findByCodeQuestionId(codeQuestionId);
        List<List<Tag>> eachTags = sharedSolutionEntities.stream().map(item->{
            List<SharedSolutionTagEntity> sst = sharedSolutionTagJpaRepository.findBySharedSolutionId(item.getId());
            return sst.stream().map(sharedSolutionTagDataAccessMapper::sharedSolutionTagEntityToTag).toList();
        }).toList();
        List<SharedSolution> result = new ArrayList<>();
        for(int i = 0; i<sharedSolutionEntities.size(); ++i){
            result.add(dataAccessMapper
                    .entityToSharedSolution(sharedSolutionEntities.get(i), eachTags.get(i)));
        }
        return result;
    }

}
