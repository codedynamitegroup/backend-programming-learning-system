package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TagRepository {
    Optional<Tag> findById(TagId id);

    void saveAll(List<Tag> tags);

    void deleteTag(TagId tagId);

    List<Tag> getTags();
}
