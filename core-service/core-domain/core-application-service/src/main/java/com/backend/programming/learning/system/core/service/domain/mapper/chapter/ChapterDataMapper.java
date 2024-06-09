package com.backend.programming.learning.system.core.service.domain.mapper.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryAllChaptersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.UpdateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.OrganizationResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResourceResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterResource;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.mapper.chapter_resource.ChapterResourceDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.organization.OrganizationDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChapterDataMapper {
    private final UserDataMapper userDataMapper;
    private final ChapterResourceDataMapper chapterResourceDataMapper;

    public ChapterDataMapper(UserDataMapper userDataMapper,
                             ChapterResourceDataMapper chapterResourceDataMapper) {
        this.userDataMapper = userDataMapper;
        this.chapterResourceDataMapper = chapterResourceDataMapper;
    }

    public Chapter createChapterCommandToChapter(CreateChapterCommand createChapterCommand) {
        return Chapter.builder()
                .title(createChapterCommand.getTitle())
                .description(createChapterCommand.getDescription())
                .chapterResources(new ArrayList<>())
                .createdBy(User
                        .builder()
                        .id(new UserId(createChapterCommand.getCreatedBy()))
                        .build())
                .updatedBy(User
                        .builder()
                        .id(new UserId(createChapterCommand.getUpdatedBy()))
                        .build())
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .updatedAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .build();
    }

    public CreateChapterResponse chapterToCreateChapterResponse(Chapter chapter, String message) {
        return CreateChapterResponse.builder()
                .chapterId(chapter.getId().getValue())
                .certificateCourseId(chapter.getCertificateCourseId().getValue())
                .no(chapter.getNo())
                .title(chapter.getTitle())
                .description(chapter.getDescription())
                .questions(new ArrayList<>())
                .message(message)
                .build();
    }

    public ChapterResponseEntity chapterToQueryChapterResponse(Chapter chapter) {
        UserResponseEntity createdByResponse = userDataMapper.userToUserResponseEntity(chapter.getCreatedBy());
        UserResponseEntity updatedByResponse = userDataMapper.userToUserResponseEntity(chapter.getUpdatedBy());
        List<ChapterResourceResponseEntity> chapterResourceResponseEntity = new ArrayList<>();
        for (ChapterResource chapterResource : chapter.getChapterResources()) {
            chapterResourceResponseEntity.add(
                    chapterResourceDataMapper.chapterResourceToChapterResourceResponse(chapterResource));
        }

        return ChapterResponseEntity.builder()
                .chapterId(chapter.getId().getValue())
                .certificateCourseId(chapter.getCertificateCourseId().getValue())
                .no(chapter.getNo())
                .title(chapter.getTitle())
                .description(chapter.getDescription())
                .resources(chapterResourceResponseEntity)
                .createdBy(createdByResponse)
                .updatedBy(updatedByResponse)
                .createdAt(chapter.getCreatedAt())
                .updatedAt(chapter.getUpdatedAt())
                .build();
    }

    public Chapter chapterResponseEntityToChapter(ChapterResponseEntity chapterResponseEntity) {
        User createdBy = chapterResponseEntity.getCreatedBy() == null
                ? null
                : userDataMapper.userResponseEntityToUser(chapterResponseEntity.getCreatedBy());
        User updatedBy = chapterResponseEntity.getUpdatedBy() == null
                ? null
                : userDataMapper.userResponseEntityToUser(chapterResponseEntity.getUpdatedBy());
        List<ChapterResource> chapterResources = new ArrayList<>();
        for (ChapterResourceResponseEntity chapterResourceResponseEntity : chapterResponseEntity.getResources()) {
            chapterResources.add(
                    chapterResourceDataMapper.chapterResourceResponseToChapterResource(chapterResourceResponseEntity));
        }
        return Chapter.builder()
                .id(new ChapterId(chapterResponseEntity.getChapterId()))
                .certificateCourseId(new CertificateCourseId(chapterResponseEntity.getCertificateCourseId()))
                .no(chapterResponseEntity.getNo())
                .title(chapterResponseEntity.getTitle())
                .description(chapterResponseEntity.getDescription())
                .chapterResources(chapterResources)
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(chapterResponseEntity.getCreatedAt())
                .updatedAt(chapterResponseEntity.getUpdatedAt())
                .build();
    }

    public QueryAllChaptersResponse chaptersToQueryAllChaptersResponse(List<Chapter> chapters) {
        List<ChapterResponseEntity> chapterResponseEntities = new ArrayList<>();
        for (Chapter chapter : chapters) {
            chapterResponseEntities.add(chapterToQueryChapterResponse(chapter));
        }
        return QueryAllChaptersResponse.builder()
                .chapters(chapterResponseEntities)
                .build();
    }


    public UpdateChapterResponse chapterToUpdateChapterResponse(ChapterId chapterId, String message) {
        return UpdateChapterResponse.builder()
                .chapterId(chapterId.getValue())
                .message(message)
                .build();
    }
}
