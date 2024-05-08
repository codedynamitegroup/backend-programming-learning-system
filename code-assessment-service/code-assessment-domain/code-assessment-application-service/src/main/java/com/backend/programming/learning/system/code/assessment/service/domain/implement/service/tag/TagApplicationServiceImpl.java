package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.tag;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.tag.CreateTagsCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.tag.CreateTagsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.tag.DeleteTagCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.tag.TagResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.TagApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Service
@Validated
@Slf4j
public class TagApplicationServiceImpl implements TagApplicationService {
    final TagCommandHandler tagCommandHandler;

    public TagApplicationServiceImpl(TagCommandHandler tagCommandHandler) {
        this.tagCommandHandler = tagCommandHandler;
    }

    @Override
    public CreateTagsResponse createTags(CreateTagsCommand command) {
        return tagCommandHandler.createTags(command);
    }

    @Override
    public void deleteTag(DeleteTagCommand command) {
        tagCommandHandler.deleteTag(command);
    }

    @Override
    public List<TagResponseItem> getTags() {

        return tagCommandHandler.getTags();
    }
}
