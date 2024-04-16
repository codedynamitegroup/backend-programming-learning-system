package com.backend.programming.learning.system.core.service.domain.mapper.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.chapter.CreateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.chapter.DeleteChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.chapter.QueryAllChaptersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.chapter.QueryChapterResponse;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ChapterDataMapper {

    public Chapter createChapterCommandToChapter(CreateChapterCommand createChapterCommand) {
        return Chapter.builder()
                .title(createChapterCommand.getTitle())
                .description(createChapterCommand.getDescription())
                .createdBy(User
                        .builder()
                        .id(new UserId(createChapterCommand.getCreatedBy()))
                        .build())
                .updatedBy(User
                        .builder()
                        .id(new UserId(createChapterCommand.getUpdatedBy()))
                        .build())
                .build();
    }

    public CreateChapterResponse chapterToCreateChapterResponse(Chapter chapter, String message) {
        return CreateChapterResponse.builder()
                .chapterId(chapter.getId().getValue())
                .certificateCourseId(chapter.getCertificateCourseId().getValue())
                .no(chapter.getNo())
                .title(chapter.getTitle())
                .description(chapter.getDescription())
                .message(message)
                .build();
    }

    public QueryChapterResponse chapterToQueryChapterResponse(Chapter chapter) {
        return QueryChapterResponse.builder()
                .chapterId(chapter.getId().getValue())
                .certificateCourseId(chapter.getCertificateCourseId().getValue())
                .no(chapter.getNo())
                .title(chapter.getTitle())
                .description(chapter.getDescription())
                .questions(new ArrayList<>())
                .createdAt(chapter.getCreatedAt())
                .updatedAt(chapter.getUpdatedAt())
                .build();
    }

    public QueryAllChaptersResponse chaptersToQueryAllChaptersResponse(List<Chapter> chapters) {
        List<QueryChapterResponse> queryChapterResponses = new ArrayList<>();
        for (Chapter chapter : chapters) {
            queryChapterResponses.add(chapterToQueryChapterResponse(chapter));
        }
        return QueryAllChaptersResponse.builder()
                .chapters(queryChapterResponses)
                .build();
    }

}
