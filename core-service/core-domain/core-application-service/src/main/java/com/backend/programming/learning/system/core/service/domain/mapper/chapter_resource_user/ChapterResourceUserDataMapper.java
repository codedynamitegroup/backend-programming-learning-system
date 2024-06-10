package com.backend.programming.learning.system.core.service.domain.mapper.chapter_resource_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.CreateChapterResourceUserResponse;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterResourceUser;
import org.springframework.stereotype.Component;

@Component
public class ChapterResourceUserDataMapper {
    public CreateChapterResourceUserResponse chapterResourceUserToChapterResourceUserResponse(
            ChapterResourceUser chapterResourceUser) {
        return CreateChapterResourceUserResponse.builder()
                .chapterResourceId(chapterResourceUser.getChapterResourceId())
                .userId(chapterResourceUser.getUserId())
                .isViewed(chapterResourceUser.getViewed())
                .build();
    }


}
