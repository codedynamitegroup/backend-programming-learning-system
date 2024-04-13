package com.backend.programming.learning.system.course.service.domain.entity.post;

import com.backend.programming.learning.system.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.ExamId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * com.backend.programming.learning.system.course.service.domain.entity.post
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 1:20 AM
 * Description: ...
 */
@Getter
@Setter
@Builder
public class Post {//} extends AggregateRoot<PostId> {
    private Long courseId;
    private String title;
    private String summary;
    private String content;
    private Boolean publishState;

    public Post(
//            PostId id,
            Long courseId,
            String title,
            String summary,
            String content,
            Boolean publishState) {
//        super.setId(id);
        this.courseId = courseId;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.publishState = publishState;
    }
}
