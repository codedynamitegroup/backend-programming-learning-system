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
                .build();
    }
}
