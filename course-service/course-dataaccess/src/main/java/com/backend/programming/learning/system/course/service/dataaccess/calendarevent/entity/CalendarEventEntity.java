package com.backend.programming.learning.system.course.service.dataaccess.calendarevent.entity;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.dataaccess.exam.entity.ExamEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationComponentType;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationEventType;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationNotifyTime;
import lombok.*;

import jakarta.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "calendar_event", schema = "public")
@Entity
public class CalendarEventEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private NotificationEventType eventType;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private CourseEntity course;
    private UUID contestId;
    @ManyToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    private ExamEntity exam;
    @ManyToOne
    @JoinColumn(name = "assignment_id", referencedColumnName = "id")
    private AssignmentEntity assignment;
    @Enumerated(EnumType.STRING)
    private NotificationComponentType component;
    @Enumerated(EnumType.STRING)
    private NotificationNotifyTime notificationNotifyTime;
    private ZonedDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarEventEntity that = (CalendarEventEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
