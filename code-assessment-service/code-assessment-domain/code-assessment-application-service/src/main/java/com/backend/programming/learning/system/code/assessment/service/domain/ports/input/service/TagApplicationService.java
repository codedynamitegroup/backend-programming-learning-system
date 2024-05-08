package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.tag.CreateTagsCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.tag.CreateTagsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.tag.DeleteTagCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.tag.TagResponseItem;

import java.util.List;

public interface TagApplicationService {
    CreateTagsResponse createTags(CreateTagsCommand command);

    void deleteTag(DeleteTagCommand command);

    List<TagResponseItem> getTags();
}
