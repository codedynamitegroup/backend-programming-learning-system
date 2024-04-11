package com.backend.programming.learning.system.core.service.dataaccess.chapter.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.mapper.CertificateCourseDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper.ChapterDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.repository.ChapterJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterRepository;
import org.springframework.stereotype.Component;

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
}
