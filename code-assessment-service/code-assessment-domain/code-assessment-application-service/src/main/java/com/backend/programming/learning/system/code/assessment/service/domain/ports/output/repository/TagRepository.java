package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagType;

import java.util.List;
import java.util.Optional;

public interface TagRepository {
    Optional<Tag> findById(TagId id);

    void saveAll(List<Tag> tags);

    void deleteTag(TagId tagId);

    List<Tag> getTags(TagType tagType);

    List<Tag> getTagsExcludeCountCodeQuestion(TagType tagType);
}
