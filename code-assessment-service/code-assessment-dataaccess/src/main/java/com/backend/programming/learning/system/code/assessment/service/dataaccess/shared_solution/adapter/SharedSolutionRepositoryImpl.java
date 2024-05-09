package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.general_mapper.GeneralMapper;
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
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.Vote;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.shared_solution_vote.SharedSolutionVoteId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QueryOrderBy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
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
    final GeneralMapper generalMapper;

    public SharedSolutionRepositoryImpl(SharedSolutionDataAccessMapper dataAccessMapper, SharedSolutionJpaRepository sharedSolutionJpaRepository, SharedSolutionTagJpaRepository sharedSolutionTagJpaRepository, SharedSolutionTagDataAccessMapper sharedSolutionTagDataAccessMapper, SharedSolutionVoteJpaRepository sharedSolutionVoteJpaRepository, SharedSolutionVoteDataAccessMapper sharedSolutionVoteDataAccessMapper, GeneralMapper generalMapper) {
        this.dataAccessMapper = dataAccessMapper;
        this.sharedSolutionJpaRepository = sharedSolutionJpaRepository;
        this.sharedSolutionTagJpaRepository = sharedSolutionTagJpaRepository;
        this.sharedSolutionTagDataAccessMapper = sharedSolutionTagDataAccessMapper;
        this.sharedSolutionVoteJpaRepository = sharedSolutionVoteJpaRepository;
        this.sharedSolutionVoteDataAccessMapper = sharedSolutionVoteDataAccessMapper;
        this.generalMapper = generalMapper;
    }

    @Override
    public SharedSolution save(SharedSolution sharedSolution) {
        //save shared solution
        SharedSolutionEntity entity = sharedSolutionJpaRepository.save(dataAccessMapper.sharedSoltionToEntity(sharedSolution));

        //save shared solution tag
        List<Tag> tags = sharedSolution.getTags();
        if(tags != null && !tags.isEmpty()){
            List<SharedSolutionTagEntity> sharedSolutionTagEntities =
                    tags.stream().map(tag -> dataAccessMapper.tagToSharedSolutionTagEntity(tag, entity))
                            .toList();
            sharedSolutionTagJpaRepository.saveAll(sharedSolutionTagEntities);
        }

        return dataAccessMapper.entityToSharedSolution(entity, tags);
    }

    @Override
    public void saveTag(List<Tag> tags, UUID id) {
        List<SharedSolutionTagEntity> sharedSolutionTagEntities =
                tags.stream().map(tag -> dataAccessMapper.tagToSharedSolutionTagEntity(tag, SharedSolutionEntity.builder().id(id).build()))
                        .toList();
        sharedSolutionTagJpaRepository.saveAll(sharedSolutionTagEntities);
    }

    @Override
    public Optional<SharedSolution> findById(UUID sharedSolutionId, UUID voteUserId) {
        //find tag
        List<SharedSolutionTagEntity> sst = sharedSolutionTagJpaRepository.findBySharedSolutionId(sharedSolutionId);

        //check if user vote this
        SharedSolutionVoteEntityId entityId = sharedSolutionVoteDataAccessMapper.userIdAndSharedSolutionIdToEntityId(sharedSolutionId, voteUserId);
        Optional<SharedSolutionVoteEntity> sharedSolutionVoteEntityOpt = sharedSolutionVoteJpaRepository.findById(entityId);
        SharedSolutionVote sharedSolutionVote = sharedSolutionVoteEntityOpt.map(sharedSolutionVoteDataAccessMapper::entityToVote).orElse(null);

        //map tag
        List<Tag> tags = sst.stream().map(sharedSolutionTagDataAccessMapper::sharedSolutionTagEntityToTag).toList();

        //find shared solution and return
        return sharedSolutionJpaRepository
                .findById(sharedSolutionId)
                .map(item -> dataAccessMapper.entityToSharedSolution(item, tags, sharedSolutionVote));
    }

    @Override
    public Optional<SharedSolution> findById(UUID sharedSolutionId) {
        return sharedSolutionJpaRepository
                .findById(sharedSolutionId)
                .map(dataAccessMapper::entityToSharedSolutionIgnoreLazy);
    }

    @Override
    public Page<SharedSolution>
    findByCodeQuestionId(CodeQuestionId codeQuestionId,
                         Integer pageNo,
                         Integer pageSize,
                         SharedSolution.SortedFields sortBy,
                         QueryOrderBy orderBy,
                         List<TagId> tagIds) {

        List<UUID> tagEntityId
                = tagIds == null?
                null:
                tagIds.stream()
                        .map(sharedSolutionTagDataAccessMapper::tagIdToEntityId)
                        .toList();

        Pageable pageable
                = PageRequest
                    .of(pageNo,
                        pageSize,
                        Sort.by(generalMapper.QueryOrderByToSortDirection(orderBy),
                                dataAccessMapper.sharedSolutionFieldToSharedSolutionEntityField(sortBy.name())));
        Page<SharedSolutionEntity> sharedSolutionEntities = sharedSolutionJpaRepository
                .findByCodeQuestionId(codeQuestionId.getValue(),tagEntityId, pageable);

        //get tag
        List<List<Tag>> eachTags = sharedSolutionEntities.getContent().stream().map(item->{
            List<SharedSolutionTagEntity> sst = sharedSolutionTagJpaRepository.findBySharedSolutionId(item.getId());
            return sst.stream().map(sharedSolutionTagDataAccessMapper::sharedSolutionTagEntityToTag).toList();
        }).toList();

        List<SharedSolution> sharedSolutions = new ArrayList<>();
        for(int i = 0; i<sharedSolutionEntities.getContent().size(); ++i){
            sharedSolutions.add(dataAccessMapper
                    .entityToSharedSolution(sharedSolutionEntities.getContent().get(i), eachTags.get(i)));
        }

        Page<SharedSolution> result = new PageImpl<>(sharedSolutions, sharedSolutionEntities.getPageable(), sharedSolutionEntities.getTotalElements());
        return result;
    }

    @Override
    public void increaseViewByOne(SharedSolutionId id) {
        sharedSolutionJpaRepository.increaseOneViewById(id.getValue());
    }

    @Override
    public void deleteById(SharedSolutionId id) {
        sharedSolutionJpaRepository.deleteById(id.getValue());
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
