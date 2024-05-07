package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.tag.SharedSolutionTagEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.vote.SharedSolutionVoteEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.vote.SharedSolutionVoteEntityId;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.mapper.SharedSolutionDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.mapper.SharedSolutionTagDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.mapper.SharedSolutionVoteDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.repository.SharedSolutionJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.repository.SharedSolutionTagJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.repository.SharedSolutionVoteJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolutionVote;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.SharedSolutionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.Vote;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.shared_solution_vote.SharedSolutionVoteId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.*;

@Component
@Slf4j
public class SharedSolutionRepositoryImpl implements SharedSolutionRepository {
    final SharedSolutionDataAccessMapper dataAccessMapper;
    final SharedSolutionJpaRepository sharedSolutionJpaRepository;
    final SharedSolutionTagJpaRepository sharedSolutionTagJpaRepository;
    final SharedSolutionTagDataAccessMapper sharedSolutionTagDataAccessMapper;
    final SharedSolutionVoteJpaRepository sharedSolutionVoteJpaRepository;
    final SharedSolutionVoteDataAccessMapper sharedSolutionVoteDataAccessMapper;

    public SharedSolutionRepositoryImpl(SharedSolutionDataAccessMapper dataAccessMapper, SharedSolutionJpaRepository sharedSolutionJpaRepository, SharedSolutionTagJpaRepository sharedSolutionTagJpaRepository, SharedSolutionTagDataAccessMapper sharedSolutionTagDataAccessMapper, SharedSolutionVoteJpaRepository sharedSolutionVoteJpaRepository, SharedSolutionVoteDataAccessMapper sharedSolutionVoteDataAccessMapper) {
        this.dataAccessMapper = dataAccessMapper;
        this.sharedSolutionJpaRepository = sharedSolutionJpaRepository;
        this.sharedSolutionTagJpaRepository = sharedSolutionTagJpaRepository;
        this.sharedSolutionTagDataAccessMapper = sharedSolutionTagDataAccessMapper;
        this.sharedSolutionVoteJpaRepository = sharedSolutionVoteJpaRepository;
        this.sharedSolutionVoteDataAccessMapper = sharedSolutionVoteDataAccessMapper;
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
    public Optional<SharedSolution> findById(UUID sharedSolutionId, UUID voteUserId) {
        List<SharedSolutionTagEntity> sst = sharedSolutionTagJpaRepository.findBySharedSolutionId(sharedSolutionId);

        SharedSolutionVoteEntityId entityId = sharedSolutionVoteDataAccessMapper.userIdAndSharedSolutionIdToEntityId(sharedSolutionId, voteUserId);
        Optional<SharedSolutionVoteEntity> sharedSolutionVoteEntityOpt = sharedSolutionVoteJpaRepository.findById(entityId);
        SharedSolutionVote sharedSolutionVote = sharedSolutionVoteEntityOpt.map(sharedSolutionVoteDataAccessMapper::entityToVote).orElse(null);

        List<Tag> tags = sst.stream().map(sharedSolutionTagDataAccessMapper::sharedSolutionTagEntityToTag).toList();

        return sharedSolutionJpaRepository
                .findById(sharedSolutionId)
                .map(item -> dataAccessMapper.entityToSharedSolution(item, tags, sharedSolutionVote));
    }

    @Override
    public Optional<SharedSolution> findById(UUID sharedSolutionId) {
        List<SharedSolutionTagEntity> sst = sharedSolutionTagJpaRepository.findBySharedSolutionId(sharedSolutionId);
        List<Tag> tags = sst.stream().map(sharedSolutionTagDataAccessMapper::sharedSolutionTagEntityToTag).toList();

        return sharedSolutionJpaRepository
                .findById(sharedSolutionId)
                .map(item -> dataAccessMapper.entityToSharedSolution(item, tags));
    }

    @Override
    public Integer countVoteById(UUID sharedSolutionId) {
        long numUpvote = sharedSolutionVoteJpaRepository.countBySharedSolutionIdAndVoteTypeIn(sharedSolutionId, List.of(Vote.UPVOTE));
        long numDownvote = sharedSolutionVoteJpaRepository.countBySharedSolutionIdAndVoteTypeIn(sharedSolutionId, List.of(Vote.DOWNVOTE));

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

    @Override
    public void increaseViewByOne(SharedSolutionId id) {
        sharedSolutionJpaRepository.increaseOneViewById(id.getValue());
    }

    @Override
    public void voteSharedSolution(SharedSolutionVote ssv) {
        SharedSolutionVoteEntity ssve = sharedSolutionVoteDataAccessMapper.voteToEntity(ssv);
        sharedSolutionVoteJpaRepository.save(ssve);
    }

    @Override
    public void deleteSharedSolutionVoteById(SharedSolutionVoteId sharedSolutionVoteId) {
        SharedSolutionVoteEntityId id = sharedSolutionVoteDataAccessMapper.idToEntityId(sharedSolutionVoteId);
        sharedSolutionVoteJpaRepository.deleteById(id);
    }

    @Override
    public Optional<SharedSolutionVote> findSharedSolutionVoteById(SharedSolutionVoteId sharedSolutionVoteId) {
        SharedSolutionVoteEntityId id = sharedSolutionVoteDataAccessMapper.idToEntityId(sharedSolutionVoteId);

        return sharedSolutionVoteJpaRepository.findById(id).map(sharedSolutionVoteDataAccessMapper::entityToVote);
    }

}
