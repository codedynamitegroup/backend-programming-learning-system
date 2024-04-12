package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.entity;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.entity.ProgrammingLanguageEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "certificate_course_programming_language")
@Entity
public class CertificateCourseProgrammingLanguageEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private UUID certificateCourseId;
    private UUID programmingLanguageId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CertificateCourseProgrammingLanguageEntity that = (CertificateCourseProgrammingLanguageEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
