package com.backend.programming.learning.system.core.service.dataaccess.chapter.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.mapper.CertificateCourseDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper.ChapterDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.repository.ChapterJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ChapterRepositoryImpl implements ChapterRepository {
    private final ChapterJpaRepository chapterJpaRepository;
    private final ChapterDataAccessMapper chapterDataAccessMapper;

    public ChapterRepositoryImpl(ChapterJpaRepository chapterJpaRepository,
                                  ChapterDataAccessMapper chapterDataAccessMapper) {
        this.chapterJpaRepository = chapterJpaRepository;
        this.chapterDataAccessMapper = chapterDataAccessMapper;
    }

    @Override
    public Chapter saveChapter(Chapter chapter) {
        return chapterDataAccessMapper.chapterEntityToChapter(
                chapterJpaRepository
                        .save(chapterDataAccessMapper
                                .chapterToChapterEntity(chapter)));
    }

    @Override
    public Optional<Chapter> findById(UUID chapterId) {
        return chapterJpaRepository.findById(chapterId)
                .map(chapterDataAccessMapper::chapterEntityToChapter);
    }

    @Override
    public List<Chapter> findAllByCertificateCourseId(CertificateCourseId certificateCourseId) {
        return chapterDataAccessMapper.chapterEntityListToChapterList(
                chapterJpaRepository.findAllByCertificateCourseIdOrderByNoAsc(certificateCourseId.getValue()));
    }

    @Override
    public Integer findTopNoByCertificateCourseId(CertificateCourseId certificateCourseId) {
        return chapterJpaRepository.findTopNoByCertificateCourseId(certificateCourseId.getValue());
    }

    @Override
    public void deleteChapterById(UUID chapterId) {
        chapterJpaRepository.deleteById(chapterId);
    }

    @Override
    public void deleteChaptersByCertificateCourseId(UUID certificateCourseId) {
        chapterJpaRepository.deleteChaptersByCertificateCourseId(certificateCourseId);
    }
}
