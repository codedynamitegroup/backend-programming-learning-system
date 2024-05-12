package com.backend.programming.learning.system.code.assessment.service.domain.mapper.tag;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.TagDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.tag.TagResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TagDataMapper {
    public Tag createTagCommandToTag(String s) {
        return Tag.builder().name(s).build();
    }

    public TagDto tagToTagResponseItem(Tag tag) {
        return TagDto.builder()
                .id(tag.getId().getValue())
                .name(tag.getName())
                .numOfCodeQuestion(tag.getNumOfCodeQuestion())
                .build();
    }

    public TagId UUIDToTagId(UUID uuid) {
        return new TagId(uuid);
    }
}
