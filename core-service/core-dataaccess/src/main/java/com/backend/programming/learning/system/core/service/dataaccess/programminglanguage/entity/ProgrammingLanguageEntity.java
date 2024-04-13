package com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.entity;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.entity.CertificateCourseProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.domain.entity.ProgrammingLanguage;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "programming_language")
@Entity
public class ProgrammingLanguageEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private String name;
    private Integer compilerApiId;
    private Float timeLimit;
    private Float memoryLimit;
    private String headCode;
    private String bodyCode;
    private String tailCode;
    private Boolean isActive;

    @OneToMany(mappedBy = "programmingLanguage")
    private List<CertificateCourseProgrammingLanguageEntity> certificateCourseProgramingLanguages;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgrammingLanguageEntity that = (ProgrammingLanguageEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
