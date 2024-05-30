package com.backend.programming.learning.system.course.service.dataaccess.activity_attachment.entity;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "activity_attachment")
@Entity
public class ActivityAttachmentEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "assignment_id", referencedColumnName = "id")
    private AssignmentEntity assignment;

    private String fileName;
    private Integer fileSize;
    private ZonedDateTime timemodified;
    private String mimetype;
    private String fileUrl;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityAttachmentEntity that = (ActivityAttachmentEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
