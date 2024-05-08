package com.backend.programming.learning.system.code.assessment.service.domain.mapper.tag;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import org.springframework.stereotype.Component;

@Component
public class TagDataMapper {
    public Tag createTagCommandToTag(String s) {
        return Tag.builder().name(s).build();
    }
}
