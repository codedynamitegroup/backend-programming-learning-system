package com.backend.programming.learning.system.course.service.dataaccess.module.entity;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.exam.entity.ExamEntity;
import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.section.entity.SectionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.domain.valueobject.TypeModule;
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
@Table(name = "module")
@Entity
public class ModuleEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @OneToOne
    @JoinColumn(name="assignment_id", referencedColumnName = "id")
    private AssignmentEntity assignment;

    @OneToOne
    @JoinColumn(name="exam_id", referencedColumnName = "id")
    private ExamEntity exam;

    private Integer cmid;

    @ManyToOne
    @JoinColumn(name = "section_id", referencedColumnName = "id")
      private SectionEntity section;

    @Enumerated(EnumType.STRING)
    private TypeModule typeModule;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModuleEntity that = (ModuleEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
