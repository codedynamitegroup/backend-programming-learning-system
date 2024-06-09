package com.backend.programming.learning.system.core.service.dataaccess.chapter_resource_user.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.mapper.ChapterResourceDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.repository.ChapterResourceJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource_user.mapper.ChapterResourceUserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource_user.repository.ChapterResourceUserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterResource;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterResourceUser;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterResourceRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterResourceUserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ChapterResourceUserRepositoryImpl implements ChapterResourceUserRepository {
    private final ChapterResourceUserDataAccessMapper chapterResourceUserDataAccessMapper;

    private final ChapterResourceUserJpaRepository chapterResourceUserJpaRepository;

    public ChapterResourceUserRepositoryImpl(
            ChapterResourceUserJpaRepository chapterResourceUserJpaRepository,
            ChapterResourceUserDataAccessMapper chapterResourceUserDataAccessMapper) {
        this.chapterResourceUserJpaRepository = chapterResourceUserJpaRepository;
        this.chapterResourceUserDataAccessMapper = chapterResourceUserDataAccessMapper;
    }

    @Override
    public Boolean checkChapterResourceIsCompleted(UUID chapterResourceId, UUID userId) {
        return chapterResourceUserJpaRepository.checkChapterResourceIsCompleted(chapterResourceId, userId);
    }

    @Override
    public Optional<ChapterResourceUser> findChapterResourceUserByChapterResourceIdAndUserId(UUID chapterResourceId, UUID userId) {
        return chapterResourceUserJpaRepository.findChapterResourceUserByChapterResourceIdAndUserId(chapterResourceId, userId)
                .map(chapterResourceUserDataAccessMapper::chapterResourceUserEntityToChapterResourceUser);
    }

    @Override
    public ChapterResourceUser saveChapterResourceUser(ChapterResourceUser chapterResourceUser) {
        return chapterResourceUserDataAccessMapper.chapterResourceUserEntityToChapterResourceUser(
                chapterResourceUserJpaRepository.save(
                        chapterResourceUserDataAccessMapper.chapterResourceUserToChapterResourceUserEntity(chapterResourceUser)));
    }
}
