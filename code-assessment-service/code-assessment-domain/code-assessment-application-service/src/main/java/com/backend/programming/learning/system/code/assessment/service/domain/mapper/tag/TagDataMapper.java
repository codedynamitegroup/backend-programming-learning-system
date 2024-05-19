package com.backend.programming.learning.system.code.assessment.service.domain.mapper.tag;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.TagDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.tag.TagResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TagDataMapper {
    public Tag createTagCommandToTag(TagDto s) {
        return Tag.builder()
                .name(s.getName())
                .tagType(s.getTagType())
                .build();
    }

    public TagDto tagToTagResponseItem(Tag tag) {
        return TagDto.builder()
                .id(tag.getId() != null? tag.getId().getValue(): null)
                .name(tag.getName())
                .numOfCodeQuestion(tag.getNumOfCodeQuestion())
                .tagType(tag.getTagType())
                .build();
    }

    public TagId UUIDToTagId(UUID uuid) {
        return new TagId(uuid);
    }
}
