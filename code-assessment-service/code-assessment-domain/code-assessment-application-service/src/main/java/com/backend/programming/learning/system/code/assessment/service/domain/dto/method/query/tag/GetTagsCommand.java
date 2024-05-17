package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.tag;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class GetTagsCommand {
    private Boolean countCodeQuestion;
    private TagType tagType;
}
