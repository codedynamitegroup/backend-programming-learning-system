package com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tag")
public class TagEntity {
    @Id
    UUID id;

    String name;

    @Basic(fetch = FetchType.LAZY)
    @Formula("""
            COALESCE((select count(*) from tag_code_question tcq where tcq.tag_id = id), 0)
            """)
    Integer numOfCodeQuestion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagEntity tagEntity = (TagEntity) o;
        return Objects.equals(id, tagEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
