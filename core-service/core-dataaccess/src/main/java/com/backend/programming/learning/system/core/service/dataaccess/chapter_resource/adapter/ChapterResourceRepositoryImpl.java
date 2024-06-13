package com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.entity.ChapterResourceEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.mapper.ChapterResourceDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.projection.CourseTypeCountProjection;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.repository.ChapterResourceJpaRepository;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapterResource.ChapterResourceCount;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterResource;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterResourceRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ChapterResourceRepositoryImpl implements ChapterResourceRepository {
    private final ChapterResourceJpaRepository chapterResourceJpaRepository;
    private final ChapterResourceDataAccessMapper chapterResourceDataAccessMapper;

    public ChapterResourceRepositoryImpl(ChapterResourceJpaRepository chapterResourceJpaRepository,
                                         ChapterResourceDataAccessMapper chapterResourceDataAccessMapper) {
        this.chapterResourceJpaRepository = chapterResourceJpaRepository;
        this.chapterResourceDataAccessMapper = chapterResourceDataAccessMapper;
    }

    @Override
    public ChapterResource saveChapterResource(ChapterResource chapterResource) {
        return chapterResourceDataAccessMapper.chapterResourceEntityToChapterResource(
                chapterResourceJpaRepository.save(
                        chapterResourceDataAccessMapper.chapterResourceToChapterResourceEntity(chapterResource)
                )
        );
    }

    @Override
    public List<ChapterResource> findAllChapterResourcesByChapterId(UUID chapterId) {
        return chapterResourceDataAccessMapper.chapterQuestionEntityListToChapterQuestionList(
                chapterResourceJpaRepository.findAllChapterQuestionsByChapterId(chapterId)
        );
    }

    @Override
    public Optional<ChapterResource> findFirstUncompletedResourceByCertificateCourseIdAndUserId(UUID certificateCourseId, UUID userId) {
        Optional<ChapterResourceEntity> firstUncompletedResource = chapterResourceJpaRepository
        .findFirstUncompletedResourceByCertificateCourseIdAndUserId(certificateCourseId, userId);
        if (firstUncompletedResource.isPresent()) {
            return Optional.of(chapterResourceDataAccessMapper.chapterResourceEntityToChapterResource(firstUncompletedResource.get()));
        } else {
            Optional<ChapterResourceEntity> lastResource = chapterResourceJpaRepository
                    .findLastResourceByCertificateCourseId(certificateCourseId);
            return lastResource.map(chapterResourceDataAccessMapper::chapterResourceEntityToChapterResource);
        }
    }

    @Override
    public Optional<ChapterResource> findChapterResourceById(UUID chapterResourceId) {
        return chapterResourceJpaRepository.findById(chapterResourceId)
                .map(chapterResourceDataAccessMapper::chapterResourceEntityToChapterResource);
    }

    @Override
    public List<ChapterResourceCount> countResourceByType() {
        List<CourseTypeCountProjection> courseTypeCountProjections = chapterResourceJpaRepository.countResourceByType();

        return chapterResourceDataAccessMapper
                .chapterResourceTypeCountProjectionListToChapterResourceCountList(courseTypeCountProjections);
    }
}
