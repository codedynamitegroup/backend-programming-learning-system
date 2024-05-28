package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.ContestUserId;
import com.backend.programming.learning.system.core.service.domain.valueobject.UpdateState;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class ContestUser extends AggregateRoot<ContestUserId> {
    private User user;
    private Contest contest;
    private UUID calendarEventId;
    private UpdateState updateCalendarEventState;
    private Boolean isCompleted;
    private ZonedDateTime completedAt;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private Integer rank;
    private Float totalScore;
    private Long totalTime;
    private List<ContestQuestion> contestQuestions;

    private ContestUser(Builder builder) {
        super.setId(builder.contestUserId);
        setUser(builder.user);
        setContest(builder.contest);
        setCalendarEventId(builder.calendarEventId);
        setUpdateCalendarEventState(builder.updateCalendarEventState);
        isCompleted = builder.isCompleted;
        setCompletedAt(builder.completedAt);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
        setRank(builder.rank);
        setTotalScore(builder.totalScore);
        setTotalTime(builder.totalTime);
        setContestQuestions(builder.contestQuestions);
    }

    public static Builder builder() {
        return new Builder();
    }

    public void initializeContestUser() {
        setId(new ContestUserId(UUID.randomUUID()));
        setCreatedAt(ZonedDateTime.now(ZoneId.of("UTC")));
        setUpdatedAt(ZonedDateTime.now(ZoneId.of("UTC")));
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    public UUID getCalendarEventId() {
        return calendarEventId;
    }

    public void setCalendarEventId(UUID calendarEventId) {
        this.calendarEventId = calendarEventId;
    }

    public UpdateState getUpdateCalendarEventState() {
        return updateCalendarEventState;
    }

    public void setUpdateCalendarEventState(UpdateState updateCalendarEventState) {
        this.updateCalendarEventState = updateCalendarEventState;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public ZonedDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(ZonedDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Float totalScore) {
        this.totalScore = totalScore;
    }

    public Long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Long totalTime) {
        this.totalTime = totalTime;
    }

    public List<ContestQuestion> getContestQuestions() {
        return contestQuestions;
    }

    public void setContestQuestions(List<ContestQuestion> contestQuestions) {
        this.contestQuestions = contestQuestions;
    }

    public static final class Builder {
        private ContestUserId contestUserId;
        private User user;
        private Contest contest;
        private UUID calendarEventId;
        private UpdateState updateCalendarEventState;
        private Boolean isCompleted;
        private ZonedDateTime completedAt;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
        private Integer rank;
        private Float totalScore;
        private Long totalTime;
        private List<ContestQuestion> contestQuestions;

        private Builder() {
        }

        public Builder id(ContestUserId val) {
            contestUserId = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder contest(Contest val) {
            contest = val;
            return this;
        }

        public Builder calendarEventId(UUID val) {
            calendarEventId = val;
            return this;
        }

        public Builder updateCalendarEventState(UpdateState val) {
            updateCalendarEventState = val;
            return this;
        }

        public Builder isCompleted(Boolean val) {
            isCompleted = val;
            return this;
        }

        public Builder completedAt(ZonedDateTime val) {
            completedAt = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder updatedAt(ZonedDateTime val) {
            updatedAt = val;
            return this;
        }

        public Builder rank(Integer val) {
            rank = val;
            return this;
        }

        public Builder totalScore(Float val) {
            totalScore = val;
            return this;
        }

        public Builder totalTime(Long val) {
            totalTime = val;
            return this;
        }

        public Builder contestQuestions(List<ContestQuestion> val) {
            contestQuestions = val;
            return this;
        }

        public ContestUser build() {
            return new ContestUser(this);
        }
    }
}
