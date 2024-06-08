package com.backend.programming.learning.system.core.service.domain.mapper.chapter_resource;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryAllChaptersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.UpdateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterQuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResourceResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterResource;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.mapper.organization.OrganizationDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChapterResourceDataMapper {
    private final ChapterQuestionDataMapper chapterQuestionDataMapper;

    public ChapterResourceDataMapper(ChapterQuestionDataMapper chapterQuestionDataMapper) {
        this.chapterQuestionDataMapper = chapterQuestionDataMapper;
    }

    public ChapterResourceResponseEntity chapterResourceToChapterResourceResponse(ChapterResource chapterResource) {
        ChapterQuestionResponseEntity question = chapterResource.getQuestion() != null
                ? chapterQuestionDataMapper.questionToChapterQuestionResponse(chapterResource.getQuestion())
                : null;
        return ChapterResourceResponseEntity.builder()
                .chapterId(chapterResource.getChapter().getId().getValue())
                .question(question)
                .resourceType(chapterResource.getResourceType().toString())
                .lessonHtml(chapterResource.getLessonHtml())
                .youtubeVideoUrl(chapterResource.getYoutubeVideoUrl())
                .isCompleted(chapterResource.getCompleted())
                .build();
    }
}
