package com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language.entity;


import com.backend.programming.learning.system.domain.valueobject.CopyState;
import lombok.*;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="programming_language")
public class ProgrammingLanguageEntity {
    @Id
    UUID id;

    String name;
    Integer compilerApiId;
    Float timeLimit;
    Float memoryLimit;
    Boolean isActived;

    String headCode;
    String bodyCode;
    String tailCode;

    @Enumerated(EnumType.STRING)
    CopyState copyState;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ProgrammingLanguageEntity that = (ProgrammingLanguageEntity) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
