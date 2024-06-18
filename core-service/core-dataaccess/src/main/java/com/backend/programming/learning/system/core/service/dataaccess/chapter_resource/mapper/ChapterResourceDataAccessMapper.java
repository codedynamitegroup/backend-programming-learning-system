package com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper.ChapterDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.entity.ChapterResourceEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.projection.CourseTypeCountProjection;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapterResource.ChapterResourceCount;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterResource;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterResourceId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ResourceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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
                chapterResource.getQuestion() == null
                        ? null
                        : questionDataAccessMapper.questionToQuestionEntity(chapterResource.getQuestion());

        return ChapterResourceEntity.builder()
                .id(chapterResource.getId().getValue())
                .no(chapterResource.getNo())
                .chapter(chapterEntity)
                .resourceType(chapterResource.getResourceType())
                .title(chapterResource.getTitle())
                .lessonHtml(chapterResource.getLessonHtml())
                .question(questionEntity)
                .youtubeVideoUrl(chapterResource.getYoutubeVideoUrl())
                .build();
    }

    public ChapterResource chapterResourceEntityToChapterResource(
            ChapterResourceEntity chapterResourceEntity) {
        Chapter chapter = chapterDataAccessMapper.chapterEntityToChapter(chapterResourceEntity.getChapter());
        Question question = chapterResourceEntity.getQuestion() == null
                ? null
                : questionDataAccessMapper.questionEntityToQuestion(chapterResourceEntity.getQuestion());

        return ChapterResource.builder()
                .id(new ChapterResourceId(chapterResourceEntity.getId()))
                .no(chapterResourceEntity.getNo())
                .chapter(chapter)
                .question(question)
                .resourceType(chapterResourceEntity.getResourceType())
                .title(chapterResourceEntity.getTitle())
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

    private ChapterResourceCount chapterResourceTypeCountProjectionToChapterResourceCount(CourseTypeCountProjection courseTypeCountProjection) {
        return ChapterResourceCount.builder()
                .resourceType(ResourceType.valueOf(courseTypeCountProjection.getResourceType()))
                .count(courseTypeCountProjection.getCount())
                .build();
    }

    public List<ChapterResourceCount> chapterResourceTypeCountProjectionListToChapterResourceCountList(List<CourseTypeCountProjection> courseTypeCountProjections) {
        return courseTypeCountProjections.stream()
                .map(this::chapterResourceTypeCountProjectionToChapterResourceCount)
                .collect(Collectors.toList());
    }
}
