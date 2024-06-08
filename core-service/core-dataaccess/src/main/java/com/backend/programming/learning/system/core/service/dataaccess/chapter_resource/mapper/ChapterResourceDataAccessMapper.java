package com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper.ChapterDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.entity.ChapterResourceEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterResource;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterResourceId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChapterResourceDataAccessMapper {
    private final ChapterDataAccessMapper chapterDataAccessMapper;
    private final QuestionDataAccessMapper questionDataAccessMapper;

    public ChapterResourceDataAccessMapper(ChapterDataAccessMapper chapterDataAccessMapper,
                                           QuestionDataAccessMapper questionDataAccessMapper) {
        this.chapterDataAccessMapper = chapterDataAccessMapper;
        this.questionDataAccessMapper = questionDataAccessMapper;
    }

    public ChapterResourceEntity chapterResourceToChapterResourceEntity(
            ChapterResource chapterResource) {
        ChapterEntity chapterEntity = chapterDataAccessMapper.chapterToChapterEntity(chapterResource.getChapter());
        QuestionEntity questionEntity =
                chapterResource.getQuestion() == null ? null :
                questionDataAccessMapper.questionToQuestionEntity(chapterResource.getQuestion());

        return ChapterResourceEntity.builder()
                .id(chapterResource.getId().getValue())
                .chapter(chapterEntity)
                .resourceType(chapterResource.getResourceType())
                .lessonHtml(chapterResource.getLessonHtml())
                .question(questionEntity)
                .youtubeVideoUrl(chapterResource.getYoutubeVideoUrl())
                .build();
    }

    public ChapterResource chapterResourceEntityToChapterResource(
            ChapterResourceEntity chapterResourceEntity) {
        Chapter chapter = chapterDataAccessMapper.chapterEntityToChapter(chapterResourceEntity.getChapter());
        Question question = chapterResourceEntity.getQuestion() == null ? null :
                questionDataAccessMapper.questionEntityToQuestion(chapterResourceEntity.getQuestion());

        return ChapterResource.builder()
                .id(new ChapterResourceId(chapterResourceEntity.getId()))
                .chapter(chapter)
                .question(question)
                .resourceType(chapterResourceEntity.getResourceType())
                .lessonHtml(chapterResourceEntity.getLessonHtml())
                .youtubeVideoUrl(chapterResourceEntity.getYoutubeVideoUrl())
                .build();
    }

    public List<ChapterResource> chapterQuestionEntityListToChapterQuestionList(
            List<ChapterResourceEntity> chapterQuestionEntities) {
        List<ChapterResource> chapterResources = new ArrayList<>();
        for (ChapterResourceEntity chapterResourceEntity : chapterQuestionEntities) {
            chapterResources.add(chapterResourceEntityToChapterResource(chapterResourceEntity));
        }
        return chapterResources;
    }
}
