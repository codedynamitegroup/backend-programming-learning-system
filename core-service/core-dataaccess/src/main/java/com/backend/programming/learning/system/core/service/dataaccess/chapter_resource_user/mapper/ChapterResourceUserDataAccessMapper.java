package com.backend.programming.learning.system.core.service.dataaccess.chapter_resource_user.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper.ChapterDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.entity.ChapterResourceEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource_user.entity.ChapterResourceUserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterResource;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterResourceUser;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterResourceId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterResourceUserId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChapterResourceUserDataAccessMapper {
    public ChapterResourceUser chapterResourceUserEntityToChapterResourceUser(ChapterResourceUserEntity chapterResourceUserEntity) {
        return ChapterResourceUser.builder()
                .id(new ChapterResourceUserId(chapterResourceUserEntity.getId()))
                .chapterResourceId(chapterResourceUserEntity.getChapterResourceId())
                .userId(chapterResourceUserEntity.getUserId())
                .isViewed(chapterResourceUserEntity.getIsViewed())
                .build();
    }

    public  ChapterResourceUserEntity chapterResourceUserToChapterResourceUserEntity(ChapterResourceUser chapterResourceUser) {
        return ChapterResourceUserEntity.builder()
                .id(chapterResourceUser.getId().getValue())
                .chapterResourceId(chapterResourceUser.getChapterResourceId())
                .userId(chapterResourceUser.getUserId())
                .isViewed(chapterResourceUser.getViewed())
                .build();
    }
}
