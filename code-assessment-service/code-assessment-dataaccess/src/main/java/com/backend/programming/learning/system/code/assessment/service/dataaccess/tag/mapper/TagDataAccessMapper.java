package com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.entity.TagEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import org.springframework.stereotype.Component;

@Component
public class TagDataAccessMapper {
    public Tag entityToTag(TagEntity tagEntity) {
        return Tag.builder()
                .id(new TagId(tagEntity.getId()))
                .name(tagEntity.getName())
                .numOfCodeQuestion(tagEntity.getNumOfCodeQuestion())
                .tagType(tagEntity.getTagType())
                .build();
    }

    public TagEntity tagToEntity(Tag tag) {
        return TagEntity.builder()
                .id(tag.getId().getValue())
                .name(tag.getName())
                .tagType(tag.getTagType())
                .build();
    }

    public Tag entityToTagIgnoreLazy(TagEntity tagEntity) {
        return Tag.builder()
                .id(new TagId(tagEntity.getId()))
                .name(tagEntity.getName())
                .tagType(tagEntity.getTagType())
                .build();
    }
}
