package com.backend.programming.learning.system.core.service.domain.mapper.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryAllChaptersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.UpdateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.entity.User;
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
public class ChapterDataMapper {
    private final UserDataMapper userDataMapper;
private final QuestionDataMapper questionDataMapper;

    public ChapterDataMapper(UserDataMapper userDataMapper,
                             QuestionDataMapper questionDataMapper) {
        this.userDataMapper = userDataMapper;
        this.questionDataMapper = questionDataMapper;
    }

    public Chapter createChapterCommandToChapter(CreateChapterCommand createChapterCommand) {
        return Chapter.builder()
                .title(createChapterCommand.getTitle())
                .description(createChapterCommand.getDescription())
                .questions(new ArrayList<>())
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
        List<QuestionResponseEntity> queryQuestionResponses = new ArrayList<>();
        for (Question question : chapter.getQuestions()) {
            queryQuestionResponses.add(
                    questionDataMapper.questionToQuestionResponseEntity(question));
        }

        UserResponseEntity createdByResponse = userDataMapper.userToUserResponseEntity(chapter.getCreatedBy());
        UserResponseEntity updatedByResponse = userDataMapper.userToUserResponseEntity(chapter.getUpdatedBy());

        return ChapterResponseEntity.builder()
                .chapterId(chapter.getId().getValue())
                .certificateCourseId(chapter.getCertificateCourseId().getValue())
                .no(chapter.getNo())
                .title(chapter.getTitle())
                .description(chapter.getDescription())
                .questions(queryQuestionResponses)
                .createdBy(createdByResponse)
                .updatedBy(updatedByResponse)
                .createdAt(chapter.getCreatedAt())
                .updatedAt(chapter.getUpdatedAt())
                .build();
    }

    public QueryAllChaptersResponse chaptersToQueryAllChaptersResponse(List<Chapter> chapters) {
        List<ChapterResponseEntity> chapterResponsEntities = new ArrayList<>();
        for (Chapter chapter : chapters) {
            chapterResponsEntities.add(chapterToQueryChapterResponse(chapter));
        }
        return QueryAllChaptersResponse.builder()
                .chapters(chapterResponsEntities)
                .build();
    }


    public UpdateChapterResponse chapterToUpdateChapterResponse(ChapterId chapterId, String message) {
        return UpdateChapterResponse.builder()
                .chapterId(chapterId.getValue())
                .message(message)
                .build();
    }
}
