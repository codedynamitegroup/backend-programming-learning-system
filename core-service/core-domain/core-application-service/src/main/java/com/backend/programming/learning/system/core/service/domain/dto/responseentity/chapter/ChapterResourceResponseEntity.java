package com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
@NoArgsConstructor(force = true)
public class ChapterResourceResponseEntity {
    @JsonProperty("chapterResourceId")
    private UUID chapterResourceId;
    @JsonProperty("no")
    private int no;
    @JsonProperty("chapterId")
    private UUID chapterId;
    @JsonProperty("resourceType")
    private String resourceType;
    @JsonProperty("title")
    private String title;
    @JsonProperty("question")
    private ChapterQuestionResponseEntity question;
    @JsonProperty("lessonHtml")
    private String lessonHtml;
    @JsonProperty("youtubeVideoUrl")
    private String youtubeVideoUrl;
    @JsonProperty("isCompleted")
    private Boolean isCompleted;
}
