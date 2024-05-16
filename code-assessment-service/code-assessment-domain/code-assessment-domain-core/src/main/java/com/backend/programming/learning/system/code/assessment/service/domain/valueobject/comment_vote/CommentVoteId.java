package com.backend.programming.learning.system.code.assessment.service.domain.valueobject.comment_vote;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CommentId;
import com.backend.programming.learning.system.domain.valueobject.BaseId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

public class CommentVoteId extends BaseId<CommentVoteCombineId> {
    public CommentVoteId(UserId userId, CommentId commentId) {
        super(new CommentVoteCombineId(userId, commentId));
    }
}