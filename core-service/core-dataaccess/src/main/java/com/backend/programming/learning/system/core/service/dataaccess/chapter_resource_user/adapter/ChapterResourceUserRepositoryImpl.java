package com.backend.programming.learning.system.core.service.dataaccess.chapter_resource_user.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.mapper.ChapterResourceDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.repository.ChapterResourceJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource_user.repository.ChapterResourceUserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterResource;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterResourceRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterResourceUserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ChapterResourceUserRepositoryImpl implements ChapterResourceUserRepository {

    private final ChapterResourceUserJpaRepository chapterResourceUserJpaRepository;

    public ChapterResourceUserRepositoryImpl(
            ChapterResourceUserJpaRepository chapterResourceUserJpaRepository) {
        this.chapterResourceUserJpaRepository = chapterResourceUserJpaRepository;
    }

    @Override
    public Boolean checkChapterResourceIsCompleted(UUID chapterResourceId, UUID userId) {
        return chapterResourceUserJpaRepository.checkChapterResourceIsCompleted(chapterResourceId, userId);
    }
}
