package com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.entity.TagEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.mapper.TagDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.repository.TagJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.TagRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class TagRepositoryImpl implements TagRepository {
    final TagJpaRepository jpaRepository;
    final TagDataAccessMapper dataAccessMapper;

    public TagRepositoryImpl(TagJpaRepository jpaRepository, TagDataAccessMapper dataAccessMapper) {
        this.jpaRepository = jpaRepository;
        this.dataAccessMapper = dataAccessMapper;
    }

    @Override
    public Optional<Tag> findById(TagId id) {
        Optional<TagEntity> tagEntity = jpaRepository.findById(id.getValue());

        return tagEntity.map(dataAccessMapper::entityToTag);
    }

    @Override
    public void saveAll(List<Tag> tags) {
        List<TagEntity> tagEntities = tags.stream().map(dataAccessMapper::tagToEntity).toList();
        jpaRepository.saveAll(tagEntities);
    }

    @Override
    public void deleteTag(TagId tagId) {
        jpaRepository.deleteById(tagId.getValue());
    }
}
