package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.tag;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.TagDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.tag.CreateTagsCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.tag.CreateTagsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.tag.DeleteTagCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.tag.GetTagsCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.tag.TagResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.tag.TagDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Component
@Slf4j
public class TagCommandHandler {
    final TagDataMapper tagDataMapper;
    final TagHelper tagHelper;

    public TagCommandHandler(TagDataMapper tagDataMapper, TagHelper tagHelper) {
        this.tagDataMapper = tagDataMapper;
        this.tagHelper = tagHelper;
    }

    public CreateTagsResponse createTags(CreateTagsCommand command) {
        tagHelper.createTags(command);
        return CreateTagsResponse.builder().message("create successfully").build();
    }

    public void deleteTag(DeleteTagCommand command) {
        tagHelper.deleteTag(command);
    }

    public List<TagDto> getTags(GetTagsCommand command) {
        List<Tag> tags = tagHelper.getTags(command);
        return tags.stream().map(tagDataMapper::tagToTagResponseItem)
                .sorted(Comparator.comparing(TagDto::getName)).toList();
    }
}
