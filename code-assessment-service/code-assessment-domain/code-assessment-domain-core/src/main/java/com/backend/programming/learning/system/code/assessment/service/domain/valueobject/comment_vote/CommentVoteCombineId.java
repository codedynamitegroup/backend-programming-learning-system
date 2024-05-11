package com.backend.programming.learning.system.code.assessment.service.domain.valueobject.comment_vote;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CommentId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.util.Objects;

public class CommentVoteCombineId {
    final UserId userId;
    final CommentId commentId;

    public CommentVoteCombineId(UserId userId, CommentId commentId) {
        this.userId = userId;
        this.commentId = commentId;
    }

    public CommentId getCommentId() {
        return commentId;
    }

    public UserId getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentVoteCombineId that = (CommentVoteCombineId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(commentId, that.commentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, commentId);
    }
}
