package com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.mapper.CertificateCourseDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.ChapterNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChapterDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;

    public ChapterDataAccessMapper(UserDataAccessMapper userDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
    }

    public ChapterEntity chapterToChapterEntity(Chapter chapter) {
        CertificateCourseEntity certificateCourse = CertificateCourseEntity.builder()
                .id(chapter.getCertificateCourseId().getValue())
                .build();
        UserEntity createdBy = userDataAccessMapper.userToUserEntity(chapter.getCreatedBy());
        UserEntity updatedBy = userDataAccessMapper.userToUserEntity(chapter.getUpdatedBy());

        return ChapterEntity.builder()
                .id(chapter.getId().getValue())
                .certificateCourse(certificateCourse)
                .title(chapter.getTitle())
                .description(chapter.getDescription())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(chapter.getCreatedAt())
                .updatedAt(chapter.getUpdatedAt())
                .build();
    }

    public Chapter chapterEntityToChapter(ChapterEntity chapterEntity) {
        User createdBy = userDataAccessMapper.userEntityToUser(chapterEntity.getCreatedBy());
        User updatedBy = userDataAccessMapper.userEntityToUser(chapterEntity.getUpdatedBy());

        return Chapter.builder()
                .id(new ChapterId(chapterEntity.getId()))
                .certificateCourseId(new CertificateCourseId(chapterEntity.getCertificateCourse().getId()))
                .title(chapterEntity.getTitle())
                .description(chapterEntity.getDescription())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(chapterEntity.getCreatedAt())
                .updatedAt(chapterEntity.getUpdatedAt())
                .build();
    }

    public List<Chapter> chapterEntityListToChapterList(List<ChapterEntity> chapterEntities) {
        List<Chapter> chapters = new ArrayList<>();
        for (ChapterEntity chapterEntity : chapterEntities) {
            chapters.add(chapterEntityToChapter(chapterEntity));
        }
        return chapters;
    }
}
